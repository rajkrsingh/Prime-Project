package com.primeresponse.pagehelper;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class WebHelper extends DriverHelper{

	private LocatorReader webLocator;
	public WebHelper(WebDriver webdriver) {
		super(webdriver);
		webLocator = new LocatorReader("Web.xml");
		new LocatorReader("Header.xml");
	}

	//*****Method to randomly select any referral analysis from list and verify its details on Web >Referral Analysis page**//
	public void verify_ReferralAnalysis()
	{
		String str ="No data exists for the specified time period";
		String locator1=webLocator.getLocator("ReferralAnalysis.ReferralAnalysisHeader");
		Assert.assertTrue(isElementPresent(locator1));

		String locator2=webLocator.getLocator("ReferralAnalysis.ViewList");
		clickOn(locator2);

		int totalSize=getSize(webLocator.getLocator("ReferralAnalysis.TotalViewList"));
		int randomval=getRandomInteger(1,totalSize);

		clickOn("//div[@id='id_chzn']//ul/li["+randomval+"]");
		waitForLoading();

		if(isElementPresent(webLocator.getLocator("ReferralAnalysis.NoDataExistMsg")))
		{
			Assert.assertTrue(true,"No Data Exist");

		}
		else
		{
			Assert.assertTrue(isElementPresent(webLocator.getLocator("ReferralAnalysis.OverAllTrafficSources")));
			Assert.assertTrue(isElementPresent(webLocator.getLocator("ReferralAnalysis.ReferralSourcesBreakdown")));
			Assert.assertTrue(isElementPresent(webLocator.getLocator("ReferralAnalysis.SocialSiteReferral")));
			Assert.assertTrue(isElementPresent(webLocator.getLocator("ReferralAnalysis.ReputationSiteReferrals")));
		}	


	}

	//Verify user redirect to same url which will open in new window
	public void verify_GotoSiteReputationSiteRefferal() throws InterruptedException
	{

		String str=getAttribute("//div[@id='analytics-tracked-referrals']//tr[4]/td[1]/a[@href]", "href");
		//System.out.println("Str value:"+str);
		String[] newstr=str.split("http://");
		System.out.println("new str value:"+newstr[1]);
		
		clickOn("//div[@id='analytics-tracked-referrals']//tr[4]/td[1]/a[@href]");
		waitForLoading();

		//waitForLoading();

		//Focus on the new window opened
		Set<String> windows = getWebDriver().getWindowHandles();
		String parent = null;
		String child = null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			parent = (String) it.next();
			child = (String) it.next();
		}
		getWebDriver().switchTo().window(child);
		Thread.sleep(5000);
		String url12 = getWebDriver().getCurrentUrl();
		//System.out.println("New URL:"+url12);
		String[] newurl=url12.split("https://");
		System.out.println("New URL:"+newurl[1]);
		Assert.assertTrue(newurl[1].contains(newstr[1]));
		getWebDriver().close();

		//Switch back to main window
		getWebDriver().switchTo().window(parent);
	}

	//*********Verify process to create 'New Search Engine Result Page'*******************
	public void create_NewSearchEngineResultPage()
	{
		String locator1=webLocator.getLocator("SerpCapture.NewSearchEngineResultPageLink");
		clickOn(locator1); 

		String locator2=webLocator.getLocator("SerpCapture.Label");
		sendKeys(locator2,"Test");

		String locator3=webLocator.getLocator("SerpCapture.SearchTerm");
		sendKeys(locator3,"Test");

		String locator4=webLocator.getLocator("SerpCapture.SourceType");
		clickOn(locator4);

		String locator5=webLocator.getLocator("SerpCapture.CreateSerpButton");
		clickOn(locator5);
		waitForLoading();

	}

	//***********Method to delete 'Search Engine Result Page'***********************
	public void delete_SearchEngineResultPage()
	{

		String locator1=webLocator.getLocator("SerpCapture.DeleteIcon");
		clickOn(locator1);
		acceptAlert();

	}

	//********Verify sorting functionality of Avg Sorting column**********************//
	public void sort_ReputationSiteReferralAvgRating() throws InterruptedException
	{
		// click on sort icon of rating columns
		waitForLoading();
		String locator1 = webLocator.getLocator("ReferralAnalysis.RatingSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = webLocator.getLocator("ReferralAnalysis.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-tracked-referrals']/table/tbody/tr["+i+"]//div[@class='star_rating']/div", "style");
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
			Thread.sleep(4000);
			String locator ="//div[@id='analytics-tracked-referrals']/table/tbody/tr["+i+"]//div[@class='star_rating']"; 

			if(isElementPresent(locator))
				str = getAttribute(locator+"/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}	

	//***********Verify sorting functionality of 'Total Reputation Traffic' ************************************//
	 public void sort_ReputationSite_TotalReputationTraffic()
	 {
		// click on sort icon of 'Total Reputation Traffic' column
					String locator1 = webLocator.getLocator("ReferralAnalysis.TotalReputationTraffic");
					clickOn(locator1);

					// scroll the page down
					javaScriptExecute("window.scrollBy(0,4050)");
					waitForLoading();

					// calculate the no of rows

					String locator7 = webLocator.getLocator("ReferralAnalysis.ReputationSiteRow");
					int n_rows = getSize(locator7);

					// store sorting value in array
					ArrayList <String> al1 = new ArrayList <String>();
					ArrayList <String> al2 = new ArrayList <String>();
					String str =null;
					for (int i=1; i<=n_rows; i++)
					{
						str = getAttribute("//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[5]", "style");
						//System.out.println("str :"+str);
						al1.add(str.substring(0));
						al2 = al1;

					}

					// check if sorted in ascending order or not
					Collections.sort(al1);
					int x=0; int size = al1.size();
					do
					{
						al1.get(1).equals(al2.get(1));
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
						String locator= "//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[5]";
						if(isElementPresent(locator))
							str = getAttribute(locator, "style");
						//System.out.println("new str :"+str); 
						al2.add(str.substring(0));
						al1.get(size-1).equals(al2.get(i-1));
						size--;

					}
	 }
	
	//**********Verify process to create 'Landing Pages' ***********************//
	public void create_LandingPages()
	{
		String locator1=webLocator.getLocator("LandingPages.NewLandingPage");
		clickOn(locator1);

		int randomval=getRandomInteger(1,9);
		
		String locator2=webLocator.getLocator("LandingPages.Name");
		sendKeys(locator2,"Test"+randomval);

		String locator3=webLocator.getLocator("LandingPages.Title");
		sendKeys(locator3,"Test Title");

		String locator4=webLocator.getLocator("LandingPages.Discoverable");
		clickOn(locator4);


		String locator5=webLocator.getLocator("LandingPages.TextAreaSource");
		clickOn(locator5);

		String locator6=webLocator.getLocator("LandingPages.TextArea");
		sendKeys(locator6,"Writting to html editor");

		String locator7=webLocator.getLocator("LandingPages.SubmitButton");
		clickOn(locator7);
	}

	//************Verify process to delete 'Landing Pages' **********************
	public void delete_LandingPages()
	{
		String str="Test";

		int totalrow=getSize(webLocator.getLocator("LandingPages.Row"));

		for(int i=1;i<=totalrow;i++)
		{
			if(getText("//table[contains(@class,'landing-page-table')]/tbody/tr["+i+"]/td[1]").contains(str));
			{
				clickOn("//table[contains(@class,'landing-page-table')]/tbody/tr["+i+"]//a[@data-original-title='Delete']/i");
				acceptAlert();
				break;
			}    
		}

	}

	//****************Verify sorting functionality of 'source' column *********************************//
	public void sort_ReputationSiteReferralsSourceCol()
	{
		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.SourceIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.ReputationSiteRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//div[@id='analytics-tracked-referrals']//a/img");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			str = getText("//div[@id='analytics-tracked-referrals']//a/img");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//******************Verify sorting functionality of 'Number Of Reviews' column******************************//
	public void sort_ReputationSiteReferralsNumberOfReviewsCol()
	{

		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.NoReviewsCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.ReputationSiteRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[9]", "style");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			String locator= "//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[9]";
			if(isElementPresent(locator))
				str = getAttribute(locator, "style");
			System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//**************Verify sorting functionality of 'Total Social Traffic' column**********************// 
	public void sort_SocialSiteReferralTrafficCol()
	{
		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.TotalSocialTrafficCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.SocialSiteReferralsRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-social-referrals']//tr["+i+"]/td[5]", "style");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			String locator= "//div[@id='analytics-social-referrals']//tr["+i+"]/td[5]";
			if(isElementPresent(locator))
				str = getAttribute(locator, "style");
			System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//***********Verify sorting functionality of 'Total Social Traffic' column****************************// 
	public void sort_SocialSiteReferralBounceRateCol()
	{
		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.BounceRateCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.SocialSiteReferralsRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-social-referrals']//tr["+i+"]/td[7]", "style");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			String locator= "//div[@id='analytics-social-referrals']//tr["+i+"]/td[7]";
			if(isElementPresent(locator))
				str = getAttribute(locator, "style");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//***********Verify sorting functionality of 'Total Social Traffic' column***************************// 
	public void sort_SocialSiteReferralAvgTimeOnSiteCol()
	{
		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.AvgTimeSite");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.SocialSiteReferralsRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-social-referrals']//tr["+i+"]/td[8]", "style");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			String locator= "//div[@id='analytics-social-referrals']//tr["+i+"]/td[8]";
			if(isElementPresent(locator))
				str = getAttribute(locator, "style");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}
	
	
	//************Verify sorting functionality of 'Avg time on site' column *******************//
	public void sort_ReputationSite_AvgTimeOnSite()
	{
		// click on sort icon of Source column
				String locator1 = webLocator.getLocator("ReferralAnalysis.ReputationAvgTimeSite");
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// calculate the no of rows

				String locator7 = webLocator.getLocator("ReferralAnalysis.ReputationSiteRow");
				int n_rows = getSize(locator7);

				// store sorting value in array
				ArrayList <String> al1 = new ArrayList <String>();
				ArrayList <String> al2 = new ArrayList <String>();
				String str =null;
				for (int i=1; i<=n_rows; i++)
				{
					str = getAttribute("//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[8]", "style");
					//System.out.println("str :"+str);
					al1.add(str.substring(0));
					al2 = al1;

				}

				// check if sorted in ascending order or not
				Collections.sort(al1);
				int x=0; int size = al1.size();
				do
				{
					al1.get(1).equals(al2.get(1));
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
					String locator= "//div[@id='analytics-tracked-referrals']//tr["+i+"]/td[8]";
					if(isElementPresent(locator))
						str = getAttribute(locator, "style");
					//System.out.println("new str :"+str); 
					al2.add(str.substring(0));
					al1.get(size-1).equals(al2.get(i-1));
					size--;

				}
	}


	//***************Verify sorting functionality of 'Pages/Visit' column**************************************// 
	public void sort_SocialSiteReferralsPagesVisit()
	{
		// click on sort icon of Source column
		String locator1 = webLocator.getLocator("ReferralAnalysis.PagesVisit");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows

		String locator7 = webLocator.getLocator("ReferralAnalysis.SocialSiteReferralsRow");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//div[@id='analytics-social-referrals']//tr["+i+"]/td[6]", "style");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(1));
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
			String locator= "//div[@id='analytics-social-referrals']//tr["+i+"]/td[6]";
			if(isElementPresent(locator))
				str = getAttribute(locator, "style");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}
	
	//*************Verify sorting functionality of 'of Total Social Traffic' column************************// 
	 public void sort_SocialSiteRefTotalSocialTraffic()
	 {
		// click on sort icon of Source column
			String locator1 = webLocator.getLocator("ReferralAnalysis.TotalSocialTraffic");
			clickOn(locator1);

			// scroll the page down
			javaScriptExecute("window.scrollBy(0,4050)");
			waitForLoading();

			// calculate the no of rows

			String locator7 = webLocator.getLocator("ReferralAnalysis.SocialSiteReferralsRow");
			int n_rows = getSize(locator7);

			// store sorting value in array
			ArrayList <String> al1 = new ArrayList <String>();
			ArrayList <String> al2 = new ArrayList <String>();
			String str =null;
			for (int i=1; i<=n_rows; i++)
			{
				str = getAttribute("//div[@id='analytics-social-referrals']//tr["+i+"]/td[5]", "style");
				//System.out.println("str :"+str);
				al1.add(str.substring(0));
				al2 = al1;

			}

			// check if sorted in ascending order or not
			Collections.sort(al1);
			int x=0; int size = al1.size();
			do
			{
				al1.get(1).equals(al2.get(1));
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
				String locator= "//div[@id='analytics-social-referrals']//tr["+i+"]/td[5]";
				if(isElementPresent(locator))
					str = getAttribute(locator, "style");
				//System.out.println("new str :"+str); 
				al2.add(str.substring(0));
				al1.get(size-1).equals(al2.get(i-1));
				size--;

			}
	 }

	//*********Verify process to create 'Google Campaigns' ***************************//
	public void create_GoogleCampaigns()
	{

		String locator1 = webLocator.getLocator("GoogleCampaigns.NewButton");
		clickOn(locator1);
		
		int randamval=this.getRandomInteger(0,9);

		String locator2 = webLocator.getLocator("GoogleCampaigns.Name");
		sendKeys(locator2,"TestingGoogleCampaign"+randamval);

		String locator3 = webLocator.getLocator("GoogleCampaigns.SubmitButton");
		clickOn(locator3);


	}
	
	//********Fetch total google campaigns from Web>Google Campaigns page.************************
	
	public ArrayList<String> fetchGoogleCampaigns()
	{
		String strOFF="OFF";
		String strON="ON";
		ArrayList <String> arr = new ArrayList<String>();

		int totalrow=getSize(webLocator.getLocator("GoogleCampaigns.Row"));
		//System.out.println("Row val:"+totalrow);
		
		String aa=getText("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr/td[3]//div[@class='switch-animate switch-on']/span");
		System.out.println("aa val:"+aa);
		for(int i=1; i<=totalrow;i++)
		{
			/////////****************if part*******//////////////
			String str11=getText("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr["+i+"]/td[3]//div[@class='switch-animate switch-off']/span[2][contains(text(),'OFF')]");
			System.out.println("str11:"+str11);
			
			if(str11.contains(strOFF))
			{
		
			clickOn("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr["+i+"]/td[3]//div[@class='switch-animate switch-off']/span[2][contains(text(),'OFF')]");
			arr.add(getText("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr["+i+"]/td[1]"));
			//System.out.println("Sting valueeeeee:"+arr);
			
			}
		}
		for(int j=1;j<=totalrow;j++)
		{
			
			String str12=getText("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr["+j+"]/td[3]//div[@class='switch-animate switch-on']/span[2][contains(text(),'ON')]");
			if(str12.contains(strON))
				{
				arr.add(getText("//div[@id='data-wiselinks-container']//tbody[@class='products-body']/tr["+j+"]/td[1]"));
				}
					
		}
	
		
		
		return arr;
	}
	
	
	//********Click on Off button to disable all google campaigns.******************************//
	public void OffgoogleCampaigns()
	{
		int totalrow=getSize(webLocator.getLocator("GoogleCampaigns.Row"));
		//System.out.println("Row val:"+totalrow);
		
		for(int i=1;i<=totalrow;i++)
		{
		    clickOn("//tbody[@class='products-body']/tr["+i+"]/td[3]//span[1]");	
		}		
	}
	

	public void verify_CampaignReport()
	{
		isElementPresent(webLocator.getLocator("CampaignReport.ReportTitle"));
		isElementPresent(webLocator.getLocator("CampaignReport.SiteTraffic"));
		isElementPresent(webLocator.getLocator("CampaignReport.Visits"));
		isElementPresent(webLocator.getLocator("CampaignReport.Acquisition"));
		isElementPresent(webLocator.getLocator("CampaignReport.Behavior"));
		isElementPresent(webLocator.getLocator("CampaignReport.Conversion"));
		isElementPresent(webLocator.getLocator("CampaignReport.SourceMedium"));


	}
	
	//************Verify preview Of Landing Pages*****************************//
	public void verify_PreviewOfLandingPage()
	{
	
		String locator1 = webLocator.getLocator("LandingPages.EditButton");
		clickOn(locator1);
		waitForLoading();
		
		String locator2 = webLocator.getLocator("LandingPages.TextAreaSource");
		clickOn(locator2);
		
		//waitForLoading();
		String str=getAttribute(webLocator.getLocator("LandingPages.TextAreaValue"),"value");
		//System.out.println("str:"+str);
		
		
		String locator3 = webLocator.getLocator("LandingPages.BackLink");
		clickOn(locator3);
		
		
		String locator4 = webLocator.getLocator("LandingPages.PreviewButton");
		clickOn(locator4);
		
		waitForLoading();
		String str1 = getText(webLocator.getLocator("LandingPages.PreviewPage"));
		
		//System.out.println("str1:"+str1);
		if(str.contains(str1))
		{
			Assert.assertTrue(true,"String matched");
		}
	}

	//*********Verify process to filter 'Google Campaigns'**************************
	public void filter_CampaignReport()
	{
		
		String locator1 = webLocator.getLocator("CampaignReport.CampaignListIcon");
		clickOn(locator1);
		
		int totallist=getSize(webLocator.getLocator("CampaignReport.CampaignList"));
		int randomval=getRandomInteger(1,totallist);
		
		clickOn("//div[@id='google_campaign_id_chzn']//li["+randomval+"]");
		
		String locator2 = webLocator.getLocator("CampaignReport.DatePicker");
		clickOn(locator2);
		
		String locator3 = webLocator.getLocator("CampaignReport.LastMonth");
		clickOn(locator3);
		
		String locator4 = webLocator.getLocator("CampaignReport.SubmitButton");
		clickOn(locator4);
		waitForLoading();
			
	}
	
	//*************Verify that google campaigns are same on 'Google Campaigns' and 'Campaigns Reports' pages.******************//
	public void verify_GoogleCampaignsOnReport(ArrayList <String> arr)
	{
		
		ArrayList<String> arr1=new ArrayList<String>();
		
		String locator1 = webLocator.getLocator("CampaignReport.CampaingsList");
		clickOn(locator1);
		
		int totallistval=getSize(webLocator.getLocator("CampaignReport.TotalCampaignList"));
		
		for(int i=2;i<=totallistval;i++)
		{
			arr1.add(getText("//div[@id='google_campaign_id_chzn']//li["+i+"]"));
		}
		
		if(arr.equals(arr1))
		{
			Assert.assertTrue(true,"Value Matched");
		}
	}
	
	
	//Verify process to create 'Tracking URLs'
	public void create_TrackingURLs()
	{
		String locator1 = webLocator.getLocator("TrackingUrls.NewButton");
		clickOn(locator1);
		
		String locator2 = webLocator.getLocator("TrackingUrls.AdName");
		sendKeys(locator2,"Test");
		
		String locator3 = webLocator.getLocator("TrackingUrls.BaseUrl");
		sendKeys(locator3,"https://test.com");
		
		String locator4 = webLocator.getLocator("TrackingUrls.Description");
		sendKeys(locator4,"Testing  tracking urls");
		
		String locator5 = webLocator.getLocator("TrackingUrls.GoogleCampaignOption");
		clickOn(locator5);
		
		String locator6 = webLocator.getLocator("TrackingUrls.GoogleCampaign");
		clickOn(locator6);
		
		String locator7 = webLocator.getLocator("TrackingUrls.MarkettingProductOption");
		clickOn(locator7);
		
		String locator8 = webLocator.getLocator("TrackingUrls.MarkettingProduct");
		clickOn(locator8);
		
		String locator9 = webLocator.getLocator("TrackingUrls.SubmitButton");
		clickOn(locator9);
		
	}
	
	//Verify utm_content parameter 
	public void verify_Utm_ContentParameter()
	{
		
		String str =getText(webLocator.getLocator("TrackingUrls.GetAdName"));
		System.out.println("Ad name Val:"+str); 
		
		String str1=getAttribute("//table[@class='table table-striped']//td[5]/a", "data-copy-text");
		System.out.println("UTM Val:"+str1); 
		
		String utm_content = str1.substring(94,101);
		
		System.out.println("UTM utm_content:"+utm_content); 
		
		//System.out.println("dfdffdf");
		Assert.assertEquals(str,utm_content);
		//Assert.assertTrue(str.contains(str1));
	
			
			
	}
}

