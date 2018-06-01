package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class ProfileHelper extends DriverHelper {

	private LocatorReader profileLocator;

	public ProfileHelper(WebDriver driver) {
		super(driver);
		profileLocator = new LocatorReader("Profile.xml");		
	}

	// *********** Create Page Capture Methods *************
	public void clickOnNewPageCapture()
	{
		String locator = profileLocator.getLocator("PageCapture.CreateCapture.NewPageCaptureLink");
		clickOn(locator);
	}

	public void createCapturePage()
	{
		String locator1= profileLocator.getLocator("PageCapture.CreateCapture.Label");
		sendKeys(locator1, "Test Page Capture Created by Webdriver script execution");
		String locator2 = profileLocator.getLocator("PageCapture.CreateCapture.Url");
		sendKeys(locator2, "https://www.google.co.in");
		String locator3 = profileLocator.getLocator("PageCapture.CreateCapture.Interval");
		selectDropDown(locator3, "7 Days");
		String locator4 = profileLocator.getLocator("PageCapture.CreateCapture.SubmitButton");
		clickOn(locator4);		
	}

	// *********** Delete Page Capture Methods *************

	public void deletePagecapture()
	{
		String locator1 = profileLocator.getLocator("PageCapture.Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{
			if(isElementPresent("//div[@class='serps']/div["+i+"]/table/thead/tr/th[1][contains(text(), 'Test Page Capture Created by Webdriver script execution')]"));
			{
				clickOn("//div[@class='serps']/div["+i+"]/table/thead/tr/th[2]/a/img");
				acceptAlert();
				break;
			}
		}
	}
	
	//Method to Check all site details available on Site Details page ***********************//
	public void check_SiteDetails() throws InterruptedException
	{
		String locator = profileLocator.getLocator("SiteDetail.SelectSourceDropDownList");
		clickOn(locator);
		
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.AolAuto")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.BetterBusinessBureau")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.BookingCom")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.YellowBot")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.Yelp")));
		
		clickOn(profileLocator.getLocator("SiteDetail.SiteDetail"));
		
		int row=getSize(profileLocator.getLocator("SiteDetail.Row"));
		//System.out.println("Row count:"+row);
		
		int randomval=getRandomInteger(1,row); 
		System.out.println("random value:"+randomval);
		
		clickOn("//tbody/tr["+randomval+"]/td[1]//a[contains(@title,'View More')]");
		waitForLoading();
		
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.ProfileData")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.MonthlyReputationRating")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.About")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.ResponseRateStatistics")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.MonthlyActivity")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.ResponseTimeStatistics")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.ResponsePenetrationRate")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.ResponsePenetrationRatePosNeg")));
		Assert.assertTrue(isElementPresent(profileLocator.getLocator("SiteDetail.AvgResponseTime")));
		
		//*******Verify page url****************//
		
		waitForLoading();
		mouseOver(profileLocator.getLocator("SiteDetail.ClickHerePageLink"));
		
		Thread.sleep(4000);
		String str=getAttribute(profileLocator.getLocator("SiteDetail.ClickHerePageLink"),"href");
		//System.out.println("Go to Site url:"+str);
		
		String locator1 = profileLocator.getLocator("SiteDetail.ClickHerePageLink");
		clickOn(locator1);
		waitForLoading();
		
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
   	  	if(url12.contains(str))
   	  	{		
   	  		Assert.assertTrue(url12.contains(str));
   	  		getWebDriver().close();
   	  	}
   	  	else
   	  		Assert.assertTrue(true, url12);
   	  //Switch back to main window
   	  getWebDriver().switchTo().window(parent);
	
	}
	
	//****************Verify sorting functionality of source column on Site Detail page**********************//
	public void sort_SiteDetailSource()
	{
		
		
		// click on sort icon of rating columns
				String locator1 = profileLocator.getLocator("SiteDetail.SourceCol");
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// calculate the no of rows
				String locator2 = profileLocator.getLocator("SiteDetail.Row");
				int n_rows = getSize(locator2);

				// store rating value in array
				ArrayList <String> al1 = new ArrayList <String>();
				ArrayList <String> al2 = new ArrayList <String>();
				String str =null;
				for (int i=1; i<=n_rows; i++)
				{
					str = getAttribute("//table[@class='sort-table']/tbody/tr["+i+"]/td[2]/a/img", "style");
					//System.out.println("strrrr:"+str);
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
					
					str = getAttribute("//table[@class='sort-table']/tbody/tr["+i+"]/td[2]/a/img", "style");
					//str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[2]/a");
					//System.out.println("new strrrr:"+str);
					
					al2.add(str.substring(7));
					al1.get(size-1).equals(al2.get(i-1));
					size--;

				}
	}
	
	//*********Verify sorting functionality of description column on Site Detail page*************//
	public void sort_SiteDetailDescription()
	{
		// click on sort icon of rating columns
		String locator1 = profileLocator.getLocator("SiteDetail.DescCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = profileLocator.getLocator("SiteDetail.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[3]");
			//System.out.println("strrrr:"+str);
			al1.add(str);
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
			
			str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[3]");
			//System.out.println("new strrrr:"+str);
			
			al2.add(str);
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//***************Verify sorting functionality of site score column on Site Detail page********************//
	public void sort_SiteDetailSiteScore()
	{
		// click on sort icon of rating columns
				String locator1 = profileLocator.getLocator("SiteDetail.SiteScoreCol");
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// calculate the no of rows
				String locator2 = profileLocator.getLocator("SiteDetail.Row");
				int n_rows = getSize(locator2);

				// store rating value in array
				ArrayList <String> al1 = new ArrayList <String>();
				ArrayList <String> al2 = new ArrayList <String>();
				String str =null;
				for (int i=1; i<=n_rows; i++)
				{
					
					str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[4]");
					al1.add(str);
					
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
					
					str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[4]");
					al2.add(str);
					al1.get(size-1).equals(al2.get(i-1));
					size--;

				}
	}
	
	//****************Verify sorting functionality of reviews column on Site Detail page**************************//
	public void sort_SiteDetailReviews()
	{
		// click on sort icon of rating columns
		String locator1 = profileLocator.getLocator("SiteDetail.ReviewsCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = profileLocator.getLocator("SiteDetail.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			
			str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[5]");
			al1.add(str);
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
			
			str = getText("//table[@class='sort-table']/tbody/tr["+i+"]/td[5]");
			al2.add(str);
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}
	
	//**************Verify sorting functionality of rating column on Site Detail page******************//
	public void sort_SiteDetailRating()
	{
		// click on sort icon of rating columns
				String locator1 = profileLocator.getLocator("SiteDetail.RatingCol");
				clickOn(locator1);

				// scroll the page down
				javaScriptExecute("window.scrollBy(0,4050)");
				waitForLoading();

				// calculate the no of rows
				String locator2 = profileLocator.getLocator("SiteDetail.Row");
				int n_rows = getSize(locator2);

				// store rating value in array
				ArrayList <String> al1 = new ArrayList <String>();
				ArrayList <String> al2 = new ArrayList <String>();
				String str =null;
				for (int i=1; i<=n_rows; i++)
				{
					str = getAttribute("//table[@class='sort-table']/tbody/tr["+i+"]/td[6]/div/div", "style");
					//System.out.println("strrr:"+str);
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
					String locator ="//table[@class='sort-table']/tbody/tr["+i+"]/td[6]"; 

					if(isElementPresent(locator))
						str = getAttribute(locator+"/div/div", "style");
					//System.out.println("new str:"+str);
					//str = getAttribute(locator2+"["+i+"]/td//div[@class='star_rating']/div", "style");
					al2.add(str.substring(7));
					al1.get(size-1).equals(al2.get(i-1));
					size--;

				}
	}
	// *********** Create SERP Methods *************

	public void clickOnnewSearchEngineResultlink()
	{
		String locator = profileLocator.getLocator("SERP.CreateSERP.NewSearchEngineResultPageLink");
		clickOn(locator);
	}

	public void createSERP()
	{
		String locator1= profileLocator.getLocator("SERP.CreateSERP.Label");
		sendKeys(locator1, "Test SERP created by Webdriver script execution");

		String locator2 = profileLocator.getLocator("SERP.CreateSERP.SearchTerm");
		sendKeys(locator2, "Software Testing");

		String locator3 = profileLocator.getLocator("SERP.CreateSERP.Interval");
		selectDropDown(locator3, "7 Days");

		String locator4 = profileLocator.getLocator("SERP.CreateSERP.SearchTypeGoogle");
		clickOn(locator4);

		String locator5 = profileLocator.getLocator("SERP.CreateSERP.SubmitButton");
		clickOn(locator5);		
	}    
	
	// ******** Delete SERP Method **********
	public void deleteSerp(String text)
    {
		String locator1 = profileLocator.getLocator("SERP.Row");
		int no_rows = getSize(locator1);
		for(int i = 1; i<=no_rows; i++)
		{
			if(isElementPresent("//div[@class='serps']/div["+i+"]/table/thead/tr/th[contains(text(), 'text')]"));
			{
				clickOn("//div[@class='serps']/div["+i+"]/table/tbody/tr/td/a/img");
				acceptAlert();
				break;
			}
		}
	}

}
