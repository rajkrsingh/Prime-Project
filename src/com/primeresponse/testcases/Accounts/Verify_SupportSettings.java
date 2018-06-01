package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Verify_SupportSettings extends DriverTestCase{

	@Test
	public void testVerify_SupportSettings() throws Exception {

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

			//Click on logged in user edit link
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on logged in user edit link");
			
			//Click on Accounts->Support Settings
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/support_settings");
			//headerHelper.clickOnSupportSettings();
			//ExecutionLog.Log("Click on Accounts->Support Settings");
			
		    //Verify that support settings is successfully updated
			accountsHelper.verify_SupportSettings();
			ExecutionLog.Log("Verify that support settings is successfully updated");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully updated.");	
			ExecutionLog.Log("success message");	

			
		}


		catch (Error e) {
			captureScreenshot("testVerify_SupportSettings");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_SupportSettings");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}



