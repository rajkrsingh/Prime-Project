package com.primeresponse.testcases.Web;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.ProfileHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Serp_Profile extends DriverTestCase{

	@Test
	public void testSerp_Profile() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		ProfileHelper profileHelper = new ProfileHelper (getWebDriver());

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

			// Go to Profile > SERP
			headerHelper.clickonWebSERP();
			ExecutionLog.Log("Go to Profile > SERP");

			//Click on SERP from Profile list
			profileHelper.clickOnnewSearchEngineResultlink();
			ExecutionLog.Log("click on SERP link");

			// Enter SERP Details 
			profileHelper.createSERP();
			ExecutionLog.Log("Enter SERP Details");

			// verify the success notification
			headerHelper.checkSuccessMessage("SERP was successfully created.");	
			ExecutionLog.Log("success message");
			System.out.println("Test Case Passed");

		}

		catch (Error e) {
			captureScreenshot("testSerp_Profile");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSerp_Profile");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
