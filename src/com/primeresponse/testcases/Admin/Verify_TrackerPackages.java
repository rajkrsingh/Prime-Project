package com.primeresponse.testcases.Admin;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.util.ExecutionLog;

public class Verify_TrackerPackages extends DriverTestCase{

	@Test
	public void testVerify_TrackerPackages() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AdminHelper adminHelper = new AdminHelper(getWebDriver());
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
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");

			//Click on Admin->Tracker Package
			getWebDriver().navigate().to("https://app.prime-response.com/admin/tracker_packages");
			//headerHelper.clickOnAdminTrackerPackage();
			//ExecutionLog.Log("Admin->Tracker Package");
			
			//Fetch Tracker Packages from Admin >Tracker Packages
			ArrayList <String> arr=adminHelper.verify_TrackerPackages();
			ExecutionLog.Log("Fetch Tracker Packages from Admin >Tracker Packages");
  
					
			//Click on 'Edit' link of logged in account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on 'Edit' link of logged in account");
			
			//Verify that same tracker packages are showing on Accounts and Admin sections.
			accountsHelper.verify_TrackerPackages(arr);
			ExecutionLog.Log("Verify that same tracker packages are showing on Accounts and Admin sections.");

		}

		catch (Error e) {
			captureScreenshot("testVerify_TrackerPackages");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_TrackerPackages");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}

