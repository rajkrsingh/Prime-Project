package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_GroupOrAccount_List extends DriverTestCase {

	@Test
	public void testVerify_GroupOrAccount_List() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		EnterpriseHelper enterpriseHelper = new EnterpriseHelper(getWebDriver());

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

			// Go to Enterprise > Dashboard
			headerHelper.clickonEnterpriseDashboard();
			ExecutionLog.Log("Go to Enterprise > Dashboard");

			// Randomly select Group 
			enterpriseHelper.selectGroup();
			ExecutionLog.Log("Randomly select Group");

			// Click on Admin > Groups
			headerHelper.clickOnAdminGroups();
			ExecutionLog.Log("Click on Admin > Groups");

			// Store sub groups or accounts 
			enterpriseHelper.matchAccountsOrSubGrps();
			ExecutionLog.Log("Store sub groups or accounts");
			
		}

		catch (Error e) {
			captureScreenshot("testVerify_GroupOrAccount_List");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_GroupOrAccount_List");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
