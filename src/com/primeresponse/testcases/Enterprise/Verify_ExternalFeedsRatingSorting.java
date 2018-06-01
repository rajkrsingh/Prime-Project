package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_ExternalFeedsRatingSorting extends DriverTestCase {
	
	@Test
	public void testVerify_ExternalFeedsRatingSorting() throws Exception {

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

			// Go to  Enterprise > External Feed
			headerHelper.clickonEnterpriseExternalFeed();
			ExecutionLog.Log("Go to Enterprise > External Feed");
			
			// Select Group
			enterpriseHelper.selectGroupAtEnterprise();
			ExecutionLog.Log("Select Group at external feed screen");
			
			// Select Source
			//String sourceName = enterpriseHelper.selectSource();
			enterpriseHelper.selectSource();
			ExecutionLog.Log("Select Source");
			
			// check sorting of rating columns
			enterpriseHelper.checkExternalRatingSorting();
			ExecutionLog.Log("check sorting of rating columns");

		}

		catch (Error e) {
			captureScreenshot("testVerify_ExternalFeedsRatingSorting");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_ExternalFeedsRatingSorting");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
