package com.primeresponse.pagehelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.testng.Assert;

import org.sikuli.script.Screen;
import org.openqa.selenium.WebDriver;


import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class EnterpriseHelper extends DriverHelper  {

	private LocatorReader enterpriseLocator;
	Screen screen = new Screen();
	public EnterpriseHelper(WebDriver driver) {
		super(driver);
		enterpriseLocator = new LocatorReader("Enterprise.xml");
		
	}

	public int getRows() {

		String locator = enterpriseLocator.getLocator("MyAccounts.Row");
		int nrow = getSize(locator);
		System.out.println("Total row:"+nrow);
		return nrow;
	}

	// ******** Method for sorting Accounts Name col *********
	public void checkNameSort(int nrow) {

		ArrayList<String> al = new ArrayList<String>();
		for (int i=2 ; i <= nrow ; i++)
		{		    
			al.add(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[2]"));
		}

		Collections.sort(al, String.CASE_INSENSITIVE_ORDER);
		clickOn(enterpriseLocator.getLocator("MyAccounts.SortIcon"));

		for (int i=2 ; i <= nrow ; i++)
		{

			Assert.assertEquals(al.get(i-2), getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[2]"));
		}

		clickOn(enterpriseLocator.getLocator("MyAccounts.SortIcon"));
		int size = al.size()-1;

		for (int i=2; i<=nrow ; i++)
		{
			Assert.assertEquals(al.get(size), getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[2]"));
			size--;			
		}
	}

	// ************ Method for sorting review column **********

	public void storeReviews(int nrow) {

		for (int j=4 ; j<=10 ; j=j+2)
		{
			ArrayList<String> al = new ArrayList<String>();

			for (int i=2 ; i <= nrow ; i++)

			{	
				al.add(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td["+j+"]"));	  
			}

			clickOn("//div[@id='data-wiselinks-container']//table/thead/tr[2]/th["+j+"]/span");
			waitForLoading();

			Collections.sort(al);

			//System.out.println("al:" + al);

			for (int i=2 ; i <=nrow ; i++)
			{
				Assert.assertEquals(al.get(i-2), getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td["+j+"]"));

				//System.out.println("asc: " + selenium.getText("//div[@class='table']/table[@class='sort-table']/tbody/tr["+i+"]/td["+j+"]"));
			}

			clickOn("//div[@id='data-wiselinks-container']//table/thead/tr[2]/th["+j+"]/span");
			waitForLoading();

			int size = al.size()-1;

			for (int i=2; i<=nrow ; i++)
			{
				Assert.assertEquals(al.get(size), getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td["+j+"]"));	
				size--;	

			}
		}

	}

	// *********** Method to sort the star rating columns ************
	public void checkStarRatingSort(int nrow) { 

		for (int j=5 ; j<=10 ; j=j+2)
		{
			ArrayList<String> al = new ArrayList<String>();

			for (int i=2 ; i <= nrow ; i++)

			{	
				al.add(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td["+j+"]"));	  
			}

			clickOn("//div[@id='data-wiselinks-container']//table/thead/tr[2]/th["+j+"]/span");
			waitForLoading();

			Collections.sort(al);

			//System.out.println("al:" + al);

			for (int i=2 ; i <=nrow ; i++)
			{
				Assert.assertEquals(al.get(i-2), getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td["+j+"]"));

				//System.out.println("asc: " + selenium.getText("//div[@class='table']/table[@class='sort-table']/tbody/tr["+i+"]/td["+j+"]"));
			}

			clickOn("//div[@id='data-wiselinks-container']//table/thead/tr[2]/th["+j+"]/span");
			waitForLoading();

			int size = al.size()-1;

			for (int i=2; i<=nrow ; i++)
			{
				Assert.assertEquals(al.get(size), getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td["+j+"]"));	
				size--;	

			}
		}


	}
	
	
	// *********** Method to sort the review response columns ************
	public void checkReviewResponsesSort(int nrow) {

		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=2 ; i<= nrow ; i++)
		{		    
			al.add(Integer.parseInt(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]")));
		}

		Collections.sort(al);

		for (int i=2 ; i<= nrow ; i++)
		{
			int str = Integer.parseInt(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]"));
			al.get(i-2).equals(str);
		}

		//clickOn(enterpriseLocator.getLocator("MyAccounts.ReviewResponse"));
		waitForLoading();

		int size = al.size()-1;

		for (int i=2; i<=nrow ; i++)
		{
			int str = Integer.parseInt(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]"));
			al.get(size).equals(str);
			size--;			
		}


	}

	// ********** Method to sort the Facebook Likes column ********

	public void checkFacebookLikesSort(int nrow) {

		ArrayList<String> al = new ArrayList<String>();
		for (int i=2 ; i<= nrow ; i++)
		{		    
			al.add(getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[10]"));
		}

		Collections.sort(al);
		//System.out.println("al:" +al);

		for (int i=2 ; i<= nrow ; i++)
		{
			String str = getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[10]");
			//System.out.println("str:" +  str);
			al.get(i-2).equals(str);
		}

		clickOn(enterpriseLocator.getLocator("MyAccounts.FacebookLikes"));

		int size = al.size()-1;

		for (int i=2; i<=nrow ; i++)
		{
			String str = getText("//div[@id='data-wiselinks-container']//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[10]");
			al.get(size).equals(str);
			size--;			
		}

	}

	// ***** Method to check functionality of segmentation buttons

	public void checkDefaultSegment() {

		String locator1 = enterpriseLocator.getLocator("SummaryHeader");
		String locator2 = enterpriseLocator.getLocator("DefaultSegmentation");
		if(isElementPresent(locator1))
		{
			isElementPresent(locator2+"[contains(text(), '365d')]");
		}


		String locator3 = enterpriseLocator.getLocator("InfluenceDashboard");
		if(isElementPresent(locator3))
		{
			isElementPresent(locator2+"[contains(text(), '90d')]");
		}

		else
		{
			isElementPresent(locator2+"[contains(text(), '30d')]");
		}

	}

	public void checkSegmentationButtonCount() {
		String locator = enterpriseLocator.getLocator("SegmentationButtons");
		int n = getSize(locator);
		Assert.assertEquals(n, 6);
		isElementPresent(locator+"[contains(@text, '30d')]");
		isElementPresent(locator+"[contains(@text, '60d')]");
		isElementPresent(locator+"[contains(@text, '90d')]");
		isElementPresent(locator+"[contains(@text, '1800d')]");
		isElementPresent(locator+"[contains(@text, '365d')]");
		isElementPresent(locator+"[contains(@text, 'All')]");
	}

	// *********** Select any random group and get the name of sub groups and accounts ***********
	ArrayList<String> accounts = new ArrayList<String>();
	ArrayList<String> sub_grps = new ArrayList<String>();
	String grp_name;
	public void selectGroup() {

		String locator1 = enterpriseLocator.getLocator("DashboardLink");
		String locator2 = enterpriseLocator.getLocator("MyAccounts.Row");
		int n_row_page1 = getSize(locator2);
		int rand = getRandomInteger(2, n_row_page1);
		if(isElementPresent(locator1))
		{
			clickOn(locator1);
		}
		//WaitForElementNotPresent(locator1, 20);
		clickOn("//div[@id='enterprise-dashboard']//table[@class='table table-striped sort-table']/tbody/tr["+rand+"]/td/a/img");
		WaitForElementPresent(locator1, 20);
		int n_row_page2 = getSize(locator2);
		//String locator4 = getAttribute(enterpriseLocator.getLocator("LoginIcon"), "title");
		String locator4 = getAttribute("//div[@id='enterprise-dashboard']//table[@class='table table-striped sort-table']/tbody/tr["+rand+"]/td/a/img", "title");
		if(locator4.contains("Login to account"))
		{
			for (int i = 2; i<= n_row_page2; i++ )
			{
				accounts.add(getText(locator2+"["+i+"]/td[2]"));
			}
		}



		else
		{
			for (int i = 2; i<= n_row_page2; i++ )
			{
				sub_grps.add(locator2+"["+i+"]/td[2]");
			}


		}
		//System.out.println(accounts);
		//System.out.println(sub_grps);
		String locator3 = enterpriseLocator.getLocator("SelectedGrp");
		grp_name = getText(locator3);

	}

	public void matchAccountsOrSubGrps() {

		String locator1 = enterpriseLocator.getLocator("GroupsRow");
		int n = getSize(locator1);

		for (int i = 1; i <= n; i++)
		{
			if(getText(locator1+"["+i+"]/td[1]").contains(grp_name))
			{
				clickOn(locator1+"["+i+"]/td[2]/a[1]/img");
				WaitForElementPresent("//li[contains(text(), '"+grp_name+"')]", 20);
				break;
			}
		}

		String locator2 = enterpriseLocator.getLocator("NullGroups");
		if(isElementPresent(locator2))
		{
			String locator3 = enterpriseLocator.getLocator("NoOfAccounts");
			int no_of_acc = getSize(locator3);
			for (int i=1; i<=no_of_acc-1; i++)
			{
				System.out.println("==: "+accounts.get(i-1));
				System.out.println("##: "+getText(locator3+"["+i+"]/span"));
				Assert.assertEquals(accounts.get(i-1), getText(locator3+"["+i+"]/span"));
//				System.out.println(accounts.get(i-1));
//				System.out.println(getText(locator3+"["+i+"]/span"));

			}
		}
		else
		{
			String locator4 = enterpriseLocator.getLocator("NoOfGrps");
			int no_of_acc = getSize(locator4);
			for (int i=1; i<=no_of_acc; i++)
			{
				Assert.assertEquals(sub_grps.get(i-1), getText(locator4+"["+i+"]/span"));
			}
		}


	}

	//**************Method to check Group Totals ******************************//

	public void checkGroupTotals() throws InterruptedException
	{
		/*if(!isElementPresent(enterpriseLocator.getLocator("DashboardLink")))
		{
			clickOn(enterpriseLocator.getLocator("Dashboard.AllButton"));
		}
		else
		{
			clickOn(enterpriseLocator.getLocator("DashboardLink"));
			clickOn(enterpriseLocator.getLocator("Dashboard.AllButton"));
		}
		  */

		clickOn(enterpriseLocator.getLocator("Dashboard.AllButton"));
		//Thread.sleep(3000);
		waitForLoading();
		
		int row=getSize(enterpriseLocator.getLocator("Row"));
		//System.out.println("Row"+row);
		
		int total_sum = 0; int total_sum1 =0; int total_sum2=0; int total_sum3 = 0; int total_sum4=0;
		
       
		//int emailsSent_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount0"))); 
		//System.out.println("emailsSent_totals:"+emailsSent_totals);
		
		String emailsSent_totals=getText(enterpriseLocator.getLocator("Dashboard.TotalCount0")); 
		//System.out.println("emailsSent_totals:"+emailsSent_totals);
		String newemailsSent_totals=emailsSent_totals.replace(",","" );
		int newemailsSent_totals1=Integer.parseInt(newemailsSent_totals);
		
		
		String webRating_totals=getText(enterpriseLocator.getLocator("Dashboard.TotalCount1"));
		//System.out.println("webRating_totals:"+webRating_totals);
		String newwebRating_totals=webRating_totals.replace(",","" );
		int webRating_totals1=Integer.parseInt(newwebRating_totals);
		
		//int webRating_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount1")));
		//System.out.println("webRating_totals:"+webRating_totals);
		
		int reviewResponses_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount2")));
		//System.out.println("reviewResponses_totals:"+reviewResponses_totals);
		
		int reviews_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount3")));
		//System.out.println("reviews_totals:"+reviews_totals);
		
				
		//int internaRating_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount4")));
		String internaRating_totals=getText(enterpriseLocator.getLocator("Dashboard.TotalCount4"));
		//System.out.println("internaRating_totals:"+internaRating_totals);
		String newinternaRating_totals=internaRating_totals.replace(",","" );
		int newinternaRating_totals1=Integer.parseInt(newinternaRating_totals);
		
		//			int fbLikes_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("Dashboard.TotalCount5")));

		//System.out.println("reviewResponses_totals:" + reviewResponses_totals + " reviews_totals:" +reviews_totals + " webRating_totals:" + webRating_totals + " internaRating_totals:" + internaRating_totals);

		for (int i=2;i<=row; i++)
		{   
			
			//total_sum +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[3]"));
			//total_sum1 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[4]"));
			//total_sum2 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]"));
			//total_sum3 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[7]"));
			//total_sum4 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[9]"));
			//total_sum4 +=Integer.parseInt(getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[10]"));
			
			String str=getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[3]");
			String newstr=str.replace(",","" );
			total_sum +=Integer.parseInt(newstr);
			//System.out.println("new str:::"+newstr);
			
			String str1=getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[4]");
			String newstr1=str1.replace(",","" );
			total_sum1 +=Integer.parseInt(newstr1);
			
			String str2=getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]");
			String newstr2=str2.replace(",","" );
			total_sum2 +=Integer.parseInt(newstr2);
			
			String str3=getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[7]");
			String newstr3=str3.replace(",","" );
			total_sum3 +=Integer.parseInt(newstr3);
			
			String str4=getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[9]");
			String newstr4=str4.replace(",","" );
			total_sum4 +=Integer.parseInt(newstr4);
			//System.out.println("Ttotal_sum:" + total_sum);
		}
		
		Assert.assertEquals(newemailsSent_totals1,total_sum);
		Assert.assertEquals(webRating_totals1,total_sum1);
		Assert.assertEquals(reviewResponses_totals, total_sum2);
		Assert.assertEquals(reviews_totals, total_sum3);
		Assert.assertEquals(newinternaRating_totals1, total_sum4);
		//Assert.assertEquals(fbLikes_totals, total_sum4);


	}


	//**************Method to check My Accounts Totals ******************************//

	public void checkMyAccountsTotals()
	{
		clickOn(enterpriseLocator.getLocator("Dashboard.AllButton"));

		int row=getSize(enterpriseLocator.getLocator("Row"));
		//System.out.println("Total column count 1:" + row);

		int total_sum = 0; int total_sum1 =0; int total_sum2=0; int total_sum3 = 0;int total_summ = 0;
		int emailSent_totals=0;

		emailSent_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("MyAccounts.TotalCount0")));
		int reviewResponses_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("MyAccounts.TotalCount1")));
		int reviews_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("MyAccounts.TotalCount2")));
		int webRating_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("MyAccounts.TotalCount3")));
		int internaRating_totals=Integer.parseInt(getText(enterpriseLocator.getLocator("MyAccounts.TotalCount4")));
		//System.out.println("reviewResponses_totals:" + reviewResponses_totals + " reviews_totals:" +reviews_totals + " webRating_totals:" + webRating_totals + " internaRating_totals:" + internaRating_totals);

		for (int i=2;i<=row; i++)
		{
		  String totalsumm = getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[3]");
		  String newtotal_summ =totalsumm.replace(",","" );
		  total_summ+=Integer.parseInt(newtotal_summ);
			
		  
		  String totalsum = getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[4]");
		  String newtotal_sum =totalsum.replace(",","" );
		  total_sum+=Integer.parseInt(newtotal_sum);
		  
		  String totalsum1 = getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]");
		  String newtotal_sum1 =totalsum1.replace(",","" );
		  total_sum1+=Integer.parseInt(newtotal_sum1);
		  
		  String totalsum2 = getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[7]");
		  String newtotal_sum2 =totalsum2.replace(",","" );
		  total_sum2+=Integer.parseInt(newtotal_sum2);
		  
		  String totalsum3 = getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[9]");
		  String newtotal_sum3 =totalsum3.replace(",","" );
		  total_sum3+=Integer.parseInt(newtotal_sum3);
			
    		//total_sum +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[4]"));
			//total_sum1 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[6]"));
			//total_sum2 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[7]"));
			//total_sum3 +=Integer.parseInt(getText("//table[@class='table table-striped sort-table']/tbody/tr["+i+"]/td[9]"));
			//System.out.println("Ttotal_sum:" + total_sum);
		}
		Assert.assertEquals(emailSent_totals,total_summ );
		Assert.assertEquals(reviewResponses_totals, total_sum);
		Assert.assertEquals(reviews_totals, total_sum1);
		Assert.assertEquals(webRating_totals, total_sum2);
		Assert.assertEquals(internaRating_totals, total_sum3);

	}



	// ******* Methods to verify Go to site functionality********
	public void selectGroupAtEnterprise() {

		String locator1 = enterpriseLocator.getLocator("ExternalFeed.GroupDropDownIcon");
		clickOn(locator1);
	
		
		//clickOn("//li[@id='external_feed_parent_id_chzn_o_482']");
		//clickOn("//div[@id='external_feed_value_chzn']//span[contains(text(),'Response filter')]");
		//clickOn("//li[contains(text(),'Without Responses')]");
		
		String locator2 = enterpriseLocator.getLocator("ExternalFeed.RandyGrp");
		clickOn(locator2);
		
		String locator3 = enterpriseLocator.getLocator("ExternalFeed.ResponseFilter");
		clickOn(locator3);
		
		String locator4 = enterpriseLocator.getLocator("ExternalFeed.ResponseFilterValue");
		clickOn(locator4);
		
		waitForLoading();
		
/*
		String locator2 = enterpriseLocator.getLocator("ExternalFeed.SearchGrp");
		sendKeys(locator2, "Randy Test Group");
		
		waitForLoading();

		String locator3 = enterpriseLocator.getLocator("ExternalFeed.SearchedGrp");
		clickOn(locator3); */
		
		

	}

	public String selectSource() throws InterruptedException {

		waitForLoading();
		String locator1 = enterpriseLocator.getLocator("ExternalFeed.SourceDropDownIcon");
		WaitForElementPresent(locator1,30);
		//Thread.sleep(4000);
		clickOn(locator1);
		waitForLoading();

		String locator2 = enterpriseLocator.getLocator("ExternalFeed.Sources");
		int no_sources = getSize(locator2);

		int rnd_source = getRandomInteger(1, no_sources);
		String source_name = getText(locator2+"["+rnd_source+"]");
		clickOn(locator2+"["+rnd_source+"]");
		//System.out.println(source_name);
		return source_name;
	}

	public void goToSite(String source, String appUrl) throws InterruptedException {

		String locator1 = enterpriseLocator.getLocator("ExternalFeed.GoToSite");
		if(isElementPresent(locator1))
		{
			String url = getAttribute(locator1, "href");	
			System.out.println(url);
			//		assert(url.contains("(?i).*" +source+ ".*"));
			assert(!url.contains("(?i).*" +appUrl+ ".*"));
		}
		else
		{
			selectSource();
		}


	}

	// ******** Check default sorting of Published date at Eternal Feeds screen ********

	public void checkPublishedSort() {

		String locator1 = enterpriseLocator.getLocator("InternalFeed.Row");
		int n_rows = getSize(locator1);

		ArrayList <String> al = new ArrayList <String>();

		for(int i =1; i<= n_rows; i++)
		{
			al.add(getText(locator1+"["+i+"]/td[3]"));
		}

		System.out.println(al);
	}

	// ******** Check default sorting of Published date at internal Feeds screen ********

	public void checkDateSort() {

		String locator1 = enterpriseLocator.getLocator("ExternalFeed.Row");
		int n_rows = getSize(locator1);

		ArrayList <String> al = new ArrayList <String>();

		for(int i =1; i<= n_rows; i++)
		{
			al.add(getText(locator1+"["+i+"]/td[3]"));
		}

		System.out.println(al);

	}

	// ******* Check sorting of Ratings Column ********

	public void checkRatingSorting() {

		// click on sort icon of rating columns
		String locator1 = enterpriseLocator.getLocator("InternalFeed.RatingSortIcon");
		clickOn(locator1);

		// scroll the page dopwn
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = enterpriseLocator.getLocator("InternalFeed.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[1]//div[@class='star_rating']/div", "style");
				
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

		// scroll the page up
		 javaScriptExecute("window.scrollBy(0,4050)");
		 waitForLoading();

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		
		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and comapre if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[1]//div[@class='star_rating']/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//*******************************************
	
	public void checkExternalRatingSorting() {

		// click on sort icon of rating columns
		String locator1 = enterpriseLocator.getLocator("ExternalFeed.RatingSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = enterpriseLocator.getLocator("ExternalFeed.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[2]//div[@class='star_rating']/div", "style");
			
				//////tbody[@id='dashboard-external-reviews']/tr/td[2]/div
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

		// scroll the page up
		 javaScriptExecute("window.scrollBy(0,4050)");
		 waitForLoading();

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		
		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and comapre if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[2]//div[@class='star_rating']/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}


	//*******************************************
	//ExternalFeed - Click on view icon of feeds and store details
	
	public void external_clickOnViewIcon(int rnd) {
		

		// calculate the no of rows
		String locator2 = enterpriseLocator.getLocator("ExternalFeed.Row");

		if(isElementPresent("//tbody[@id='dashboard-external-reviews']"))
		{
		clickOn(locator2+"["+rnd+"]/td[4]/div[3]/a[1]");
		}
		if(isElementPresent("//tbody[@id='dashboard-external-reviews']"))
		{
		clickOn(locator2+"["+rnd+"]//a[@data-original-title='View Original']");
		}

	}

	
	// Click on view icon of feeds and store details\

	public void clickOnViewIcon(int rnd) {
	

		// calculate the no of rows
		String locator2 = enterpriseLocator.getLocator("InternalFeed.Row");
		String locator=locator2+"["+rnd+"]/td[4]/div[3]/a[1]";
		
		
		if(isElementPresent("//tbody[@id='dashboard-internal-reviews']"))
		{
		//clickOn(locator2+"["+rnd+"]//a[@data-original-title='View Original']");
			//clickOn(locator2+"["+rnd+"]//a[@data-original-title='View Original']");
			clickOn("//tbody[@id='dashboard-internal-reviews']/tr[1]/td[2]//a[@rel='facebox tooltip']");
			
		}
		
//		if(isElementPresent("//tbody[@id='dashboard-internal-reviews']"))
//		{
//		clickOn(locator2+"["+rnd+"]/td[4]/div[3]/a[1]");
//		}

	}

	public void storeViewPopupDetails(int rnd) { 
		
		String title = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.Title"));
		String reviewDate = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ReviewDate"));
		String reviewer = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.Reviewer"));
		String reasonForVisit = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ReasonForVisit"));
		String sentiment = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.Sentiment"));
//		String comments = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.Title"));
		if (isElementPresent(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ResponseDate")))
		{
		String responseDate = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ResponseDate"));
		String responseUser = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ResponseUser"));
		String responseComments = getText(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.ResponseComments"));
		}
		clickOn(enterpriseLocator.getLocator("ExternalFeed.ViewPopup.Close"));
		String locator2 = enterpriseLocator.getLocator("InternalFeed.Row");
		Assert.assertEquals(title, getText(locator2+"["+rnd+"]/td[4]/div[1]/strong"));
		Assert.assertEquals(reviewDate, getText(locator2+"["+rnd+"]/td[5]/div"));
//		Assert.assertEquals(comments, getText(locator2+"["+rnd+"]/td[4]/div[2]"));
//		Assert.assertEquals(reviewDate, getText(locator2+"["+rnd+"]/td[5]/div"));
//		Assert.assertEquals(reviewDate, getText(locator2+"["+rnd+"]/td[5]/div"));
//		Assert.assertEquals(reviewDate, getText(locator2+"["+rnd+"]/td[5]/div"));
//		
		
	}

	public void storeSurveyDetails(int rnd) throws InterruptedException {
		Thread.sleep(2500);
		//String firstName = getText(enterpriseLocator.getLocator("InternalFeed.ViewPopup.FirstName"));
		//String lastName = getText(enterpriseLocator.getLocator("InternalFeed.ViewPopup.LastName"));
		
		String customername=getText("//div[@id='facebox']//div/div[2]/span[1]");
		String newcustomname=customername.replace("   ", "");
		System.out.println("new customer name:"+newcustomname);
		//String email = getText(enterpriseLocator.getLocator("InternalFeed.ViewPopup.Email"));
		//String surveyStartDate = getText(enterpriseLocator.getLocator("InternalFeed.ViewPopup.SurveyStartDate"));
		//String surveyCompleteDate= getText(enterpriseLocator.getLocator("InternalFeed.ViewPopup.SurveyCompleteDate"));
		clickOn(enterpriseLocator.getLocator("InternalFeed.ViewPopup.Close"));
		System.out.println("Testing closepopup");
		
		String locator2 = enterpriseLocator.getLocator("InternalFeed.Row");
		int locator22 = getSize(enterpriseLocator.getLocator("InternalFeed.Row"));
		System.out.println("Row Value::"+locator22);
		System.out.println("RANDOM VALUEEEEEE::"+rnd);
		//assert((firstName + " " + lastName).matches((getText(locator2+"["+rnd+"]//u/strong"))));
		//assert((firstName + " " + lastName).matches((getText(locator2+"["+1+"]//u/strong"))));
		System.out.println("Valueeeeeee:"+getText("//tbody[@id='dashboard-internal-reviews']/tr[1]//u/strong"));
		String name=getText("//tbody[@id='dashboard-internal-reviews']/tr[1]//u/strong");
		//assert((firstName + " " + lastName).matches((getText("//tbody[@id='dashboard-internal-reviews']/tr[1]//u/strong"))));
		Assert.assertTrue(newcustomname.contains(name));
		
		
	}
	
	// ######## Method to create internal review details #########
	String customerName ; String surveyName ; String comment;
	public String storeInternalReviewDetails(int rnd) {
		String locator1 = enterpriseLocator.getLocator("InternalFeed.Row");
		String locator2 = enterpriseLocator.getLocator("InternalFeed.CustomerName");
		customerName = getText(locator1+"["+rnd+"]"+locator2);
		String locator3 = enterpriseLocator.getLocator("InternalFeed.SurveyName");
	    surveyName = getText(locator1+"["+rnd+"]"+locator3);
	    surveyName	=	surveyName.substring(surveyName.indexOf('-')+2).trim();
		String locator4 = enterpriseLocator.getLocator("InternalFeed.Description");
		if(isElementPresent(locator4))
		{
			comment = getText(locator1+"["+rnd+"]"+locator4);
		}
		String locator5 = enterpriseLocator.getLocator("InternalFeed.AccountName");
		String accName = getText(locator1+"["+rnd+"]"+locator5);
//		System.out.println("cus name:" + customerName +"survey name:" + surveyName +"account Name:" + accName);
		clickOn(locator1+"["+rnd+"]"+locator5);
		return accName;
		
	}

	public void matchInternalReviewDetails(int rnd) {
		
		System.out.println("Customer name:"+getText("//table[@id='feed-items-table']//tr["+rnd+"]/td[3]/div[1]/u/strong"));
		assert(customerName.contains(getText("//table[@id='feed-items-table']//tr["+rnd+"]/td[3]/div[1]/u/strong")));
	    String surveyName2 = getText("//tbody[@id='internal-feed-items']/tr["+rnd+"]/td[2]/div[1]/u");
	    surveyName2	=	surveyName.substring(surveyName.indexOf('-')+1).trim();
        System.out.println(surveyName2);
		assert(surveyName.matches(surveyName2));
		
	}
	
	/*private boolean (boolean contains) {
		// TODO Auto-generated method stub
		return false;
	} */


	
	// ******** Methods of verifying reviews count ******
	public int storeEnterpriseSummaryDetails(ArrayList <String> al1, ArrayList <String> al2, int total_rating, double total_avg_rating) {
	
		clickOn("//a[contains(text(), '30d')]");
		String locator1 = enterpriseLocator.getLocator("Summary.NoOfReviewBySite");
		int row = getSize(locator1);
		
		if(!isElementPresent(locator1+"[2/td[1][contains(text(), 'Total')]]"))
		{
		
		for (int i=2; i< row; i++)
		{
			al1.add(getText(locator1+"["+i+"]/td[1]"));
			al2.add(getText(locator1+"["+i+"]/td[5]"));
		}
		
		total_rating = Integer.parseInt(getText(locator1+"["+row+"]/td[2]"));
		total_avg_rating = Double.parseDouble(getText(locator1+"["+row+"]/td[5]"));
		}
		
		return total_rating;
		
	}

	public void storeAccounts(ArrayList <String> al3) {
		
		clickOn("//td[contains(text(), 'Randy Test Group')]/../td[2]/a[1]");
		int no_of_associated_acc = getSize("//div[@id='group_account_ids_chzn']/ul/li");
		System.out.println(no_of_associated_acc);
		for (int i =1; i < no_of_associated_acc; i++)
		{
			al3.add(getText("//div[@id='group_account_ids_chzn']/ul/li["+i+"]/span"));
		}	

	}

	public void storeTrackSummaryDetails(ArrayList<String> al4, ArrayList<String> al5, ArrayList<Integer> al6, ArrayList<Double> al7) {
		
		clickOn("//a[contains(text(), '30d')]");
		
		String locator1 = enterpriseLocator.getLocator("Summary.NoOfReviewBySite");
		int row = getSize(locator1);
		
		if(!isElementPresent(locator1+"[2/td[1][contains(text(), 'Total')]]"))
		{
	
		for (int i=2; i< row; i++)
		{

			al4.add(getText(locator1+"["+i+"]/td[1]"));
			al5.add(getText(locator1+"["+i+"]/td[5]"));

		}
		
		al6.add(Integer.parseInt(getText(locator1+"["+row+"]/td[2]")));
		al7.add(Double.parseDouble(getText(locator1+"["+row+"]/td[5]")));
		}
		
	}
	
	
	 //*****************Method to sort dealer name column on enterprise reporting page***************//
	 public void sort_GroupReportDealerNameCol()
	 {
		 
		String locator1=enterpriseLocator.getLocator("Reports.GroupList");
		clickOn(locator1);
		
		String locator2=enterpriseLocator.getLocator("Reports.GroupName");
		clickOn(locator2);
		
		 String locator3=enterpriseLocator.getLocator("Reports.ReportList");
		 clickOn(locator3);
		 
		 String locator4=enterpriseLocator.getLocator("Reports.Report");
		 clickOn(locator4);
		 
		 String locator5=enterpriseLocator.getLocator("Reports.Submitbutton");
		 clickOn(locator5);
		 
		 waitForLoading();
		 
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.DealerCodeCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.DealerNameCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.SiteNameCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.RatingCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.TitleCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.ReviewCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.ResponseCol")));
		 Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("Reports.DateCol")));
		 
		 //*****************Verify sorting of Dealer Name Col**********************************//
		 
			 
		// click on sort icon of dealer name columns
			String locator6 = enterpriseLocator.getLocator("Reports.DealerNameCol");
			clickOn(locator6);

			// scroll the page down
			javaScriptExecute("window.scrollBy(0,4050)");
			waitForLoading();

			// calculate the no of rows
			// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
			String locator7 = enterpriseLocator.getLocator("Reports.Row");
			int n_rows = getSize(locator7);

			// store sorting value in array
			ArrayList <String> al1 = new ArrayList <String>();
			ArrayList <String> al2 = new ArrayList <String>();
			String str =null;
			for (int i=1; i<=n_rows; i++)
			{
				str = getText("//table[contains(@class,'table table-condensed')]/tbody/tr["+i+"]/td[2]");
				//System.out.println("str :"+str);
				al1.add(str.substring(0));
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
			clickOn(locator6);

			// scroll the page down
			javaScriptExecute("window.scrollBy(0,4050)");
			waitForLoading();

			// store value in array and compare if it is descending order
			for (int i=1; i<=n_rows; i++)
			{
				//Thread.sleep(4000);
				str = getText("//table[contains(@class,'table table-condensed')]/tbody/tr["+i+"]/td[2]");
				//System.out.println("new str :"+str); 
				al2.add(str.substring(0));
				al1.get(size-1).equals(al2.get(i-1));
				size--;

			}
	 }
	 
	//**************Method to download CSV file on enterprise reporting page***********************//
		public void reports_DownloadCSV(String path)
		{
			String locator1=enterpriseLocator.getLocator("Reports.GroupList");
			clickOn(locator1);
			 
			 int groupcount =getSize(enterpriseLocator.getLocator("Reports.GroupCount"));
			 System.out.println("total count:"+groupcount);
			 
			 int randomval=getRandomInteger(1,groupcount);
			 System.out.println("random val:"+randomval);
			 
			 clickOn("//form[@action='/enterprise/reports']/div[2]//ul/li["+randomval+"]");
			 
			 String locator2=enterpriseLocator.getLocator("Reports.ReportList");
			 clickOn(locator2);
			 
			 
			 int reportcount =getSize(enterpriseLocator.getLocator("Reports.ReportListCount"));
			 //System.out.println("total count:"+reportcount);
			 
			 int randomval1=getRandomInteger(1,reportcount);
			 //System.out.println("random val1:"+randomval1);
			 
			 clickOn("//form[@action='/enterprise/reports']/div[3]//ul/li["+randomval1+"]");
			 
			 String locator3=enterpriseLocator.getLocator("Reports.Submitbutton");
			 clickOn(locator3);
			 waitForLoading();
			 
			 
			 String locator4=enterpriseLocator.getLocator("Reports.CsvButton");
			 clickOn(locator4);
			 
			  /*try{

					String imgPath1 = path + "//images//SaveAs.png";
					screen.click(imgPath1);
				 }
			catch(Exception e)
				{				 
					System.out.println("Catch"); 

				} 
				try{
						String  imgPath1 = path + "//images//SaveAsWin7.png";
						screen.click(imgPath1);
					}

				catch(Exception e)
				{				 
					System.out.println("Catch");

				}
				try{

						String imgPath2 = path + "//images//OK.png";
						screen.click(imgPath2);
					}

				catch(Exception e)
					{				 
						System.out.println("Catch");

					}

				try{

						String imgPath2 = path + "//images//OKWin7.png";
						screen.click(imgPath2);
					}

				catch(Exception e)
					{				 
						System.out.println("Catch");
					}	

			  */
			 
		
				try{
						String  imgPath1 = path + "//images//Win8.1SaveFile.png";
						screen.click(imgPath1);
					}

				catch(Exception e)
				{				 
					System.out.println("Catch");

				}
				try{

						String imgPath2 = path + "//images//Win8.1OK.png";
						screen.click(imgPath2);
					}

				catch(Exception e)
					{				 
						System.out.println("Catch");

					}

		}
		
		
		//************Method to check downloading functionality of 'response penetration dashboard' in pdf format
		public void downloadPdf_ResponsePenetrationDashboard() throws InterruptedException
		{
			String str="pdf";
			
			String locator1=enterpriseLocator.getLocator("ResponsePenetrationDashboard.GroupList");
			clickOn(locator1);
			
			String locator2=enterpriseLocator.getLocator("ResponsePenetrationDashboard.RandyTestGroup");
			clickOn(locator2);
			waitForLoading();
			
			String locator3=enterpriseLocator.getLocator("ResponsePenetrationDashboard.PdfButton");
			clickOn(locator3);
			waitForLoading();
			
			if(getWebDriver().getTitle().contains(str))
			{
				Assert.assertTrue(true, this.getWebDriver().getTitle());
			}
			
			/*
			//Focus on the new window opened
	   	  	Set<String> windows = getWebDriver().getWindowHandles();
	   	  	//String parent = null;
	   	  	String child = null;
	   	  	Iterator<String> it = windows.iterator();
	   	  	while(it.hasNext())
	   	  	{
	   	       //parent = (String) it.next();
	   	       child = (String) it.next();
	   	   }
	   	  	getWebDriver().switchTo().window(child);
	   	  	//Thread.sleep(3000);
	   	  	
	   	  	String str1 = getWebDriver().getTitle();
	     	//System.out.println("New URL:"+str1);
	     	
	   	  	 Assert.assertTrue(str1.contains(str));
	   	  	 getWebDriver().close(); */
			
		}
		
		//****************Verify monthly,weekly and daily Searching functionality of Response Penetration Dashboard******************//
		public void search_ResponsePenetrationDashboard()
		{
			String locator1 = enterpriseLocator.getLocator("ResponsePenetrationDashboard.Monthly");
			clickOn(locator1);
			
			String locator2 = enterpriseLocator.getLocator("ResponsePenetrationDashboard.Weekly");
			clickOn(locator2);
			waitForLoading();
			clickOn(enterpriseLocator.getLocator("ResponsePenetrationDashboard.DropDownIcon"));
			
			String locator3 = enterpriseLocator.getLocator("ResponsePenetrationDashboard.Daily");
			clickOn(locator3);
			
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponseRateStatistics")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponsePenetrationRate")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponseRateSite")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponsePenetrationRate")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponseRateSite")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponsePenetrationRateposNeg")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.ResponseTimeStatistics")));
			Assert.assertTrue(isElementPresent(enterpriseLocator.getLocator("ResponsePenetrationDashboard.AverageResponseTimeDays")));
			
			
			
		}

}

