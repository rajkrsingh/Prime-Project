package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_WhiteLabel extends DriverTestCase {
	
	@Test
	public void testCreate_WhiteLabel() throws Exception {

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
			
			// Click on Admin > White Labels 
			getWebDriver().navigate().to("https://app.prime-response.com/admin/white_labels");
			//headerHelper.clickOnAdminWhiteLabels();
			//ExecutionLog.Log("Click on Admin > White Labels");
			
			// Submit white label details and create it
			String str = randomString(3);
			String path = getPathUpload();
			adminHelper.submitWhiteLabelDetails(str, path);
			ExecutionLog.Log("Submit white label details and create it");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("White label was successfully created.");	
			ExecutionLog.Log("success message");	
		
			// Go to Admin > User
			getWebDriver().navigate().to("https://app.prime-response.com/admin/users");
			//headerHelper.clickonAdminUsers();
			//ExecutionLog.Log("Click on Admin-> Users");
			
			// Search for shishir user
			adminHelper.searchUser("Shishir");
			ExecutionLog.Log("Search for shishir users");
			
			// Edit user and apply white label to this user
			adminHelper.assignWhiteLable();
			ExecutionLog.Log("Edit user and apply white label to this user");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("User was successfully updated.");	
			ExecutionLog.Log("success message");
			
			// Verify logo displayed current assigned white label
			boolean x = adminHelper.checkLogo();
			if (x== true)
			{
			ExecutionLog.Log("logo does not displaye current assigned white label");
			}
		}
        
		catch (Error e) {
			captureScreenshot("testCreate_WhiteLabel");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_WhiteLabel");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
