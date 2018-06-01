package com.primeresponse.testcases.Track;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;
import com.primeresponse.pagehelper.SettingHelper;


public class Verify_FeedsOnSharedExternalFeed extends DriverTestCase{

	@Test
	public void testVerify_FeedsOnSharedExternalFeed() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		TrackHelper trackHelper = new TrackHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());

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
		 	ExecutionLog.Log("Select Selenium Test Ford Account if not selected");

			// Go to Track > External Feed
			headerHelper.clickonTrackExternalFeed();
			ExecutionLog.Log("Go to Track > External Feed");

			//Fetch feeds from 'where to share list'
			int val=trackHelper.fetchFeedsExternalFeed();
			ExecutionLog.Log("Fetch feeds from 'where to share list");
			
			//Go to Settings >Feeds
			headerHelper.clickOnSettingsFeeds();
			ExecutionLog.Log("Go to Settings >Feeds");
			
			//Verify that all feeds are showing on 'Select where to share' list on external feed page.
			settingHelper.verify_FeedsOnSharedExternalFeed(val);
			ExecutionLog.Log("Verify that all feeds are showing on 'Select where to share' list on external feed page.");
			
		}

		catch (Error e) {
			captureScreenshot("testVerify_FeedsOnSharedExternalFeed");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_FeedsOnSharedExternalFeed");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}



