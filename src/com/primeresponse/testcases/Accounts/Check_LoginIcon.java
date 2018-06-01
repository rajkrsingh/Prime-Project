

package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_LoginIcon extends DriverTestCase {


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
			
			  ExecutionLog.Log("Select Selenium Test Account if not selected");
			  

			// Go to Accounts > All
			headerHelper.clickOnAccountAll();
			ExecutionLog.Log("Go to Accounts > All");
			//getWebDriver().navigate().to("https://app.prime-response.com/accounts?page=1");
			

			//Search for same account which you have logged In and match the Result
			String account = propertyReader
					.readApplicationFile("Account");
			accountsHelper.accountsSearch(account);
			ExecutionLog.Log("Search for account and match the Result");

			
			// Check login Icon is not present for this account and if so then logged out from account
			accountsHelper.loginIconNotPresent();
			ExecutionLog.Log("Check login Icon is not present for this account");

			
			//Check success message that account has been logged out
			//headerHelper.checkSuccessMessage("You have been logged out of "+account+".");
			//ExecutionLog.Log("Check success message that account has been logged out");

			// Go to Accounts > All
			headerHelper.clickOnAccountAll();
			ExecutionLog.Log("Go to Accounts > All");

		// Search again same account 
			accountsHelper.accountsSearch(account);
			ExecutionLog.Log("Search for account and match the Result");

			// Check Login Icon should present and if so then click on it to login again
			accountsHelper.loginIconPresent();
			ExecutionLog.Log("Check Login Icon should present and if so then click on it to login again");

			// Clicking on login icon should display success message
			headerHelper.checkSuccessMessage("You are now logged into "+account+".");
			ExecutionLog.Log("Clicking on login icon should display success message");  

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
