package com.primeresponse.testcases.Social;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_SocialDashboard extends DriverTestCase {

	@Test
	public void testVerify_SocialDashboard() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SocialHelper socialHelper = new SocialHelper(getWebDriver());
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

			//Method to verify Integrated Accounts are ON on Integrations page
			String arrvalue []=settingHelper.verifyIntegratedAccounts();
			ExecutionLog.Log("Method to verify Integrated Accounts are ON on Integrations page");

			// Go to Social > DashBoard
			headerHelper.clickOnSocialDashBoard();
			ExecutionLog.Log("Go to Social > DashBoard");

			//Method to verify Social DashBoard
			socialHelper.verifySocialDashBoard(arrvalue[1],arrvalue[2]);
			ExecutionLog.Log("Method to verify Social DashBoard");


		}

		catch (Error e) {
			captureScreenshot("testVerify_SocialDashboard");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_SocialDashboard");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
