package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Category  extends DriverTestCase{
	

	@Test
	public void testCreate_Category() throws Exception {

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
			
			//Click on Admin > Categories
			getWebDriver().navigate().to("https://app.prime-response.com/admin/categories");
			//headerHelper.clickOnAdminCategories();
			//ExecutionLog.Log("Click on Admin > Categories");
			
			// Submit Category details and create it
			String str = randomString(3);
			String path = getPathUpload();
			adminHelper.submitCategoryDetails(str, path);
			ExecutionLog.Log("Submit Category details and create it");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Category was successfully created.");	
			ExecutionLog.Log("success message");	

			// Go to Social > Content
			headerHelper.clickonSocialContent();
			ExecutionLog.Log("Go to Social > Content");
			
			// Verify created category thumbnail details
			adminHelper.verifyCategoryThumbnail();
			ExecutionLog.Log("Verify created category thumbnail");

		}
        
		catch (Error e) {
			captureScreenshot("testCreate_Category");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Category");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
