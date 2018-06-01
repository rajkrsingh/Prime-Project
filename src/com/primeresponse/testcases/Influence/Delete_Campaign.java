package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Delete_Campaign extends DriverTestCase {
	
	@Test
	public void testDelete_Campaign() throws Exception {
		
		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		InfluenceHelper influenceHelper = new InfluenceHelper(getWebDriver());
		
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
			
			// Go to Influence > Campaigns
			headerHelper.clickonInfluenceCampaign();
			ExecutionLog.Log("Go to Ifluence > Campaigns");
			
			// Check if campaign status is sent then delete icon should not display else delete it
			headerHelper.delete("Test Campaign by Webdriver script execution", 9);
			ExecutionLog.Log("Check if campaign status is sent then delete icon should not display else delete it");
						
			}
					
			catch (Error e) {
				captureScreenshot("testDelete_Campaign");
				ExecutionLog.LogErrorMessage(e);
				throw e;
			} catch (Exception e) {
				captureScreenshot("testDelete_Campaign");
				ExecutionLog.LogExceptionMessage(e);
				throw e;
			}
				}
					
			@AfterMethod
			public void endMethods() throws Exception {
			ExecutionLog.LogEndClass(this.getClass().getName());
			}

}

