package com.primeresponse.testcases.Admin;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_User extends DriverTestCase{

	@Test
	public void testCreate_User() throws Exception {

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
			
			//Click on Admin->Users
			 getWebDriver().navigate().to("https://app.prime-response.com/admin/users");
			//headerHelper.clickonAdminUsers();
			//ExecutionLog.Log("Click on Admin-> Users");
			
			//Click on 'New User' link on Users page
			adminHelper.clickOnNewUser();
			ExecutionLog.Log("Click on 'New Users' link");
			
			//Fill all details on New User page and click on submit button
			String append_str = randomString(3);
			adminHelper.submitUserDetails("TestUser"+append_str+"@Webdriver.com");
			ExecutionLog.Log("Fill all details on New User page");
			
			// verify the success notification
			headerHelper.checkSuccessMessage("User was successfully created. An email was sent to the email address specified.");	
			ExecutionLog.Log("success message");

		  }
        
		catch (Error e) {
			captureScreenshot("testCreate_User");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_User");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
