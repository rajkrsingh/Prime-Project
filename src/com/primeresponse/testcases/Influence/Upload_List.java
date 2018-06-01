package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Upload_List extends DriverTestCase {

	@Test
	public void testUpload_List() throws Exception {

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

			// Go to Influence > Lists
			headerHelper.clickonInfluenceLists();
			ExecutionLog.Log("Go to Ifluence > Lists");

			// Click on Create New List link
			influenceHelper.clickOnNewList();
			ExecutionLog.Log("click on create new list link");

			// Upload a CSV file as a list
			String path = getPathUpload();
			String append_str = randomString(3);
			influenceHelper.uploadList(path, append_str);
			ExecutionLog.Log("Upload a CSV file as a list");

			// verify the success notification
			headerHelper.checkSuccessMessage("List was successfully uploaded.");	
			ExecutionLog.Log("success message");
   
			// Read the column name from sheet and match it 
			influenceHelper.mapFileds();
			ExecutionLog.Log("Read the column name from sheet and match it");
		}

		catch (Error e) {
			captureScreenshot("testUpload_List");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testUpload_List");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
