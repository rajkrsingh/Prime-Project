package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Customers extends DriverTestCase {

	@Test
	public void testDelete_Customers() throws Exception {

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

			// Click to delete the Shishir details 
			influenceHelper.deleteCustomer("shishir");
			ExecutionLog.Log("Click to delete the Shishir details ");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");

			// Click to delete the Customer1 details
			influenceHelper.deleteCustomer("Test360");
			ExecutionLog.Log("Click to delete the Customer1 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");

			// Click to delete the Customer2 details
			influenceHelper.deleteCustomer("Test360.101");
			ExecutionLog.Log("Click to delete the Customer2 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");

			// Click to delete the Customer3 details
			influenceHelper.deleteCustomer("Test360.70");
			ExecutionLog.Log("Click to delete the Customer3 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");
			
			// Click to delete the Customer3 details
			influenceHelper.deleteCustomer("rajs");
			ExecutionLog.Log("Click to delete the Customer3 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");
			
			// Click to delete the Customer3 details
			influenceHelper.deleteCustomer("ashwanis");
			ExecutionLog.Log("Click to delete the Customer3 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");
			
			// Click to delete the Customer3 details
			influenceHelper.deleteCustomer("aalmeenk");
			ExecutionLog.Log("Click to delete the Customer3 details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");

		}

		catch (Error e) {
			captureScreenshot("testDelete_Customers");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_Customers");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
