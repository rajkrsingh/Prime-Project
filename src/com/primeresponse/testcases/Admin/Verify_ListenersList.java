package com.primeresponse.testcases.Admin;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_ListenersList extends DriverTestCase {

	@Test
	public void testVerify_ListenersList() throws Exception {

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

			// login to the application
			login("Admin");
			ExecutionLog.Log("log-in into application");

			// Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");
			
			// Click on Admin > Listeners Package
			getWebDriver().navigate().to("https://app.prime-response.com/admin/listeners");
			//headerHelper.clickOnAdminListeners();
			//ExecutionLog.Log("Admin-> ListenersPackage");
			
			// Add all listeners available in Scraper, Api, Content, News tabs
			ArrayList <String> al = new ArrayList<String>();
			adminHelper.check_SubTabsListeners(al);
			ExecutionLog.Log("Add all listeners available in Scraper, Api, Content, News tabs");
			
			// Check all should present in All tabs
			adminHelper.match_AllListeners(al);
			ExecutionLog.Log("Add all listeners available in Scraper, Api, Content, News tabs");

		}

		catch (Error e) {
			captureScreenshot("testVerify_ListenersList");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_ListenersList");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
