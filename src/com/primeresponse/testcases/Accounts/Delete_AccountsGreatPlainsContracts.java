package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Delete_AccountsGreatPlainsContracts extends DriverTestCase{

	@Test
	public void testDelete_AccountsGreatPlainsContracts() throws Exception {

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
			
			//Click on Accounts->Great Plains Contracts
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/great_plains_contracts");
			//headerHelper.clickOnGreatPlainsContracts();
			//ExecutionLog.Log("Click on Accounts->Great Plains Contracts");
			
		    //Method to DELETE Great Plains Contracts
			accountsHelper.delete_AccountsGreatPlainsContracts();
			ExecutionLog.Log("Method to DELETE Great Plains Contracts");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully removed.");	
			ExecutionLog.Log("success message");	

			
		}


		catch (Error e) {
			captureScreenshot("testDelete_AccountsGreatPlainsContracts");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_AccountsGreatPlainsContracts");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}


