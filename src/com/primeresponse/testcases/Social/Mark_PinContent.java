package com.primeresponse.testcases.Social;

import org.testng.annotations.Test;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Mark_PinContent extends DriverTestCase{

	@Test
	public void testMark_PinContent() throws Exception {

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

			//*******Currently this feature is not showing on content page***************
			//Mark pin content on top of the feed
			//socialHelper.mark_PinContent();
			//ExecutionLog.Log("Mark pin content on top of the feed");

		}

		catch (Error e) {
			captureScreenshot("testMark_PinContent");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testMark_PinContent");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}



