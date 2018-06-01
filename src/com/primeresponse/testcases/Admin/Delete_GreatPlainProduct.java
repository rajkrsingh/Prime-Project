package com.primeresponse.testcases.Admin;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_GreatPlainProduct extends DriverTestCase {
	@Test
	public void testDelete_GreatPlainProduct() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());
		

		AdminHelper adminHelper = new AdminHelper(getWebDriver());

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

			//Select Selenium Test Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on Admin->Great Plains Products
			getWebDriver().navigate().to("https://app.prime-response.com/admin/great_plains_products");
			//headerHelper.clickOnAdminGreatPlainsContracts();
			//ExecutionLog.Log("Click on Admin->Great Plains Products");
			
			//Method to Delete Great Plains Products from Admin menu
			adminHelper.deleteAdminGreatPlainsProducts();
			ExecutionLog.Log("Method to Delete Great Plains Products from Admin menu");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");
			
			//Click on edit icon of logged in account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on edit icon of logged in account");
			
			//Click on Accounts->Great Plains Contracts
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/great_plains_contracts");
			//headerHelper.clickOnGreatPlainsContracts();
			//ExecutionLog.Log("Click on Accounts->Great Plains Contracts");
			
			//Method to delete Great Plains Contracts from Accounts menu
			accountsHelper.deleteAccountsGreatPlainsContracts();
			ExecutionLog.Log("Method to delete Great Plains Contracts from Accounts menu");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message"); 
		}

		catch (Error e) {
			captureScreenshot("testDelete_GreatPlainProduct");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_GreatPlainProduct");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}

	

