package com.primeresponse.testcases.Influence;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Survey extends DriverTestCase {

	@Test
	public void testCreate_Survey() throws Exception {

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

			// Go to Influence > Survey
			//headerHelper.clickonInfluenceSurvey();
			//ExecutionLog.Log("Go to Ifluence > Survey");
			getWebDriver().navigate().to("https://app.prime-response.com/influence/surveys");
			

			// Click on New Survey link
			influenceHelper.clickOnNewSurvey();
			ExecutionLog.Log("click on create new Survey link");

			// Enter Surveys Details
			String append_str = randomString(3);
			influenceHelper.submitDetails(append_str);
			ExecutionLog.Log("Enter Surveys Details");

			// verify the success notification
			headerHelper.checkSuccessMessage("Survey was successfully created. Now begin adding questions.");	
			ExecutionLog.Log("success message");

			// Verify the notification when no question provided
			influenceHelper.checkNoQuesMessage();
			ExecutionLog.Log("Verify the notification when no question provided");

			// Check visibility of question popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of question popup");

			// check message "Please begin by creating your first question."
			influenceHelper.checkFlashMessage("Please begin by creating your first question.");
			ExecutionLog.Log("Verify the notification when no question provided");

			// Add 5 Star question with Overall category 
			influenceHelper.addQuestion("5 Star", "Overall");
			ExecutionLog.Log("Add 5 Star question with Overall category ");

			// Check visibility of another question popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of another question popup");
			
			// Add Long Text question with Customer Service category 
			influenceHelper.addQuestion("Long Text", "Customer Service");
			ExecutionLog.Log("Add Long Text question with Customer Service category  ");
			
			// Check visibility of another question popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of another question popup");

			// Add Short Text question with Customer Service category 
			influenceHelper.addQuestion("Short Text", "Customer Service");
			ExecutionLog.Log("Add Short Text question with Customer Service category ");
			
			// Check visibility of another question popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of another question popup");
			
			// Add Single Select question with Customer Service category 
			influenceHelper.addQuestion("Single Select", "Customer Service");
			ExecutionLog.Log("Add Single Select question with Customer Service category ");
			
			// Check visibility of answer popup
			headerHelper.checkFacebox();
			ExecutionLog.Log("Check visibility of answer popup");
			
			// check message "Question was successfully created. Now add an answer."
			influenceHelper.checkFlashMessage("Question was successfully created. Now add an answer.");
			ExecutionLog.Log("check message Question was successfully created. Now add an answer.");
			
			// Add answer of Single Select Question 
			influenceHelper.addAnswer("Answer Added for single select");
			ExecutionLog.Log("Add answer of Single Select Question  ");
			
		}

		catch (Error e) {
			captureScreenshot("testCreate_Survey");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Survey");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}
