package com.primeresponse.testcases.Admin;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;
import com.primeresponse.pagehelper.EnterpriseHelper;

public class Check_GroupHierarchy extends DriverTestCase{

	@Test
	public void testCheck_GroupHierarchy() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		EnterpriseHelper enterpriseHelper = new EnterpriseHelper(getWebDriver());

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

			//Select Selenium Test Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on Admin->Groups
			getWebDriver().navigate().to("https://app.prime-response.com/admin/groups");
			//headerHelper.clickOnAdminGroups();
			//ExecutionLog.Log("Click on Admin->Groups");

			//Method to check Group Hierarchy
			adminHelper.adminGroupHierarchy();
			ExecutionLog.Log("Method to check Group Hierarchy");

			// Go to Enterprise > Dashboard
			headerHelper.clickonEnterpriseDashboard();
			ExecutionLog.Log("Go to Enterprise > Dashboard");

			//Method to verify  Group Hierarchy on Dashboard page
			adminHelper.verifyGroupHierarchy();
			ExecutionLog.Log("Method to verify  Group Hierarchy on Dashboard page");

		}

		catch (Error e) {
			captureScreenshot("testAdd_Content");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testAdd_Content");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}

