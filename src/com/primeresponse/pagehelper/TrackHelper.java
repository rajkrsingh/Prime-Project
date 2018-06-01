package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;
import com.primeresponse.util.ExecutionLog;

public class TrackHelper extends DriverHelper {

	private LocatorReader trackLocator;
	private LocatorReader headerLocator;

	public TrackHelper(WebDriver webdriver) {
		super(webdriver);
		trackLocator = new LocatorReader("Track.xml");
		headerLocator = new LocatorReader("Header.xml");	
	}

	// **** Delete Internal feed method **********

	public void deleteInternalFeed()
	{
		{
			String str="- Testing";
			String locator1 = trackLocator.getLocator("InternalFeed.Row");
			int no_rows = getSize(locator1);
			for (int i = 1; i<=no_rows; i++)
			{
				if(str.contains(getText("//tbody[@id='feed-items']/tr["+i+"]/td[3]/div[1]/u")))
				{
					clickOn("//tbody[@id='feed-items']/tr["+i+"]/td[5]/a");
					acceptAlert();
					break;
				}

			}
		}
	}

	// ****** Delete External feed method **********

	public void checkDisableDeleteButton()
	{
		String disable_locator = trackLocator.getLocator("ExternalFeed.DisbaledButton");
		isElementPresent(disable_locator);
	}

	public void selectCheckBox()
	{
		String row_locator = trackLocator.getLocator("ExternalFeed.Row");
		int no_rows = getSize(row_locator);
		int rand_checkbox=2+(int)(Math.random()*((no_rows-2)+1));
		clickOn("//table/tbody/tr["+rand_checkbox+"]/td[1]/input");
	}

	public void checkEnableDeleteButton()
	{
		String enable_locator = trackLocator.getLocator("ExternalFeed.EnableDeleteButton");
		isElementPresent(enable_locator);
	}

	public void deleteExternalFeed()
	{
		String enable_locator = trackLocator.getLocator("ExternalFeed.DeleteButton");	
		clickOn(enable_locator);
		acceptAlert();
	}

	// ********* Check review counts methods ************
	public void select365Segment() {

		String locator1 = trackLocator.getLocator("Summary.Segment365On");	
		if(!isElementPresent(locator1))
		{
			String locator2 = trackLocator.getLocator("Summary.Segment365");
			clickOn(locator2);
		}


	}

	public void storeListenersAndReviewCount() {

		ArrayList<String> al1 = new ArrayList<String>();
		ArrayList<String> al2 = new ArrayList<String>();
		String locator1 = trackLocator.getLocator("Summary.Row");
		int n = getSize(locator1);
		
		//System.out.println("N value:" +n);
		for (int i =1; i <n; i++ )
		{
		    //al1.add(getText(locator1+"["+(i+1)+"]/td[2]"));
			//al2.add(getText(locator1+"["+(i+1)+"]/td[3]"));
			al2.add(getText(locator1+"["+i+"]/td[3]"));
		}

		//System.out.println(al1 + "/n" + al2);

	}

	//*****************Method to verify name of all available widgets on Track summary screen*******************// 
	public void verifyWidgetsTrackSummary()
	{
		waitForLoading();
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.ReviewsBySite")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.Chart")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.Day365Trends")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.WebReviews")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.InternalSurveys")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.ExternalCustomerSentiment")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.Chart")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.PositiveReview")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.NegativeReview")));
		//Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.SocialMonitor")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("Summary.YrProductSpecialist")));


	}

	//**************Method to verify functionality of resolving external feed****************//
	public void resolveExternalFeed()
	{
		String locator1 = trackLocator.getLocator("ExternalFeed.Row");
		int count=getSize(locator1);
		System.out.println("Total Row:"+count);

		int randomvalue=getRandomInteger(1,count);
		//System.out.println("random value:"+randomvalue);

		clickOn("//tbody[@id='feed-items']/tr["+randomvalue+"]/td[4]//div/a[5]");
		waitForLoading();

		String locator2 = trackLocator.getLocator("ExternalFeed.CommentsTextArea");
		sendKeys(locator2,"test comments");

		String locator3 = trackLocator.getLocator("ExternalFeed.SaveButton");
		clickOn(locator3);

		Assert.assertTrue(isElementPresent("//tbody[@id='feed-items']/tr["+randomvalue+"]/td[4]//div/i"));

	}

	//*************Verify random search of any external feed*************************
	public void Search_ExternalFeed()
	{
		String locator = trackLocator.getLocator("ExternalFeed.FilterButton");
		clickOn(locator);
		
		String locator1 = trackLocator.getLocator("ExternalFeed.SelectSourceList");
		clickOn(locator1);

		int totalsource =getSize(trackLocator.getLocator("ExternalFeed.SourceCount"));
		System.out.println("total source count:"+totalsource);

		int randomval=getRandomInteger(1,totalsource);
		System.out.println("random val:"+randomval);

		clickOn("//div[@id='feed-filter-dropdown']//li["+randomval+"]/a");
		
		clickOn(trackLocator.getLocator("ExternalFeed.UpdateResultButton"));
		waitForLoading();

	}

	//**************Share external feed with social accounts*******************************//
	public void share_ExternalFeed() 
	{
		int row=getSize(trackLocator.getLocator("ExternalFeed.Row"));
		//System.out.println("Total Row:"+row);

		int randomval=getRandomInteger(1,row);
		this.WaitForElementPresent("//tbody[@id='feed-items']/tr["+randomval+"]/td[4]//a[@data-original-title='Share']/i", 30);
		clickOn("//tbody[@id='feed-items']/tr["+randomval+"]/td[4]//a[@data-original-title='Share']/i");

		String locator1 = trackLocator.getLocator("ExternalFeed.SelectWhereToShareDropDown");
		clickOn(locator1);


		String locator3 = trackLocator.getLocator("ExternalFeed.ShareListFbAccount");
		WaitForElementPresent(locator3, 30);
		clickOn(locator3);


		String locator4 = trackLocator.getLocator("ExternalFeed.ShareListTwitterAccount");
		//WaitForElementPresent(locator4, 30);
		clickOn(locator4);


		String locator5 = trackLocator.getLocator("ExternalFeed.SendNowButton");
		clickOn(locator5);


	}
	
	//*********Fetch feeds from 'where to share list'***************************//
	public int fetchFeedsExternalFeed()
	{
		int row=getSize(trackLocator.getLocator("ExternalFeed.Row"));
		//System.out.println("Total Row:"+row);

		int randomval=getRandomInteger(1,row);
		clickOn("//tbody[@id='feed-items']/tr["+randomval+"]//a[4]/i");

		String locator1 = trackLocator.getLocator("ExternalFeed.SelectWhereToShareDropDown");
		clickOn(locator1);
		
		int totalval=getSize("//ul[@class='dropdown-menu']/li/a/span/img[@alt='Social-rss']");
		//System.out.println("Total Size:"+totalval);
		return totalval;
		
		
		
	}

	//****************Method to verify the functionality of resolving internal feed***********************//
	public void resolveInternalFeed()
	{
		String locator1 = trackLocator.getLocator("InternalFeed.Row");
		int count=getSize(locator1);
		//System.out.println("Total Row:"+count);

		int randomvalue=getRandomInteger(1,count);
		//System.out.println("random value:"+randomvalue);

		clickOn("//tbody[@id='feed-items']/tr["+randomvalue+"]/td[3]//div[2]/div/a[@data-original-title='Resolve']");
		waitForLoading();

		String locator2 = trackLocator.getLocator("InternalFeed.CommentsTextArea");
		sendKeys(locator2,"test comments");

		String locator3 = trackLocator.getLocator("InternalFeed.SaveButton");
		clickOn(locator3);

		Assert.assertTrue(isElementPresent("//tbody[@id='feed-items']/tr["+randomvalue+"]/td[3]//div[2]/div/a[@data-original-title='Resolve']/i"));

	}

	//********Method to check sorting of date column*******************************//
	public void checkInternalFeedDateSorting() throws InterruptedException
	{
		// click on sort icon of date columns
		String locator1 = trackLocator.getLocator("InternalFeed.DateSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("InternalFeed.Row");
		int n_rows = getSize(locator2);
		//System.out.println("Total Row Value:"+n_rows);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='feed-items']/tr["+i+"]/td[4]");
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
			Thread.sleep(4000);
			str = getText("//tbody[@id='feed-items']/tr["+i+"]/td[4]");

			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//********Verify sorting functionality of Account column under Track >Competitors latest reviews widget***************//
	public void sort_TrackCompetitiorsAccountCol() throws InterruptedException
	{
		// click on sort icon of published columns
		waitForLoading();
		String locator1 = trackLocator.getLocator("Competitors.AccountSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("Competitors.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[2]");
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
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[2]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//*************Verify sorting functionality of Description column under Track >Competitors latest reviews widget.*********
	public void sort_TrackCompetitiorsDescriptionCol() throws InterruptedException
	{
		// click on sort icon of published columns
		waitForLoading();
		String locator1 = trackLocator.getLocator("Competitors.DescriptionSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("Competitors.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[3]");
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
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[3]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//**********Verify default sorting of published date under Track >Competitors latest reviews widget**********//
	public void checkTrackCompetitiorsDefaultSorting() throws InterruptedException
	{
		// click on sort icon of published columns
		waitForLoading();
		String locator1 = trackLocator.getLocator("Reputation.PublishedSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("Reputation.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[5]");
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
			str = getText("//tbody[@id='competitors-reviews']/tr["+i+"]/td[5]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//******Verify the functionality of clicking go to site icon and should redirect to same domain under Track >Competitors latest reviews widget.***********
	public void verify_TrackCompetitiorsGoToSite() throws InterruptedException
	{

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();


		waitForLoading();
		mouseOver(trackLocator.getLocator("Competitors.GoToSite"));

		Thread.sleep(4000);
		String str=getAttribute(trackLocator.getLocator("Competitors.GoToSite"),"href");
		//System.out.println("Go to Site url:"+str);

		String locator1 = trackLocator.getLocator("Competitors.GoToSite");
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
		System.out.println("New URL:"+url12);
		
		//System.out.println("new url value::"+newurl);
		
	 String[] strr=url12.split(".m/");
	 //System.out.println("new url value::"+strr[0]);
		Assert.assertTrue(str.contains(strr[0]));
		
		getWebDriver().close();

		//Switch back to main window
		getWebDriver().switchTo().window(parent);
	}

	//******Verify that same competitors are showing on 'Track >Competitors' and 'Settings >Competitors' page.
	//********Also logged in account is showing  in competitors list on 'Track >Competitors' page.
	public void verify_CompetitorsOnTrackAndSettings(ArrayList<String> arr)
	{
		 ArrayList<String> arr1= new ArrayList<String>();
		 int totval=getSize(trackLocator.getLocator("Competitors.TotalCompetitors"));
		 
		 for(int i=1;i<=totval;i++)
		 {
			 arr1.add(getText("//div[@class='tags ui-accordion ui-widget ui-helper-reset']/div["+i+"]"));
		 }
		 
		 //System.out.println("Track >Total Competitors:" +arr1);
		 
		 if(arr.contains(arr1))
		 {
			 Assert.assertTrue(true,"Value matched.");
			 
		 }
		 
		 if(arr1.contains(headerLocator.getLocator("TopRightIcons.SelectedAccount")))
		 {
			 Assert.assertTrue(true,"Value matched.");
		 }
		 
			
	}
	 

	//*****Verify sorting functionality of rating column under Track >Competitors latest reviews widget.***************//
	public void sort_TrackCompetitiorsRating() throws InterruptedException
	{
		// click on sort icon of rating columns
		String locator1 = trackLocator.getLocator("Competitors.RatingSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("Competitors.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute("//tbody[@id='competitors-reviews']/tr["+i+"]/td[4]//div[@class='star_rating']/div", "style");
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
			String locator ="//tbody[@id='competitors-reviews']/tr["+i+"]/td[4]//div[@class='star_rating']"; 

			if(isElementPresent(locator))
				str = getAttribute(locator+"/div", "style");
			//str = getAttribute(locator2+"["+i+"]/td//div[@class='star_rating']/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}


	}

	//*********************check sorting of published columns**********************//
	public void checkPublishRatingSorting() throws InterruptedException
	{
		// click on sort icon of published columns
		String locator1 = trackLocator.getLocator("ExternalFeed.PublishedSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("ExternalFeed.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//table[@id='feed-items-table']//tr["+i+"]/td[5]");
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
			str = getText("//table[@id='feed-items-table']//tr["+i+"]/td[5]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//************************check sorting of rating columns******************************//
	public void checkRatingSorting() throws InterruptedException
	{
		// click on sort icon of rating columns
		String locator1 = trackLocator.getLocator("ExternalFeed.RatingSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("ExternalFeed.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[*]//div[@class='star_rating']/div", "style");
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
			String locator ="//tbody//tr["+i+"]//td//div[contains(@class,'star_rating')]"; 

			if(isElementPresent(locator))
				str = getAttribute(locator+"/div", "style");
			//str = getAttribute(locator2+"["+i+"]/td//div[@class='star_rating']/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//*****************Method to check sorting of rating columns of Internal Feed******************//
	public void checkInternalFeedRatingSorting() throws InterruptedException
	{
		// click on sort icon of rating columns
		String locator1 = trackLocator.getLocator("InternalFeed.RatingSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("InternalFeed.Row");
		int n_rows = getSize(locator2);

		// store rating value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getAttribute(locator2+"["+i+"]/td[*]//div[@class='star_rating']/div", "style");
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
			String locator ="//tbody//tr["+i+"]//td//div[contains(@class,'star_rating')]"; 

			if(isElementPresent(locator))
				str = getAttribute(locator+"/div", "style");
			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//********************Method to check sorting of source columns*******************************//
	public void checkSourceSorting() throws InterruptedException
	{
		// click on sort icon of source columns
		String locator1 = trackLocator.getLocator("ExternalFeed.SourceSortIcon");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = trackLocator.getLocator("ExternalFeed.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='external-feed-reviews']/tr["+i+"]/td[2]/img");
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
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			Thread.sleep(4000);
			str = getText("//tbody[@id='external-feed-reviews']/tr["+i+"]/td[2]/img");

			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//********Method to verify the functionality of clicking go to site icon and should redirect to same domain**************//
	public void verifyGoToSiteExternalFeed() throws InterruptedException
	{
		waitForLoading();
		mouseOver(trackLocator.getLocator("ExternalFeed.GoToSite"));

		Thread.sleep(4000);
		String str=getAttribute(trackLocator.getLocator("ExternalFeed.SiteUrl"),"href");
		//System.out.println("Go to Site url:"+str);
        
		String[] newstrr=str.split("//");
		
		System.out.println("new newstrr value::"+newstrr[1]);
		String locator1 = trackLocator.getLocator("ExternalFeed.GoToSite");
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
		System.out.println("New URL:"+url12);
		
		String[] strr=url12.split("//");
		System.out.println("new url value::"+strr[1]);
	   
	   //System.out.println("Trim URL::"+newstr);
		Assert.assertTrue(newstrr[1].contains(strr[1]));
		getWebDriver().close();

		//Switch back to main window
		getWebDriver().switchTo().window(parent);
	}


	//*****************Verify product review feed on Track > Product Review Feed page*******************************//
	public void verify_TrackProductReviewFeed()
	{
		String locator1 = trackLocator.getLocator("ProductReviewFeed.FilterByProductDropDown");
		clickOn(locator1);

		int productcount=getSize(trackLocator.getLocator("ProductReviewFeed.ProductCount"));

		int randomval=getRandomInteger(1,productcount);

		clickOn("//div[@id='product_id_chzn']//li["+randomval+"]");

		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ProductReviewFeed.Product")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ProductReviewFeed.Rating")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ProductReviewFeed.Comments")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ProductReviewFeed.Published")));
	}

	//*************Verify reviews details on Track > External Feed page.**************************//
	public void verify_ExternalFeedReviewDetails()
	{
		int viewmorecount=getSize(trackLocator.getLocator("ExternalFeed.ViewMoreButton"));

		int randomval=getRandomInteger(1,viewmorecount);

		clickOn("//tbody[@id='feed-items']/tr["+randomval+"]//a[@data-original-title='View More']/i");
		waitForLoading();

		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ExternalFeed.ReviewDate")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ExternalFeed.Reviewer")));
		//Assert.assertTrue(isElementPresent(trackLocator.getLocator("ExternalFeed.Sentiment")));
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ExternalFeed.Comments")));

	}

	//****************Method to verify name of all available widgets on Track and summary page***********************// 
	public void verify_TotalRatingsOnExternalFeedAndSummary()
	{

		waitForLoading();
		clickOn(trackLocator.getLocator("Summary.AllTab"));
		waitForLoading();

		int totsize =getSize("//div[@id='data-wiselinks-container']//tbody/tr/td[6]/a");
		//System.out.println("total size"+totsize);

		int randomval=getRandomInteger(1,totsize);
		// System.out.println("random val"+randomval);

		String ratings=getText("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"+1]/td[2]");
		//System.out.println("ratings val:"+ratings);

		clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"+1]/td[6]/a");

		waitForLoading();

		int  totalrating=getSize(trackLocator.getLocator("ExternalFeed.Row"));
		//System.out.println("total rating:"+totalrating);

		if(ratings.equals(totalrating))
		{
			Assert.assertTrue(true,"Value matched");
		}

	}

	//********Verify total number of responses on External Feed and Track > summary page. 
	String str3=null;
	public void verify_TotalResponsesOnExternalFeedAndSummary()
	{
		String str="-";
		waitForLoading();
		clickOn(trackLocator.getLocator("Summary.AllTab"));
		waitForLoading();

		int totsize =getSize("//div[@id='data-wiselinks-container']//tbody/tr/td[6]/a");
		int randomval=getRandomInteger(1,totsize);

		String totresponse=getText("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"]/td[3]");
		//System.out.println("Response val:"+totresponse);
		if(str.equals(totresponse))
		{
			Assert.assertFalse(false,"There is no response to match");
			
			
		}
		
		else 
		{
			int k=Integer.parseInt(totresponse);
			//System.out.println("K value is:"+k);
			str3=getText("//*[@id='data-wiselinks-container']/div[3]/div/div[1]/div/div[2]/div/table/tbody/tr["+randomval+"]/td[2]");
		    int count = Integer.parseInt(str3);
       	    System.out.println(count);
       	    
			clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"]/td[6]/a");
			waitForLoading();
          	scroll();
		
			int j=0;
			//String str1="1 Response(s)";
			for(int i=1;i<=count; i++)
			{

				 //System.out.println(i);
				 //String text= getText("//form[@id='reviews']//tbody/tr["+i+"]/td[5]/div[3]/span");
				 if(isElementPresent("//form[@id='reviews']//tbody/tr["+i+"]/td[5]/div[3]/span[contains(text(),'Response')]"))
				 {					 
					 j=j+1;
					 //System.out.println(j);
				 }
						 
			}
			
			 Assert.assertEquals(j, k);
		
	  }
		
  }
	
	public void scroll()
	{
		//boolean found= false;
		
		while(!isElementPresent("//form[@id='reviews']//tbody/tr["+str3+"]/td/input"))
		{
			// scroll the page down
			javaScriptExecute("window.scrollBy(0,4050)");
			
			if(isElementPresent("//form[@id='reviews']//tbody/tr["+str3+"]/td/input"))
				break;
		}
	}
	
	
	//*************Verify that same source is displayed on Track Listeners and External feeds page****************************
	public void verifySourceOnExternalfeed(ArrayList<String> arr)
	{
		
		ArrayList<String> arr1 = new ArrayList<String>(2);
		String locator1 = trackLocator.getLocator("ExternalFeed.FilterButton");
		clickOn(locator1);
		
		String locator2 = trackLocator.getLocator("ExternalFeed.SourceCount");
		clickOn(locator2);
		
		//String locator1 = trackLocator.getLocator("ExternalFeed.SelectSourceList");
		//clickOn(locator1);
		
		 //System.out.println("Arr value on extnl feed page:"+arr);
		int totalsource =getSize(locator2);
		System.out.println("total source count:"+totalsource);
    
		for(int i=1;i<=totalsource;i++)
		{
			 String str=getText("//div[@id='feed-filter-dropdown']//li[2]//li["+i+"]/a");
			 System.out.println("String Vsalue:"+str);
			 arr1.add(str);
			 
			 if(arr1.get(i-2).contains(arr.get(i-2)))
			 {
				 
				 System.out.println("Value exists");
				 
			 }	 
				 else
				 {
					 System.out.println("Value does not exist");
				 }
			 }
		}
		
 }

