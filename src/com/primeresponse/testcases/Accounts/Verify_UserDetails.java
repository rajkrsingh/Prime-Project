package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Verify_UserDetails extends DriverTestCase{
	private AdminHelper adminHelper;

	@Test
	public void testVerify_UserDetails() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		adminHelper = new AdminHelper(getWebDriver());
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
				
			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on logged in account edit icon
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on logged in account edit icon");
			
			//Click on Accounts->Users
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/accounts_users");
			//headerHelper.clickOnUsers();
			//ExecutionLog.Log("Click on Accounts->Users");
			
			//Method to verify user details 
			
			String []test=accountsHelper.verifyUserDetails();
			ExecutionLog.Log("Method to verify user details");
			
			//Click on Admin->Users
			getWebDriver().navigate().to("https://app.prime-response.com/admin/users");
			//headerHelper.clickonAdminUsers();
			//ExecutionLog.Log("Click on Admin->Users");
						
			//Search user on Admin's user page 
			adminHelper.searchUser(test[2]);
			ExecutionLog.Log("Search user on Admin's user page");
			
			//Verify Account's user information on Admin's users page
			adminHelper.verifyAdminUserDetails(test[0],test[1],test[2]);
			ExecutionLog.Log("Verify Account's user information on Admin's users page");
			

      }
		
		catch (Error e) {
			captureScreenshot("testVerify_UserDetails");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_UserDetails");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}

