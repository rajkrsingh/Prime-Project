package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Sort_MyAccount_ReviewsCol extends DriverTestCase {

	@Test
	public void testSort_MyAccount_ReviewsCol() throws Exception {

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

			// Go to Enterprise > My Accounts
			headerHelper.clickonEnterpriseMyAccount();
			ExecutionLog.Log("Go to Enterprise > My Accounts");
			
			// Find out no. of rows
			int nrow = enterpriseHelper.getRows();
			ExecutionLog.Log("Find out no. of rows");
			
			// Store the reviews in array and check the sorting 
			enterpriseHelper.storeReviews(nrow);
			ExecutionLog.Log("Store the reviews in array and check the sorting ");
			
		}

		catch (Error e) {
			captureScreenshot("testSort_MyAccount_ReviewsCol");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSort_MyAccount_ReviewsCol");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
