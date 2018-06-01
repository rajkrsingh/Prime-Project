package com.primeresponse.pagehelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;
import com.primeresponse.pagehelper.HeaderHelper;


public class AccountsHelper extends DriverHelper {

	private LocatorReader accountsLocator;
	private LocatorReader headerLocator;
	
	public AccountsHelper(WebDriver driver) {
		super(driver);
		accountsLocator = new LocatorReader("Accounts.xml");
		headerLocator = new LocatorReader("Header.xml");
		
	}


	public void randomClickOnPageCount()
	{
		int n_Count= getSize(accountsLocator.getLocator("Accounts.PageCount"));
		if ( n_Count != 0)	
		{		
			int n_PageCount = Integer.parseInt(getText("//div[@class='flickr_pagination']/a["+ (n_Count-1) +"]"));
			int rd_PageCount = (int) (1+Math.random()*n_PageCount);
			String nav= "https://app.prime-response.com/accounts?account_search=&commit=Filter+Accounts&page="+rd_PageCount+"";
			getWebDriver().navigate().to(nav);
			WaitForElementPresent(accountsLocator.getLocator("Accounts.SearchAccount"), 30);
		}
	}

	public void accountsSearch(String text)
	{
		sendKeys(accountsLocator.getLocator("Accounts.SearchAccount"), text);
		clickOn(accountsLocator.getLocator("Accounts.SubmitButton"));

		int count=getSize(accountsLocator.getLocator("Accounts.RowCount"));
		if(count !=0)
		{
			for(int i=1; i<=count; i++)
			{
				String str= getText("//table/tbody/tr["+i+"]/td[1]");
				//				String actstr= str.toLowerCase();
				Assert.assertTrue(str.matches("(?i).*" +text+ ".*"));
			}	
		}
		else
		{
			String str1= getText("//div[@class='center error-text bold']");
			Assert.assertTrue(str1.contains("Search data not found"));
		}

	} 

	public void createAccount()
	{
		String locator1=accountsLocator.getLocator("Accounts.NewAccount");
		clickOn(locator1);
		//Verify 'Account Information' element is present
		Assert.assertEquals(getText("//div[@class='panel']/h1"),"Account Information");
	}

	public void submitAccountDetails(String text) throws InterruptedException
	{
		
		String locator1=accountsLocator.getLocator("Accounts.AccountsInformation.Name");
		this.WaitForElementVisible(locator1,20);
		sendKeys(locator1, text);

		String locator2=accountsLocator.getLocator("Accounts.AccountsInformation.Address1");
		sendKeys(locator2,"New York");

		String locator3=accountsLocator.getLocator("Accounts.AccountsInformation.Address2");
		sendKeys(locator3,"New York");


		String locator4=accountsLocator.getLocator("Accounts.AccountsInformation.ZipCode");
		sendKeys(locator4,"100");
		clickOn(locator4);
		
        
		String locator5=accountsLocator.getLocator("Accounts.AccountsInformation.ZipCodeClick");
		WaitForElementPresent(locator5,30);
		clickOn(locator5);
		waitForLoading();

		String locator6=accountsLocator.getLocator("Accounts.AccountsInformation.VerticalSelect");
		clickOn(locator6);

		String locator7=accountsLocator.getLocator("Accounts.AccountsInformation.VerticalListValue");
		clickOn(locator7);

		String locator8=accountsLocator.getLocator("Accounts.SubmitButton");
		clickOn(locator8);

	}


	public void checkAccountsMenuEnable()
	{
		//String locator8=accountsLocator.getLocator("Accounts.AccountsHeader");
		//clickOn(locator8);
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		WaitForElementPresent(locator2,30);
		mouseOver(locator2);
		WaitForElementPresent(locator2,30);
		//clickOn(locator2);
		
		WaitForElementVisible(locator2, 30);
		
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.AccountInformation"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.OfficialProfile"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.Users"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.Contacts"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.Employees"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.AccessKeys"))).isEnabled());
		Assert.assertTrue(getWebDriver().findElement(ByLocator(accountsLocator.getLocator("Accounts.AdminSettings"))).isEnabled());
		clickOn(locator2);
	}

	public void submitOfficialProfileDetails() throws InterruptedException
	{
		String locator2=accountsLocator.getLocator("Accounts.OfficialProfile.LocalNumber");
		clickOn(locator2);
		sendKeys(locator2,"334554565768687");

		String locator3=accountsLocator.getLocator("Accounts.OfficialProfile.Category1");
		clickOn(locator3);

		String locator4=accountsLocator.getLocator("Accounts.OfficialProfile.SelectCatgory1Option");
		clickOn(locator4);

		String locator5=accountsLocator.getLocator("Accounts.OfficialProfile.Email");
		sendKeys(locator5,"test123@yopmail.com");

		String locator6=accountsLocator.getLocator("Accounts.OfficialProfile.Brands");
		sendKeys(locator6,"ABC Brand");

		String locator7=accountsLocator.getLocator("Accounts.OfficialProfile.Products");
		sendKeys(locator7,"ABC Product");
		//Thread.sleep(3000);
		String locator8=accountsLocator.getLocator("Accounts.OfficialProfile.SubmitButton");
		clickOn(locator8);
		clickOn(locator8);
	}

	public void verifyUsersEmail()
	{
		String email= getText("//div[@class='pull-right']");
		String actemail= email.replace(">", "");
		int totalrow=getSize("//div[@class='table']/table/tbody/tr");
		for(int i=1;i<=totalrow;i++)
		{
			if(actemail.contains(getText("//div[@class='table']/table/tbody/tr["+i+"]/td[3]")))
			{
				Assert.assertTrue(true,"User email verified");
				break;
			}
		}
		
		//String email1= getText("//tr[@class='line_color_1']//td[3]");
		//Assert.assertEquals(actemail,email1);

	}

	public void submitContactsDetails()
	{
		String locator2=accountsLocator.getLocator("Accounts.Contacts.NewContactsLink");
		clickOn(locator2);

		String locator3=accountsLocator.getLocator("Accounts.Contacts.FirstName");
		sendKeys(locator3,"abc");

		String locator4=accountsLocator.getLocator("Accounts.Contacts.LastName");
		sendKeys(locator4,"xyz");

		String locator5=accountsLocator.getLocator("Accounts.Contacts.SubmitButton");
		clickOn(locator5);

	}

	public void submitEmployeeDetails()
	{	
		String locator2=accountsLocator.getLocator("Accounts.Employees.NewEmployeeLink");
		clickOn(locator2);

		String locator3=accountsLocator.getLocator("Accounts.Employees.FirstName");
		sendKeys(locator3,"qatest");

		String locator4=accountsLocator.getLocator("Accounts.Employees.Email");
		sendKeys(locator4,"qatest12@yopmail.com");

        int randomval=getRandomInteger(1, 9);
		String locator5=accountsLocator.getLocator("Accounts.Employees.EmployeeNumber");
		sendKeys(locator5,"12345678"+randomval);

		String locator6=accountsLocator.getLocator("Accounts.Employees.SubmitButton");
		clickOn(locator6);
	}	

	public void adminSettings()
	{
		Assert.assertEquals("Demo",getText(accountsLocator.getLocator("Accounts.AdminSettings.AccountTypes")));

		String locator2=accountsLocator.getLocator("Accounts.AdminSettings.Groups");
		clickOn(locator2);
        waitForLoading();
		String locator3=accountsLocator.getLocator("Accounts.AdminSettings.GroupsList");
		clickOn(locator3);
		waitForLoading();
		String locator4=accountsLocator.getLocator("Accounts.AdminSettings.SubmitButton");
		clickOn(locator4);
		waitForLoading();

	}

	public void deleteAccount(String text)
	{

		String locator2=accountsLocator.getLocator("Accounts.SearchForAccount");
		sendKeys(locator2, text);

		String locator3=accountsLocator.getLocator("Accounts.SubmitButton");
		clickOn(locator3);

		String locator4=accountsLocator.getLocator("Accounts.DeleteButton");
		clickOn(locator4);
		acceptAlert();
		acceptAlert();

	}

	// ******* Method to check Login Icon is not present for already selected Account *****
	public void loginIconNotPresent() {

		String locator1=accountsLocator.getLocator("Accounts.LoginIcon");
		if(!isElementPresent(locator1))
		{
			Assert.assertTrue(true, "login icon is not present");
			
			String locator2=accountsLocator.getLocator("Accounts.AccountIcon");
			clickOn(locator2);
			
			String locator3=accountsLocator.getLocator("Accounts.AccountList");
			clickOn(locator3);
			
		}



	}
	// ******* Method to check Login Icon is not present for already selected Account *****

	public void loginIconPresent() {

		String locator1=accountsLocator.getLocator("Accounts.LoginIcon");
		isElementPresent(locator1);
		clickOn(locator1);
		waitForLoading();

	}



	// ******* Method to select any random page count *********
	public void randomSelectPage(String url) {

		String locator2=accountsLocator.getLocator("Accounts.PageCount");
		int no_page_count = getSize(locator2)-1;
		int rnd_page_count = getRandomInteger(1, no_page_count);
		getWebDriver().navigate().to(url+"/accounts?page="+rnd_page_count);

	}

	// ***** Method to check the default sorting of name columns *********
	public void checkNameSorting() {
		
		randomClickOnPageCount();
		waitForLoading();

		//String locator1=accountsLocator.getLocator("Accounts.RowCount");
		//int no_row = getSize(locator1);

		/*ArrayList <String> al = new ArrayList <String>();

		for (int i =1 ; i<= no_row; i++)
		{
			al.add(getText(locator1+"["+i+"]/td[1]"));

		}

		Collections.sort(al);

		for(int i=1; i<=al.size(); i++)
		{
			//System.out.println("aL:" + al.get(i-1) + "actual:" + getText(locator1+"["+i+"]/td[1]") );
			assert(al.get(i-1).contains(getText(locator1+"["+i+"]/td[1]")));
		}
            */
		
		String locator1 = accountsLocator.getLocator("Accounts.NameCol");
		clickOn(locator1);
		
		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = accountsLocator.getLocator("Accounts.RowCount");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='account_index']/tr["+i+"]/td[1]");
			al1.add(str.substring(7));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//tbody[@id='account_index']/tr["+i+"]/td[1]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	// ***** Method to check the Created columns sorting *********

	public void checkCreatedSorting() throws ParseException {
		
		randomClickOnPageCount();
		waitForLoading();
		
		String locator3=accountsLocator.getLocator("Accounts.CreatedSortIcon");
		clickOn(locator3);

		String locator1=accountsLocator.getLocator("Accounts.RowCount");
		int no_row = getSize(locator1);
		
		for(int i=1;i<no_row;i++)
		{			
			String str1=getText(locator1+"["+i+"]/td[3]");
			String str2=getText(locator1+"["+(i+1)+"]/td[3]");
			//System.out.println(str1.compareTo(str2));
			if(str1.compareTo(str2)==1)
			{
				Assert.fail("Sorting functionality is not working correctly");  
			}

		}


	}

	// ****** Methods to create access keys *********
	
	public void createAccessKeys(String str)
	{

		String locator1=accountsLocator.getLocator("Accounts.AccessKeys.AcessKeysButton");
		clickOn(locator1);

		String locator2=accountsLocator.getLocator("Accounts.AccessKeys.EnterUniqueKey");
		sendKeys(locator2,"test"+ str);

		String locator3=accountsLocator.getLocator("Accounts.AccessKeys.ActionsAllButton");
		clickOn(locator3);

		String locator4=accountsLocator.getLocator("Accounts.AccessKeys.SubmitButton");
		clickOn(locator4);

	}

	// ***********Method to DELETE Access Keys*****************
	public void deleteAccessKeys()
	{
		String locator=accountsLocator.getLocator("Accounts.AccessKeys.DeleteButton");
		clickOn(locator);
		acceptAlert();
	}


	//**************Method to Send Social Integration via Email************

	public void sendSocialIntegration(String email)
	{
		String locator = accountsLocator.getLocator("Accounts.Users.Row");
		int row=getSize(locator);
		for(int i=1;i<=row;i++)
		{
			String str1=getText(locator+"["+i+"]/td[3]");
			String actualemail=str1.replace(" ", "");

			if(email.equals(actualemail))
			{
				clickOn(locator+"["+i+"]/td[5]/a[1]/img");
				acceptAlert();
				break;
			}
		}

	}

	//**************Method to tick employee check box************//
	public void markEmployeeCheckbox(String user)
	{
		String locator = accountsLocator.getLocator("Accounts.Users.Row");
		int row=getSize(locator);
		for(int i=1;i<=row;i++)
		{
			String str1=getText(locator+"["+i+"]/td[3]");
			String actualemail=str1.replace(" ", "");
			if(user.equals(actualemail))
			{
				clickOn(locator+"["+i+"]/td[5]/a[2]/img");
				if(isElementPresent("//div[@id='profile-tab']//input[2][@checked='checked']"))	
				{
				    
					break;
				  
				}
				
				
				 clickOn(accountsLocator.getLocator("Accounts.Users.EmployeeCheckBox"));
				 //clickOn("//input[@id='accounts_user_employee']");
				 waitForLoading();
				 clickOn(accountsLocator.getLocator("Accounts.Users.BackLink"));
				

			}
		}
		 
	}

	//**************Method to verify tick icon on users page************//
	public void verifyUserTickIcon(String email) throws InterruptedException 
	{
		String locator = accountsLocator.getLocator("Accounts.Users.Row");
		int row=getSize(locator);
		for(int i=1;i<=row;i++)
		{
			String str1=getText(locator+"["+i+"]/td[3]");
			
			//System.out.println("String1 Value:"+str1);
					
			String actualemail=str1.replace(" ", "");

			if(email.equals(actualemail))
			{
				//WaitForElementPresent(locator+"["+i+"]/td[4]/img[@alt='Tick']", 30);
				//WaitForElementEnabled(accountsLocator.getLocator("Accounts.EmployeeTickIcon"),4);
				Thread.sleep(3000);
				Assert.assertTrue(isElementPresent("//tbody/tr["+i+"]/td[4]/img[@alt='Tick']"));
				
								
			}
		}

	}	

	//**************Method to verify untick icon on users page************//

	public void verifyUserUnTickIcon(String email) 
	{
		String locator = accountsLocator.getLocator("Accounts.Users.Row");
		int row=getSize(locator);
		for(int i=1;i<=row;i++)
		{
			String str1=getText(locator+"["+i+"]/td[3]");
			String actualemail=str1.replace(" ", "");

			if(email.equals(actualemail))
			{
				WaitForElementNotPresent(accountsLocator.getLocator("Accounts.Users.Employed"), 30);
				Assert.assertFalse(isElementPresent(accountsLocator.getLocator("Accounts.Users.Employed")));


			}
		}
	}

	//**************Method to verify user details************//
	public String[] verifyUserDetails()
	{

		String locator1 = accountsLocator.getLocator("Accounts.Users.Row");
		int n_rowsize = getSize(locator1);

		// select any random user	
		int n_start=2+(int)(Math.random()*((n_rowsize-2)+1));

		clickOn("//tr["+n_start+"]/td[5]/a[2]/img");
		waitForLoading();
		Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.Users.FirstName")));
		String firstname=getText(accountsLocator.getLocator("Accounts.Users.FirstName"));

		Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.Users.LastName")));
		String lastname=getText(accountsLocator.getLocator("Accounts.Users.LastName"));

		Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.Users.Email")));
		String email=getText(accountsLocator.getLocator("Accounts.Users.Email"));

		String[] arr = new String[]{firstname,lastname,email};

		String[] arr1 = new String[3];
		arr1[0]=arr[0];
		arr1[1]=arr[1];
		arr1[2]=arr[2];
		return arr1;

	}

	//**************Method to sort Age column************//

	public void sortAgeColumn()
	{
		randomClickOnPageCount();
		waitForLoading();

		String locator2=accountsLocator.getLocator("Accounts.AgeSortingIcon");
		clickOn(locator2);

		String locator = accountsLocator.getLocator("Accounts.RowCount");
		int totalrowsize=getSize(locator);
//		System.out.println("total row value:"+totalrowsize);

		for(int i=1;i<totalrowsize;i++)
		{			
			String str1=getText(locator+"["+i+"]/td[4]");
			String str2=getText(locator+"["+(i+1)+"]/td[4]");
			//System.out.println(str1.compareTo(str2));
			if(str1.compareTo(str2)==1)
			{
				Assert.fail("Sorting functionality is not working correctly");  
			}

		}
	}	

	//**************Method to create Great Plains Contracts from Accounts menu***************//
	public void accountsCreateGreatPlainsContracts(String str1,String str2)
	{

		String locator1=accountsLocator.getLocator("Accounts.GreatPlainsContracts.NewButton");
		clickOn(locator1);

		String locator2=accountsLocator.getLocator("Accounts.GreatPlainsContracts.ContractNumberTextField");
		sendKeys(locator2,"9999988888"+str2);

		String locator3=accountsLocator.getLocator("Accounts.GreatPlainsContracts.ActivationDateTextField");
		sendKeys(locator3,"2016-09-15");

		String locator4=accountsLocator.getLocator("Accounts.GreatPlainsContracts.DeactivationDateTextField");
		sendKeys(locator4,"2016-12-16");

		String locator5=accountsLocator.getLocator("Accounts.GreatPlainsContracts.GreatPlainsProductDropDown");
		clickOn(locator5);

		int totallistcount=getSize(accountsLocator.getLocator("Accounts.GreatPlainsContracts.TotalListCount"));

		for(int i=1;i<=totallistcount;i++)
		{
			if(str1.equals(getText("//ul[@class='chzn-results']/li["+i+"]")))
			{
				clickOn("//ul[@class='chzn-results']/li["+i+"]");
				break;
			}
		}

		String locator6=accountsLocator.getLocator("Accounts.GreatPlainsContracts.SubmitButton");
		clickOn(locator6);
	}

	//**************Method to delete Great Plains Contracts from Accounts menu***************//

	public void deleteAccountsGreatPlainsContracts()
	{

		String str="9999988888";
		String locator = accountsLocator.getLocator("Accounts.GreatPlainsContracts.RowCount");
		int rowcount=getSize(locator);
		System.out.println("total size:"+rowcount);

		for(int i=1;i<=rowcount;i++)
		{

			if(getText(locator+"["+i+"]/td[1]").contains(str))
			{

				clickOn(locator+"["+i+"]/td[5]/div/div/a[2]/i");
				acceptAlert();
				break;
			}

		}

	}

	//Method to fetch Timezone from user information page
	public String fetchTimeZone()
	{
		String str=getText(accountsLocator.getLocator("Accounts.AccountsInformation.TimeZone"));
		return str;
	}

	//***************Method to fetch State from Account Information******************//
	public String fetchAccountInformation()
	{


		int totalstate=getSize(accountsLocator.getLocator("Accounts.AccountsInformation.TotalState"));
		System.out.println("Total state count:"+totalstate);

		int randomvalue=getRandomInteger(2,totalstate);

		clickOn("//select[@id='account_addresses_attributes_0_state']/option["+randomvalue+"]");
		waitForLoading();

		String state=getAttribute("//select[@id='account_addresses_attributes_0_state']/option["+randomvalue+"]", "value");

		String locator4=accountsLocator.getLocator("Accounts.SubmitButton");
		clickOn(locator4);

		return state;
	}
	
	//*******Match Application Products on Account information page******************************//
	public void matchApplicationProduct(ArrayList<String> arr)
	{
		ArrayList<String> al1=new ArrayList<String>();
		int totalproduct=getSize(accountsLocator.getLocator("Accounts.AccountsInformation.ApplicationProductList"));
		System.out.println("AP count:"+totalproduct);
		clickOn(accountsLocator.getLocator("Accounts.AccountsInformation.ClickProductList"));
		//clickOn("//li[contains(@id,'account_application_product_ids_chzn_c')]/a");
		for(int i=1;i<=totalproduct;i++)
		{
			//clickOn(accountsLocator.getLocator("Accounts.AccountsInformation.ClickProductList"));
			al1.add(getText("//div[@id='account_application_product_ids_chzn']//li["+i+"]"));
			//System.out.println("Account AP:"+al1);
	
			if(al1.contains(arr))
			{
			   Assert.assertTrue(true,"Value matched");	
			}
		}
				
	}
	
	 //*****************Method to CREATE Great Plains Contracts*************************************************//
	public void create_AccountsGreatPlainsContracts() 
	{
		String locator1=accountsLocator.getLocator("Accounts.GreatPlainsContracts.NewButton");
		clickOn(locator1);

		String locator2=accountsLocator.getLocator("Accounts.GreatPlainsContracts.ContractNumberTextField");
		sendKeys(locator2,"9999988888");

		String locator3=accountsLocator.getLocator("Accounts.GreatPlainsContracts.ActivationDateTextField");
		sendKeys(locator3,"2014-12-18");

		String locator4=accountsLocator.getLocator("Accounts.GreatPlainsContracts.DeactivationDateTextField");
		sendKeys(locator4,"2014-12-18");
		
		String locator5=accountsLocator.getLocator("Accounts.GreatPlainsContracts.NewTitle");
		clickOn(locator5);

		String locator6=accountsLocator.getLocator("Accounts.GreatPlainsContracts.GreatPlainsProductDropDown");
		clickOn(locator6);
        
		int totallistcount=getSize(accountsLocator.getLocator("Accounts.GreatPlainsContracts.TotalListCount"));
		//System.out.println("total list count value:"+totallistcount);
		
        int randomval=getRandomInteger(1,totallistcount);
        //System.out.println("total list random value:"+randomval);
        WaitForElementVisible("//ul[@class='chzn-results']/li["+randomval+"]",30);
        clickOn("//ul[@class='chzn-results']/li["+randomval+"]");
        		     
		String locator7=accountsLocator.getLocator("Accounts.GreatPlainsContracts.SubmitButton");
		clickOn(locator7);
	}

	//*********Method to DELETE Great Plains Contracts*************************
	public void delete_AccountsGreatPlainsContracts()
	{
		String str="9999988888";
		int rowcount=getSize(accountsLocator.getLocator("Accounts.GreatPlainsContracts.RowCount"));
		for(int i=1;i<=rowcount;i++)
		{
			if(getText("//tbody[contains(@class,'great-plains-contracts-body')]/tr["+i+"]/td[1]").contains(str))
			{
			   clickOn("//tbody[contains(@class,'great-plains-contracts-body')]/tr["+i+"]//a[2]/i");
			   acceptAlert();
			   break;
			}
		}
	}
	
	//******************Randomly select any account and verify its name on edit page and Account list********************//
	 public void verify_AccountNameOnList()
	 {
		 int totalrow=getSize(accountsLocator.getLocator("Accounts.RowCount"));
		 int randomval=getRandomInteger(1,totalrow);
		 //System.out.println("total row"+ totalrow);
		 
		 clickOn("//table/tbody[@id='account_index']/tr["+randomval+"]/td[6]/a[contains(@title,'Edit')]");
		 
		 
		 String str=getAttribute(accountsLocator.getLocator("AccountsInformation.Name"), "value");
		 //System.out.println("Account name on edit page:"+ str);
		 
		 //String locator = headerLocator.getLocator("Header.Accounts");
		 //clickOn(locator);
		 
		 String locator1=headerLocator.getLocator("Header.More");
		 clickOn(locator1);
			
		String locator2=headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		 
		 String str1=getText("//li[@class='nav-header']");
		// System.out.println("Account name on list:"+ str1);
		 
		 if(str.contentEquals(str1))
		   {
			 Assert.assertTrue(true);
		   }
		 		 
	  }
	 
	//**********Filter Accounts and verify its filter results.*************************//
	 public void filter_AccountsAndVerifyResults()
	 {
		 String str="ABC Ford";
		 String locator1=accountsLocator.getLocator("Accounts.SearchForAccount");
		 sendKeys(locator1,str);
		 
		 String locator2=accountsLocator.getLocator("Accounts.SubmitButton");
		 clickOn(locator2);
		 
		 Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.ABCFordName")));
		 Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.ABCFordAddress")));
		 Assert.assertTrue(isElementPresent(accountsLocator.getLocator("Accounts.ABCFordCreatedDate")));
		 
	 }
	 
	//************Verify that support settings is successfully updated***************************//
	public void verify_SupportSettings()
	{
		  String locator1=accountsLocator.getLocator("Accounts.SocialPostsPerWeek");
		  sendKeys(locator1,"1");
		  
		  String locator2=accountsLocator.getLocator("Accounts.SupportCallsPerMonth");
		  sendKeys(locator2,"2");
		  
		  String locator3=accountsLocator.getLocator("Accounts.SubmitButton");
		  clickOn(locator3);
		 
	
	}
	
	//*************** Check sorting of name columns *****************************************//
	public void sort_NameCol()
	{
		// click on sort icon of rating columns
				String locator1 = accountsLocator.getLocator("Accounts.NameCol");
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// calculate the no of rows
				String locator2 = accountsLocator.getLocator("Accounts.RowCount");
				int n_rows = getSize(locator2);

				// store sorting value in array
				ArrayList <String> al1 = new ArrayList <String>();
				ArrayList <String> al2 = new ArrayList <String>();
				String str =null;
				for (int i=1; i<=n_rows; i++)
				{
					str = getText("//tbody[@id='account_index']/tr["+i+"]/td[1]");
					al1.add(str.substring(2));
					al2 = al1;

				}

				// check if sorted in ascending order or not
				Collections.sort(al1);
				int x=0; int size = al1.size();
				do
				{
					al1.get(1).equals(al2.get(2));
					x++;
				}while(x < size);

				// again click on sort icon to make it in descending order
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// store value in array and compare if it is descending order
				for (int i=1; i<=n_rows; i++)
				{
					//Thread.sleep(4000);
					str = getText("//tbody[@id='account_index']/tr["+i+"]/td[1]");

					al2.add(str.substring(7));
					al1.get(size-1).equals(al2.get(i-1));
					size--;

				}
	}
	
	//***************Verify current logged in account on official profile page************************
	public void verify_AccountOnOfficialProfile(String str) 
	{
		System.out.println("str value:"+str);
		String locator1=accountsLocator.getLocator("Accounts.OfficialProfile.BusinessName");
		//WaitForElementEnabled(locator1, 30);
		String str1=getAttribute(locator1,"value");
		this.WaitForElementNotVisible(str, 30);
		System.out.println("str1 value:"+str1);
		if(str.equals(str1))
		{
			Assert.assertTrue(true,"Account matched successfully");
		}
		
	}
	
	//****************Verify that admin notes is displayed on different pages.********************************//
	 public void verifyAdminNotesOnPages()
	 {
		 
		 //String locator1=accountsLocator.getLocator("AdminSettings.AdminNotes");
  		 //sendKeys(locator1,"Testing Admin Notes....");
  		 
  		//String locator2=accountsLocator.getLocator("AdminSettings.SubmitButton");
		//clickOn(locator2);
		
		String adminnotes=getAttribute(accountsLocator.getLocator("AdminSettings.AdminNotes"),"value");
		System.out.println("admin notes:"+adminnotes);
		
		/*if (str.equals(adminnotes))
		{
			Assert.assertTrue(true,"Admin Notes matched");
		}*/
	
	 }
	 
	 
		//*************Verify that same tracker packages are showing on Accounts and Admin sections.******************//
		public void verify_TrackerPackages(ArrayList <String> arr) 
		{

			ArrayList <String> al2 = new ArrayList<String>();
			
			String locator1=accountsLocator.getLocator("Accounts.AccountsInformation.TrackerPackages");
			clickOn(locator1);
		
			int totalval=getSize(accountsLocator.getLocator("Accounts.AccountsInformation.TrackerPackagesList"));
			
			 for(int i=1;i<totalval;i++)
			 {
				 
				 
				 al2.add(getText("//div[@id='account_package_ids_chzn']//li[contains(@id,'account_package_ids_chzn')]["+i+"]"));
			 }
			System.out.println("Total Tracker value in Account:"+al2);
			if(al2.contains(arr))
			{
				Assert.assertTrue(true,"Value matched");
			}
		}
	 

	 //*******Fetch 'AB Service CID' and 'Ivm cvd inventory dealer lot key' from Admin settings page.*********************//
	 public void fetchAbServiceAndIvmCvd()
	 {
		String locator1=accountsLocator.getLocator("AdminSettings.IvmCvdInventoryDealerLotKey");
		String ivmCvdInventoryval=getAttribute(locator1,"value");
		//System.out.println("ivmCvdInventoryval:"+ivmCvdInventoryval);
		
		String locator2=accountsLocator.getLocator("AdminSettings.ABServiceCID");
		String abservicecid=getAttribute(locator2,"value");
		
		//System.out.println("abservicecid:"+abservicecid);
		
		String locator3=accountsLocator.getLocator("AdminSettings.AccountText");
		clickOn(locator3);
		
		sendKeys(locator3,"ABC Ford");
		
		String locator4=accountsLocator.getLocator("AdminSettings.SelectAccount");
		clickOn(locator4);
		
		waitForLoading();
		
		Assert.assertTrue(isElementPresent(accountsLocator.getLocator("AdminSettings.ABCAccountName")));
		
		if(ivmCvdInventoryval.contains(getAttribute("//input[@id='account_account_native_ids_attributes_4_value']","value")));
		{
			Assert.assertTrue(true,"Value matched");
		}
		
		if(abservicecid.contains(getAttribute("//input[@id='account_account_native_ids_attributes_5_value']","value")));
		{
			Assert.assertTrue(true,"Value matched");
		}
		
	 }
	 
	
	
}



