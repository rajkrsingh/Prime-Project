package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class DownloadPdf_ResponsePenetrationDashboard extends DriverTestCase{

	@Test
	public void testDownloadPdf_ResponsePenetrationDashboard() throws Exception {

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

			//Go to Enterprise > ResponsePenetration
			headerHelper.clickonResponsePenetration();
			ExecutionLog.Log("Enterprise > ResponsePenetration");
			
			//Check downloading functionality of 'response penetration dashboard' in pdf format
			enterpriseHelper.downloadPdf_ResponsePenetrationDashboard();
			ExecutionLog.Log("Check downloading functionality of 'response penetration dashboard' in pdf format");
		

		}

		catch (Error e) {
			captureScreenshot("testDownloadPdf_ResponsePenetrationDashboard");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDownloadPdf_ResponsePenetrationDashboard");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
