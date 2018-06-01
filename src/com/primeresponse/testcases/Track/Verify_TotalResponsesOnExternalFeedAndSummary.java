package com.primeresponse.testcases.Track;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_TotalResponsesOnExternalFeedAndSummary extends DriverTestCase {

	@Test
	public void testVerify_TotalResponsesOnExternalFeedAndSummary() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
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
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");

			// Go to Track > Summary
			headerHelper.clickonTrackSummary();
			ExecutionLog.Log("Go to Track > Summary");
			
			//Verify total number of responses on External Feed and Track > summary page. 
			trackHelper.verify_TotalResponsesOnExternalFeedAndSummary();
			ExecutionLog.Log("Verify total number of ratings on External Feed and Summary page.");
		}

		catch (Error e) {
			captureScreenshot("testVerify_TotalResponsesOnExternalFeedAndSummary");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_TotalResponsesOnExternalFeedAndSummary");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


