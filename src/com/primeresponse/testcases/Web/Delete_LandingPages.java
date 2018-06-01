package com.primeresponse.testcases.Web;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.WebHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_LandingPages extends DriverTestCase {

	@Test
	public void testDelete_LandingPages() throws Exception {

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

			//Go to Web > Landing Pages
			headerHelper.clickonWebLandingPages();
			ExecutionLog.Log("Go to Web > Landing Pages");
			
			//Verify process to delete 'Landing Pages'
			webHelper.delete_LandingPages();
			ExecutionLog.Log("Verify process to delete 'Landing Pages");
			
			// Check success message
			headerHelper.checkSuccessMessage("The landing page was successfully removed.");	
			ExecutionLog.Log("success message");
						
		
		}

		catch (Error e) {
			captureScreenshot("testDelete_LandingPages");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_LandingPages");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}

