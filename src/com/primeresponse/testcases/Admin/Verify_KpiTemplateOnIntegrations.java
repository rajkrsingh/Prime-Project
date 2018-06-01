package com.primeresponse.testcases.Admin;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.AdminHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_KpiTemplateOnIntegrations extends DriverTestCase {
	
	@Test
	public void testVerify_KpiTemplateOnIntegrations() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
	    AdminHelper adminHelper = new AdminHelper(getWebDriver());
	    SettingHelper settingHelper = new SettingHelper(getWebDriver());
	    
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
			
			// Click on Admin > KPI template
			getWebDriver().navigate().to("https://app.prime-response.com/admin/kpi_templates");
			//headerHelper.clickOnAdminKpiTemplate();
			//ExecutionLog.Log("Click on Admin > KPI template");
			
			//Verify total KPI templates on Admin > KPI template page. 
			ArrayList<String> arr= adminHelper.verify_KpiTemplateOnIntegrations();
			ExecutionLog.Log("Verify process of creating KPI template");
			
			//Go to Settings > Social Integration
			headerHelper.clickOnSettingsSocialIntegration();
			ExecutionLog.Log("Go to Settings > Social Integration");
			
			//Verify KPI templates on Integrations page. 
			settingHelper.verify_KpiTemplateOnIntegrations(arr);
			ExecutionLog.Log("Verify process of creating KPI template");
			
			
		}
        
		catch (Error e) {
			captureScreenshot("testVerify_KpiTemplateOnIntegrations");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_KpiTemplateOnIntegrations");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

