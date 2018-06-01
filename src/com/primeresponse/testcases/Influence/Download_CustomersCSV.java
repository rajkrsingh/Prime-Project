 package com.primeresponse.testcases.Influence;
import org.openqa.selenium.Alert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.InfluenceHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;


public class Download_CustomersCSV extends DriverTestCase {

	@Test
	public void testDownload_CustomersCSV() throws Exception {

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
			ExecutionLog.Log("Select Selenium Test Account if not selected");

			// Go to Influence > Customers
			headerHelper.clickonInfluenceCustomers();
			ExecutionLog.Log("Go to Ifluence > Customers");
			
			//Method to download customers in .CSV file
			String path = getPathUpload();
			influenceHelper.downloadCustomersCSV(path);
			ExecutionLog.Log("Method to download customers in .CSV file");
			
		}

		catch (Error e) {
			captureScreenshot("testDownload_CustomersCSV");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testDownload_CustomersCSV");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}

	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}

}

