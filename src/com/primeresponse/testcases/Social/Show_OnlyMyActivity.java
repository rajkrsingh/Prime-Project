package com.primeresponse.testcases.Social;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Show_OnlyMyActivity extends DriverTestCase{

	@Test
	public void testShow_OnlyMyActivity() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());
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
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			// Go to Settings > Social Integration
			headerHelper.clickOnSettingsSocialIntegration();
			ExecutionLog.Log("Go to Settings > Social Integration");
			
			//Method to verify Integrated Accounts are ON on Integrations page
			 String arrvalue []=settingHelper.verifyIntegratedAccountsON();
			 ExecutionLog.Log("Method to verify Integrated Accounts are ON on Integrations page");
			 
			// Go to Social > Posts
			headerHelper.clickonSocialPost();
			ExecutionLog.Log("Go to Social > Posts");
			
			//Verify my activity on social post screen
			socialHelper.showOnlyMyActivity(arrvalue[1],arrvalue[2],arrvalue[3],arrvalue[4]);
			ExecutionLog.Log("Verify my activity on social post screen");
			
		}
		catch (Error e) {
			captureScreenshot("testShow_OnlyMyActivity");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testShow_OnlyMyActivity");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}


	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}

