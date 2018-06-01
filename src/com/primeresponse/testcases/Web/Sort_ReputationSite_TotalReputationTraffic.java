package com.primeresponse.testcases.Web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.WebHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Sort_ReputationSite_TotalReputationTraffic extends DriverTestCase {

	@Test
	public void testSort_ReputationSite_TotalReputationTraffic() throws Exception {

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

			// Go to Web > Referral Analysis
			headerHelper.clickOnWebReferralAnalysis();
			ExecutionLog.Log("Go to Web > Referral Analysis");
			
			//Verify sorting functionality of 'Total Reputation Traffic'
			webHelper.sort_ReputationSite_TotalReputationTraffic();
			ExecutionLog.Log("Verify sorting functionality of Total Reputation Traffic");
			
		
		}

		catch (Error e) {
			captureScreenshot("testSort_ReputationSite_TotalReputationTraffic");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSort_ReputationSite_TotalReputationTraffic");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


