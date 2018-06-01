package com.primeresponse.testcases.Web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.WebHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_SearchEngineResultPage extends DriverTestCase {

	@Test
	public void testDelete_SearchEngineResultPage() throws Exception {

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

			//Go to Web > SERP Capture
			headerHelper.clickonWebSERP();
			ExecutionLog.Log("Go to Web > SERP Capture");
			
			//Method to delete 'Search Engine Result Page'
			webHelper.delete_SearchEngineResultPage();
			ExecutionLog.Log("Method to delete 'Search Engine Result Page'");
			
			// Check success message
			headerHelper.checkSuccessMessage("SERP was successfully removed.");	
			ExecutionLog.Log("success message");
						
		
		}

		catch (Error e) {
			captureScreenshot("testDelete_SearchEngineResultPage");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_SearchEngineResultPage");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
