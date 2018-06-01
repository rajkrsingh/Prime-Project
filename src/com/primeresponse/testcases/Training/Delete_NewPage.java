package com.primeresponse.testcases.Training;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrainingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_NewPage extends DriverTestCase {

	@Test
	public void testDelete_NewPage() throws Exception {

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
			
			//Verify process of deleting already created new page on Training section
			trainingHelper.delete_NewPage();
			ExecutionLog.Log("Verify process of deleting already created new page on Training section");
			
			// Check success message
			headerHelper.checkSuccessMessage("Page was successfully removed.");	
			ExecutionLog.Log("success message");
						
		
		}

		catch (Error e) {
			captureScreenshot("testDelete_NewPage");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_NewPage");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}


