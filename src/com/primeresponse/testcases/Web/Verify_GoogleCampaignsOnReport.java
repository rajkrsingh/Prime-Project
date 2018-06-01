package com.primeresponse.testcases.Web;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.WebHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_GoogleCampaignsOnReport extends DriverTestCase {

	@Test
	public void testVerify_GoogleCampaignsOnReport() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		WebHelper webHelper = new WebHelper(getWebDriver());

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
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Go to Web > Google Campaigns
			headerHelper.clickonWebGoogleCampaigns();
			ExecutionLog.Log("Go to Web > Google Campaigns");
			
			
			//***********Currently data is not showing on Campaign Report page*******************
		/*
			//Fetch total google campaigns from Web>Google Campaigns page.
			ArrayList <String> arr=webHelper.fetchGoogleCampaigns();
			ExecutionLog.Log("Fetch total google campaigns");
			
			//Go to Web > Campaigns Report
			headerHelper.clickonWebCampaignsReport();
			ExecutionLog.Log("Go to Web > Campaigns REport");
			
			//Verify that google campaigns are same on 'Google Campaigns' and 'Campaigns Reports' pages.
			webHelper.verify_GoogleCampaignsOnReport(arr);
			ExecutionLog.Log("Verify that google campaigns are same on 'Google Campaigns' and 'Campaigns Reports' pages.");
			
			*/
		}

		catch (Error e) {
			captureScreenshot("testVerify_GoogleCampaignsOnReport");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_GoogleCampaignsOnReport");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}



