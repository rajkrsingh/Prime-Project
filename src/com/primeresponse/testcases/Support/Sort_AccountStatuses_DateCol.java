package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Sort_AccountStatuses_DateCol extends DriverTestCase  {

	@Test
	public void testSort_AccountStatuses_DateCol() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SupportHelper supportHelper = new SupportHelper(getWebDriver());

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

			//Go to Support > Account Statuses
			getWebDriver().navigate().to("https://app.prime-response.com/support/account_statuses");
			//headerHelper.clickOnAccountStatuses();
			//ExecutionLog.Log("Go to Support > Account Statuses");
			
			//Verify sorting functionality of date column on Support > Account Statuses page.
			supportHelper.sort_AccountStatuses_DateCol();
			ExecutionLog.Log("Verify sorting functionality of date column on Support > Account Statuses page.");
		
		}
		catch (Error e) {
			captureScreenshot("testSort_AccountStatuses_DateCol");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSort_AccountStatuses_DateCol");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}


