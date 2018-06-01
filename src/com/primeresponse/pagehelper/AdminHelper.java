package com.primeresponse.pagehelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;
import com.primeresponse.util.ExecutionLog;


public class AdminHelper extends DriverHelper {

	private LocatorReader adminLocator;
	HeaderHelper headerHelper = new HeaderHelper(getWebDriver());
	Screen screen = new Screen();

	public AdminHelper(WebDriver driver) {
		super(driver);
		adminLocator = new LocatorReader("Admin.xml");		
	}

	// *********** Create User Methods ***************

	public void clickOnNewUser()
	{
		String locator = adminLocator.getLocator("Users.NewUser");
		clickOn(locator);
	}

	public void submitUserDetails(String email) throws InterruptedException
	{
		String locator1 = adminLocator.getLocator("Users.FirstName");
		sendKeys(locator1,"Test User Created by Webdriver Script execution");

		String locator2 = adminLocator.getLocator("Users.LastName");
		sendKeys(locator2,"Test");

		String locator3 = adminLocator.getLocator("Users.Email");
		sendKeys(locator3,email);

		String locator4 = adminLocator.getLocator("Users.AccountsOptions");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("Users.Accounts");
		this.WaitForElementPresent(locator5,10); 
		clickOn(locator5);

		String locator6 = adminLocator.getLocator("Users.GroupsOptions");
		clickOn(locator6);

		String locator7 = adminLocator.getLocator("Users.Groups");
		clickOn(locator7);

		String locator8 = adminLocator.getLocator("Users.RoleOptions");
		clickOn(locator8);

		String locator9= adminLocator.getLocator("Users.Roles");
		clickOn(locator9);

		String locator10= adminLocator.getLocator("Users.WhiteLabelOptions");
		clickOn(locator10);

		String locator11= adminLocator.getLocator("Users.WhiteLabel");
		clickOn(locator11);

		String locator12= adminLocator.getLocator("Users.GlobalAdmin");
		clickOn(locator12);

		String locator13 = adminLocator.getLocator("Users.SubmitButton");
		clickOn(locator13);
	}

	// ************* Delete User Method *****************

	public void deleteUser(String text)
	{
		String locator1 = adminLocator.getLocator("Users.SearchUserText");
		sendKeys(locator1, text);

		String locator2 = adminLocator.getLocator("Users.SubmitButton");
		clickOn(locator2);

		waitForLoading();

		String locator3 = adminLocator.getLocator("Users.DeleteAccount");
		clickOn(locator3);
		acceptAlert();
	}

	// ************** Search User Methods ************

	public void searchUser(String text)
	{

		//Verify Administrator is selected in drop down by default
		String locator = adminLocator.getLocator("Users.AdminRoleDropDown");
		isElementPresent(locator);

		//Search for user by Email
		String locator1 = adminLocator.getLocator("Users.SearchUserText");
		sendKeys(locator1, text);
		String locator2 = adminLocator.getLocator("Users.SubmitButton");
		clickOn(locator2);
		waitForLoading();

		//While search is executed no role is selected in user drop down
		String locator3 = adminLocator.getLocator("Users.SelectRole");
		isElementPresent(locator3);

		//Matching result string with searched user
		String user= getText(adminLocator.getLocator("Users.SearchEmail"));
		isElementPresent(user+"[contains(text(), 'text')]");
	}


	// *********** Create Package Methods ***************
	static String[] actArr= null;
	public void submitTrackerPackageDetails(String trackerpkg) throws InterruptedException
	{

		String locator1 = adminLocator.getLocator("TrackerPackage.NewTrackerPackageLink");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("TrackerPackage.TrackerPackageName");
		sendKeys(locator2, trackerpkg);

		String locator3 = adminLocator.getLocator("TrackerPackage.ClickTrackersList");
		clickOn(locator3);

		//Verify the Sort By Options


		List <WebElement> sortby= getWebDriver().findElements(ByLocator("//div[@id='package_tracker_package_tracker_ids_chzn']//div[@class='chzn-drop']//ul[@class='chzn-results']//li"));
		actArr= new String [5];	
		int k=0;
		for (WebElement opt: sortby)
		{
			actArr[k]= opt.getText();
			System.out.println(actArr[k]);
			k++;
			if(k==5)
				break;

		}

		String locator4 = adminLocator.getLocator("TrackerPackage.Trackers1");
		clickOn(locator4);
		clickOn(locator3);

		String locator5 = adminLocator.getLocator("TrackerPackage.Trackers2");
		clickOn(locator5);
		clickOn(locator3);

		String locator6 = adminLocator.getLocator("TrackerPackage.Trackers3");
		clickOn(locator6);
		clickOn(locator3);

		String locator7 = adminLocator.getLocator("TrackerPackage.Trackers4");
		clickOn(locator7);
		clickOn(locator3);

		String locator8 = adminLocator.getLocator("TrackerPackage.Trackers5");
		clickOn(locator8);

		String locator9 = adminLocator.getLocator("TrackerPackage.SubmitButton");
		clickOn(locator9);

	}

	public void selectTrackerPackage(String trackerpkg ) throws InterruptedException
	{
		String loc= "//div[@id='account_package_id_chzn']//div[@class='chzn-drop']//ul[@class='chzn-results']//li"; 
		int count= getSize(loc);
		for(int j=1; j<=count; j++)
		{
			String locator = "//*[@id='account_package_id_chzn']/a";
			clickOn(locator);
			String text = getText("//div[@id='account_package_id_chzn']//div[@class='chzn-drop']//ul[@class='chzn-results']//li["+j+"]");
			//System.out.println(text);
			if(text.contains(trackerpkg));
			{   
				clickOn("//ul[@class='chzn-results']//li[contains(text(),'"+trackerpkg+"')]");
				Thread.sleep(2000);
				break;
			}	
		}

		//Click on Update button
		String locator1 = adminLocator.getLocator("TrackerPackage.SubmitButton");
		clickOn(locator1);

	}

	//Fetch Tracker Packages from Admin >Tracker Packages
	public ArrayList<String> verify_TrackerPackages()
	{
		ArrayList <String> al2 = new ArrayList<String>();
		int totrowval =getSize(adminLocator.getLocator("TrackerPackage.Row"));
		System.out.println("Total Val:"+totrowval);

		for(int i=1;i<=totrowval;i++)
		{
			al2.add(getText("//tbody[@class='tracker_packages-body']/tr["+i+"]/td[1]"));
		}

		//System.out.println("Total Array val:"+al2);
		return al2;

	}

	public void checkTrackListeners()
	{

		//Verify listeners under created package
		int totallistners= getSize("//div[@class='table']/table/tbody/tr");

		for (int i=1; i<=totallistners;i++)
		{
			System.out.println("array is" +actArr[i-1]);
			if(getText("//div[@class='table']/table/tbody/tr["+i+"]/td[1]").contains(actArr[i-1]))
			{
				//System.out.println(i);

				Assert.assertTrue(this.isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[1]/img[@title='This track setting belongs to a package']"));
			}
		}
	}

	// ********** Methods to delete the package ********
	public void deletePackage(String text) {

		int row = getSize(adminLocator.getLocator("TrackerPackage.Row"));
		for (int i=1; i<= row; i++)
		{
			if(isElementPresent("//tbody[@class='tracker_packages-body']/tr["+i+"]/td[contains(text(), '"+text+"')]"))
			{
				clickOn("//tbody[@class='tracker_packages-body']/tr["+i+"]/td[*]/div/div/a[2]");
				acceptAlert();
			}

		}

	}

	// ******* Methods to create a vertical *****


	public void submitAvailableListColumnDetails(String str)
	{
		String locator1 = adminLocator.getLocator("VerticalPage.NewVerticalLink");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("VerticalPage.Name");
		sendKeys(locator2,"atestvertical"+ str);

		//Verify hidden fields
		isElementPresent(adminLocator.getLocator("VerticalPage.AvailableListColumn"));
		isElementPresent(adminLocator.getLocator("VerticalPage.DataTypeHiddenField1"));
		isElementPresent(adminLocator.getLocator("VerticalPage.DataTypeHiddenField2"));
		isElementPresent(adminLocator.getLocator("VerticalPage.DataTypeHiddenField3"));

		//Click 3 times on "Add Available Column Link
		String locator3 = adminLocator.getLocator("VerticalPage.AddAvailableColumnLink");
		clickOn(locator3);
		clickOn(locator3);
		clickOn(locator3);

		//Fill details of date type fields

		String locator4 = adminLocator.getLocator("VerticalPage.SelectField1");
		selectDropDown(locator4, "Number");

		String locator5 = adminLocator.getLocator("VerticalPage.SelectField2");
		selectDropDown(locator5, "Text");

		String locator6 = adminLocator.getLocator("VerticalPage.SelectField3");
		selectDropDown(locator6, "Transaction Type");

		//Enter value in text fields

		String locator7 = adminLocator.getLocator("VerticalPage.TextField1");
		sendKeys(locator7,"123456");

		String locator8 = adminLocator.getLocator("VerticalPage.TextField2");
		sendKeys(locator8,"abc"+ str);

		String locator9 = adminLocator.getLocator("VerticalPage.TextField3");
		sendKeys(locator9,"transtype"+ str);


		//Select hidden check box
		String locator10 = adminLocator.getLocator("VerticalPage.HiddenCheckBox");
		clickOn(locator10);

		//Select Mandatory check box

		String locator11 = adminLocator.getLocator("VerticalPage.MandatoryCheckBox");
		clickOn(locator11);

	}

	public void submitTransactionTypeDetails(String str)
	{
		//Click on Transaction Type Details tab
		String locator1 = adminLocator.getLocator("VerticalPage.TransactionTypes");
		clickOn(locator1); 

		//Click on Add Transaction Type Link
		String locator2 = adminLocator.getLocator("VerticalPage.AddTransactionTypeLink");
		clickOn(locator2);

		//Fill Transaction Type Name

		String locator3 = adminLocator.getLocator("VerticalPage.TransactionName");
		sendKeys(locator3,"TransName"+ str);

	}

	//This method is used to Submit the Product details
	public  void submitProductDetails(String str) 
	{
		//Click on Products tab
		String locator1 = adminLocator.getLocator("VerticalPage.Products");
		clickOn(locator1); 

		//Click on Add Products Link
		String locator2 = adminLocator.getLocator("VerticalPage.AddProductLink");
		clickOn(locator2);

		//Fill Products Name   	
		String locator3 = adminLocator.getLocator("VerticalPage.ProductsName");
		sendKeys(locator3,"atest "+ str);

		//Fill Tags
		String locator4 = adminLocator.getLocator("VerticalPage.ProductsTags");
		sendKeys(locator4,"TagName1"+ str);

	}

	//Submit Marketing Product Details
	public void submitMarketingProductDetails(String str) throws InterruptedException
	{
		//Click on Marketing Products tab
		String locator1 = adminLocator.getLocator("VerticalPage.MarketingProduct");
		clickOn(locator1); 

		//Click on Add Marketing Products Link
		String locator2 = adminLocator.getLocator("VerticalPage.AddMarketingProduct");
		clickOn(locator2);

		Thread.sleep(7000);
		//Fill Label   	
		String locator3 = adminLocator.getLocator("VerticalPage.Label");
		//this.WaitForElementPresent(locator3, 30);
		
		sendKeys(locator3,"test "+str);
		
		
		//Fill Medium
		String locator4 = adminLocator.getLocator("VerticalPage.Medium");
		sendKeys(locator4,"TagName1"+ str);
		
		//Fill Source
		String locator5 = adminLocator.getLocator("VerticalPage.Source");
		sendKeys(locator5,"TagName1"+ str);
		
		//Fill Campaign
		String locator6 = adminLocator.getLocator("VerticalPage.Campaign");
		sendKeys(locator6,"TagName1"+ str);


		
	}
	
	
	//***********Submit Account Attributes Details**************************//
	public void submitAccountAttributesDetails(String str)
	{
		
		//Click on Account Attributes tab
		String locator1 = adminLocator.getLocator("VerticalPage.AccountAttributes");
		clickOn(locator1); 

		//Click on Account Attributes Link
		String locator2 = adminLocator.getLocator("VerticalPage.AddAccountAttribute");
		clickOn(locator2);

		//Fill Label   	
		String locator3 = adminLocator.getLocator("VerticalPage.AccountAttributeLabel");
		sendKeys(locator3,"test "+str);
		
		//Fill Label   	
		String locator4 = adminLocator.getLocator("VerticalPage.AccountAttributeField");
		sendKeys(locator4,"test "+ str);

		//Click on submit buttons
		String locator5 = adminLocator.getLocator("VerticalPage.SubmitButton");
		clickOn(locator5);

	}

	// ******* Method to delete the Vertical ***********

	public void delete_Vertical()
	{
		int count= getSize(adminLocator.getLocator("VerticalPage.VerticalCount"));
		//System.out.println("total count:"+count);
		for(int i=1; i<=count; i++)
		{
			String name= getText("//div[@class='table']/table/tbody/tr["+i+"]/td[1]");
			if(name.contains("atest"))
			{
				clickOn("//div[@class='table']//tr["+i+"]/td[2]/a[2]/img");
				acceptAlert();
				break;
			}

		}
	}

	// ************ Method to Create Templates **********


	public void submitEmailTemplatesDetails(String str)
	{
		String locator1 = adminLocator.getLocator("EmailTemplates.NewEmailTemplatesLink");
		clickOn(locator1);

		//Verify 'New Email Template' text on 'Email Templates' page
		isTextPresent(adminLocator.getLocator("EmailTemplates.NewEmailTemplatesText"),"New Email Template");

		//Fill all details for Email Templates
		String locator2 = adminLocator.getLocator("EmailTemplates.Name");
		sendKeys(locator2,"Test Template Created by Webdriver Script Execution"+ str);

		String locator3 = adminLocator.getLocator("EmailTemplates.VerticalsDropDown");
		clickOn(locator3);

		String locator4 = adminLocator.getLocator("EmailTemplates.VerticalsList");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("EmailTemplates.AccountsDropDown");
		clickOn(locator5);

		String locator6 = adminLocator.getLocator("EmailTemplates.AccountsList");
		clickOn(locator6);

		String locator7 = adminLocator.getLocator("EmailTemplates.TagList");
		sendKeys(locator7,"testag "+ str);


		String locator8 = adminLocator.getLocator("EmailTemplates.TextAreaSource");
		clickOn(locator8);

		String locator9 = adminLocator.getLocator("EmailTemplates.TextArea");
		sendKeys(locator9,"%%Member_City%%%%Member_City%%%%Member_State%%%%Member_PostalCode%%%%Member_Country%%%%unsub_center_url%%%%profile_center_url%%%%Member_Addr%%%%Member_Busname%%");

		String locator10 = adminLocator.getLocator("EmailTemplates.SubmitButton");
		clickOn(locator10);   
	}

	// ******* Method to delete Template *****
	public void deleteTemplate(String str)
	{

		String locator1 = adminLocator.getLocator("EmailTemplates.TagName");
		clickOn(locator1); 

		String locator2 = adminLocator.getLocator("EmailTemplates.LoadingImg");
		WaitForElementNotPresent(locator2, 20);

		int count= getSize(adminLocator.getLocator("EmailTemplates.NameCount"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//div[@class='table']/table/tbody/tr["+i+"]/td[2]");
			if(name.contains(str))
			{
				clickOn("//tbody/tr["+i+"]/td/a[2]/img");
				acceptAlert();
				break;
			}

		}
	}

	// ******** Method to create category details *********
	public void submitCategoryDetails(String str, String path) {

		String locator1 = adminLocator.getLocator("Categories.NewCategorybtn");
		clickOn(locator1); 

		String locator2 = adminLocator.getLocator("Categories.Name");
		sendKeys(locator2, "Test360 Category "+ str);

		String locator3 = adminLocator.getLocator("Categories.TypeDropDown");
		clickOn(locator3);

		String locator4 = adminLocator.getLocator("Categories.Type");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("Categories.ImportKey");
		sendKeys(locator5, "Test ImportKey "+ str);

		String imgPath = path + "\\lighthouse.jpg";
		String locator6 = adminLocator.getLocator("Categories.AttachImg");
		//sendKeys(locator6, imgPath);
		getWebDriver().findElement(By.id("category_image_attributes_file")).sendKeys(imgPath);

		String locator7 = adminLocator.getLocator("Categories.SubmitButton");
		clickOn(locator7);  
		waitForLoading();

	}

	public void verifyCategoryThumbnail() {

		String locator7 = adminLocator.getLocator("Categories.ThumbnailTitle");
		isElementPresent(locator7);

		String locator8 = adminLocator.getLocator("Categories.ThimnailImg");
		isElementPresent(locator8);

	}

	// ************* Mehtods of Delete Category *********

	public void clickOnCategoryContent() {

		String locator7 = adminLocator.getLocator("Categories.CategoryContent");
		clickOn(locator7);  
	}

	public void deleteCategory(String str) {


		int count= getSize(adminLocator.getLocator("Categories.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//div[@id='category-categorycontent']/table/tbody/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//div[@id='category-categorycontent']/table/tbody/tr["+i+"]/td[4]/div/a[2]");
				acceptAlert();
				break;
			}

		}


	}

	// ************* Methods to create white label ********

	public void submitWhiteLabelDetails(String str, String path) {

		String locator1 = adminLocator.getLocator("WhiteLabels.NewWhiteLableLink");
		clickOn(locator1); 

		String locator2 = adminLocator.getLocator("WhiteLabels.Name");
		sendKeys(locator2, "Test360 White Lable "+str);

		String imgPath = path + "\\Lighthouse.jpg";
		String locator6 = adminLocator.getLocator("WhiteLabels.AttachImg");

		//sendKeys(locator6, imgPath);
		getWebDriver().findElement(By.id("white_label_logo_attributes_file")).sendKeys(imgPath);

		String locator7 = adminLocator.getLocator("WhiteLabels.Submitbtn");
		clickOn(locator7);  
		waitForLoading();
	}

	public void assignWhiteLable() {

		String locator1 = adminLocator.getLocator("Users.EditUser");
		clickOn(locator1); 
		waitForLoading();

		String locator10= adminLocator.getLocator("Users.WhiteLabelOptions");
		clickOn(locator10);

		String locator11= adminLocator.getLocator("Users.WhiteLabel");
		clickOn(locator11);

		String locator13 = adminLocator.getLocator("Users.SubmitButton");
		clickOn(locator13);
		waitForLoading();
	}

	public boolean checkLogo() {
		String locator1 = adminLocator.getLocator("WhiteLabels.Logo");
		if (isElementPresent(locator1))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	// ******* Method to Delete the white label *****
	public void deleteWhiteLabel(String str) {

		int count = getSize(adminLocator.getLocator("WhiteLabels.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//table/tbody/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//table/tbody/tr["+i+"]/td[2]/a[2]/img");
				acceptAlert();
				break;
			}

		}


	}

	// ******** Method to create application product and check same product assigning functionality to account *****

	public void submitAppProductDetails(String str, int n) {

		String locator1= adminLocator.getLocator("ApplicationProduct.NewProductButton");
		clickOn(locator1);

		String locator2= adminLocator.getLocator("ApplicationProduct.Name");
		sendKeys(locator2, str);

		String locator3= adminLocator.getLocator("ApplicationProduct.ProductId");
		sendKeys(locator3, "12"+n);

		String locator4= adminLocator.getLocator("ApplicationProduct.Submitbtn");
		clickOn(locator4);
		waitForLoading();
	}

	public void assignApplicationProduct(String str) {

		String locator1= adminLocator.getLocator("ApplicationProduct.AppProductIds");
		clickOn(locator1);

		//		String locator2= adminLocator.getLocator("ApplicationProduct.SelectProd");
		clickOn("//div[@id='account_application_product_ids_chzn']/div/ul/li[contains(text(), '"+str+"')]");

		String locator4= adminLocator.getLocator("ApplicationProduct.Submitbtn");
		clickOn(locator4);
		waitForLoading();

	}

	// ***** Method to delete the application product ********

	public void deleteApplicationProduct(String str) {

		int count = getSize(adminLocator.getLocator("ApplicationProduct.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//tbody[@class='products-body']/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//tbody[@class='products-body']/tr["+i+"]/td[3]/div/div/a[2]");
				acceptAlert();
				break;
			}

		}

	}

	//Verify total application product on Application products page.
	public ArrayList<String> verifyApplicationProductOnAdmin()
	{
		ArrayList <String> al2 = new ArrayList<String>();
		int count = getSize(adminLocator.getLocator("ApplicationProduct.Row"));
		//System.out.println("Total Row"+count);

		for(int i=1;i<=count;i++)
		{
			al2.add(getText("//tbody[@class='products-body']/tr["+i+"]/td[1]"));
			//System.out.println("Product name:"+al2);
		}

		return al2;
	}



	// ******* Method to create parents group *********

	public void submitParentGroupDetails(String str) {

		String locator1= adminLocator.getLocator("Groups.NewGroupLink");
		clickOn(locator1);

		String locator2= adminLocator.getLocator("Groups.Name");
		sendKeys(locator2, "Test360 Parent Group "+str);

		String locator3= adminLocator.getLocator("Groups.Description");
		sendKeys(locator3, "Test360 Description "+str);

		String locator12= adminLocator.getLocator("Groups.ChildTextBox");
		clickOn(locator12);

		String locator4= adminLocator.getLocator("Groups.ChildGroup");
		clickOn(locator4);

		String locator13= adminLocator.getLocator("Groups.AccountInputBox");
		clickOn(locator13);

		String locator5= adminLocator.getLocator("Groups.Account");
		clickOn(locator5);

		String locator6= adminLocator.getLocator("Groups.SFTPCheckBox");
		clickOn(locator6);

		String locator7= adminLocator.getLocator("Groups.SFTPFields");
		isElementPresent(locator7);

		String locator8= adminLocator.getLocator("Groups.Submitbtn");
		clickOn(locator8);

		String locator11= adminLocator.getLocator("Groups.AccInLIneError");
		isTextPresent(locator11, "Group cannot have accounts if there are child groups selected.");

		String locator9= adminLocator.getLocator("Groups.RemoveAccount");
		clickOn(locator9);
		WaitForElementNotVisible(locator4, 10);

		String locator10= adminLocator.getLocator("Groups.Submitbtn");
		clickOn(locator10);
		waitForLoading();
	}


	// ********* Method to create child group ********

	public void submitChildGroupDetails(String str) {

		String locator1= adminLocator.getLocator("Groups.NewGroupLink");
		clickOn(locator1);

		String locator2= adminLocator.getLocator("Groups.Name");
		sendKeys(locator2, "Test360 Child Group "+str);

		String locator3= adminLocator.getLocator("Groups.Description");
		sendKeys(locator3, "Test360 Description "+str);

	 
		String locator4= adminLocator.getLocator("Groups.DropDownIcon");
		
		
		clickOn(locator4);
		
		//WaitForElementNotVisible(locator4, 10);

		String locator5= adminLocator.getLocator("Groups.ParentGroup");
		clickOn(locator5);
		
		//WaitForElementNotVisible(locator5, 10);
		String locator6= adminLocator.getLocator("Groups.ChildTextBox");
		clickOn(locator6);

		String locator7= adminLocator.getLocator("Groups.ChildGroup");
		clickOn(locator7);

		String locator8= adminLocator.getLocator("Groups.AccountInputBox");
		clickOn(locator8);

		String locator9= adminLocator.getLocator("Groups.Account");
		clickOn(locator9);

		String locator10= adminLocator.getLocator("Groups.SFTPCheckBox");
		clickOn(locator10);

		String locator11= adminLocator.getLocator("Groups.SFTPFields");
		isElementPresent(locator11);

		String locator12= adminLocator.getLocator("Groups.Submitbtn");
		clickOn(locator12);

		String locator13= adminLocator.getLocator("Groups.ChildGrpInlineError");
		isTextPresent(locator13, "is invalid");

		String locator14= adminLocator.getLocator("Groups.RemoveChildGrp");
		clickOn(locator14);
		WaitForElementNotVisible(locator4, 10);

		String locator15= adminLocator.getLocator("Groups.Submitbtn");
		clickOn(locator15);
		waitForLoading();
	}

	// ********* Method to delete Groups ********

	public void deleteGroup(String str) {

		int count = getSize(adminLocator.getLocator("Groups.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//table/tbody/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//table/tbody/tr["+i+"]/td[2]/a[2]/img");
				acceptAlert();
				break;
			}

		}

	}

	//********Method to Create Recipient Templates ***********************

	public void submitAdminRecipientTemplates(String str)
	{
		String locator1 = adminLocator.getLocator("RecipientTemplates.NewTemplateButton");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("RecipientTemplates.Name");
		sendKeys(locator2,"test"+str);

		String locator3 = adminLocator.getLocator("RecipientTemplates.Description");
		sendKeys(locator3,"test"+str);

		String locator4 = adminLocator.getLocator("RecipientTemplates.VerticalDropDown");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("RecipientTemplates.VerticalDropDownValue");
		clickOn(locator5);

		waitForLoading();

		String locator6 = adminLocator.getLocator("RecipientTemplates.ConditionDropDownValue");
		clickOn(locator6);


		String locator7 = adminLocator.getLocator("RecipientTemplates.DropDownSelectFirstName");
		clickOn(locator7);

		String locator8 = adminLocator.getLocator("RecipientTemplates.ConditionTextValue");
		sendKeys(locator8,"Shishir");

		String locator9 = adminLocator.getLocator("RecipientTemplates.SubmitButton");
		clickOn(locator9);

	}

	//**********Method to Delete Recipient Templates*************************
	public void deleteAdminRecipientTemplates()
	{
		//String locator1 = adminLocator.getLocator("Admin.RecipientTemplates.RemoveButton");
		//clickOn(locator1);
		//acceptAlert();


		int count= getSize(adminLocator.getLocator("RecipientTemplates.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//table[@class='table table-striped']/tbody/tr["+i+"]/td[3]");
			if(name.contains("test"))
			{
				clickOn("//table[@class='table table-striped']/tbody/tr["+i+"]/td/a[2]");
				acceptAlert();
				break;
			}

		}
	}

	//**********Method to check  admin Group Hierarchy***************//
	String groupname=null;String parent_group_name=null;
	public void adminGroupHierarchy()  
	{
		String locator = adminLocator.getLocator("Groups.Row");
		int groupcount=getSize(locator);

		for(int i=1;i<=groupcount; i++)
		{
			String text1= getText(locator+"["+i+"]/td[1]");
			if(text1.contains("--"))
			{
				clickOn(locator+"["+i+"]/td[2]/a[1]/img");
				break;	
			}
		}

		parent_group_name =getText(adminLocator.getLocator("Groups.ParentGroupName"));
		groupname =getAttribute(adminLocator.getLocator("Groups.GroupName"), "value");

	}	
	//**********Method to verify Admin Group Hierarchy on Dashboard page***************//

	public void verifyGroupHierarchy()
	{
		//String locator = adminLocator.getLocator("Groups.NewRow"); 
		String locator = adminLocator.getLocator("Groups.NewRow"); 
		int rowcount=getSize(locator);    

		if(isElementPresent("//div[@class='prime-breadcrumb']//a[contains(text(),'Dashboard')]"))
		{
			clickOn("//div[@class='prime-breadcrumb']//a[contains(text(),'Dashboard')]");
		}

		waitForLoading();

		for (int j=1; j<= rowcount; j++)
		{
			if(getText(locator+"["+j+"]/td[2]").matches(parent_group_name))
			{
				clickOn(locator+"["+j+"]/td[1]/a/img");
				break;
			}

		}

		for(int i=1; i<=rowcount; i++)
		{   		 
			if(getText(locator+"["+i+"]/td[2]").contains(groupname))
			{
				System.out.println("Text Matched: "+groupname);
				break;
			}
		}

	}  

	//************Method to verify user details**************// 
	public void verifyAdminUserDetails(String firstname,String lastname,String email)
	{
		clickOn(adminLocator.getLocator("Users.EditUser"));

		String str1=getAttribute(adminLocator.getLocator("Users.FirstName"),"value");
		WaitForElementPresent(adminLocator.getLocator("Users.FirstName"),30);
		if(firstname.equals(str1)) 
		{
			Assert.assertTrue(isElementPresent(adminLocator.getLocator("Users.FirstName")));
		}

		String str2=getAttribute(adminLocator.getLocator("Users.LastName"),"value");
		if(lastname.equals(str2)) 
		{
			Assert.assertTrue(isElementPresent(adminLocator.getLocator("Users.LastName")));
		}

		String str3=getAttribute(adminLocator.getLocator("Users.Email"),"value");

		if(email.equals(str3)) 
		{
			Assert.assertTrue(isElementPresent(adminLocator.getLocator("Users.Email")));
		}

		Assert.assertTrue(isElementPresent(adminLocator.getLocator("Users.Accounts")));


	}

	// ****** Method to verify listeners list *******
	public void check_SubTabsListeners(ArrayList <String> al ) {

		String locator1 = adminLocator.getLocator("Listeners.SubMenus");
		//String locator1 = "css=.row-fluid:nth-child(1) *>ul.nav.nav-pills.pull-right>li>a";
		//

		//javaScriptExecute("window.document.getElementsByTagName('a')[101].click()");
		//waitForLoading();
		//javaScriptExecute("window.document.getElementsByTagName('a')[102].click()");
		//waitForLoading();
		//javaScriptExecute("window.document.getElementsByTagName('a')[103].click()");
		//waitForLoading();
		//javaScriptExecute("window.document.getElementsByTagName('a')[104].click()");
		//waitForLoading();

		//int no_submenus = getSize(locator1);
		//for(int i =2; i<=no_submenus; i++)
		//{				
		///mouseDoubleClick(locator1+"["+i+"]");
		//clickOn(locator1+":nth-child("+i+")");

		//waitForLoading();
		//String loc = "//a";
		///int no_rows = getSize(loc);
		//for (int j =1; j<=120;j++)
		//{

		//String str = javaScriptExecute("window.document.getElementsByTagName('a')["+j+"].getAttribute('href')");


		//System.out.println("Anchor value: "+str);

		//}*/

		// System.out.println("ssssdds");
		String locator2 = adminLocator.getLocator("Listeners.Row");
		int no_rows = getSize(locator2);
		//System.out.println("Total Row:"+no_rows);

		for (int j =1; j<=no_rows;j++)
		{
			//al.add(getText(locator2+"["+j+"]/td[1]"));
			al.add(getText("//div[@id='data-wiselinks-container']//tbody/tr["+j+"]/td[1]"));
			//System.out.println("Text msg:"+getText("//div[@id='data-wiselinks-container']//tbody/tr["+j+"]/td[1]"));
		}


		Collections.sort(al);

	}

	public void match_AllListeners(ArrayList <String> al) {

		ArrayList <String> al2 = new ArrayList<String>();
		String locator1 = adminLocator.getLocator("Listeners.SubMenus");
		clickOn(locator1+"[1]");
		waitForLoading();

		String locator2 = adminLocator.getLocator("Listeners.Row");
		int no_rows = getSize(locator2);
		for (int j =1; j<=no_rows;j++)
		{
			al2.add(getText(locator2+"["+j+"]/td[1]"));
		}

		Collections.sort(al2);
		System.out.println("al2:"+ al2);

		System.out.println("al:"+ al);
		assert(al.equals(al2));

	}	

	// ************** Method to create Great Plains Products ************
	public String adminCreateGreatPlainsProducts(String str)
	{
		String locator1=adminLocator.getLocator("GreatPlainsProducts.NewButton");
		clickOn(locator1);
		
		int strr=this.getRandomInteger(0,9);

		String locator2=adminLocator.getLocator("GreatPlainsProducts.NameTextField");
		sendKeys(locator2,"test"+strr);

		String str1= this.getAttribute(locator2, "value");

		String locator3=adminLocator.getLocator("GreatPlainsProducts.SubmitButton");
		clickOn(locator3);

		return str1;

	}

	// **************Method to Delete Great Plains Products from Admin menu************//
	public void deleteAdminGreatPlainsProducts()
	{
		String str="test";
		String locator = adminLocator.getLocator("GreatPlainsProducts.RowCount");
		int rowcount=getSize(locator);
		//System.out.println("total size:"+rowcount);
		for(int i=1;i<=rowcount;i++)
		{

			if(getText(locator+"["+i+"]/td[1]").contains(str))
			{

				clickOn(locator+"["+i+"]/td[3]/div/div/a[2]/i");
				acceptAlert();
				break;
			}

		}


	}

	//***********Verify process of creating new notification**********************//
	public void create_Notification()
	{
		String locator1 = adminLocator.getLocator("Notifications.NewNotifications");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("Notifications.WhomToNotifyList");
		clickOn(locator2);

		String locator3 = adminLocator.getLocator("Notifications.Administrator");
		clickOn(locator3);

		String locator4 = adminLocator.getLocator("Notifications.DateRangeList");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("Notifications.TodayOnlyDate");
		clickOn(locator5);

		String locator6 = adminLocator.getLocator("Notifications.DescriptionTextArea");
		sendKeys(locator6,"test");

		String locator7 = adminLocator.getLocator("Notifications.SubmitButton");
		clickOn(locator7);

	}

	//************** Verify process of deleting any randomly notification****************//
	public void delete_Notification()
	{
		int totalrow=getSize(adminLocator.getLocator("Notifications.Row"));
		int randomval=getRandomInteger(1,totalrow);
		clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"]/td[7]/a/img");
		acceptAlert();

	}

	//************ Verify process of creating new Rss Seeds ***************************//
	public void create_RssSeed()
	{
		String locator1 = adminLocator.getLocator("RssSeeds.NewSeedButton");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("RssSeeds.Name");
		sendKeys(locator2,"New Jaguar 2014 Video");

		int randomval=this.getRandomInteger(0, 9);		
		String locator3 = adminLocator.getLocator("RssSeeds.Url");
		sendKeys(locator3,"https://www.youtube.com/watch?v=Gg-TyW84aGU"+randomval);

		String locator4 = adminLocator.getLocator("RssSeeds.LocationList");
		clickOn(locator4);
		sendKeys(locator4,"te");
		clickOn(adminLocator.getLocator("RssSeeds.LocationValue"));

		String locator5 = adminLocator.getLocator("RssSeeds.BrandList");
		sendKeys(locator5,"Jaguar");

		String locator6 = adminLocator.getLocator("RssSeeds.Category");
		clickOn(locator6);


		String locator7 = adminLocator.getLocator("RssSeeds.CategoryValue");
		WaitForElementVisible(locator7, 30);
		clickOn(locator7);

		String locator8 = adminLocator.getLocator("RssSeeds.New");
		clickOn(locator8);

		String locator9 = adminLocator.getLocator("RssSeeds.SubmitButton");
		clickOn(locator9);


	}

	//*********************** Verify process of deleting Rss Seeds********************************//
	public void delete_RssSeeds()
	{
		String str="New Jaguar 2014 Video";
		int totalrow=getSize(adminLocator.getLocator("RssSeeds.Row"));
		System.out.println("total size:"+totalrow);

		for(int i=1;i<=totalrow;i++)
		{
			if(getText("//tbody[@id='rss_seeds-body']/tr["+i+"]/td[1]").contains(str))
			{
				clickOn("//tbody[@id='rss_seeds-body']/tr["+i+"]//a[3]");
				acceptAlert();
				break;
			}
		}
	}


	//*********Verify process of creating Great Plains Import Files********************// 
	public void create_GreatPlainsImportFiles(String path, String str) throws InterruptedException
	{
		String locator1 = adminLocator.getLocator("GreatPlainsImport.NewButton");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("GreatPlainsImport.Name");
		sendKeys(locator2, "List uploaded by Webdriver automation script execution" + str);

		//String imgPath1 = path + "//images//Win7BrowseButton.png";
		//String csvPath = path + "//Upload_list.csv";
		Thread.sleep(3000);
		//System.out.println(csvPath);
		

		String file_locator = adminLocator.getLocator("GreatPlainsImport.Browse");
		String csvPath = path + "\\Upload_list.csv";
		sendKeys(file_locator, csvPath);
		//System.out.println("dfdffdfdf"+csvPath);
		Assert.assertTrue(true,csvPath);


		/*screen.sendKeys(file_locator,csvPath);
		try {
			screen.paste(imgPath1, csvPath);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		String locator3 = adminLocator.getLocator("GreatPlainsImport.SubmitButton");
		clickOn(locator3);


	}

	private String getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	//Verify process of deleting Great Plains Import Files
	public void deleteAdminGreatPlainsImport()
	{
		String str="List uploaded by Webdriver automation script execution";
		int totrow=getSize(adminLocator.getLocator("GreatPlainsImport.Row"));
		//System.out.println("Total Row:"+totrow);

		for(int i=1;i<=totrow;i++)
		{
			String str1=getText("//tbody[@class='great-plains-products-body']/tr["+i+"]");
			if(str1.contains(str))
			{
				clickOn("//tbody[@class='great-plains-products-body']/tr["+i+"]//a");
				acceptAlert();
				break;
			}

		}

	}

	//********Verify process of filtering Jobs queue****************************//
	public void filterJobsQueue()
	{
		String locator1 = adminLocator.getLocator("Jobs.ChooseFilter");
		clickOn(locator1);

		int totrow=getSize(adminLocator.getLocator("Jobs.Row"));
		int randomval=getRandomInteger(1,totrow);
		clickOn("//div[@id='job_payload_object_chzn']//li["+randomval+"]");


	}

	//****************Verify process of creating KPI template ************************************//
	public void create_KPI_Template()
	{
		String locator1 = adminLocator.getLocator("KpiTemplate.CreateKpiTemplateButton");
		clickOn(locator1);

		String locator2 = adminLocator.getLocator("KpiTemplate.Name");
		sendKeys(locator2,"Test KPI");


		String locator3 = adminLocator.getLocator("KpiTemplate.Description");
		sendKeys(locator3,"Test KPI");

		String locator4 = adminLocator.getLocator("KpiTemplate.VerticalList");
		clickOn(locator4);

		String locator5 = adminLocator.getLocator("KpiTemplate.VerticalValue");
		clickOn(locator5);

		String locator6 = adminLocator.getLocator("KpiTemplate.AddSegmentation");
		clickOn(locator6);

		String locator7= adminLocator.getLocator("KpiTemplate.SegmentName");
		sendKeys(locator7,"Test");

		String locator8 = adminLocator.getLocator("KpiTemplate.AddGroupLink");
		clickOn(locator8);

		String locator9 = adminLocator.getLocator("KpiTemplate.AddCondition");
		clickOn(locator9);

		String locator10 = adminLocator.getLocator("KpiTemplate.ConditionValue");
		sendKeys(locator10,"test");

		String locator11 = adminLocator.getLocator("KpiTemplate.SubmitButton");
		clickOn(locator11);
	}


	// **********Verify process of deleting KPI template********************//
	public void delete_KPI_Template()
	{
		String str ="Test KPI";

		int totrow=getSize(adminLocator.getLocator("KpiTemplate.Row"));
		for(int i=1;i<=totrow;i++)
		{
			if(str.contains(getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[1]")))
			{
				clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[6]//a[2]");
				acceptAlert();
				break;
			}
		}

	}

	//************ Verify KPI templates on Integrations page*****************************// 
	public ArrayList<String> verify_KpiTemplateOnIntegrations()
	{
		ArrayList<String> al2 = new ArrayList<String>();
		int totrow=getSize(adminLocator.getLocator("KpiTemplate.Row"));

		//System.out.println("Row Value:"+totrow);
		for(int i=1; i<=totrow; i++)
		{
			al2.add(getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[1]"));
			//System.out.println("KPI Value:"+al2);
		}

		return al2;
	}

}
