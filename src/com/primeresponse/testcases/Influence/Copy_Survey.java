package com.primeresponse.testcases.Influence;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Copy_Survey extends DriverTestCase {

	@Test
	public void testCopy_Survey() throws Exception {

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
			ExecutionLog.Log("Select Selenium Test account if not selected");
			
			// Go to Influence > Survey
			//headerHelper.clickonInfluenceSurvey();
			//ExecutionLog.Log("Go to Influence > Survey");
			getWebDriver().navigate().to("https://app.prime-response.com/influence/surveys");

			// Method to verify the functionality of copy surveys
			influenceHelper.copySurvey();
			ExecutionLog.Log("Verifying the functionality of copying surveys");

		}

		catch (Error e) {
			captureScreenshot("testCopy_Survey");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCopy_Survey");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
