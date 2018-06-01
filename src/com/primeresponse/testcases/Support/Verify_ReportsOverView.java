package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_ReportsOverView extends DriverTestCase {

	@Test
	public void testVerify_ReportsOverView() throws Exception {

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

			// Go to Support > Reports
			getWebDriver().navigate().to("https://app.prime-response.com/support/reports");
			//headerHelper.clickonSupportReports();
			//ExecutionLog.Log(" Go to Support > Reports");
			
			// Verify review by site,monthly activity and suggestion on 'Response Overview' page.
			supportHelper.verify_ReportsOverView();
			ExecutionLog.Log("Verify review by site,monthly activity and suggestion on 'Response Overview' page.");
			
			
		}

		catch (Error e) {
			captureScreenshot("testVerify_ReportsOverView");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Report");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

