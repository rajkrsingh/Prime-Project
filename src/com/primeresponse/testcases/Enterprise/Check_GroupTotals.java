package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_GroupTotals extends DriverTestCase{

	@Test
	public void testCheck_GroupTotals() throws Exception {

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

			//login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");
						
			//Select Selenium Test Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");
			
			// Go to Enterprise > Dashboard
			headerHelper.clickonEnterpriseDashboard();
			ExecutionLog.Log("Go to Enterprise > Dashboard");
			
			//Method to check Group Total
			enterpriseHelper.checkGroupTotals();
			ExecutionLog.Log("Method to check Group Total");
		
		}
        
		catch (Error e) {
			captureScreenshot("testCheck_GroupTotals");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_GroupTotals");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}
 