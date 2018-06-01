package com.primeresponse.testcases.Enterprise;


import java.util.*;

import org.testng.Assert;
import org.testng.annotations.*;
import com.primeresponse.pagehelper.EnterpriseHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Verify_EnterpriseSummaryReviewsCount extends DriverTestCase  {

	@Test
	public void testVerify_EnterpriseSummaryReviewsCount() throws Exception {

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

			// Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selenium Test Ford Account if not selected");

			// Go to  Enterprise > Summary
			headerHelper.clickonEnterpriseSummary();
			ExecutionLog.Log("Go to  Enterprise > Summary");

			// Select Group
			enterpriseHelper.selectGroupAtEnterprise();
			ExecutionLog.Log("Select Group at external feed screen");

			// Add all listers into one array and count in to another array also total rating and total average
			ArrayList <String> al1 = new ArrayList <String>();
			ArrayList <String> al2 = new ArrayList <String>();
			int total_rating =0;
			double total_avg_rating =0;
			total_rating=enterpriseHelper.storeEnterpriseSummaryDetails(al1, al2, total_rating, total_avg_rating );
			System.out.println("toalt rating: "+total_rating);
			ExecutionLog.Log("Add all listers into one array and count in to another array also total rating and total average");
			System.out.println("al1" + al1 + "al2" + al2 + "total_rating:" + total_rating + "total_avg_rating:" + total_avg_rating);

			//Click on Admin > Groups
			headerHelper.clickOnAdminGroups();
			ExecutionLog.Log("Click on Admin > Groups");

			// Enter into the "Randy Test Group" and store all account in to array 
			ArrayList <String> al3 = new ArrayList <String>();
			enterpriseHelper.storeAccounts(al3);
			ExecutionLog.Log("Enter into the Randy Test Group and store all account in to array ");
			
			System.out.println(al3);

			//in for loop on that basis of array count call two functions
			ArrayList <String> al4 = new ArrayList <String>();
			ArrayList <String> al5 = new ArrayList <String>();
			ArrayList <Integer> al6 = new ArrayList <Integer>();
			ArrayList <Double> al7 = new ArrayList <Double>();
			for(int i =0; i<=(al3.size()-1); i++)
			{
				// Login in to each associated account one by one
				loginHelper.selectAccount(al3.get(i));

				// Go to Track > External Feed for each associated account
				headerHelper.clickonTrackSummary();
				ExecutionLog.Log("Go to Track > Summary");

				// Store Listeners name, review count, total review and total average review and match with Enterprise summary details for each associated accounts
				enterpriseHelper.storeTrackSummaryDetails(al4, al5, al6, al7);
			}

			// Match the details from Enterprise Summary screen to Track Summary Screen
			System.out.println("al4:" + al4 +"al5:" + al5 + "al6" + al6 + "al7" + al7);
			ArrayList<String> al8 = new ArrayList<String>(new HashSet<String>(al4));
			System.out.println("al8:" + al8);
			int sum =0;
			for (int i=0; i< al1.size(); i++)
			{
				Collections.sort(al1, String.CASE_INSENSITIVE_ORDER);
				Collections.sort(al8, String.CASE_INSENSITIVE_ORDER);
				assert(al1.get(i).equals(al8.get(i)));

			}
			for(int i=0; i< al6.size(); i++)
			{
				sum  = sum + al6.get(i); 	
			}
			System.out.println(total_rating + " " + sum);
			Assert.assertEquals(total_rating, sum);
		}

		catch (Error e) {
			captureScreenshot("testVerify_EnterpriseSummaryReviewsCount");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testVerify_EnterpriseSummaryReviewsCount");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());

	}

}
