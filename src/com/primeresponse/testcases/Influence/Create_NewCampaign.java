package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_NewCampaign extends DriverTestCase {
	
	@Test
	public void testCreate_NewCampaign() throws Exception {
		
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
			//headerHelper.clickonInfluenceCampaign();
			//ExecutionLog.Log("Go to Ifluence > Campaigns");
			getWebDriver().navigate().to("https://app.prime-response.com/influence/campaigns");
			
			// Click on Create New Campaign link
			influenceHelper.clickOnNewCampaign();
			ExecutionLog.Log("click on create new campaign link");
			
			// Enter basic campaigns details
			String append_str = randomString(3);
			influenceHelper.submitBasicDetails(append_str);
			ExecutionLog.Log("Enter basic campaigns details");
			
			// Select a sender
			influenceHelper.selectSender();
			ExecutionLog.Log("Select a sender");
			
			// Select a recipients and verify preview list
			influenceHelper.submitRecipientsDetails();
 			ExecutionLog.Log("Select a recipients and verify preview list");
			
			// Schedule the campaigns
			influenceHelper.scheduleCampaign();
			ExecutionLog.Log("Schedule the campaigns");
			
			// Select Template
			influenceHelper.selectTemplate();
			ExecutionLog.Log("Select Template");
			
			//Enter campaign body content
			influenceHelper.submitBodyContent();
			ExecutionLog.Log("Enter campaign body contents");
			
//			// Review the campaign details and send it
//			influenceHelper.reviewDetails();
//			ExecutionLog.Log("Review the campaign details and send it");
			
			// Click on send button 
			influenceHelper.sendCampaign();
			ExecutionLog.Log("Click on send button");
			
			// verify the success notification
			headerHelper.checkSuccessMessage("Campaign has been queued to be sent!");	
			ExecutionLog.Log("success message");
			
			}
		
		catch (Error e) {
			captureScreenshot("testCreate_NewCampaign");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_NewCampaign");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
	}
	}
		
		@AfterMethod
		public void endMethods() throws Exception {
			ExecutionLog.LogEndClass(this.getClass().getName());
		}

}
