package com.primeresponse.testcases.Social;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_DarkPost  extends DriverTestCase {
	
	@Test
	public void testCreate_SocialPost() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SocialHelper socialHelper = new SocialHelper(getWebDriver());
		
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
			
			// Go to Social > Posts
			headerHelper.clickonSocialPost();
			ExecutionLog.Log("Go to Social > Posts");
			
			// Click on Post button
			socialHelper.clickOnPost();
			ExecutionLog.Log("click on create social post button");
			
			// Check visibility of post popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of post popup");
			
			//Verify process to create dark post
			socialHelper.submitDarkPost("Test Title by Webdriver script execution", "Test Description - https://app.prime-response.com/social/accounts");
			ExecutionLog.Log("Verify process to create dark post");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");
			
		}
		
		catch (Error e) {
			captureScreenshot("testCreate_SocialPost");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_SocialPost");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
