package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_AccessKey extends DriverTestCase{

	@Test
	public void testCreate_AccessKey() throws Exception {

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
			
			//Click on Accounts->Access Keys
			headerHelper.clickOnAccessKeys();
			ExecutionLog.Log("Click on Accounts->Access Keys");
			
		    //Method to CREATE Access Keys
			String str = randomString(4);
			accountsHelper.createAccessKeys(str);
			ExecutionLog.Log("Method to Create Access Keys");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");	

			
		}


		catch (Error e) {
			captureScreenshot("testCreate_AccessKey");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_AccessKey");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}

