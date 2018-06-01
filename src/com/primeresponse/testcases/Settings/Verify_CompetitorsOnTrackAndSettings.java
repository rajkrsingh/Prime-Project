package com.primeresponse.testcases.Settings;

import java.util.ArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.pagehelper.SettingHelper;
import com.primeresponse.pagehelper.TrackHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_CompetitorsOnTrackAndSettings extends DriverTestCase {

	@Test
	public void testVerify_CompetitorsOnTrackAndSettings() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		SettingHelper settingHelper = new SettingHelper(getWebDriver());
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

			// Go to Settings > Competitors 
			headerHelper.clickonSettingsCompetitors();
			ExecutionLog.Log("Go to Settings > Competitors ");

			//Fetch details of Competitors
			ArrayList<String> arr=settingHelper.fetchCompetitor();
			ExecutionLog.Log("Fetch details of Competitors");

			// Go to Track > Competitors
			//headerHelper.clickonTrackCompetitors();
			getWebDriver().navigate().to("https://app.prime-response.com/track/competitors");
			
			//Verify that same competitors are showing on 'Track >Competitors' and 'Settings >Competitors' page.Also logged in account is showing  in competitors list on 'Track >Competitors' page.
			trackHelper.verify_CompetitorsOnTrackAndSettings(arr);
			ExecutionLog.Log("Verify that same competitors are showing on 'Track >Competitors' and 'Settings >Competitors' page.");
            
		}
		catch (Error e) {
			captureScreenshot("testVerify_CompetitorsOnTrackAndSettings");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_CompetitorsOnTrackAndSettings");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}


	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
