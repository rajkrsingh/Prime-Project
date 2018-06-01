package com.primeresponse.testcases.Social;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.ExecutionLog;

public class Add_Content extends DriverTestCase {
	
	@Test
	public void testAdd_Content() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SocialHelper socialHelper = new SocialHelper(getWebDriver());
		
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
			
			// Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");
			
			// Click on Add Content button
			socialHelper.clickOnAddContent();
			ExecutionLog.Log("Click on Add Content button");
			
			// Check visibility of content popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of content popup");
			
			// Check Title of add content popup
			socialHelper.checkTitle("Add Content");
			ExecutionLog.Log("Check Title of add content popup");
			
			// Enter details and submit content
			String path = getPathUpload();
			socialHelper.submitContent(path);
			ExecutionLog.Log("Enter details and submit content");
			
			// Check success message
			headerHelper.checkSuccessMessage("New content has been added to library.");	
			ExecutionLog.Log("success message");
			
		}
		catch (Error e) {
			captureScreenshot("testAdd_Content");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testAdd_Content");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
