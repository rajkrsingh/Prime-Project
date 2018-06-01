package com.primeresponse.testcases.Web;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.WebHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;
import com.primeresponse.pagehelper.SocialHelper;

public class Verify_OnOffGoogleCampaigns extends DriverTestCase {

	@Test
	public void testVerify_OnOffGoogleCampaigns() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		WebHelper webHelper = new WebHelper(getWebDriver());
		SocialHelper socialHelper = new SocialHelper(getWebDriver());
		
		ExecutionLog.LogAddClass(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			// Open application
			getWebDriver().navigate().to(applicationUrl);
			ExecutionLog.Log("open application giturl");

			// login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");

			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Go to Web > Google Campaigns
			headerHelper.clickonWebGoogleCampaigns();
			ExecutionLog.Log("Go to Web > Google Campaigns");
			
			//Fetch total google campaigns from Web>Google Campaigns page.
			ArrayList <String> arr=webHelper.fetchGoogleCampaigns();
			ExecutionLog.Log("Fetch total google campaigns");
			
			//Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");
			
			//Verify google campaigns are same on Contents > Site Map entries > new post page.
			socialHelper.verify_GoogleCampaignsOnSiteMapPosts(arr);
			ExecutionLog.Log("Verify google campaigns are same on Contents > Site Map entries > new post page.");
			
			//Go to Web > Google Campaigns
			headerHelper.clickonWebGoogleCampaigns();
			ExecutionLog.Log("Go to Web > Google Campaigns");
			
			//Click on Off button to disable all google campaigns.
			webHelper.OffgoogleCampaigns();
			ExecutionLog.Log("Click on Off button to disable all google campaigns.");
			
			//Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");
			
			//Verify that google campaigns are not showing on create post page after making it OFF. 
     		socialHelper.verify_OnOffGoogleCampaigns();
     		ExecutionLog.Log("Verify that google campaigns are not showing on create post page after making it OFF");
			
			
			
		
		}

		catch (Error e) {
			captureScreenshot("testVerify_OnOffGoogleCampaigns");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_OnOffGoogleCampaigns");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


