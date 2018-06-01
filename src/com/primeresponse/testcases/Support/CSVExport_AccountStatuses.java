package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class CSVExport_AccountStatuses extends DriverTestCase {


	@Test
	public void testCSVExport_AccountStatuses() throws Exception {

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
			
			// Click on Support > Account Statuses 
			getWebDriver().navigate().to("https://app.prime-response.com/support/account_statuses");
			//headerHelper.clickOnAccountStatuses();
			//ExecutionLog.Log("Click on Support > Account Statuses ");

			// Verify that account statuses is successfully exported in CSV files
			String path = getPathUpload();
			supportHelper.csvExport_AccountStatuses(path);
			ExecutionLog.Log("Verify that account statuses is successfully exported in CSV files");

		}
		
		catch (Error e) {
			captureScreenshot("testCSVExport_AccountStatuses");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCSVExport_AccountStatuses");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


