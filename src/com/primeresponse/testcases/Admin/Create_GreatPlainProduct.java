package com.primeresponse.testcases.Admin;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_GreatPlainProduct extends DriverTestCase {
	@Test
	public void testCreate_GreatPlainProduct() throws Exception {

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
			
			//Method to create Great Plains Products from Admin menu
			String str = randomString(4);
			String str1=adminHelper.adminCreateGreatPlainsProducts(str);
			ExecutionLog.Log("Method to create Great Plains Products from Admin menu");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");
					
			//Click on edit icon of logged account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Click on edit icon of logged account");
			
			//Click on Accounts->Great Plains Contracts
			 getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/great_plains_contracts");
			//headerHelper.clickOnGreatPlainsContracts();
			//ExecutionLog.Log("Click on Accounts->Great Plains Contracts");
			
			//Method to create Great Plains Contracts from Accounts menu
			String str2 = randomString(4);
			accountsHelper.accountsCreateGreatPlainsContracts(str1,str2);
			ExecutionLog.Log("Method to create Great Plains Contracts from Accounts menu");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");	

		}

		catch (Error e) {
			captureScreenshot("testCreate_GreatPlainProduct");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_GreatPlainProduct");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}
