package com.primeresponse.testcases.Enterprise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class SegmentationButtons extends DriverTestCase {

	@Test
	public void testSegmentationButtons() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		EnterpriseHelper enterpriseHelper = new EnterpriseHelper(getWebDriver());

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

			// Go to Enterprise > Dashboard
			headerHelper.clickonEnterpriseDashboard();
			ExecutionLog.Log("Go to Enterprise > Dashboard");

			// Check by default 30d is selected
			enterpriseHelper.checkDefaultSegment();
			ExecutionLog.Log(" Check by default 30d is selected");

			// Check total available segmentation buttons are 6
			enterpriseHelper.checkSegmentationButtonCount();
			ExecutionLog.Log(" Check total available segmentation buttons are 6");

			// Go to Enterprise > My Accounts
			headerHelper.clickonEnterpriseMyAccount();
			ExecutionLog.Log("Go to Enterprise > Dashboard");

			// Check by default 30d is selected
			enterpriseHelper.checkDefaultSegment();
			ExecutionLog.Log(" Check by default 30d is selected");

			// Check total available segmentation buttons are 6
			enterpriseHelper.checkSegmentationButtonCount();
			ExecutionLog.Log("Check total available segmentation buttons are 6");

			// Go to Track > Summary
			headerHelper.clickonTrackSummary();
			ExecutionLog.Log("Go to Track > Summary");

			// Check by default 365d is selected by default
			enterpriseHelper.checkDefaultSegment();
			ExecutionLog.Log(" Check by default 365d is selected");

			// Check total available segmentation buttons are 6
			enterpriseHelper.checkSegmentationButtonCount();
			ExecutionLog.Log("Check total available segmentation buttons are 6");
			
			// Go to Influence > Dashboard
			headerHelper.clickonInfluenceDashboard();
			ExecutionLog.Log("Go to Influence > Dashboard");
			
			// Check by default 90d is selected by default
			enterpriseHelper.checkDefaultSegment();
			ExecutionLog.Log(" Check by default 90d is selected");

			// Check total available segmentation buttons are 6
			enterpriseHelper.checkSegmentationButtonCount();
			ExecutionLog.Log("Check total available segmentation buttons are 6");

		}

		catch (Error e) {
			captureScreenshot("testSegmentationButtons");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSegmentationButtons");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
