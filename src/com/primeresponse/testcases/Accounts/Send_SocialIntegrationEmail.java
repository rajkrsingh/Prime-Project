package com.primeresponse.testcases.Accounts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Send_SocialIntegrationEmail extends DriverTestCase {
	@Test
	public void testSend_SocialIntegrationEmail() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());

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

			// Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on logged in account edit icon
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on logged in account edit icon");
			
			//Click on Accounts->Users
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/accounts_users");
			//headerHelper.clickOnUsers();
			//ExecutionLog.Log("Click on Accounts->Users");
			
			//Method to Send Social Integration
			accountsHelper.sendSocialIntegration(userEmail);
			ExecutionLog.Log("Method to Send Social Integration");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Email successfully sent to "+userEmail+" for social integration.");	
			ExecutionLog.Log("success message");	

      }
		
		catch (Error e) {
			captureScreenshot("testSend_SocialIntegrationEmail");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSend_SocialIntegrationEmail");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}


