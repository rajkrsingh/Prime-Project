package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Vertical extends DriverTestCase{

	@Test
	public void testCreate_Vertical() throws Exception {

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

			//Click on Admin->Verticals
			getWebDriver().navigate().to("https://app.prime-response.com/admin/verticals");
			//headerHelper.clickOnAdminVerticals();
			//ExecutionLog.Log("Click on Admin->Verticals");

			//Submit Available List Column Details
			String str = randomString(4);
			adminHelper.submitAvailableListColumnDetails(str);
			ExecutionLog.Log("Submit Available List Column Details");

			//Submit Transaction Type Details
			adminHelper.submitTransactionTypeDetails(str);
			ExecutionLog.Log("Submit Transaction Type Details");

			//Submit products Details
			adminHelper.submitProductDetails(str);
			ExecutionLog.Log("Submit products Details");
			
			//Submit Marketing Product Details
			adminHelper.submitMarketingProductDetails(str);
			ExecutionLog.Log("Submit Marketing Product Details");
			
			//Submit Account Attributes Details
			adminHelper.submitAccountAttributesDetails(str);
			ExecutionLog.Log("Submit Account Attributes Details");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Vertical was successfully created.");	
			ExecutionLog.Log("success message");


		}

		catch (Error e) {
			captureScreenshot("testCreate_Vertical");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Vertical");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
