package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Add_Customer extends DriverTestCase {

	@Test
	public void testAdd_Customer() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		InfluenceHelper influenceHelper = new InfluenceHelper(getWebDriver());

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

			// Go to Influence > Customers
			headerHelper.clickonInfluenceCustomers();
			ExecutionLog.Log("Go to Ifluence > Customers");
			
			// Click on Create New Customer link
			influenceHelper.clickOnNewCustomer();
			ExecutionLog.Log("click on create new customer link");
			
			// Enter Details
			String append_str = randomString(3);
			influenceHelper.submitCustomerDetails("shishirj"+append_str+"@360logica.com", "Shishir");
			ExecutionLog.Log("Enter Customer Details");
			
			// Click on submit button
			influenceHelper.clickonSubmit();
			ExecutionLog.Log("Click on submit button ");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testAdd_Customer");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testAdd_Customer");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
