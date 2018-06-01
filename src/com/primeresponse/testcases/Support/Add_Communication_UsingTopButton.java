package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Add_Communication_UsingTopButton extends DriverTestCase {


	@Test
	public void testAdd_Communication_UsingTopButton() throws Exception {

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
			
			// Click on support note top icon
			 getWebDriver().navigate().to("https://app.prime-response.com/support/support_items");
			//headerHelper.clickOnSupportNoteIcon();
			//ExecutionLog.Log("Click on support note top icon");

			// Enter all details using top icon and submit it
			supportHelper.submitCommunicationDetailsUsingTopIcon();
			ExecutionLog.Log("Enter all details using top icon and submit it");

			// Check success message
			headerHelper.checkSuccessMessage("Communications support was successfully created");	
			ExecutionLog.Log("success message");

		}
		
		catch (Error e) {
			captureScreenshot("testAdd_Communication_UsingTopButton");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testAdd_Communication_UsingTopButton");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
