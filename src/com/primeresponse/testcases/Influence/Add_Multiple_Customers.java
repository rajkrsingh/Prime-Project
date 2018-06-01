package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Add_Multiple_Customers extends DriverTestCase {

	@Test
	public void testAdd_Multiple_Customers() throws Exception {

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
			//headerHelper.clickonInfluenceCustomers();
			//ExecutionLog.Log("Go to Influence > Customers");
			getWebDriver().navigate().to("https://app.prime-response.com/influence/customers");

			// Click on Add Multiple Customers link
			influenceHelper.clickOnAddMultipleCustomer();
			ExecutionLog.Log("Click on Add Multiple Customers link");

			// Enter Customer1 Details
			String append_str1 = randomString(3);
			influenceHelper.submitCustomerDetails("Test360.15"+append_str1+"@gmail.com", "Test360");
			ExecutionLog.Log("Enter Customer1 Details");

			// Click on submit button
			influenceHelper.clickonSubmit();
			ExecutionLog.Log("Click on submit button ");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");

			// Enter Customer2 Details
			String append_str2 = randomString(3);
			influenceHelper.submitCustomerDetails("Test360.101"+append_str2+"@gmail.com", "Test101");
			ExecutionLog.Log("Enter Customer2 Details");

			// Click on submit button
			influenceHelper.clickonSubmit();
			ExecutionLog.Log("Click on submit button ");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");

			// Enter Customer3 Details
			String append_str3 = randomString(3);
			influenceHelper.submitCustomerDetails("Test360.70"+append_str3+"@gmail.com", "Test70");
			ExecutionLog.Log("Enter Customer3 Details");

			// Click on submit button
			influenceHelper.clickonSubmit();
			ExecutionLog.Log("Click on submit button ");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testAdd_Multiple_Customers");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testAdd_Multiple_Customers");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
