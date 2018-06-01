package com.primeresponse.testcases.Settings;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Manage_OffIntegratedAccounts extends DriverTestCase{

	@Test
	public void testManage_OffIntegratedAccounts() throws Exception {

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

			//login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");

			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select 'Selenium Test' Account if not selected");

			// Go to Settings > Social Integration
			headerHelper.clickOnSettingsSocialIntegration();
			ExecutionLog.Log("Go to Settings > Social Integration");
           /*
			//Method to OFF Integrated Accounts on Integration page
			settingHelper.integratedAccountsOff();
			ExecutionLog.Log("Method to OFF Integrated Accounts on Integration page");

			// Go to Social > Posts
			headerHelper.clickonSocialPost();
			ExecutionLog.Log("Go to Social > Posts");
        
			//Method to verify OFF pop up message on Post page
			//settingHelper.verifyOffPopUpMessagePost();
			//ExecutionLog.Log("Method to verify OFF pop up message on Post page");

			// Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");

			//Method to verify OFF pop up message on content page
			settingHelper.verifyOffPopUpMessageContent();
			ExecutionLog.Log("Method to verify OFF pop up message on content page");

			// Go to Track > External Feed
			headerHelper.clickonTrackExternalFeed();
			ExecutionLog.Log("Go to Track > External Feed");
			
			//Method to verify OFF pop up message on External Feed page
			settingHelper.verifyOffPopUpMessageOnExternal();
			ExecutionLog.Log("//Method to verify OFF pop up message on External Feed page");

			// Go to Track > Internal Feed
			headerHelper.clickonTrackInternalFeed();
			ExecutionLog.Log("Go to Track > Internal Feed");
			
			//Method to verify OFF pop up message on Internal Feed page
			settingHelper.verifyOffPopUpMessageOnInternal();
			ExecutionLog.Log("Method to verify OFF pop up message on Internal Feed page");

               */

		}

		catch (Error e) {
			captureScreenshot("testManage_OffIntegratedAccounts");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testManage_OffIntegratedAccounts");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}