package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Filter_ConversionRatesDrilldown extends DriverTestCase {

	@Test
	public void testFilter_ConversionRatesDrilldown() throws Exception {

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

			// Click on Supports > Conversion Rates
			getWebDriver().navigate().to("https://app.prime-response.com/support/conversions");
			//headerHelper.clickOnSupportConversionRates();
			//ExecutionLog.Log("Click on Supports > Conversion Rates");
			
			//Verify filter functionality of conversion rates by randomly selecting resolutions.
			supportHelper.filter_ConversionRatesDrilldown();
			ExecutionLog.Log("Verify filter functionality of conversion rates by randomly selecting resolutions");
			
			
		}

		catch (Error e) {
			captureScreenshot("testFilter_ConversionRatesDrilldown");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testFilter_ConversionRatesDrilldown");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

