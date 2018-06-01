package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Category extends DriverTestCase{
	
	@Test
	public void testDelete_Category() throws Exception {

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
			
			// Click on CategoryContent tab
			adminHelper.clickOnCategoryContent();
			ExecutionLog.Log("Click on CategoryContent tab");
			
			// Look for category and delete it
			adminHelper.deleteCategory("Test360 Category");
			ExecutionLog.Log("Look for category and delete it");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Category has been successfully removed.");	
			ExecutionLog.Log("success message");	
		}
        
		catch (Error e) {
			captureScreenshot("testDelete_Category");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_Category");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
