package com.primeresponse.testcases.Admin;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_ApplicationProductOnAccounts extends DriverTestCase{
	
	@Test
	public void testVerify_ApplicationProductOnAccounts() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
	    AdminHelper adminHelper = new AdminHelper(getWebDriver());
	    AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());
	    
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
			
			//Click on Admin > Application Products
			getWebDriver().navigate().to("https://app.prime-response.com/admin/application_products");
			//headerHelper.clickOnAdminApplicationProduct();
			//ExecutionLog.Log("Click on Admin > Application Products");
			
			
			//Verify total application product on Admin > Application products page.
			ArrayList<String> arr=adminHelper.verifyApplicationProductOnAdmin();
			ExecutionLog.Log("Verify total application product on Admin > Application products page.");
			
			// Go to Edit account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Go to Edit account");
			
			//Match Application Products on Account information page
			accountsHelper.matchApplicationProduct(arr);
			//ExecutionLog.Log("Match Application Products on Account information page");
			
		}
        
		catch (Error e) {
			captureScreenshot("testCreate_ApplicationProduct");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_ApplicationProduct");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
