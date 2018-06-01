package com.primeresponse.testcases.Settings;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_SameSourceOnListenersAndExternalFeed extends DriverTestCase{
	
	@Test
	public void testVerify_SameSourceOnListenersAndExternalFeed() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());
		TrackHelper trackHelper = new TrackHelper(getWebDriver());
		
		
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
			
			//Go to Settings>Track Listeners
			headerHelper.clickOnSettingsTrackListeners();
			ExecutionLog.Log("Go to Settings>Track Listeners");
			
			//Verify that same source is displayed on Listeners and External feeds page
			ArrayList<String> arr= settingHelper.fetchSourceOnListeners();
			ExecutionLog.Log("Verify that total reviews count is same on Listeners and External feeds page.");
			
			// Go to Track > External Feed
			headerHelper.clickonTrackExternalFeed();
			ExecutionLog.Log("Go to Track > External Feed");
			
			//Verify that same source is displayed on External feeds page
			trackHelper.verifySourceOnExternalfeed(arr); 
			ExecutionLog.Log("Verify that same source is displayed on External feeds page");
   
		  			
		}
		
	
		catch (Error e) {
			captureScreenshot("testVerify_SameSourceOnListenersAndExternalFeed");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_ReviewsCountOnListenersAndExternalFeed");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}



