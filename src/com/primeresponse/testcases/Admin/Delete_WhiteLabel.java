package com.primeresponse.testcases.Admin;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_WhiteLabel extends DriverTestCase  {

	@Test
	public void testDelete_WhiteLabel() throws Exception {

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

			// Click on Admin > White Labels
			getWebDriver().navigate().to("https://app.prime-response.com/admin/white_labels");
			//headerHelper.clickOnAdminWhiteLabels();
			//ExecutionLog.Log("Click on Admin > White Labels");
			
			// Delete white label
			adminHelper.deleteWhiteLabel("Test360 White Lable");
			ExecutionLog.Log("Delete white lable");

			//verify the success notification
			headerHelper.checkSuccessMessage("White label has been successfully removed.");	
			ExecutionLog.Log("success message");
			
			//Current logo should change in to default
			boolean x = adminHelper.checkLogo();
			if (x== false)
			{
			ExecutionLog.Log("logo does not change in to default");
			}
		}

		catch (Error e) {
			captureScreenshot("testDelete_WhiteLabel");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDelete_WhiteLabel");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
