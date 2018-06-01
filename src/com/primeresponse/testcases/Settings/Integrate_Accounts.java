package com.primeresponse.testcases.Settings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Integrate_Accounts extends DriverTestCase{

	@Test
	public void testIntegrate_Accounts() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());

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

			// Go to Settings > Social Integration
			headerHelper.clickOnSettingsSocialIntegration();
			ExecutionLog.Log("Go to Settings > Social Integration");

			//Integrate Accounts with FaceBook
			settingHelper.integrateFacebook();
			ExecutionLog.Log("Integrate Accounts with FaceBook");
			
			//verify the success notification for Facebook Integration
			headerHelper.checkSuccessMessage("Account was successfully integrated.");	
			ExecutionLog.Log("success message");	
			
			//Integrate Accounts with Twitter
			settingHelper.integrateTwitter();
			ExecutionLog.Log("Integrate Accounts with Twitter");
			
			//Verify the success notification for Twitter Integration
			headerHelper.checkSuccessMessage("Account was successfully integrated.");	
			ExecutionLog.Log("success message");
			
			//Integrate Accounts with YouTube
			settingHelper.integrateYouTube();
			ExecutionLog.Log("Integrate Accounts with YouTube");
			
			//Verify the success notification for YouTube Integration
			headerHelper.checkSuccessMessage("Account was successfully integrated.");	
			ExecutionLog.Log("success message");

		}
		catch (Error e) {
			captureScreenshot("testIntegrate_Accounts");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testIntegrate_Accounts");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}


	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
