package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class MainNav_MenuList extends DriverTestCase {
	
	@Test
	public void testMainNav_MenuList() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());

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
			
			// Verify Enterprise Sub-Menus 
			headerHelper.verifyEnterpriseSubMenus();
			ExecutionLog.Log("Verify Enterprise Sub-Menus");
			
			// Verify Accounts Sub-Menus
			headerHelper.verifyAccountsSubMenus();
			ExecutionLog.Log("Verify Accounts Sub-Menus");
			
			// Verify Reputation Sub-Menus
			headerHelper.verifyReputationSubMenus();
			ExecutionLog.Log("Verify Reputation Sub-Menus");
			
			// Verify Social Sub-Menus
			headerHelper.verifySocialSubMenus();
			ExecutionLog.Log("Verify Social Sub-Menus");
			
			// Verify Web Sub-Menus
			headerHelper.verifyWebSubMenus();
			ExecutionLog.Log("Verify Web Sub-Menus");
			
			// Verify Settings Sub-Menus
			headerHelper.verifySettingsSubMenus();
			ExecutionLog.Log("Verify Settings Sub-Menus");
			
			// Verify Support Sub-Menus
			headerHelper.verifySupportSubMenus();
			ExecutionLog.Log("Verify Support Sub-Menus");
			
			// Verify Training Sub-Menus
			headerHelper.verifyTrainingSubMenus();
			ExecutionLog.Log("Verify Training Sub-Menus");
			
			// Verify Admin Sub-Menus
			headerHelper.verifyAdminSubMenus();
			ExecutionLog.Log("Verify Admin Sub-Menus");
			
		}

		catch (Error e) {
			captureScreenshot("testMainNav_MenuList");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testMainNav_MenuList");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

	
}
