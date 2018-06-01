package com.primeresponse.testcases.Social;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_PinnedContentReport extends DriverTestCase {
	
	@Test
	public void testVerify_PinnedContentReport() throws Exception {

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

			//Go to Social > Pinned Content Report
			headerHelper.pinnedContentReport();
			ExecutionLog.Log("Go to Social > Pinned Content Report");

			
			//Verify details of Pinned Content Report on Social > Pinned Content Report page.
			socialHelper.verify_PinnedContentReport();
			ExecutionLog.Log("click on create social post button");

		
		}

		catch (Error e) {
			captureScreenshot("testVerify_PinnedContentReport");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_PinnedContentReport");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
