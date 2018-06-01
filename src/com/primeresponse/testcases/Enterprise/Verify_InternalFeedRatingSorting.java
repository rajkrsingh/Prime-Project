package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_InternalFeedRatingSorting extends DriverTestCase {

	@Test
	public void testVerify_InternalFeedRatingSorting() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		EnterpriseHelper enterpriseHelper = new EnterpriseHelper(getWebDriver());

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

			// Go to  Enterprise > Internal Feed
			headerHelper.clickonEnterprisInternalFeed();
			ExecutionLog.Log("Go to Enterprise > Internal Feed");

			// check sorting of rating columns
			enterpriseHelper.checkRatingSorting();
			ExecutionLog.Log("check sorting of rating columns");

		}

		catch (Error e) {
			captureScreenshot("testVerify_InternalFeedRatingSorting");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_InternalFeedRatingSorting");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
