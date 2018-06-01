package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Filter_AccountsAndVerifyResults extends DriverTestCase{

	@Test
	public void testFilter_AccountsAndVerifyResults() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());

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

			// Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");
			
			// Click on Accounts >> All
			 //headerHelper.clickOnAllAccountSubMenu();
			 //ExecutionLog.Log(" Click on Accounts >> All");
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts");
			
			 //Filter Accounts and verify its filter results.
			 accountsHelper.filter_AccountsAndVerifyResults();
			 ExecutionLog.Log("Filter Accounts and verify its filter results.");
		
	}


		catch (Error e) {
			captureScreenshot("testFilter_AccountsAndVerifyResults");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testFilter_AccountsAndVerifyResults");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}

