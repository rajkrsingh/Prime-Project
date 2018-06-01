package com.primeresponse.testcases.Training;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrainingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Pdf_DownloadRecommendedGuideLine extends DriverTestCase {

	@Test
	public void testPdf_DownloadRecommendedGuideLine() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		TrainingHelper trainingHelper = new TrainingHelper(getWebDriver());

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

			//Go to Training page
			headerHelper.clickOnTraining();
			ExecutionLog.Log("Go to Training page");
			
			// Now page is open in same window instead of new window so commenting method for now
			
			//Verify process of downloading recommended guide line 
			trainingHelper.pdf_DownloadRecommendedGuideLine();
			//ExecutionLog.Log("Verify process of downloading recommended guide line ");
		
		}

		catch (Error e) {
			captureScreenshot("testPdf_DownloadRecommendedGuideLine");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testPdf_DownloadRecommendedGuideLine");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


