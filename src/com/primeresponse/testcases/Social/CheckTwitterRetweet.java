package com.primeresponse.testcases.Social;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class CheckTwitterRetweet extends DriverTestCase {

	@Test
	public void testCheckTwitterRetweet() throws Exception {

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

			// Go to Social > Posts
			headerHelper.clickonSocialPost();
			ExecutionLog.Log("Go to Social > Posts");

			//Method to verify user should be able to retweet of integrated account
			String str= socialHelper.checkTwitterRetweet();
			System.out.println("STR value:::::"+str);
			ExecutionLog.Log("Method to verify user should be able to retweet of integarted account");			

			//Open twitter url
			getWebDriver().navigate().to("https://twitter.com/");
			ExecutionLog.Log("Open twitter url");

			//Login to the Twitter and verify retweet
			socialHelper.loginTwitter(str);
			ExecutionLog.Log("Login to the Twitter and verify retweet");

		}

		catch (Error e) {
			captureScreenshot("testCheckTwitterRetweet");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheckTwitterRetweet");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
