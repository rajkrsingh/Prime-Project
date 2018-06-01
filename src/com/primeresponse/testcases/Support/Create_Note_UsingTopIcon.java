package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Note_UsingTopIcon extends DriverTestCase  {
	
	@Test
	public void testCreate_Note_UsingTopIcon() throws Exception {

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
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			// click on top icon to create support note
			headerHelper.clickOnNewNoteIcon();
			ExecutionLog.Log("click on top icon to create support note");
			
			// Enter Note details using top icon
			supportHelper.submitNoteDetailsUsingTopIcon();
			ExecutionLog.Log("Enter Note details using top icon");

			// Check success message
			//headerHelper.checkSuccessMessage("Note was successfully created");	
			//ExecutionLog.Log("success message");

		}
		catch (Error e) {
			captureScreenshot("testCreate_Note_UsingTopIcon");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Note_UsingTopIcon");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
