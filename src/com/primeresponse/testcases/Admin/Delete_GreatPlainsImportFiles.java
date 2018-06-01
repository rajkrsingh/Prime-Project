package com.primeresponse.testcases.Admin;

import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_GreatPlainsImportFiles extends DriverTestCase {
	@Test
	public void testDelete_GreatPlainsImportFiles() throws Exception {

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
			
			//Verify process of deleting Great Plains Import Files
			adminHelper.deleteAdminGreatPlainsImport();
			ExecutionLog.Log("Click on Admin->Great Plains Products");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record has been successfully removed.");	
			ExecutionLog.Log("success message");	

			
		}

		catch (Error e) {
			captureScreenshot("Delete_GreatPlainsImportFiles");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_GreatPlainsImportFiles");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
}

