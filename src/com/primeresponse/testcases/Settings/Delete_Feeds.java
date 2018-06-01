package com.primeresponse.testcases.Settings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Feeds extends DriverTestCase{
	
	@Test
	public void testDelete_Feeds() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());
		
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
			ExecutionLog.Log("Select Selenium Test Account if not selected");
						
			//Go to Settings >Feeds
			headerHelper.clickOnSettingsFeeds();
			ExecutionLog.Log("Go to Settings >Feeds");
			
			//Verify the process of deleting feeds on Settings >Feeds page
			settingHelper.delete_Feeds();
			ExecutionLog.Log("Verify the process of deleting feeds on Settings >Feeds page");
			
			// Check success message
			headerHelper.checkSuccessMessage("Feed was successfully removed.");	
			ExecutionLog.Log("success message");
			
		}
		
	
		catch (Error e) {
			captureScreenshot("testDelete_Feeds");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_Feeds");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

