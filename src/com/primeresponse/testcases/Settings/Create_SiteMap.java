package com.primeresponse.testcases.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_SiteMap extends DriverTestCase{
	
	@Test
	public void testCreate_SiteMap() throws Exception {
		
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
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");
			
			//Go to Settings >SiteMap
			headerHelper.clickOnSettingsSiteMap();
			ExecutionLog.Log("Go to Settings >SiteMap");
			
			//Method to create SiteMap
			String str=randomString(4);
			settingHelper.createSiteMap(str);
			ExecutionLog.Log("Go to Settings >SiteMap");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");	
			
		}
		catch (Error e) {
			captureScreenshot("testCreate_SiteMap");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_SiteMap");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}