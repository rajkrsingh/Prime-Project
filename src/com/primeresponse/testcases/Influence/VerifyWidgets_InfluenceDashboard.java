package com.primeresponse.testcases.Influence;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class VerifyWidgets_InfluenceDashboard extends DriverTestCase {

	@Test
	public void testVerifyWidgets_InfluenceDashboard() throws Exception {

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
			headerHelper.clickonInfluenceSurvey();
			ExecutionLog.Log("Go to Influence > Survey");

			//Get Surveys count on Survey page
			int count= influenceHelper.getSurveyCount();
			ExecutionLog.Log("Get Surveys count on Survey page");

			//Go to Influence > Dashboard
			headerHelper.clickonInfluenceDashboard();
			ExecutionLog.Log("Go to Influence > Dashboard");

			//Method to verify the name of all available widgets on influence dashboard page
			influenceHelper.verifyWidgetsInfluenceDashboard(count);
			ExecutionLog.Log("Method to verify the name of all available widgets on influence dashboard page");

		}

		catch (Error e) {
			captureScreenshot("testVerifyWidgets_InfluenceDashboard");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerifyWidgets_InfluenceDashboard");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}

