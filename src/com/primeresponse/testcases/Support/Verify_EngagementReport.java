package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_EngagementReport extends DriverTestCase {

	@Test
	public void testVerify_EngagementReport() throws Exception {

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

			//Click on Supports > Conversion Rates
			getWebDriver().navigate().to("https://app.prime-response.com/support/engagements?");
			//headerHelper.clickOnSupportEngagement();
			//ExecutionLog.Log("Click on support > Engagement");
			
			//Verify filter functionality of Engagement dashboard
			supportHelper.filter_Engagement();
			ExecutionLog.Log("Verify filter functionality of Engagement dashboard");

			//Verify engagement reports on engagement dashboard page.
			supportHelper.verify_EngagementReport();
			ExecutionLog.Log("Verify filter functionality of conversion rates by randomly selecting resolutions");
			
			
		}

		catch (Error e) {
			captureScreenshot("Verify_EngagementReport");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_EngagementReport");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}



