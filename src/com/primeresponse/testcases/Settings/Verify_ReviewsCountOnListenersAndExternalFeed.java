package com.primeresponse.testcases.Settings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Verify_ReviewsCountOnListenersAndExternalFeed extends DriverTestCase{
	
	@Test
	public void testVerify_ReviewsCountOnListenersAndExternalFeed() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
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
			ExecutionLog.Log("Select Selenium Test Account if not selected");
			
			//Go to Settings>Track Listeners
			headerHelper.clickOnSettingsTrackListeners();
			ExecutionLog.Log("Go to Settings>Track Listeners");
			
			//Verify that total reviews count is same on Listeners and External feeds page.
			settingHelper.verify_ReviewsCountOnListenersAndExternalFeed();
			ExecutionLog.Log("Verify that total reviews count is same on Listeners and External feeds page.");
		   
			
		}
		
	
		catch (Error e) {
			captureScreenshot("testVerify_ReviewsCountOnListenersAndExternalFeed");
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


