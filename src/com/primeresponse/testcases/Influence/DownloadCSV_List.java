package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class DownloadCSV_List extends DriverTestCase {

	@Test
	public void testDownloadCSV_List() throws Exception {

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
			//influenceHelper.clickOnNewList();
			//ExecutionLog.Log("click on create new list link");
			getWebDriver().navigate().to("https://app.prime-response.com/influence/lists");

			//Verify that list is downloading in CSV file.
			String path = getPathUpload();
			System.out.println( "path "+path);
			influenceHelper.downloadCSV_List(path);
			ExecutionLog.Log("Verify that list is downloading in CSV file.");

			
			
		}

		catch (Error e) {
			captureScreenshot("testDownloadCSV_List");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDownloadCSV_List");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}

