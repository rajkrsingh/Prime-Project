package com.primeresponse.testcases.Track;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_ExternalFeed extends DriverTestCase{

	@Test
	public void testDelete_ExternalFeed() throws Exception {

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

			// Go to Track > External Feed
			headerHelper.clickonTrackExternalFeed();
			ExecutionLog.Log("Go to Track > External Feed");

			// Check Delete button is disabled 
			trackHelper.checkDisableDeleteButton();
			ExecutionLog.Log("Check Delete button is disabled ");

			// Select any random check box
			trackHelper.selectCheckBox();
			ExecutionLog.Log("Select any random check box");

			// Check Delete button is getting enabled 
			trackHelper.checkEnableDeleteButton();
			ExecutionLog.Log(" Check Delete button is getting enabled");

			// Click on Delete Icon
			trackHelper.deleteExternalFeed();
			ExecutionLog.Log("Go to Ifluence > External Feed");

			// verify the success notification
			headerHelper.checkSuccessMessage("Track Items were successfully removed.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testDelete_ExternalFeed");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_ExternalFeed");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
