package com.primeresponse.testcases.Track;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_TrackCompetitiorsGoToSite extends DriverTestCase {
	
	@Test
	public void testVerify_TrackCompetitiorsGoToSite() throws Exception {

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
			//headerHelper.clickonTrackCompetitors();
			getWebDriver().navigate().to("https://app.prime-response.com/track/competitors");
			//ExecutionLog.Log("Go to Track > Competitors");
			
			
			//Verify the functionality of clicking go to site icon and should redirect to same domain under Track >Competitors latest reviews widget.
			trackHelper.verify_TrackCompetitiorsGoToSite();
			ExecutionLog.Log("Verify the functionality of clicking go to site icon and should redirect to same domain under Track >Competitors latest reviews widget.");
			

		}

		catch (Error e) {
			captureScreenshot("testVerify_TrackCompetitiorsGoToSite");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_TrackCompetitiorsGoToSite");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}


}
