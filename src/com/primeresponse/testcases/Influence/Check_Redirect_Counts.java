package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_Redirect_Counts extends DriverTestCase {
	
	@Test
	public void testCheck_Redirect_Counts() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		InfluenceHelper influenceHelper = new InfluenceHelper(getWebDriver());

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

			// Go to Influence > Redirects
			headerHelper.clickonInfluenceRedirects();
			ExecutionLog.Log("Go to Influence > Redirects");
			
			// Verify Redirect details which have been created in Add_Redirect scripts
			influenceHelper.verifyAddedRedirect("Test Redirect created by Webdriver script execution");
			ExecutionLog.Log("Verify Redirect details which have been created in Add_Redirect scripts");
			
			// Click on label 6 times
			influenceHelper.clickonLabel("Test Redirect created by Webdriver script execution");
			ExecutionLog.Log("Click on label 6 times");
			
			// Check total count should be equal to 6
			influenceHelper.checkCounts();
			ExecutionLog.Log("Check total count should be equal to 6");

		}

		catch (Error e) {
			captureScreenshot("testCheck_Redirect_Counts");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_Redirect_Counts");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
