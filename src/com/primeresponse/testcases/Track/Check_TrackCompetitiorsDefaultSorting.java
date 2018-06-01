package com.primeresponse.testcases.Track;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Check_TrackCompetitiorsDefaultSorting extends DriverTestCase {
	
	@Test
	public void testCheck_TrackCompetitiorsDefaultSorting() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		TrackHelper trackHelper = new TrackHelper(getWebDriver());

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
			
			// Go to Track > Competitors
			headerHelper.clickonTrackCompetitors();
			ExecutionLog.Log("Go to Track > Competitors");
			
			//Verify default sorting of published date under Track >Competitors latest reviews widget
			trackHelper.checkTrackCompetitiorsDefaultSorting();
			ExecutionLog.Log("Verify default sorting of published date under Track >Competitors latest reviews widget");
			

			

		}

		catch (Error e) {
			captureScreenshot("testCheck_TrackCompetitiorsDefaultSorting");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCheck_TrackCompetitiorsDefaultSorting");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
