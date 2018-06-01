package com.primeresponse.testcases.Settings;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Create_NewDigestSubscription extends DriverTestCase{
	
	@Test
	public void testCreate_NewDigestSubscription() throws Exception {
		
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
			
			//Go to Settings >Digest
			headerHelper.clickOnSettingsDigests();
			ExecutionLog.Log("Go to Settings >Digest");
			
			//Method to create new digest subscription
			String str=randomString(4);
			settingHelper.createNewDigestSubscription(str);
			ExecutionLog.Log("Method to create new digest subscription");
			
			//verify the success notification
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("success message");	
			
		}
		catch (Error e) {
			captureScreenshot("testCreate_NewDigestSubscription");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_NewDigestSubscription");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}