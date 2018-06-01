package com.primeresponse.testcases.Accounts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Search_Account extends DriverTestCase{

	@Test
	public void testSearch_Account() throws Exception {

		// Initialize objects
		loginHelper = new LoginHelper(getWebDriver());
		headerHelper = new HeaderHelper(getWebDriver());
		AccountsHelper accountsHelper = new AccountsHelper(getWebDriver());

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

			// Select "Selenium Test" Account if its not selected
			selectAccount();
			ExecutionLog.Log("select Account if its not selected");

			// Open accounts 
			getWebDriver().navigate().to("https://app.prime-response.com/accounts?page=1");
			//headerHelper.randomClickOnAccountSubMenu();
			//ExecutionLog.Log("click on Accoutn list");
			
			//Random click on any page count
			accountsHelper.randomClickOnPageCount();
			ExecutionLog.Log("Random click on any page count");

			//Search for account and match the Result
			accountsHelper.accountsSearch("test");
			ExecutionLog.Log("Search for account and match the Result");
		}

		catch (Error e) {
			captureScreenshot("testSearch_Account");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testSearch_Account");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
