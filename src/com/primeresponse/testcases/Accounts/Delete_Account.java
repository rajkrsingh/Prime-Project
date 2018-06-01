package com.primeresponse.testcases.Accounts;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Account extends DriverTestCase{

	@Test
	public void testDeleteAccount() throws Exception {

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
			
		    //Go to Account > All Screen
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts?page=1");
			//headerHelper.clickOnAccountAll();
			//ExecutionLog.Log("Go to Account > All Screen");
			
			// Search for account and delete it
			accountsHelper.deleteAccount("Test360");
			ExecutionLog.Log("Search for acocunt and delete it");
			
			// verify delete success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");
			
				     
		}
		
        
		catch (Error e) {
			captureScreenshot("testDeleteAccount");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDeleteAccount");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
