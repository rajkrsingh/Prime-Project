package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Verify_AccountOnOfficialProfile extends DriverTestCase {


	@Test
	public void testVerify_AccountOnOfficialProfile() throws Exception {

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
			
			//Click on logged in user edit link
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on logged in user edit link");

			//Go to Account > Official Profile
			//getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/official_profile");
			String str =headerHelper.clickOnAccountOfficialProfile();
			ExecutionLog.Log("Go to Account > Official Profile");
			
			//Verify current logged in account on official profile page
			accountsHelper.verify_AccountOnOfficialProfile(str);
			ExecutionLog.Log("Verify current logged in account on official profile page");
			
			//verify the success notification
			//headerHelper.checkSuccessMessage("Record was successfully created.");	
			//ExecutionLog.Log("success message");	

		}


		catch (Error e) {
			captureScreenshot("testVerify_AccountOnOfficialProfile");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_AccountOnOfficialProfile");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

