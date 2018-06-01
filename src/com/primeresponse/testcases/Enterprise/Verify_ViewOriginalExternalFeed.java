package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_ViewOriginalExternalFeed extends DriverTestCase {

	@Test
	public void testVerify_ViewOriginalExternalFeed() throws Exception {

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
			
			// Click on view icon of External Feeds
			int rand_n_rows = getRandomInteger(1, 10);
			enterpriseHelper.external_clickOnViewIcon(rand_n_rows);
			ExecutionLog.Log(" Click on view icon of External Feeds");

			// Check facebox displayed or not
			headerHelper.checkFacebox();
			ExecutionLog.Log("Clicking on view icon should display popup");
			
			// Store facebox values 
			enterpriseHelper.storeViewPopupDetails(rand_n_rows);
			ExecutionLog.Log("Store facebox values");
			
			
			
		}

		catch (Error e) {
			captureScreenshot("testVerify_ViewOriginalExternalFeed");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_ViewOriginalExternalFeed");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
