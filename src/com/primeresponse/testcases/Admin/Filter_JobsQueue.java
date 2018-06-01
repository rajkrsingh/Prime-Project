package com.primeresponse.testcases.Admin;

import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Filter_JobsQueue extends DriverTestCase {
	@Test
	public void testFilter_JobsQueue() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
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

			//Click on Admin->Jobs
			getWebDriver().navigate().to("https://app.prime-response.com/admin/jobs");
			//headerHelper.clickOnAdminJobs();
			//ExecutionLog.Log("Click on Admin->Jobs");
			
			//Verify process of filtering Jobs queue
			adminHelper.filterJobsQueue();
			ExecutionLog.Log("Verify process of filtering Jobs queue");
			
			
			
		}

		catch (Error e) {
			captureScreenshot("testFilter_JobsQueue");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testFilter_JobsQueue");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}

