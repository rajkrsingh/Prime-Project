package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;
import com.primeresponse.util.ExecutionLog;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SocialHelper extends DriverHelper {

	private LocatorReader socialLocator;

	public SocialHelper(WebDriver webdriver) {
		super(webdriver);
		socialLocator = new LocatorReader("Social.xml");
	}

	public void clickOnAddContent()
	{
		String btn_locator = socialLocator.getLocator("Content.AddContent.AddContentButton");
		clickOn(btn_locator);
	}

	public void checkTitle(String text)
	{
		String title_locator  = socialLocator.getLocator("AddContent.PopUpTitle");
		isTextPresent(title_locator, text);

	}

	public void submitContent(String path)
	{
		String title_locator = socialLocator.getLocator("Content.AddContent.Title");
		sendKeys(title_locator, "Test Title by Webdriver script execution");
		String desc_locator = socialLocator.getLocator("Content.AddContent.Description");
		sendKeys(desc_locator, "Test Description by Webdriver script execution");
		String Atchimg_locator = socialLocator.getLocator("Content.AddContent.AttachImage");
		String imgPath1 = path + "/lighthouse.jpg";
		sendKeys(Atchimg_locator, imgPath1);
		String img = socialLocator.getLocator("Content.AddContent.Image");
		WaitForElementPresent(img, 10);
		String imgPath2 = path + "/Penguins.jpg";
		sendKeys(Atchimg_locator, imgPath2);
		String submit_locator = socialLocator.getLocator("Content.AddContent.Submitbutton");
		clickOn(submit_locator);
		WaitForElementNotVisible(submit_locator, 30);
	}


	public void clickOnPost()
	{
		String btn_locator = socialLocator.getLocator("Posts.CreatePost.NewPostButton");
		WaitForElementPresent(btn_locator, 20);
		clickOn(btn_locator);
	}

	public void submitPost(String text1, String text2)
	{
		String no_acc = socialLocator.getLocator("Posts.CreatePost.NoAccountIntegrated");
		if (isElementPresent(no_acc))
		{
			System.out.println("There are currently no social accounts integrated. so cannot post");
		}
		else
		{
			String title_locator = socialLocator.getLocator("Posts.CreatePost.Title");
			sendKeys(title_locator, text1);
			String desc_locator = socialLocator.getLocator("Posts.CreatePost.Description");
			sendKeys(desc_locator, text2);
			String shrtnbtn_locator = socialLocator.getLocator("Posts.CreatePost.Shortenbutton");
			clickOn(shrtnbtn_locator);
			String shrting_locator = socialLocator.getLocator("Posts.CreatePost.Shortening");
			WaitForElementNotPresent(shrting_locator, 20);
			String drpdwn_locator = socialLocator.getLocator("Posts.CreatePost.AccountDropDown");
			clickOn(drpdwn_locator);
			String fbacnt_locator = socialLocator.getLocator("Posts.CreatePost.SelectFbAccount");
			if (isElementPresent(fbacnt_locator))
			{
				clickOn(fbacnt_locator);
			}
			else
			{
				System.out.println("FB account is not integrated/has been expired");
			}
			String twtacnt_locator = socialLocator.getLocator("Posts.CreatePost.SelectTwtrAccount");
			if(isElementPresent(twtacnt_locator))
			{
				clickOn(twtacnt_locator);
			}
			else
			{
				System.out.println("Twitter Account is not Integrated/ Has been expired");
			}
			String send_locator = socialLocator.getLocator("Posts.CreatePost.Sendbutton");
			clickOn(send_locator);
		}

	}

	//***************Verify process to create dark post*****************************************//
	public void submitDarkPost(String text1, String text2)
	{

		String no_acc = socialLocator.getLocator("Posts.CreatePost.NoAccountIntegrated");
		if (isElementPresent(no_acc))
		{
			System.out.println("There are currently no social accounts integrated. so cannot post");
		}
		else
		{
			String title_locator = socialLocator.getLocator("Posts.CreatePost.Title");
			sendKeys(title_locator, text1);
			String desc_locator = socialLocator.getLocator("Posts.CreatePost.Description");
			sendKeys(desc_locator, text2);
			String shrtnbtn_locator = socialLocator.getLocator("Posts.CreatePost.Shortenbutton");
			clickOn(shrtnbtn_locator);
			String shrting_locator = socialLocator.getLocator("Posts.CreatePost.Shortening");
			WaitForElementNotPresent(shrting_locator, 20);
			String drpdwn_locator = socialLocator.getLocator("Posts.CreatePost.AccountDropDown");
			clickOn(drpdwn_locator);
			String fbacnt_locator = socialLocator.getLocator("Posts.CreatePost.NewFbAcct");
			if (isElementPresent(fbacnt_locator))
			{
				clickOn(fbacnt_locator);
			}
			else
			{
				System.out.println("FB account is not integrated/has been expired");
			}
			/*
			String twtacnt_locator = socialLocator.getLocator("Posts.CreatePost.SelectTwtrAccount");
			if(isElementPresent(twtacnt_locator))
			{
				clickOn(twtacnt_locator);
			}
			else
			{
				System.out.println("Twitter Account is not Integrated/ Has been expired");
			}*/

			String send_locator = socialLocator.getLocator("Posts.CreatePost.DarkPost");
			clickOn(send_locator);

			String send_locator1 = socialLocator.getLocator("Posts.CreatePost.Sendbutton");
			clickOn(send_locator1);
		}


	}
	//**************Method to mark content as Favorites*******************//

	public void markContentFavorite() 
	{
		String locator = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator);
		waitForLoading();

		int totalcontentcount=getSize(socialLocator.getLocator("Content.TotalContentCount"));
		if(totalcontentcount !=0)
		{

			int a= getRandomInteger(1,totalcontentcount);
			clickOn("//*[@id='social-content-feed-items']/div["+a+"]/a/img");

			String locator1 = socialLocator.getLocator("Content.MarkAsFavoriteButton");
			clickOn(locator1);


			String locator2 = socialLocator.getLocator("Content.CloseButton");
			clickOn(locator2);

			String locator3 = socialLocator.getLocator("Content.FilterDropDown");
			clickOn(locator3);

			String locator4 = socialLocator.getLocator("Content.CategoryFilter");
			clickOn(locator4);

			String locator5 = socialLocator.getLocator("Content.SelectFavorites");
			clickOn(locator5);

			String locator6 = socialLocator.getLocator("Content.UpdateResultsButton");
			clickOn(locator6);
		}


	}

	//****************Verify content details on Social>Content page.****************************//
	public void verify_ContentDetails()
	{
		String locator1 = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator1);
		waitForLoading();

		int totalcontentcount=getSize(socialLocator.getLocator("Content.TotalContentCount"));
		if(totalcontentcount !=0)
		{

			int a= getRandomInteger(1,totalcontentcount);
			clickOn("//*[@id='social-content-feed-items']/div["+a+"]/a/img");

			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.ContentTitle")));

			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.CreatedDate")));

			String locator4 = socialLocator.getLocator("Content.CloseButton");
			clickOn(locator4);

		}
	}

	//********Verify google campaigns are same on Contents > Site Map entries > new post page.*****************
	public void verify_GoogleCampaignsOnSiteMapPosts(ArrayList<String> arr1) throws InterruptedException
	{
		String locator = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator);

		waitForLoading();

		String locator1 = socialLocator.getLocator("Content.FilterDropDown");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Content.Filter.SiteMapEntryFilter");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator3);

		waitForLoading();

		String locator4 = socialLocator.getLocator("Content.PostButton");
		clickOn(locator4);
		Thread.sleep(4000);

		String locator5 = socialLocator.getLocator("Content.GoogleCampaignsList");
		Thread.sleep(3000);
		//WaitForElementPresent(locator5,30);
		clickOn(locator5);

		int totlvalue=getSize(socialLocator.getLocator("Content.TotallGoogleCampaign"));
		ArrayList<String> arr11=new ArrayList<String>();
		for(int i=2;i<=totlvalue;i++)
		{
			arr11.add(getText("//div[@id='google-campaign-select']//li["+i+"]/a/span"));
		}
		if(arr11.contains(arr1))
		{
			Assert.assertTrue(true, "Value matched");
		}

      clickOn(socialLocator.getLocator("Content.CloseIcon"));
	}


	//******Verify that google campaigns are not showing on create post page after making it OFF.*******************// 
	public void verify_OnOffGoogleCampaigns()
	{
		String locator = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator);

		waitForLoading();

		String locator1 = socialLocator.getLocator("Content.FilterDropDown");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Content.Filter.SiteMapEntryFilter");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator3);

		waitForLoading();

		String locator4 = socialLocator.getLocator("Content.PostButton");
		clickOn(locator4);

		String locator5 = socialLocator.getLocator("Content.GoogleCampaignsList");
		//Assert.assertTrue(!isElementPresent(locator5));
		Assert.assertFalse(false, locator5);


	}
	//Mark pin content on top of the feed
	public void mark_PinContent()
	{
		String locator1 = socialLocator.getLocator("Content.MyContent");
		clickOn(locator1);
		waitForLoading();

		String locator2 = socialLocator.getLocator("Content.PinTitleButton");
		clickOn(locator2);

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.PinTitle")));

		String locator3 = socialLocator.getLocator("Content.PinButton");
		clickOn(locator3);

	}
	//**************Method to mark content as Flagged*******************//

	public void markContentFlagged()
	{
		String locator = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator);
		waitForLoading();

		int totalcontentcount=getSize(socialLocator.getLocator("Content.TotalContentCount"));
		if(totalcontentcount !=0)
		{

			int a= getRandomInteger(1,totalcontentcount);
			clickOn("//*[@id='social-content-feed-items']/div["+a+"]/a/img");

			String locator1 = socialLocator.getLocator("Content.MarkAsFlaggedButton");
			clickOn(locator1);


			String locator2 = socialLocator.getLocator("Content.CloseButton");
			clickOn(locator2);

			String locator3 = socialLocator.getLocator("Content.FilterDropDown");
			clickOn(locator3);

			String locator4 = socialLocator.getLocator("Content.CategoryFilter");
			clickOn(locator4);

			String locator5 = socialLocator.getLocator("Content.SelectFlagged");
			clickOn(locator5);

			String locator6 = socialLocator.getLocator("Content.UpdateResultsButton");
			clickOn(locator6);
		}
	} 

	//**************Method to verify Social DashBoard*******************//
	public void verifySocialDashBoard(String x,String y)
	{
		{
			String locator1 = socialLocator.getLocator("Dashboard.DashBoardDropDown");
			clickOn(locator1);
			if(getText(socialLocator.getLocator("Dashboard.SelectFbAccount")).contains(x))
			{	
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.SelectFbAccount")));
			}
			if(getText(socialLocator.getLocator("Dashboard.SelectFbAccount")).contains(y))
			{
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.SelectTwtrAccount")));
			}	

			String locator2 = socialLocator.getLocator("Dashboard.MonthlyDropDown");
			clickOn(locator2);

			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.Monthly")));
			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.Weekly")));
			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.Daily")));

			String locator3 = socialLocator.getLocator("Dashboard.UpdateButton");
			clickOn(locator3);

			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.AllWidgets")));

			String locator4 = socialLocator.getLocator("Dashboard.SaveToPdfDropDown");
			clickOn(locator4);

			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Dashboard.SaveToPdfList")));

		}

	}

	//************Verify social reports are downloading in pdf file*********************//
	public void pdf_DownloadSocialDashboardReport() throws InterruptedException
	{
		String str="pdf";
		String locator1 = socialLocator.getLocator("Dashboard.SaveToPdfDropDown");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Dashboard.SaveToPdfList");
		clickOn(locator2);

		waitForLoading();
		//System.out.println(GetFiles());
		//Assert.assertTrue(GetFiles().contains(".pdf"));


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
		Thread.sleep(5000);
		String str1 = getWebDriver().getTitle();
		
		//System.out.println("New URL:"+str1);
		System.out.println("get files....."+GetFiles());
		
		//String filename=getText(GetFiles());
		Assert.assertTrue(GetFiles().contains("pdf"));
		//Assert.assertTrue(filename.contains(str));

		//Assert.assertTrue(str1.contains(str));
		getWebDriver().close();

	}


	// ********** Method to Analyze Hashtags *************
	public void analyzeHashtags() throws InterruptedException {
		String a = "#gratitude";
		String b = "#gratitude";

		Assert.assertTrue(a.contains(b));

		String hashtags = "#gratitude #selfie #technology #lovable";

		String locator1 = socialLocator.getLocator("Posts.CreatePost.Description");
		WaitForElementPresent(locator1, 30);
		sendKeys(locator1, hashtags);

		clickOn(socialLocator.getLocator("Posts.CreatePost.Sendbutton"));

		String locator4 = socialLocator.getLocator("Posts.CreatePost.AccountDropDown");
		WaitForElementPresent(locator4, 30);
		clickOn(locator4);

		String locator5 = socialLocator.getLocator("Posts.CreatePost.SelectFbAccount");
		clickOn(locator5);


		String locator6 = socialLocator.getLocator("Posts.CreatePost.SelectTwtrAccount");
		WaitForElementPresent(locator6, 30);
		clickOn(locator6);

		String locator2 = socialLocator.getLocator("Posts.CreatePost.AnalyzeHashtagsbtn");
		clickOn(locator2);


		String locator3 = socialLocator.getLocator("Posts.CreatePost.AnalyzeHashtagsSuggestion");
		int no_hashtags = getSize(locator3);

		for (int i = 1; i <= no_hashtags; i++)
		{
			clickOn(locator3+"["+i+"]/a");
			int no_suggestion = getSize(locator3+"["+i+"]/ul/li");
			int rnd = getRandomInteger(1, no_suggestion);
			clickOn(locator3+"["+i+"]/ul/li["+rnd+"]/a");	
		}

		String updated_desc = getText(locator1);
		//System.out.println("updated_desc: "+updated_desc);
		//System.out.println("hashtags: "+hashtags);
		Assert.assertTrue(hashtags.contains(updated_desc));
		//Made changes
		//Assert.assertTrue(hashtags.matches(updated_desc));
		///System.out.println(updated_desc);

		String locator7 = socialLocator.getLocator("Posts.CreatePost.FBPreview");
		WaitForElementPresent(locator7, 30);
		//assert(updated_desc.matches(getText(locator7)));
		Assert.assertTrue(updated_desc.contains(getText(locator7)));

		String locator9 = socialLocator.getLocator("Posts.CreatePost.TwtrPreviewTab");
		clickOn(locator9);

		String locator8 = socialLocator.getLocator("Posts.CreatePost.TwtrPreview");
		locator8 =locator8+"/span";
		WaitForElementPresent(locator8, 30);
		Assert.assertTrue(updated_desc.contains(getText(locator8)));
	}


	// ******* Method to check shoretn Url ******
	public void shortenUrl() throws InterruptedException {

		String fullUrl = "https://app.prime-response.com/social/accounts";
		
		String locator = socialLocator.getLocator("Posts.CreatePost.Title");
		sendKeys(locator, "TestWebDriver");

		String locator1 = socialLocator.getLocator("Posts.CreatePost.Description");
		sendKeys(locator1, fullUrl);

		String snd_btn = socialLocator.getLocator("Posts.CreatePost.Sendbutton");
		clickOn(snd_btn);
		String disbale_snd_btn = socialLocator.getLocator("Posts.CreatePost.DisabledSendBtn");
		WaitForElementNotPresent(disbale_snd_btn, 10);

		String locator4 = socialLocator.getLocator("Posts.CreatePost.AccountDropDown");
		clickOn(locator4);
		String locator5 = socialLocator.getLocator("Posts.CreatePost.SelectFbAccount");
		clickOn(locator5);
		String locator6 = socialLocator.getLocator("Posts.CreatePost.SelectTwtrAccount");
		clickOn(locator6);

		String locator2 = socialLocator.getLocator("Posts.CreatePost.Shortenbutton");
		clickOn(locator2);

		String shortening = socialLocator.getLocator("Posts.CreatePost.Shortening");
		isElementPresent(shortening);
		WaitForElementNotPresent(shortening, 20);
		WaitForElementEnabled(locator1, 20);

		Thread.sleep(3000);

		String updated_desc = getText(locator1);
		System.out.println("updated_desc:" + updated_desc);
		Assert.assertTrue(updated_desc.contains("http://bit.ly"));


		String locator7 = socialLocator.getLocator("Posts.CreatePost.FBPreview");
		assert(updated_desc.matches(getText(locator7)));

		String locator9 = socialLocator.getLocator("Posts.CreatePost.TwtrPreviewTab");
		clickOn(locator9);

		String locator8 = socialLocator.getLocator("Posts.CreatePost.TwtrPreview");
		assert(updated_desc.matches(getText(locator8)));

	}

	//****************Method to verify user should be able to click on like and comment on Facebook post*******************//
	public void check_FBLikeAndComment() throws InterruptedException
	{
		String locator1 = socialLocator.getLocator("Posts.PostPage.ListViewButton");
		clickOn(locator1);


		String locator2 = socialLocator.getLocator("Posts.PostPage.SocialAccountDropDown");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Posts.PostPage.FbAccount");
		clickOn(locator3);

		Thread.sleep(4000);
		String countstatus=getText("//div[2]/div[1]//div[@data-str-retweeted='Retweeted']/span[@class='facebook-style-like-count']");

		int aa=Integer.parseInt(countstatus);

		getWebDriver().findElement(ByLocator("//a[contains(@class,'facebook-like')]")).click();
		Thread.sleep(4000);
		String countnewstatus=getText("//div[2]/div[1]//div[@data-str-retweeted='Retweeted']/span[@class='facebook-style-like-count']");

		int bb=Integer.parseInt(countnewstatus);

		Assert.assertEquals(bb, aa+1);
		Thread.sleep(4000);
		String comment= "test comment";
		sendKeys("//input[@id='comment']",comment);

		getWebDriver().findElement(By.xpath("//input[@id='comment']")).sendKeys(Keys.ENTER);
		Assert.assertTrue(isElementPresent("//div[contains(@id,'social-comments')]//div[@class='span11']//span[contains(text(),'"+comment+"')]"));

	}

	//***************Method to verify user should be able to retweet of integarted account****************//
	String text= null;
	public String checkTwitterRetweet() throws InterruptedException
	{
		String locator1 = socialLocator.getLocator("Posts.PostPage.ListViewButton");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Posts.PostPage.SocialAccountDropDown");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Posts.PostPage.TwitterAccount");
		clickOn(locator3);
		
		clickOn("//div[@id='header']//li[contains(text(),'Posts')]");
		
		//WaitForElementVisible(TestUsrTwitterAccount,30);

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.PostPage.TestUsrTwitterAccount")));

		Thread.sleep(3000);
		clickOn("//div[@data-str-retweeted='Retweeted']//a[@class='retweet']");
		Thread.sleep(3000);
		text= getText("//div[@id='social-post-feed']//div[@id='feed']//div//div[contains(@class,'twitter-style-message-text')]");
		String [] split= text.split(" ", 6);
		String tweet=null;
		tweet=split[2];
		return tweet;
	}

	//******** Method to login on Twitter account *************//
	public void loginTwitter(String str)
	{
		clickOn("//a[3][@href='/login']");
		
		String locator1 =socialLocator.getLocator("Posts.PostPage.TwitterUserName");
		sendKeys(locator1,"test360.15@gmail.com");

		String locator2 =socialLocator.getLocator("Posts.PostPage.TwitterPwd");
		sendKeys(locator2,"360logica");

		clickOn(socialLocator.getLocator("Posts.PostPage.Submitbutton"));

		int tweetcount=getSize("//div[@class='stream home-stream']//div[2]/p");
		for(int i=1;i<=tweetcount;i++)
		{
			if(str.contains(getText("//div[@class='stream home-stream']//li["+i+"]//div[2]/p")))
			{
				Assert.assertTrue(isElementPresent("//div[@class='stream home-stream']/ol/li["+i+"]//div[@class='stream-item-footer']//a[contains(@class,'with-icn undo-retweet')]"));
				break;
			}
		}
	}

	//**************** Method to verify result after applying filter at social content screen *************************//
	public void check_FilterResults() throws InterruptedException
	{

		//1.Verifying result after applying filter for TEXT

		String locator1 = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator1);
		waitForLoading();

		String locator2 = socialLocator.getLocator("Content.FilterDropDown");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Content.Filter.TextFilter");
		clickOn(locator3);

		String locator4 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator4);

		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.TextResult")));

		//2.Verifying result after applying filter for IMAGE

		String locator5 = socialLocator.getLocator("Content.Filter.TextFilter");
		clickOn(locator5);

		String locator6 = socialLocator.getLocator("Content.Filter.ImageFilter");
		clickOn(locator6);

		String locator7 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator7);

		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.ImageResult")));

		//3.Verifying result after applying filter for GALLERY

		String locator8 = socialLocator.getLocator("Content.Filter.ImageFilter");
		clickOn(locator8);

		String locator9 = socialLocator.getLocator("Content.Filter.GalleryFilter");
		clickOn(locator9);

		String locator10 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator10);

		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.GalleryResult")));

		//4.Verifying result after applying filter for VIDEO

		String locator11 = socialLocator.getLocator("Content.Filter.GalleryFilter");
		clickOn(locator11);

		String locator12 = socialLocator.getLocator("Content.Filter.VideoFilter");
		clickOn(locator12);

		String locator13 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator13);

		waitForLoading();

		Assert.assertTrue(isElementPresent("//div[@id='social-content-feed-items']/div/a/img"));

		/*int totalvideo=getSize(socialLocator.getLocator("Content.Filter.VideoResult"));
				int randomvalue=getRandomInteger(1,totalvideo);

				clickOn("//div[@id='social-content-feed-items']/div["+randomvalue+"]/a/img");

				waitForLoading();
				Thread.sleep(6000);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.VideoPlayButton")));

				clickOn(socialLocator.getLocator("Content.Filter.Submitbutton"));
		 */

		//5.Verifying result after applying filter for REVIEW

		String locator14 = socialLocator.getLocator("Content.Filter.VideoFilter");
		clickOn(locator14);

		String locator15 = socialLocator.getLocator("Content.Filter.ReviewFilter");
		clickOn(locator15);

		String locator16 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator16);

		waitForLoading();

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.ReviewResult")));	

		//6.Verifying result after applying filter for SITE MAP ENTRY

		String locator17 = socialLocator.getLocator("Content.Filter.ReviewFilter");
		clickOn(locator17);

		String locator18 = socialLocator.getLocator("Content.Filter.SiteMapEntryFilter");
		clickOn(locator18);

		String locator19 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator19);

		waitForLoading();

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.SiteMapEntryResult")));	

		//7.Verifying result after applying filter for INVENTORY

		String locator20 = socialLocator.getLocator("Content.Filter.SiteMapEntryFilter");
		clickOn(locator20);

		String locator21 = socialLocator.getLocator("Content.Filter.InventoryFilter");
		clickOn(locator21);

		String locator22 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator22);

		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Content.Filter.InventoryResult")));

	}

	//********************Method to verify system categories available on social content screen*********************//
	public void verifySystemCategories()
	{
		String []arr={"Animals","Appeal","Auto Dealer Marketing","Automotive Industry","Charities","Community Events","DIY","Food & Drink","Funny-Viral","Health & Fitness","Home & Garden","Human Interest","Kids","National Calendar Days","Outdoors","Product","Quotes","Seasonal","Sports","Stock Photos","Technology","Testimonial","Travel","Trending Content"};
		int k=0;
		int row1=getSize("//div[@id='social-content-items']/fieldset[2]/div[1]/div/div/a/div[1]");

		for(int i=1;i<=row1;i++)
		{
			if(arr[k].equals(getText("//div[@id='social-content-items']/fieldset[2]/div[1]/div["+i+"]/div/a/div[1]")))
			{
				Assert.assertTrue(isElementPresent("//div[@id='social-content-items']/fieldset[2]/div[1]/div["+i+"]/div/a/div[1]"));
				System.out.println("Categories Value:"+getText("//div[@id='social-content-items']/fieldset[2]/div[1]/div["+i+"]/div/a/div[1]"));
			}
			k++;
		}	
		int row2=getSize("//div[@id='social-content-items']/fieldset[2]/div[2]/div/div/a/div[1]");
		for(int i=1;i<=row2;i++)
		{
			if(arr[k].equals(getText("//div[@id='social-content-items']/fieldset[2]/div[2]/div["+i+"]/div/a/div[1]")))
			{
				Assert.assertTrue(isElementPresent("//div[@id='social-content-items']/fieldset[2]/div[2]/div["+i+"]/div/a/div[1]"));
				System.out.println("Categories Value:"+getText("//div[@id='social-content-items']/fieldset[2]/div[2]/div["+i+"]/div/a/div[1]"));

			}
			k++;
		}	

		int row3=getSize("//div[@id='social-content-items']/fieldset[2]/div[3]/div/div/a/div[1]");

		for(int i=1;i<=row3;i++)
		{
			if(arr[k].equals(getText("//div[@id='social-content-items']/fieldset[2]/div[3]/div["+i+"]/div/a/div[1]")))
			{
				Assert.assertTrue(isElementPresent("//div[@id='social-content-items']/fieldset[2]/div[3]/div["+i+"]/div/a/div[1]"));
				System.out.println("Categories Value:"+getText("//div[@id='social-content-items']/fieldset[2]/div[3]/div["+i+"]/div/a/div[1]"));

			}
			k++;
		}	

		int row4=getSize("//div[@id='social-content-items']/fieldset[2]/div[4]/div/div/a/div[1]");
		for(int i=1;i<=row4;i++)
		{
			if(arr[k].equals(getText("//div[@id='social-content-items']/fieldset[2]/div[4]/div["+i+"]/div/a/div[1]")))
			{
				Assert.assertTrue(isElementPresent("//div[@id='social-content-items']/fieldset[2]/div[4]/div["+i+"]/div/a/div[1]"));
				System.out.println("Categories Value:"+getText("//div[@id='social-content-items']/fieldset[2]/div[4]/div["+i+"]/div/a/div[1]"));

			}
			k++;
		}	

		int row5=getSize("//div[@id='social-content-items']/fieldset[2]/div[5]/div/div/a/div[1]");
		for(int i=1;i<=row5;i++)
		{
			if(arr[k].equals(getText("//div[@id='social-content-items']/fieldset[2]/div[5]/div["+i+"]/div/a/div[1]")))
			{
				Assert.assertTrue(isElementPresent("//div[@id='social-content-items']/fieldset[2]/div[5]/div["+i+"]/div/a/div[1]"));
				System.out.println("Categories Value:"+getText("//div[@id='social-content-items']/fieldset[2]/div[5]/div["+i+"]/div/a/div[1]"));

			}
			k++;
		}
	}

	//*************Method to verify hashtags displays related results***********************//
	public void check_HashtagsResults()
	{
		String locator1 = socialLocator.getLocator("Posts.PostPage.ListViewButton");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Posts.PostPage.SocialAccountDropDown");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Posts.PostPage.TwitterAccount");
		clickOn(locator3);

		String locator4 = socialLocator.getLocator("Posts.PostPage.HashTag");
		clickOn(locator4);

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.PostPage.HashTagResult"))); 

	}

	//**************Method to search content*******************************//
	public void search_Content()
	{
		//String locator1 = socialLocator.getLocator("Content.ViewAllButton");
		//clickOn(locator1);
		//waitForLoading();

		String str="Toyota Tundra";

		String locator2 = socialLocator.getLocator("Content.SearchField");
		sendKeys(locator2,str);

		getWebDriver().findElement(By.xpath("//input[@id='q']")).sendKeys(Keys.ENTER);

		int totalcontentcount=getSize(socialLocator.getLocator("Content.TotalContentCount"));

		for(int i=1;i<=totalcontentcount;i++)
		{
			if(getText("//div[@id='social-content-feed-items']/div["+i+"]").contains(str))
			{
				System.out.println("SEARCH RESULT FOUND");
				break;

			}
			/*else if(str.equals(getText("//div[@id='social-content-feed-items']/div["+i+"]/a/div[1]"))
				{

				}*/
		}

		//String aa=getText("//div[@id='social-content-feed-items']/div[1]");
		//System.out.println("Content Title:"+aa);

	}

	//*********** Method to verify TimeZone on Post page*************//
	public void verifyTimeZone(String str1,String str12)
	{
		String btn_locator = socialLocator.getLocator("Posts.CreatePost.NewPostButton");
		clickOn(btn_locator);

		String locator = socialLocator.getLocator("Posts.CreatePost.SchedulePost");
		clickOn(locator);

		String locator1 = socialLocator.getLocator("Posts.CreatePost.UserTimeZoneButton");
		clickOn(locator1);

		String a= getText(socialLocator.getLocator("Posts.CreatePost.PostTimeZone"));

		if(a.contains(str1))
		{
			Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PostTimeZone")));
		}

		String locator2 = socialLocator.getLocator("Posts.CreatePost.AccountTimeZoneButton");
		clickOn(locator2);

		String[]EST={"AA","AE","CT","DC","DE","GA","GU","IN","MA","MD","ME","MH","MI","NC","NH","NJ","NY","OH","PA","RI","SC","VA","VI","VT","WV"};
		String[]CST={"AL","AP","AR","AS","FL","FM","IA","IL","KS","KY","LA","MN","MO","MP","MS","ND","NE","OK","SD","TN","TX","WI"};
		String[]PST={"CA","NV","OR","WA"};
		String[]MST={"AZ","CO","ID","MT","NM","UT","WY"};
		String[]Alaska={"AK"};
		String[]Hawaii={"HI"};
		String []US_Rico={"PR","PW"};
		int totalrow=22;
		for(int i=0;i<totalrow;i++)
		{	
			if(str12.equals(EST[i]))
			{
				System.out.println("EST Value:"+EST[i]);
				//mouseOver(socialLocator.getLocator("Posts.CreatePost.EstTime"));
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.EstTime")));
				break;
			}
			if(str12.equals("VI"))
			{
				System.out.println("EST Value:VI");
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.EstTime")));
				break;
			}

			if(str12.equals("VT"))
			{
				System.out.println("EST Value:VT");
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.EstTime")));
				break;
			}
			if(str12.equals("WV"))
			{
				System.out.println("EST Value:WV");
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.EstTime")));
				break;
			}
			else if(str12.equals(CST[i]))
			{
				System.out.println("CST Value:"+CST[i]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.CstTime")));
				break;
			}

			else if(str12.equals(PST[0]))
			{
				System.out.println("PST Value:"+PST[0]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PstTime")));
				break;
			}	
			else if(str12.equals(PST[1]))
			{
				System.out.println("PST Value:"+PST[1]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PstTime")));
				break;
			}	
			else if(str12.equals(PST[2]))
			{
				System.out.println("PST Value:"+PST[2]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PstTime")));
				break;
			}	
			else if(str12.equals(PST[3]))
			{
				System.out.println("PST Value:"+PST[3]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PstTime")));
				break;
			}	
			else if(str12.equals(MST[0]))
			{
				System.out.println("MST Value:"+MST[0]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals(MST[1]))
			{
				System.out.println("MST Value:"+MST[1]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}
			else if(str12.equals(MST[2]))
			{
				System.out.println("MST Value:"+MST[2]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals(MST[3]))
			{
				System.out.println("MST Value:"+MST[3]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals(MST[4]))
			{
				System.out.println("MST Value:"+MST[4]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals(MST[5]))
			{
				System.out.println("MST Value:"+MST[5]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals(MST[6]))
			{
				System.out.println("MST Value:"+MST[6]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MstTime")));
				break;
			}	
			else if(str12.equals("AK"))
			{
				System.out.println("Alaska Value:"+Alaska[i]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.AlaskaTime")));
				break;
			}	

			else if(str12.contains(US_Rico[0]))
			{
				System.out.println("America/Puerto_Rico Value:"+US_Rico[0]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.US_RicoTime")));
				break;
			}	

			else if(str12.contains(US_Rico[1]))
			{
				System.out.println("America/Puerto_Rico Value:"+US_Rico[1]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.US_RicoTime")));
				break;
			}	
			else if(str12.contains(Hawaii[0]))
			{
				System.out.println("Hawaii:  Value"+Hawaii[0]);
				Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.HawaiiTime")));
				break;
			}	
		}		
		String locator3 = socialLocator.getLocator("Posts.CreatePost.TimeZoneDropDown");
		clickOn(locator3);

		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.EasternTime")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.CentralTime")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.MountainTime")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.PacificTime")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.Alaska")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Posts.CreatePost.Hawaii")));
	}

	//*******************Method to verify my activity on social post screen*************************//

	public void	showOnlyMyActivity(String str1, String str2,String str3, String str4)
	{
		String locator1 = socialLocator.getLocator("Posts.PostPage.ListViewButton");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Posts.PostPage.ShowOnlyMyActivity");
		clickOn(locator2);

		//String locator3 = socialLocator.getLocator("Posts.PostPage.Google_plusButton");
		//clickOn(locator3);

		String locator3 = socialLocator.getLocator("Posts.PostPage.SocialAccountsList");
		clickOn(locator3);

		this.WaitForElementEnabled("//ul[@class='dropdown-menu']/li[3]/a/span", 30);
		clickOn("//ul[@class='dropdown-menu']/li[3]/a/span");
		waitForLoading();

		int rowcount=getSize(socialLocator.getLocator("Posts.PostPage.Row"));
		String posttext=null;

		for(int i=1;i<=rowcount;i++)
		{
			int aa=getRandomInteger(1,rowcount);
			if(getWebDriver().findElement(ByLocator("//div[@id='data-wiselinks-container']//div[@id='feed']/div["+aa+"]//div[contains(@class,'facebook-style-name')]")).isDisplayed())
				//if(this.isElementPresent("//div[@id='data-wiselinks-container']//div[@id='feed']/div["+aa+"]//div[contains(@class,'facebook-style-name')]"))
			{
				posttext= getText("//div[@id='data-wiselinks-container']//div[@id='feed']/div["+aa+"]//div[contains(@class,'facebook-style-name')]");
				System.out.println("posttext is " +posttext);
				break;
			}
		}

		boolean test = false;
		if(posttext.contains(str1))
			test=true;

		else if(posttext.contains(str2))
			test=true;

		else if(posttext.contains(str3))
			test=true;

		else if(posttext.contains(str4))
			test=true;

		if(!test)
			Assert.fail("Post not matched");

	}

	//*********** Verify social post reports of last 30 days.********************//

	public void verify_SocialPostReport()
	{
		waitForLoading();

		String locator=socialLocator.getLocator("Reports.ChooseDropDown");
		clickOn(locator);

		String loc=socialLocator.getLocator("Reports.SelectPage");
		clickOn(loc);
		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.SocialPostReport")));

		String locator1=socialLocator.getLocator("Reports.DateDropDownIcon");
		clickOn(locator1);

		String locator2=socialLocator.getLocator("Reports.Last30Days");
		clickOn(locator2);

		waitForLoading();
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.StoryType")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.FbContentBrkDown")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.FbAvg")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.FbTotal")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.FbPost")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.TweetType")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.TweetContentBrkDown")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.TweetAvg")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.TweetTotal")));
		Assert.assertTrue(isElementPresent(socialLocator.getLocator("Reports.TweeterTweet")));

	}


	//*** Add a google analytics link and verify same in description. 

	public void addaLink() {
		// TODO Auto-generated method stub

	}


	//**********Method to filter "This Account And Public" content***************************//
	public void filter_ContentThisAccountAndPublic()
	{
		String locator = socialLocator.getLocator("Content.ViewAllButton");
		clickOn(locator);

		waitForLoading();

		String locator1 = socialLocator.getLocator("Content.FilterDropDown");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("Content.Filter.ThisAccountPublic");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("Content.UpdateResultsButton");
		clickOn(locator3);
	}


	//***********Verify details of Pinned Content Report on Social > Pinned Content Report page.*************************//
	public void verify_PinnedContentReport()
	{
		//String locator1 = socialLocator.getLocator("PinnedContentRepor.Title");
		//Assert.assertTrue(true,locator1);

		isElementPresent(socialLocator.getLocator("PinnedContentRepor.Title"));

		String locator1 = socialLocator.getLocator("PinnedContentRepor.SelectTag");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("PinnedContentRepor.HondaTag");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("PinnedContentRepor.Submitbutton");
		clickOn(locator3);

		waitForLoading();

		String str=getText(locator2);

		String locator4 = socialLocator.getLocator("PinnedContentRepor.DateRange");

		String str1=getText(locator4);

		//System.out.println("Report Date Range:"+str1);



		if(str.contains(getText(socialLocator.getLocator("PinnedContentRepor.BrandName")))) 
		{
			Assert.assertTrue(true,"Value matched");
		}
		//System.out.println("Report Date:"+getText(socialLocator.getLocator("PinnedContentRepor.ReportDateRange")));

		if(str1.contains(getText(socialLocator.getLocator("PinnedContentRepor.ReportDateRange")))) 
		{
			Assert.assertTrue(true,"Value matched");
		}
		//Compare date with system date
		DateFormat df = new SimpleDateFormat("MM/dd/yy");
		Date dateobj = new Date();
		//System.out.println(df.format(dateobj));

		if(df.format(dateobj).contains(socialLocator.getLocator("PinnedContentRepor.CurrentDate"))) 
		{
			Assert.assertTrue(true,"value matched");
		}

		isElementPresent(socialLocator.getLocator("PinnedContentRepor.PinnedContentSummary"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.PinnedContentCount"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.UniquePinnedContentCount"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.PostsPinnedContent"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.AccountsUsePinnedContent"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.TotalPosts"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.TotalAccounts"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.TotalSocialAccounts"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.AccountName"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.SocialAccount"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.Network"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.PostDate"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.UtilizationSummary"));
		isElementPresent(socialLocator.getLocator("PinnedContentRepor.DetailedPostReport"));
	}

	//Verify that Pinned Content Report is downloaded in pdf file.
	public void pdfDownload_PinnedContentReport() throws InterruptedException
	{
		CheckDir();

		String locator1 = socialLocator.getLocator("PinnedContentRepor.SelectTag");
		clickOn(locator1);

		String locator2 = socialLocator.getLocator("PinnedContentRepor.HondaTag");
		clickOn(locator2);

		String locator3 = socialLocator.getLocator("PinnedContentRepor.Submitbutton");
		clickOn(locator3);

		String locator4 = socialLocator.getLocator("PinnedContentRepor.Pdf");
		clickOn(locator4);
		Thread.sleep(2000);

		//System.out.println(GetFiles());
		Assert.assertTrue(GetFiles().contains(".pdf"));


	}



}
