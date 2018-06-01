package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_InternalFeedsMentionedAccounts extends DriverTestCase{

	@Test
	public void testVerify_InternalFeedsMentionedAccounts() throws Exception {

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
			
			// Store details of review from internal feed screen
			int rand_n_rows = getRandomInteger(1, 10);
			String accountName = enterpriseHelper.storeInternalReviewDetails(rand_n_rows);
			ExecutionLog.Log("Go to Enterprise > Internal Feed");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("You are now logged into The "+accountName+".");	
			ExecutionLog.Log("success message");
			
			// Go to Track > Internal Feed
			headerHelper.clickonTrackInternalFeed();
			ExecutionLog.Log("Go to Track > Internal Feed");
			
			// Match details stored in above function using below function
			enterpriseHelper.matchInternalReviewDetails(rand_n_rows);
			ExecutionLog.Log("Match details stored in above function using below function");

		}

		catch (Error e) {
			captureScreenshot("testVerify_InternalFeedsMentionedAccounts");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_InternalFeedsMentionedAccounts");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
