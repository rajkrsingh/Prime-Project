package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Create_Goals extends DriverTestCase  {

	@Test
	public void testCreate_Goals() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SupportHelper supportHelper = new SupportHelper(getWebDriver());

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

			// Go to Support > Goals
			getWebDriver().navigate().to("https://app.prime-response.com/support/goals");
			//headerHelper.clickonSupportGoals();
			//ExecutionLog.Log("Go to Go to Support > Goals");
			
			//Verify process of creating new goals
			supportHelper.create_Goals();
			ExecutionLog.Log("Verify process of creating new goals.");

			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");
			

		}
		catch (Error e) {
			captureScreenshot("testCreate_Goals");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Goals");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
