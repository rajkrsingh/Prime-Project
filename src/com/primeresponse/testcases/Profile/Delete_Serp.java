package com.primeresponse.testcases.Profile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.ProfileHelper;

import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Serp extends DriverTestCase {

	@Test
	public void testDelete_Serp() throws Exception {

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

			// Go to Web > SERP Capture
			headerHelper.clickonWebSERP();
			ExecutionLog.Log("Go to Profile > SERP");

			// Click to delete the SERP
			profileHelper.deleteSerp("Test SERP created by Webdriver script execution");
			ExecutionLog.Log("Click to delete the SERP");

			// verify delete success notification
			headerHelper.checkSuccessMessage("SERP was successfully removed.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testDelete_Serp");
			ExecutionLog.LogErrorMessage(e);
			throw e;

		} catch (Exception e) {
			captureScreenshot("testDelete_Serp");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}





