package com.primeresponse.testcases.Support;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SupportHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Report extends DriverTestCase {

	@Test
	public void testCreate_Report() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SupportHelper supportHelper = new SupportHelper(getWebDriver());

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

			// Go to Support > Reports
			getWebDriver().navigate().to("https://app.prime-response.com/support/reports");
			//headerHelper.clickonSupportReports();
			//ExecutionLog.Log(" Go to Support > Reports");
			
			// Fill all details and create report
			String append_str1= randomString(5);
			supportHelper.createReport("Support", append_str1);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str2= randomString(5);
			supportHelper.createReport("Overall Status - PRIME", append_str2);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str3= randomString(5);
			supportHelper.createReport("PRIME - Review Recap", append_str3);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str4= randomString(5);
			supportHelper.createReport("Mercedes Benz", append_str4);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str5= randomString(5);
			supportHelper.createReport("Overall Status - Travel Media", append_str5);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str6= randomString(5);
			supportHelper.createReport("Milestone - Travel Media", append_str6);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str7= randomString(5);
			supportHelper.createReport("Social Audit", append_str7);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
			
			// Fill all details and create report
			String append_str8= randomString(5);
			supportHelper.createReport("Account Audit", append_str8);
			ExecutionLog.Log("Fill all details and create report");
			
			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created");	
			ExecutionLog.Log("success message");
		}

		catch (Error e) {
			captureScreenshot("testCreate_Report");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Report");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
