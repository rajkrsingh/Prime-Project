package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Notification extends DriverTestCase {
	
	@Test
	public void testCreateNotification() throws Exception {

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

			//login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");
						
			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");
			
			// Click on Admin > Notifications
			getWebDriver().navigate().to("https://app.prime-response.com/admin/notifications");
			//headerHelper.clickOnAdminNotifications();
			//ExecutionLog.Log("Click on Admin > Notifications");
			
			// Verify process of creating new notification
			adminHelper.create_Notification();
			ExecutionLog.Log("Verify process of creating new notification");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Notification was successfully created.");	
			ExecutionLog.Log("success message");	
			
		}
        
		catch (Error e) {
			captureScreenshot("testCreateNotification");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreateNotification");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

