package com.primeresponse.testcases.Social;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.ExecutionLog;

public class Check_FilterResult extends DriverTestCase {

	@Test
	public void testCheck_FilterResult() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SocialHelper socialHelper = new SocialHelper(getWebDriver());

		ExecutionLog.LogAddClass(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			//Open application
			getWebDriver().navigate().to(applicationUrl);
			ExecutionLog.Log("open application giturl");

			//login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");

			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");

			//Method to verify result after applying filter at social content screen
			socialHelper.check_FilterResults();
			ExecutionLog.Log("Method to verify result after applying filter at social content screen");

		}
		catch (Error e) {
			captureScreenshot("testCheck_FilterResult");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_FilterResult");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}


	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
