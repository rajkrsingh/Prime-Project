package com.primeresponse.testcases.Settings;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_AlertSubscription extends DriverTestCase{
	
	@Test
	public void testCheck_AlertSubscription() throws Exception {
		
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
			
			// Go to Settings > Alert
			headerHelper.clickOnSettingsAlert();
			ExecutionLog.Log("Go to Settings > Alert ");
			
			//Verify current user is already subscribed and other can subscribe it
			settingHelper.verifySubscription();
			ExecutionLog.Log("Verify current user is already subscribed");
		}
		
		catch (Error e) {
			captureScreenshot("testCheck_AlertSubscription");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_AlertSubscription");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
				
	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
