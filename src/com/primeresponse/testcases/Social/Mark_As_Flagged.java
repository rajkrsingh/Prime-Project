package com.primeresponse.testcases.Social;

import org.testng.annotations.Test;

import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Mark_As_Flagged extends DriverTestCase{

	@Test
	public void testMark_As_Flagged() throws Exception {

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

			//login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");

			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");

			// Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");

			// Method to mark Content as Flagged
			socialHelper.markContentFlagged();
			ExecutionLog.Log("Method to mark Content as Flagged");


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
}

