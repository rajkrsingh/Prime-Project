package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_AbServiceAndIvmCvdInventory_NonUniqueKey extends DriverTestCase{

	@Test
	public void testVerifyAdminNotesOnPages() throws Exception {

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
			
			 
			//Click on Accounts >> Admin Settings
			 //headerHelper.clickOnAdminSettings();
			 //ExecutionLog.Log(" Click on Accounts >>Admin Settings");
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/admin_settings");
			
			 //Fetch 'AB Service CID' and 'Ivm cvd inventory dealer lot key' from Admin settings page.
			 accountsHelper.fetchAbServiceAndIvmCvd();
			 ExecutionLog.Log("Fetch 'AB Service CID' and 'Ivm cvd inventory dealer lot key' from Admin settings page.");
			
	}


		catch (Error e) {
			captureScreenshot("testVerifyAdminNotesOnPages");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerifyAdminNotesOnPages");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}