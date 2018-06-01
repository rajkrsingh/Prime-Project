package com.primeresponse.testcases.Profile;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.ProfileHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_SiteDetails extends DriverTestCase{

	@Test
	public void testCheck_SiteDetails() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		ProfileHelper profileHelper = new ProfileHelper (getWebDriver());

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

			//Go to Profile > Site Detail
			
			//headerHelper.clickonProfileSiteDetail();
			getWebDriver().navigate().to(applicationUrl+"/track/site_detail");
			//ExecutionLog.Log("Go to Profile > Site Detail");
			
			//Check all site details available at Reputation > Profile > Site Detail page
			profileHelper.check_SiteDetails();
			ExecutionLog.Log("Check all site details available at Reputation > Profile > Site Detail page");

			

		}

		catch (Error e) {
			captureScreenshot("testCheck_SiteDetails");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_SiteDetails");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
