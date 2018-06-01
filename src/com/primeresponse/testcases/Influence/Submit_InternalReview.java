package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Submit_InternalReview extends DriverTestCase{
	
	@Test
	public void testSubmit_InternalReview() throws Exception {

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

			// Go to Influence > Survey
			headerHelper.clickonInfluenceSurvey();
			ExecutionLog.Log("Go to Ifluence > Survey");
			
			// open Pre-Survey Url of survey created via Webdriver scripts
			influenceHelper.getPreSurvey(applicationUrl);
			ExecutionLog.Log("open Pre-Survey Url of survey created via Webdriver scripts");
			
			// Enter Customer Details
			influenceHelper.enterCustomerDetails();
			ExecutionLog.Log("Enter Customer Details");
			
			// Fill the survey
			influenceHelper.fillSurvey();
			ExecutionLog.Log("Fill the survey");
			
			// Verify Thank you text
			influenceHelper.verifyThanksText();
			ExecutionLog.Log("Verify Thank you text");
		}

		catch (Error e) {
			captureScreenshot("testSubmit_InternalReview");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSubmit_InternalReview");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
