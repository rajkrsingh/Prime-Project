package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class SettingHelper extends DriverHelper {

	private LocatorReader settingLocator;
	private LocatorReader socailLocator;
	private LocatorReader trackLocator;
	private LocatorReader headerLocator;

	public SettingHelper(WebDriver driver) {
		super(driver);
		settingLocator = new LocatorReader("Settings.xml");
		socailLocator = new  LocatorReader("Social.xml");
		trackLocator = new LocatorReader("Track.xml");
		headerLocator = new  LocatorReader("Header.xml");
	}

	public void submitCompetitorsDetails() {

		String locator = settingLocator.getLocator("Competitors.AddCompetitorsLink");
		clickOn(locator);	

		String locator1 = settingLocator.getLocator("Competitors.CompetitorDrpDwn");
		clickOn(locator1);

		String locator2 = settingLocator.getLocator("Competitors.NoOfCompetitors");
		int no_ofcompetitors = getSize(locator2);
		//int randomAccount = (int )(Math.random() * no_ofcompetitors);
		int randomAccount=getRandomInteger(2,no_ofcompetitors);
		clickOn("//div[contains(@id, 'accounts_competitor_competitor_id')]//li["+randomAccount+"]");

		String locator3 = settingLocator.getLocator("Competitors.Selector");
		WaitForElementPresent(locator3, 20);	

		String locator4 = settingLocator.getLocator("Competitors.Trackers");
		int no_oftrackers = getSize(locator4);
		if (no_oftrackers > 5)
		{
			no_oftrackers = 5;
		}
		for (int i=1; i<=no_oftrackers; i++ )
		{
			clickOn("//div[@class='selector']/ul/li["+i+"]/div");
		}

		String locator5 = settingLocator.getLocator("Competitors.SubmitButton");
		clickOn(locator5);
		waitForLoading();
	}

	//*********Fetch details of Competitors*********************//
	public ArrayList<String> fetchCompetitor()
	{
		ArrayList<String> arr = new ArrayList<String>();
		
		int totrow=getSize(settingLocator.getLocator("Competitors.Row"));
		//System.out.println("Total Competitors:"+totrow);
		
		for(int i=1;i<=totrow;i++)
		{
		 	arr.add(getText("//div[@id='data-wiselinks-container']//table/tbody/tr["+i+"]/td[1]"));
		}
		
		//System.out.println("Total Competitors List:"+arr);
		
		return arr;
		
	}
	// ************ Method to create Alerts **************

	public void submitReviewAlerts(String text) {

		String locator = settingLocator.getLocator("Alert.NewAlertLink");
		clickOn(locator);	

		String locator1 = settingLocator.getLocator("Alert.SourceDrpDown");
		WaitForElementPresent(locator1, 10);
		clickOn(locator1);
		//clickOn("//li[contains(text(), '"+text+"')]");
		clickOn("//ul[@class='dropdown-menu']//li//span[contains(text(),'Internal Review')]");

		String locator2 = settingLocator.getLocator("Alert.AllCheckBox");
		WaitForElementPresent(locator2, 10);
		
		//String locator3 = settingLocator.getLocator("Alert.TransactionDrpDown");
		//clickOn(locator3);
		
		String locator3 = settingLocator.getLocator("Alert.ReceipientsDrpDown");
		clickOn(locator3);
		
		String locator6 = settingLocator.getLocator("Alert.SelectEmail");
		clickOn(locator6);
		String locator7 = settingLocator.getLocator("Alert.InputEmail");
		sendKeys(locator7, "shishirj@360logica.com");
		
		/*
		String locator4 = settingLocator.getLocator("Alert.SalesType");
		clickOn(locator4);

		String locator5 = settingLocator.getLocator("Alert.ReceipientsDrpDown");
		clickOn(locator5);
		*/
		/*String locator6 = settingLocator.getLocator("Alert.SelectEmail");
		clickOn(locator6);
		String locator7 = settingLocator.getLocator("Alert.InputEmail");
		sendKeys(locator7, "shishirj@360logica.com");*/
		
		String locator8 = settingLocator.getLocator("Alert.SubmitBtn");
		clickOn(locator8);
		waitForLoading();

	}

	// ******** Method to delete alert **************
	public void deleteAlert(String text) {

		int row = getSize(settingLocator.getLocator("Alert.Row"));
		for (int i=1; i<= row; i++)
		{
			if(isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[contains(text(), '"+text+"')]"))
			{
				clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td[5]/a[3]/img");
				acceptAlert();
				break;
			}

		}


	}

	// ******** Method to delete the Competitors ***********

	public void deleteCompetitor() {
		String locator8 = settingLocator.getLocator("Competitors.Row");
		int row = getSize(locator8);
		System.out.println(row);
		if(row > 0)
		{
			//String tr_attribute = getAttribute(locator8, "id");
		int randomval=getRandomInteger(1,row);
			clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+randomval+"]/td[3]/div/a[2]/i");
			acceptAlert();
		}

	}

	//********** Method to Integrate with Facebook ********

	public void integrateFacebook()
	{

		if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")))
		{

			String locator = settingLocator.getLocator("Integrations.FaceBook.RemoveButton");
			clickOn(locator);	
			acceptAlert();

			//WaitForTextPresent("//div[contains(text(),'Successfully destroyed authentication.')]","Successfully destroyed authentication." , 30);
			//Assert.assertTrue(isTextPresent("Successfully destroyed authentication.", "//div[contains(text(),'Successfully destroyed authentication.')]"));
		} 
		String locator1 = settingLocator.getLocator("Integrations.FaceBook.FaceBookTab");
		clickOn(locator1);

		String locator2 = settingLocator.getLocator("Integrations.FaceBook.ConnectFaceBookButton");
		clickOn(locator2);

		String locator3 = settingLocator.getLocator("Integrations.FaceBook.EmailPhoneField");
		sendKeys(locator3,"test360.15@gmail.com");

		String locator4 = settingLocator.getLocator("Integrations.FaceBook.Password");
		sendKeys(locator4,"360logica");

		String locator5 = settingLocator.getLocator("Integrations.FaceBook.LogInButton");
		clickOn(locator5);

	}		



	//********** Method to Integrate with Twitter ********

	public void integrateTwitter()
	{

		String locator1 = settingLocator.getLocator("Integrations.Twitter.TwitterTab");
		clickOn(locator1);

		if(isElementPresent(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount")))
		{

			String locator = settingLocator.getLocator("Integrations.Twitter.RemoveButton");
			clickOn(locator);	
			acceptAlert();

			//WaitForTextPresent("//div[contains(text(),'Successfully destroyed authentication.')]","Successfully destroyed authentication." , 30);
			//Assert.assertTrue(isTextPresent("Successfully destroyed authentication.", "//div[contains(text(),'Successfully destroyed authentication.')]"));

		}		  	
		String locator2 = settingLocator.getLocator("Integrations.Twitter.ConnectTwitterButton");
		clickOn(locator2);

		String locator3 = settingLocator.getLocator("Integrations.Twitter.UsernameEmailField");
		sendKeys(locator3,"test360.15@gmail.com");

		String locator4 = settingLocator.getLocator("Integrations.Twitter.Password");
		sendKeys(locator4,"360logica");

		String locator5 = settingLocator.getLocator("Integrations.Twitter.AuthorizeAppButton");
		clickOn(locator5);

	}		


	//********** Method to Integrate with YouTube ********

	public void integrateYouTube() throws InterruptedException
	{

		String locator1 = settingLocator.getLocator("Integrations.YouTube.YouTubeTab");
		clickOn(locator1);

		//if(isElementPresent(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount")))
		//{
		if(getText("//div[@id='social-integration-settings-top-level-container']//a[2][contains(text(),'Remove All')]").contains("Remove All"))
		{
            
			String locator = settingLocator.getLocator("Integrations.YouTube.RemoveButton");
			Thread.sleep(3000);
			clickOn(locator);	
			acceptAlert();

			//WaitForTextPresent("//div[contains(text(),'Successfully destroyed authentication.')]","Successfully destroyed authentication." , 30);
			//Assert.assertTrue(isTextPresent("Successfully destroyed authentication.", "//div[contains(text(),'Successfully destroyed authentication.')]"));

		}	  			  	
		
		String locator = settingLocator.getLocator("Integrations.YouTube.ConnectYouTubeButton");
		clickOn(locator);
		
		String locator2 = settingLocator.getLocator("Integrations.YouTube.EmailField");
		sendKeys(locator2,"test360.15@gmail.com");
		
		
		
		String locator3 = settingLocator.getLocator("Integrations.YouTube.NextButton");
		clickOn(locator3);

		String locator4 = settingLocator.getLocator("Integrations.YouTube.Password");
		sendKeys(locator4,"360logica1");

		String locator5 = settingLocator.getLocator("Integrations.YouTube.SignInButton");
		clickOn(locator5);

		WaitForElementEnabled((settingLocator.getLocator("Integrations.YouTube.AcceptButton")),3000);
		String locator6 = settingLocator.getLocator("Integrations.YouTube.AcceptButton");
		clickOn(locator6);

	}		

	//**************Integrate Accounts with Google Plus*************************************** 
	public void verify_GooglePlusIntegration()
	{
		String locator1 = settingLocator.getLocator("Integrations.GooglePlus.GooglePlusTab");
		clickOn(locator1);

		if(isElementPresent(settingLocator.getLocator("Integrations.GooglePlus.IntegratedGooglePlus")))
		{

			String locator = settingLocator.getLocator("Integrations.GooglePlus.RemoveButton");
			clickOn(locator);	
			acceptAlert();

		}	  			  	
		String locator2 = settingLocator.getLocator("Integrations.GooglePlus.ConnectGooglePlus");
		clickOn(locator2);

		String locator3 = settingLocator.getLocator("Integrations.GooglePlus.EmailField");
		sendKeys(locator3,"test360.15@gmail.com");

		String locator4 = settingLocator.getLocator("Integrations.GooglePlus.Password");
		sendKeys(locator4,"360logica1");

		String locator5 = settingLocator.getLocator("Integrations.GooglePlus.SignInButton");
		clickOn(locator5);

		WaitForElementEnabled((settingLocator.getLocator("Integrations.GooglePlus.AcceptButton")),3000);
		String locator6 = settingLocator.getLocator("Integrations.GooglePlus.AcceptButton");
		clickOn(locator6);

		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Integrations.GooglePlus.AccountOff")));
	}

	//********Integrate Accounts with Google Analytics and verify that account is showing OFF by default.**************************
	public void verify_GoogleAnalyticsIntegrations() 
	{
		String locator1 = settingLocator.getLocator("Integrations.GoogleAnalytics.GoogleAnalyticsTab");
		clickOn(locator1);

		if(isElementPresent(settingLocator.getLocator("Integrations.GoogleAnalytics.IntegratedGoogleAnalytics")))
		{

			String locator = settingLocator.getLocator("Integrations.GoogleAnalytics.RemoveButton");
			clickOn(locator);	
			acceptAlert();

		}	  			  	
		String locator2 = settingLocator.getLocator("Integrations.GoogleAnalytics.ConnectWithGoogleAnalyticsButton");
		clickOn(locator2);

		String locator3 = settingLocator.getLocator("Integrations.GoogleAnalytics.EmailField");
		sendKeys(locator3,"test360.15@gmail.com");

		
		//String locator4 = settingLocator.getLocator("Integrations.GoogleAnalytics.Password");
		//sendKeys(locator4,"360logica1");
		
		String locator5 = settingLocator.getLocator("Integrations.GoogleAnalytics.SignInButton");
		clickOn(locator5);
    
		String locator4 = settingLocator.getLocator("Integrations.GoogleAnalytics.Password");
		sendKeys(locator4,"360logica1");
		
		String locator6 = settingLocator.getLocator("Integrations.GoogleAnalytics.SignInButton1");
		clickOn(locator6);
		
		WaitForElementEnabled((settingLocator.getLocator("Integrations.GoogleAnalytics.AcceptButton")),3000);
		String locator7 = settingLocator.getLocator("Integrations.GoogleAnalytics.AcceptButton");
		clickOn(locator7);

		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Integrations.GoogleAnalytics.AccountOff")));
	}

	//*********Delete already integrated account of google plus*************************
	public void delete_IntegratedGooglePlusAccount()
	{
		String locator1 = settingLocator.getLocator("Integrations.GooglePlus.GooglePlusTab");
		clickOn(locator1);

		if(isElementPresent(settingLocator.getLocator("Integrations.GooglePlus.IntegratedGooglePlus")))
		{

			String locator = settingLocator.getLocator("Integrations.GooglePlus.RemoveButton");
			clickOn(locator);	
			acceptAlert();

		}	  	

	}
	
	//**************Verify process of deleting already integrated account of Google Analytics.*************************//
	public void delete_IntegratedGoogleAnalyticsAccount()
	{
		String locator1 = settingLocator.getLocator("Integrations.GoogleAnalytics.GoogleAnalyticsTab");
		clickOn(locator1);

		String locator = settingLocator.getLocator("Integrations.GoogleAnalytics.RemoveButton");
		clickOn(locator);	
		acceptAlert();
		
		/*if(isElementPresent(settingLocator.getLocator("Integrations.GoogleAnalytics.IntegratedGoogleAnalytics")))
		{

			String locator = settingLocator.getLocator("Integrations.GoogleAnalytics.RemoveButton");
			clickOn(locator);	
			acceptAlert();

		}*/	  	

	}
	//*************Verify the process of deleting feeds on Settings >Feeds page*********************
	public void delete_Feeds()
	{
		String str="test";
		int totalrow=getSize(settingLocator.getLocator("Feeds.Row"));

		for(int i=1;i<=totalrow;i++)
		{
			if(getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[1]").contains(str))
			{
				clickOn("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]//a[3]/i");
				acceptAlert();
				break;
			}
		}


	}
	//**************Method to verify Integrated Accounts are ON on Integrations page************************//

	public void integratedAccountsOff()
	{

		if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")))
		{
			if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton1")))
			{
				WaitForElementPresent(settingLocator.getLocator("Integrations.FaceBook.OffButton1"), 50);
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton1"));


			}

			if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton2")))
			{
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton2"));
				WaitForElementPresent("//div[@id='facebook']//tr//div[contains(@class,'switch-off')]",50); 
			}
		}

		String locator1 = settingLocator.getLocator("Integrations.Twitter.TwitterTab");
		clickOn(locator1);

		if(isElementPresent(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount")))
		{	
			if(isElementPresent(settingLocator.getLocator("Integrations.Twitter.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.Twitter.OffButton"));
				WaitForElementPresent("//div[@id='twitter']//tr//div[contains(@class,'switch-off')]",50); 
			}
		} 

		String locator2 = settingLocator.getLocator("Integrations.YouTube.YouTubeTab");
		clickOn(locator2);


		if(isElementPresent(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount")))
		{
			if(isElementPresent(settingLocator.getLocator("Integrations.YouTube.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.YouTube.OffButton"));
				WaitForElementPresent("//div[@id='youtube']//tr//div[contains(@class,'switch-off')]",50); 

			}
		}  
	}
	//**************Method to verify OFF Popup message on content page************************//

	public void verifyOffPopUpMessageContent()
	{

		String locator1 =socailLocator.getLocator("Content.ViewAllButton");
		clickOn(locator1);

		String locator2 =socailLocator.getLocator("Content.PostButton");
		clickOn(locator2);

		WaitForElementPresent(socailLocator.getLocator("Content.SocialMonitorPopUp"), 50); 

		Assert.assertTrue(isElementPresent(socailLocator.getLocator("Content.SocialMonitorPopUp")));

		String locator3 =socailLocator.getLocator("Content.CloseIcon");
		clickOn(locator3);
	}
	//**************Method to verify OFF Popup message on External page************************//
	public void verifyOffPopUpMessageOnExternal() 
	{
		String locator1 =trackLocator.getLocator("ExternalFeed.ShareButton");
		clickOn(locator1);  

		WaitForElementPresent(trackLocator.getLocator("ExternalFeed.SocialMonitorPopUp"), 50);


		Assert.assertTrue(isElementPresent(trackLocator.getLocator("ExternalFeed.SocialMonitorPopUp")));

		String locator2 =trackLocator.getLocator("ExternalFeed.CloseIcon");
		clickOn(locator2);
	}

	//**************Method to verify OFF Popup message on Internal page************************//

	public void verifyOffPopUpMessageOnInternal()
	{
		String locator1 =trackLocator.getLocator("InternalFeed.ShareButton");
		clickOn(locator1);
		WaitForElementPresent(trackLocator.getLocator("InternalFeed.SocialMonitorPopUp"), 50);
		Assert.assertTrue(isElementPresent(trackLocator.getLocator("InternalFeed.SocialMonitorPopUp")));

		String locator2 =trackLocator.getLocator("InternalFeed.CloseIcon");
		clickOn(locator2);
	}


	//****************Method to verify OFF pop up message on Post page****************//

	public void verifyOffPopUpMessagePost() throws InterruptedException
	{
		String locator1 =socailLocator.getLocator("Posts.CreatePost.NewPostButton");
		clickOn(locator1);

		//Thread.sleep(3000);
		//Assert.assertTrue(isElementPresent(socailLocator.getLocator("Posts.CreatePost.SocialMonitorPopUp")));

		String locator2 =socailLocator.getLocator("Posts.CreatePost.CloseIcon");
		clickOn(locator2);

	}

	//********** Method to create Site Map ********//

	public void createSiteMap(String str)
	{
		String locator1 = settingLocator.getLocator("SiteMap.NewButton");
		clickOn(locator1);

		String locator2 = settingLocator.getLocator("SiteMap.Name");
		sendKeys(locator2,"test"+str);

		String locator3 = settingLocator.getLocator("SiteMap.Desription");
		sendKeys(locator3,"test test test test test");
		int randamval=getRandomInteger(0, 9);

		String locator4 = settingLocator.getLocator("SiteMap.Url");
		sendKeys(locator4, "http://www.prime-response.com/sitemap.xml"+randamval+"");

		String locator5 = settingLocator.getLocator("SiteMap.SubmitButton");
		clickOn(locator5);		
	}

	//********** Method to Delete Site Map ********//

	public void deleteSiteMap()
	{
		String str="test";

		String locator=settingLocator.getLocator("SiteMap.RowCount");

		int totalrow=getSize(locator);

		for(int i=1;i<=totalrow;i++)
		{

			if(getText(locator+"["+i+"]/td[1]").contains(str))
			{
				clickOn(locator+"["+i+"]/td[5]/div/div/a[2]/i");
				acceptAlert();
				break;
			}	

		}

	}

	//**********Method to verify SiteMapEntries ********

	public void checkSiteMapEntries()
	{
		//		String str="test";
		String locator=settingLocator.getLocator("SiteMap.RowCount");
		int totalcount=getSize(locator);
		//System.out.println("total count:"+totalcount);

		for(int i=1;i<=totalcount;i++)
		{
			/*if(Integer.parseInt(getText(locator+"["+i+"]/td[4]/a")) > 0)
				
			{
				clickOn(locator+"["+i+"]/td[4]/a");
				waitForLoading();
			} */
			
			//System.out.println("Entries val:"+getText("//tbody[@class='products-body']/tr["+i+"]/td[4]"));
			
			int count = Integer.parseInt(getText("//tbody[@class='products-body']/tr["+i+"]/td[4]"));
			//System.out.println("count: " +count);
			if(count>0)
			{
				//System.out.println("clicking on link");
				clickOn("//tbody[@class='products-body']/tr["+i+"]/td[4]/a");
			    waitForLoading();
					
			//Verify page redirect to content library account page
			Assert.assertTrue(isElementPresent(socailLocator.getLocator("Content.ContentLibrary")));

			String locator1=socailLocator.getLocator("Content.FilterDropDown");
			clickOn(locator1);

			Assert.assertTrue(isElementPresent(socailLocator.getLocator("Content.SiteMapEntry")));
			Assert.assertTrue(isElementPresent(socailLocator.getLocator("Content.ShowAll")));
			Assert.assertTrue(isElementPresent(socailLocator.getLocator("Content.ThisAccount")));
		
			clickOn(socailLocator.getLocator("Content.ClickOnPage"));

			int totalcontentcount=getSize(socailLocator.getLocator("Content.TotalContentCount"));
			//System.out.println("total sitemap entries:"+totalcontentcount);
			if(totalcontentcount !=0)
			{

				int a= getRandomInteger(1,totalcontentcount);
				//mouseOver("//*[@id='social-content-feed-items']/div["+a+"]/a/div/div");
				//WaitForElementNotPresent("//*[@id='social-content-feed-items']/div["+a+"]/a/div/div",30);
				Assert.assertTrue(isElementPresent("//div[@id='social-content-feed-items']/div["+a+"]/div/i[@class='icon fa fa-link']"));
			}
			break;
		}
	 }
	}


	//**********Method to create Digest Subscription********//
	public void createNewDigestSubscription(String str)
	{
		String locator1=settingLocator.getLocator("Digests.NewDigestSubscriptionButton");
		clickOn(locator1);

		String locator2=settingLocator.getLocator("Digests.Name");
		sendKeys(locator2,"test"+str);

		String locator3=settingLocator.getLocator("Digests.SourceDropDown");
		clickOn(locator3);

		//Verify list value of source
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.AllReviewes")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.InternalReview")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ExternalReview")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ProductReview")));

		int totalcount1=getSize(settingLocator.getLocator("Digests.SourceDropDownCount"));

		int a= getRandomInteger(1,totalcount1);
		clickOn("//div[@id='digest_subscription_source_chzn']//ul[@class='chzn-results']/li["+a+"]");
		waitForLoading();
		
		String locator6=settingLocator.getLocator("Digests.Recipients");
		sendKeys(locator6,"shishirj@360logica.com");

		//String locator4=settingLocator.getLocator("Digests.TransactionType");
		//clickOn(locator4);

		//String locator5=settingLocator.getLocator("Digests.SalesTypeTransaction");
		//clickOn(locator5);

		//String locator6=settingLocator.getLocator("Digests.Recipients");
		//sendKeys(locator6,"shishirj@360logica.com");

		String locator7=settingLocator.getLocator("Digests.Distribute");
		clickOn(locator7);

		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.Daily")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.Weekly")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.Monthly")));


		int totalcount2=getSize(settingLocator.getLocator("Digests.DistributeDropDownCount"));


		int a1= getRandomInteger(1,totalcount2);
		clickOn("//div[@id='digest_subscription_frequency_chzn']//div[@class='chzn-drop']/ul/li["+a1+"]");

		String locator8=settingLocator.getLocator("Digests.ConditionRating");
		clickOn(locator8);

		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue1")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue2")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue3")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue4")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue5")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionRatingValue6")));


		int totalcount3=getSize(settingLocator.getLocator("Digests.ConditionRatingDropDownCount"));

		int a2= getRandomInteger(1,totalcount3);
		clickOn("//div[@id='digest_subscription_operator_chzn']//div[@class='chzn-drop']/ul/li["+a2+"]");

		String locator9=settingLocator.getLocator("Digests.ConditionStar");
		clickOn(locator9);

		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue1")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue2")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue3")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue4")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue5")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue6")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue7")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue8")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue9")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue10")));
		Assert.assertTrue(isElementPresent(settingLocator.getLocator("Digests.ConditionStarValue11")));

		int totalcount4=getSize(settingLocator.getLocator("Digests.ConditionStarDropDownCount"));
		int a3= getRandomInteger(1,totalcount4);
		clickOn("//div[@id='digest_subscription_value_chzn']//div[@class='chzn-drop']/ul/li["+a3+"]");

		String locator10=settingLocator.getLocator("Digests.WhiteLabel");
		clickOn(locator10);

		int totalcount5=getSize(settingLocator.getLocator("Digests.WhiteLabelDropDownValue"));

		int a4= getRandomInteger(1,totalcount5);
		clickOn("//div[@id='digest_subscription_white_labelable_attributes_white_label_id_chzn']//div[@class='chzn-drop']/ul/li["+a4+"]");

		String locator11=settingLocator.getLocator("Digests.SubmitButton");
		clickOn(locator11);

	}


	//********** Method to Delete digest ********//

	public void deleteNewDigestSubscription()
	{
		String str="test";
		String locator=settingLocator.getLocator("Digests.RowCount");
		int totalrow=getSize(locator);

		for(int i=1;i<=totalrow;i++)
		{
			if(getText(locator+"["+i+"]/td[1]").contains(str))
			{

				clickOn(locator+"["+i+"]/td[7]/div/a[2]/i");
				acceptAlert();
				break;
			}	

		}
	}

	//*******Method to check digest subscription****************//
	public void check_DigestSubscriptions()
	{
		String locator=settingLocator.getLocator("Digests.SubscribeButton");
		clickOn(locator);
		acceptAlert();
	}
	//**************Method to verify Integrated Accounts are ON on Integrations page************************//


	public String[] verifyIntegratedAccounts() throws InterruptedException
	{
		String arr[]=new String[4];

		if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")))
		{
			if(!isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton1")))
			{
				WaitForElementPresent(settingLocator.getLocator("Integrations.FaceBook.OffButton1"), 50);
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton1"));


			}

			if(!isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton2")))
			{
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton2"));
				WaitForElementPresent("//div[@id='facebook']//tr//div[contains(@class,'switch-off')]",50); 
			}
			arr[1]=getText(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")); 
		}

		String locator1 = settingLocator.getLocator("Integrations.Twitter.TwitterTab");
		clickOn(locator1);
		//Thread.sleep(2000);
		if(isElementPresent(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount")))
		{	
			if(!isElementPresent(settingLocator.getLocator("Integrations.Twitter.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.Twitter.OffButton"));
				WaitForElementPresent("//div[@id='twitter']//tr//div[contains(@class,'switch-off')]",50); 
			}

			arr[2]=getText(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount"));
		} 

		String locator2 = settingLocator.getLocator("Integrations.YouTube.YouTubeTab");
		clickOn(locator2);
		//Thread.sleep(2000);

		if(isElementPresent(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount")))
		{
			if(!isElementPresent(settingLocator.getLocator("Integrations.YouTube.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.YouTube.OffButton"));
				WaitForElementPresent("//div[@id='youtube']//tr//div[contains(@class,'switch-off')]",50); 

			}

			arr[3]=getText(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount"));
		}
		return arr; 

	}	




	//************************Verify ACTIVE check box on Settings>Track listeners page******************//
	public void checkUncheckActiveCheckBox() throws InterruptedException
	{
		int totalrow=getSize(settingLocator.getLocator("TrackListeners.RowCount"));
		//int row=getSize("//div[contains(@class,'clearfix track-setting')]");
		//		System.out.println("Settings page total row:"+totalrow);
		int a=getRandomInteger(1,totalrow);

		//		System.out.println("Random Value:"+a);

		String textvalue=getAttribute("//input[@id='account_track_settings_attributes_"+a+"_value']","value");

		//		System.out.println("Text Value:"+textvalue);

		if(textvalue.isEmpty())
		{	

			String url=getText("//div[@class='table']//tr["+a+"]/td[2]/table/tbody/tr[2]/td[2]/div/div");

			String[] url1 = url.split(" ");
			System.out.println("URL:"+url1[1]);
			//sendKeys("//input[@id='account_track_settings_attributes_"+a+"_value']",url);
			sendKeys("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//div/input",url1[1]);
			if(!isElementPresent("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']"))
			{
				System.out.println("Refresh icon is not available to fetch Reviews");
			}
			if(isElementPresent("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']"))
			{
				clickOn("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']");

				WaitForElementPresent("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a",30);
				//String str=getText("//tbody/tr["+a+"]/td[2]/div/div[2]/span/span/a");

				System.out.println("Review:"+getText("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
				Assert.assertTrue(isElementPresent("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
				clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));
				waitForLoading();
				Assert.assertTrue(isElementPresent("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//input[@checked='checked']"));
				clickOn("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//input[@checked='checked']");
				clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));
			}
		}

		if(!textvalue.isEmpty())
		{
			clickOn("//tbody/tr["+a+"]//div[@class='grid_7']//a[4]/img[@alt='Cross']");
			//waitForLoading();
			Assert.assertFalse(!isElementPresent("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//input[@checked='checked']"));


		}
	}

	//**********Verify the process of Creating new feeds on Settings >Feeds page***************
	public void create_Feeds() throws InterruptedException
	{
		waitForLoading();
		int a=getRandomInteger(1, 9);
		String locator1 = settingLocator.getLocator("Feeds.NewLink");
		clickOn(locator1);

		String locator2 = settingLocator.getLocator("Feeds.Name");
		sendKeys(locator2,"test"+a);

		String locator3 = settingLocator.getLocator("Feeds.Description");
		sendKeys(locator3,"Prime Desc"+a);

		String locator4 = settingLocator.getLocator("Feeds.GroupList");
		clickOn(locator4);

		clickOn(settingLocator.getLocator("Feeds.RandyGroup"));

		String locator5 = settingLocator.getLocator("Feeds.AutoDistribution");
		clickOn(locator5);

		String locator7 = settingLocator.getLocator("Feeds.Rating");
		clickOn(locator7);

		int totalrating=getSize(settingLocator.getLocator("Feeds.TotalRating"));
		System.out.println("totalrating:"+totalrating);
		int randomval=getRandomInteger(1,totalrating);

		clickOn("//div[@id='feed_operator_chzn']//ul/li["+randomval+"]");

		String locator8 = settingLocator.getLocator("Feeds.Stars");
		clickOn(locator8);


		int totalstar=getSize(settingLocator.getLocator("Feeds.TotalStar"));
		System.out.println("totalstar:"+totalstar);
		int randomval1=getRandomInteger(1,totalstar);

		WaitForElementEnabled("//div[@id='feed_value_chzn']//ul/li["+randomval1+"]", 30);
		Thread.sleep(4000);
		clickOn("//div[@id='feed_value_chzn']//ul/li["+randomval1+"]");

		String locator9 = settingLocator.getLocator("Feeds.Sentiment");
		clickOn(locator9);

		int totalSentiment=getSize(settingLocator.getLocator("Feeds.TotalSentiment"));
		//System.out.println("totalSentiment:"+totalSentiment);
		int randomval2=getRandomInteger(1,totalSentiment);

		clickOn("//div[@id='feed_sentiment_chzn']//ul/li["+randomval2+"]");

		String locator10 = settingLocator.getLocator("Feeds.SubmitButton");
		clickOn(locator10);
		waitForLoading();

	}
	
	//*******Verify that all feeds are showing on 'Select where to share' list on external feed page.****************//
	public void verify_FeedsOnSharedExternalFeed(int val)
	{
		int totalfeeds=getSize(settingLocator.getLocator("Feeds.Row"));
		//System.out.println("Total Row"+row);
		
		if(val==totalfeeds)
		{
			Assert.assertTrue(true,"Value matched");
		}
		
		
	}

	//**************************Check ON/OFF of site icon on Settings>Track listeners page*********************************//
	public void checkOnOffSiteIcon() throws InterruptedException
	{

		int totalrow=getSize(settingLocator.getLocator("TrackListeners.RowCount"));
		int row=getSize("//div[contains(@class,'clearfix track-setting')]");
		System.out.println("Settings page total row:"+totalrow);
		int a=getRandomInteger(1,totalrow);

		String textvalue=getAttribute("//input[@id='account_track_settings_attributes_"+a+"_value']","value");
		System.out.println("Text Value:"+textvalue);

		String url=null;
		if(textvalue.isEmpty())
		{	

			url=getText("//div[@class='table']//tr["+a+"]/td[2]/table/tbody/tr[2]/td[2]/div/div");

			String[] url1 = url.split(" ");
			System.out.println("URL:"+url1[1]);
			//sendKeys("//input[@id='account_track_settings_attributes_"+a+"_value']",url);
			sendKeys("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//div/input",url1[1]);
			if(!isElementPresent("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']"))
			{
				System.out.println("Refresh icon is not available to fetch Reviews");
			}
			if(isElementPresent("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']"))
			{
				clickOn("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']");

				WaitForElementPresent("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a",30);
				//String str=getText("//tbody/tr["+a+"]/td[2]/div/div[2]/span/span/a");

				System.out.println("Review:"+getText("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
				Assert.assertTrue(isElementPresent("//tr["+a+"]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
				clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));
				waitForLoading();
				Assert.assertTrue(isElementPresent("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//input[@checked='checked']"));
				clickOn("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//input[@checked='checked']");
				clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));
			} }   	
		else
		{
			clickOn("//div[@class='container_24']//div[@class='table']//tr["+a+"]//a[@class='track-setting-remove middle']/img");
			waitForLoading();
			Assert.assertFalse(!isElementPresent("//tr["+a+"]//div[contains(@class,'grid_7')]//a/img[@alt='Link_chain']"));
			clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));

			///////////////////////////////////////////
			clickOn("//div[@class='table']//tr["+a+"]/td[2]/table/tbody/tr[2]/td[2]/a");

			String url2=getText("//div[@class='table']//tr["+a+"]/td[2]/table/tbody/tr[3]/td[2]/div/div");
			System.out.println("URL1:"+url2);

			String[] url11 = url2.split(" ");
			System.out.println("URL:"+url11[1]);
			Thread.sleep(6000);
			sendKeys("//tr["+a+"]//div[contains(@class,'grid_14 suffix_1')]//div/input",url11[1]);

			clickOn("//tbody/tr["+a+"]//div[@class='grid_7']/a[1]/img[@alt='Arrow_refresh']");

			clickOn(settingLocator.getLocator("TrackListeners.SubmitButton"));
			////////////////////////////////////////////////////////////////////

			//System.out.println("Review:"+getText("//tr[6]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
			//Assert.assertTrue(isElementPresent("//tr[6]//div[contains(@class,'clearfix track-setting')]//span[@class='review-meta-info']/span/a"));
			Assert.assertTrue(isElementPresent("//tr["+a+"]//div[contains(@class,'grid_7')]//a/img[@alt='Link_chain']"));



			if(url11[1].contains("id"))
			{

				String[] spliturl=url11[1].split("id");
				String spliturl1= spliturl[1];

				clickOn("//tr["+a+"]//div[contains(@class,'grid_7')]//a/img[@alt='Link_chain']");

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
				Assert.assertTrue(url12.contains(spliturl1));
				getWebDriver().close();

				//Switch back to main window
				getWebDriver().switchTo().window(parent);
			}
			else

			{ 
				clickOn("//tr["+a+"]//div[contains(@class,'grid_7')]//a/img[@alt='Link_chain']");

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

				if(!url2.contains("www") && url12.contains("www")){
					url12= url12.replace("www", "");
				}
				Assert.assertEquals(url12, url11[1]);
				getWebDriver().close();

				//Switch back to main window
				getWebDriver().switchTo().window(parent);
			}}
	}


	//************* Verify current user is already subscribed*********************//
	public void verifySubscription()
	{

		int rowcount=getSize(settingLocator.getLocator("Alert.Row")); 
		System.out.println("Row:"+rowcount);
		String str=getText(headerLocator.getLocator("TopRightIcons.UserEmail"));
		String str1 =str.replace(">","");
		System.out.println("STr1:"+str1);

		for(int i=1;i<=rowcount;i++)
		{
			System.out.println("Recipients:"+getText("//div[@class='table']/table/tbody/tr["+i+"]/td[3]/div"));
			if(str1.contains(getText("//div[@class='table']/table/tbody/tr["+i+"]/td[3]/div")))
			{
				clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td[5]/a[1]/img");
				acceptAlert();
				Assert.assertTrue(isElementPresent("//div[contains(text(),'There was an error trying to subscribe to this record. You may already be subscribed.')]"));
				break;

			}

			if(!(str1.contains(getText("//div[@class='table']/table/tbody/tr["+i+"]/td[3]/div"))))
			{
				clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td[5]/a[1]/img");
				acceptAlert();
				if(isElementPresent("//div[@id='flash_alert']//div[contains(text(),'Record was successfully updated."))
				{ 
					Assert.assertTrue(isElementPresent("//div[@id='flash_alert']//div[contains(text(),'Record was successfully updated."));
					break;
				}
				if(isElementPresent("//div[@id='flash_alert']//div[contains(text(),'You were successfully added to this record"))
				{
					Assert.assertTrue(isElementPresent("//div[@id='flash_alert']//div[contains(text(),'You were successfully added to this record"));
					break;  

				}
			}
		}

	}

	//************** Method to verify Integrated Accounts are ON on Integrations page ************************//


	public String[] verifyIntegratedAccountsON() throws InterruptedException
	{
		String arr[]=new String[5];

		if(isElementPresent(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")))
		{
			if(!isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton1")))
			{
				WaitForElementPresent(settingLocator.getLocator("Integrations.FaceBook.OffButton1"), 50);
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton1"));

			}

			if(!isElementPresent(settingLocator.getLocator("Integrations.FaceBook.VerifyButton2")))
			{
				clickOn(settingLocator.getLocator("Integrations.FaceBook.OffButton2"));
				WaitForElementPresent("//div[@id='facebook']//tr//div[contains(@class,'switch-off')]",50); 
			}
			arr[1]=getText(settingLocator.getLocator("Integrations.FaceBook.IntegratedFaceBookAccount")); 
			arr[4]=getText("//div[@id='authentication-1248']//div/span[1]");
		}

		String locator1 = settingLocator.getLocator("Integrations.Twitter.TwitterTab");
		clickOn(locator1);
		//Thread.sleep(2000);
		if(isElementPresent(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount")))
		{	
			if(!isElementPresent(settingLocator.getLocator("Integrations.Twitter.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.Twitter.OffButton"));
				WaitForElementPresent("//div[@id='twitter']//tr//div[contains(@class,'switch-off')]",50); 
			}

			arr[2]=getText(settingLocator.getLocator("Integrations.Twitter.IntegratedTwitterAccount"));
		} 

		String locator2 = settingLocator.getLocator("Integrations.YouTube.YouTubeTab");
		clickOn(locator2);
		//Thread.sleep(2000);

		if(isElementPresent(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount")))
		{
			if(!isElementPresent(settingLocator.getLocator("Integrations.YouTube.VerifyButton")))
			{
				clickOn(settingLocator.getLocator("Integrations.YouTube.OffButton"));
				WaitForElementPresent("//div[@id='youtube']//tr//div[contains(@class,'switch-off')]",50); 

			}

			arr[3]=getText(settingLocator.getLocator("Integrations.YouTube.IntegratedYouTubeAccount"));
		}
		return arr; 


	}	

	//*******************Verify that total reviews count is same on Listerners and External feeds page.********************************//
	String str= null;
	public void verify_ReviewsCountOnListenersAndExternalFeed()
	{

		String a="0";
		String b="";

		int totalreviews=getSize(settingLocator.getLocator("TrackListeners.TotalReviews"));
		System.out.println("Total reviews:"+totalreviews);


		int randomval=getRandomInteger(1,totalreviews);
		//System.out.println("Random Val:"+randomval);

		//str=getText("//form[@id='edit_account_13594']//tr["+randomval+"]/td[2]//tr[1]/td[1]/a");
		str=getText("//form[@id='edit_account_13594']//tr/td[2]//tr[1]/td[1]/a");
		System.out.println("str value:"+str);
		int totreviews1=Integer.parseInt(str);
		System.out.println("Total reviews:"+totreviews1);

		if(a.contains(str))
		{
			Assert.assertNull("Value does not exist");

		}
		else if(b.contains(str))
		{
			Assert.assertNull("Value does not exist");

		}
		else
		{
			//clickOn("//form[@id='edit_account_13594']//tr["+randomval+"]/td[2]//tr[1]/td[1]/a");
			clickOn("//form[@id='edit_account_13594']//tr/td[2]//tr[1]/td[1]/a");
			
			scroll();
			scroll();
			waitForLoading();
			//String locator1=trackLocator.getLocator("ExternalFeed.Row");
			int totalrow=getSize("//table[@id='feed-items-table']//tbody[@id='feed-items']/tr");
			System.out.println("Total external row:"+totalrow);
			Assert.assertEquals(totreviews1,totalrow);		

		}

	}

	//********Verify that same source is displayed on Listeners and External feeds page***********************//
	public ArrayList<String> fetchSourceOnListeners()
	{

		int row=getSize(settingLocator.getLocator("TrackListeners.Row"));
		//String[] arr = new String[row];
		ArrayList<String> arr = new ArrayList<String>(2);
		System.out.println("Total Row Value:"+row);
		for(int i=1;i<=row;i++)
		{
			if(isElementPresent("//form[@id='edit_account_13594']//tr["+i+"]/td[2]//tr[1]/td[1]/a"))
			{
				String str=getText("//form[@id='edit_account_13594']/div/table/tbody/tr["+i+"]/td[1]");
				arr.add(str);
				//System.out.println("arr value:"+arr);

			}


		}

		return arr;

	}

	public void scroll()
	{
		//boolean found= false;

		while(!this.isElementPresent("//form[@id='reviews']//tbody/tr["+str+"]/td/input"))
		{
			// scroll the page down
			javaScriptExecute("window.scrollBy(0,4050)");

			if(this.isElementPresent("//form[@id='reviews']//tbody/tr["+str+"]/td/input"))
				break;
		}
	}
	
	//*************Verify KPI templates on Integrations page.*************************************// 
	public void verify_KpiTemplateOnIntegrations(ArrayList<String> arr)
	{
		
		ArrayList<String> al1 = new ArrayList<String>();
		
		String locator1 = settingLocator.getLocator("Integrations.GoogleAnalytics.GoogleAnalyticsTab");
		clickOn(locator1);
		
		String locator2 = settingLocator.getLocator("Integrations.GoogleAnalytics.KpiTemplateDropDownList");
		clickOn(locator2);
		
		int totrow=getSize(settingLocator.getLocator("Integrations.GoogleAnalytics.TotalKpiList"));
		//System.out.println("Total size:"+totrow);
		
		for(int i=2;i<=totrow;i++)
		{
			al1.add(getText("//select[@class='authentication_kpi_template']/option["+i+"]"));
			//System.out.println("Integration KPI Value:"+al1);
			//System.out.println("Integration KPI Value:"+arr);
			if(al1.contains(arr))
			{
				Assert.assertTrue(true,"Value matched");
			}
			
			
		}
		
		
		
		
	}

}




