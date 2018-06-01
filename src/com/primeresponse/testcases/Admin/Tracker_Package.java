package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Tracker_Package extends DriverTestCase{

	@Test
	public void testTracker_Package() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AdminHelper adminHelper = new AdminHelper(getWebDriver());

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

			//Submit tracker package details
			String trackerpkg= "Test360" +randomString(4);
			adminHelper.submitTrackerPackageDetails(trackerpkg);
			ExecutionLog.Log("Submit tracker package details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Account was successfully updated.");	
			ExecutionLog.Log("success message");

			//Click on 'Edit' link of logged in account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on 'Edit' link of logged in account");

			//Select Tracker Package list
			adminHelper.selectTrackerPackage(trackerpkg);
			ExecutionLog.Log("Select Tracker Package list");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");

			// Go to Settings > Track Listeners
			headerHelper.clickOnSettingsTrackListeners();
			ExecutionLog.Log("Go to Settings > Track Listeners");

			// Check selected package listeners displayed at track listeners settings screen.
			adminHelper.checkTrackListeners();
			ExecutionLog.Log("Check selected package listeners displayed at track listeners settings screen.");
		}

		catch (Error e) {
			captureScreenshot("testTracker_Package");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testTracker_Package");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
