package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_ApplicationProduct extends DriverTestCase{
	
	@Test
	public void testCreate_ApplicationProduct() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
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
						
			//Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");
			
			//Click on Admin > Application Products
			getWebDriver().navigate().to("https://app.prime-response.com/admin/application_products");
			//headerHelper.clickOnAdminApplicationProduct();
			//ExecutionLog.Log("Click on Admin > Application Products");
			
			// Enter Details and create application product
			int rand_int = getRandomInteger(1, 9);
			String app_prod = "Test360 Appication Product "+randomString(3);
			adminHelper.submitAppProductDetails(app_prod, rand_int);
			ExecutionLog.Log("Click on Admin > Application Products");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Application Product was successfully created.");	
			ExecutionLog.Log("success message");	

			// Go to Edit account
			headerHelper.clickOnEditIconOfLoggedAccount();
			ExecutionLog.Log("Go to Edit account");
			
			// Assign the same product to account
			adminHelper.assignApplicationProduct(app_prod);
			ExecutionLog.Log("Assign the same product to account");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Account was successfully updated.");	
			ExecutionLog.Log("success message");
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
