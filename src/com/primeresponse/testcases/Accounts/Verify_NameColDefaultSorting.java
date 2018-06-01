package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_NameColDefaultSorting extends DriverTestCase{

	@Test
	public void testCreate_Account() throws Exception {

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
			ExecutionLog.Log("Select ABC Ford Account if not selected");
			
			// Go to any sub menu of accounts
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts?page=1");
			//headerHelper.randomClickOnAccountSubMenu();
			//ExecutionLog.Log("Go to any sub menu of accounts");
			
			// Randomly go to any page count
			accountsHelper.randomSelectPage(applicationUrl);
			ExecutionLog.Log("Randomly go to any page count");
			
			// Check default sorting of Name columns
			accountsHelper.checkNameSorting();
			ExecutionLog.Log("Go to any sub menu of accounts");
			

		}


		catch (Error e) {
			captureScreenshot("testCreate_Account");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Account");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
