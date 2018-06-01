package com.primeresponse.testcases.Accounts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SocialHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_TimeZone extends DriverTestCase{
	

	@Test
	public void testVerify_TimeZone() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
	    AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());
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
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on edit icon of logged in user
			headerHelper.clickOnEditIconOfLoggedInUser();
			ExecutionLog.Log("Click on edit icon of logged in user");
			
			//Method to fetch timezone from user information page
			 String timezone=accountsHelper.fetchTimeZone();
			 ExecutionLog.Log("Method to fetch timezone from user information page");
			
			//Click on logged in user account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on logged in user account");
			
			//Method to fetch State from Account Information
			String state=accountsHelper.fetchAccountInformation();
			ExecutionLog.Log("Method to fetch State from Account Information");
			System.out.println("State:"+state);
			
			// Go to Social > Posts
			headerHelper.clickonSocialPost();
			ExecutionLog.Log("Go to Social > Posts");
			
			//Method to verify TimeZone on Post page
			socialHelper.verifyTimeZone(timezone,state);
			ExecutionLog.Log("Method to verify TimeZone on Post page");
		
      }
		
		catch (Error e) {
			captureScreenshot("testVerify_TimeZone");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_TimeZone");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}

