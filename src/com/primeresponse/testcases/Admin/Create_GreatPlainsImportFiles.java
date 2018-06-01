package com.primeresponse.testcases.Admin;

import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_GreatPlainsImportFiles extends DriverTestCase {
	@Test
	public void testCreate_GreatPlainsImportFiles() throws Exception {

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

			//Select Selenium Test Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			//Click on Admin->Great Plains Imports Files
			getWebDriver().navigate().to("https://app.prime-response.com/admin/great_plains_import_files");
			//headerHelper.clickOnAdminGreatPlainsImport();
			//ExecutionLog.Log("Click on Admin->Great Plains Products");
			
			//Verify process of creating Great Plains Import Files
			String path = getPathUpload();
			String append_str = randomString(3);

			adminHelper.create_GreatPlainsImportFiles(path, append_str);
			ExecutionLog.Log("Verify process of creating Great Plains Import Files");
			
						
		}

		catch (Error e) {
			captureScreenshot("Create_GreatPlainsImportFiles");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_GreatPlainsImportFiles");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}

