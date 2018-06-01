package com.primeresponse.testcases.Profile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.ProfileHelper;

import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class DeletePageCapture_Profile extends DriverTestCase {
	@Test
	public void testDeletePageCapture_Profile() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		ProfileHelper profileHelper = new ProfileHelper(getWebDriver());


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

			// Go to Profile > PageCapture
			headerHelper.clickonProfilePageCapture();
			ExecutionLog.Log("Go to Profile > PageCapture");

			// Click to delete the page capture
			profileHelper.deletePagecapture();
			ExecutionLog.Log("Click to delete the page capture");

			// verify the success notification
			headerHelper.checkSuccessMessage("Page Capture was successfully removed.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testDeletePageCapture_Profile");
			ExecutionLog.LogErrorMessage(e);
			throw e;

		} catch (Exception e) {
			captureScreenshot("testDeletePageCapture_Profile");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
