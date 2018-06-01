package com.primeresponse.testcases.Accounts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.primeresponse.pagehelper.AccountsHelper;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;
import com.primeresponse.util.DriverTestCase;
import com.primeresponse.util.ExecutionLog;

public class Create_Account extends DriverTestCase{

	@Test
	public void testCreate_Account() throws Exception {

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

			// Select "Selenium Test" Account if not selected
			selectAccount();
			ExecutionLog.Log("Select Selemium Test Account if not selected");

			// Open Random accounts 
			getWebDriver().navigate().to("https://app.prime-response.com/accounts?page=1");
			//headerHelper.randomClickOnAccountSubMenu();
			//ExecutionLog.Log("Randomly click on Accoutn list");

			//Click on 'New Account'navigation link and verify 'Account Information' element is present on Account Information page
			accountsHelper.createAccount();
			ExecutionLog.Log("Click on 'New Account'navigation link and verify 'Account Information' element is present on Account Information page");

			//Submit Accounts details
			String str = randomString(3);
			accountsHelper.submitAccountDetails("Test360"+str);
			ExecutionLog.Log("Fill all details on Account Information page");

			// Check success message
			headerHelper.checkSuccessMessage("Account was successfully created.");	
			ExecutionLog.Log("Account creation success message");

			//Check Accounts Menu List after Accounts Created 
			accountsHelper.checkAccountsMenuEnable();
			ExecutionLog.Log("Check Accounts Menu List after Accounts Created ");

			// Go to Official Profile
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/official_profile");
			//headerHelper.clickOnOfficialProfile();
			//ExecutionLog.Log("Go to Official Profile");

			//Submit Official Profile Details
			accountsHelper.submitOfficialProfileDetails();
			ExecutionLog.Log("Submit Official Profile Details");

			// Check success message
			headerHelper.checkSuccessMessage("Account was successfully updated.");	
			ExecutionLog.Log("Official Profile updating success message");

			// Go to Users
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/accounts_users");
			//headerHelper.clickOnUsers();
			//ExecutionLog.Log("Go to Users");

			//Verify logged in email with Profile page
			accountsHelper.verifyUsersEmail();
			ExecutionLog.Log("Verify logged in email with Profile page");

			// Go to Contacts
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/contacts");
			//headerHelper.clickOnContacts();
			//ExecutionLog.Log("Go to Contacts");

			//Submit Contacts Details
			accountsHelper.submitContactsDetails();
			ExecutionLog.Log("Submit Contacts Details");

			// Check success message
			headerHelper.checkSuccessMessage("Contact was successfully created.");	
			ExecutionLog.Log("Contacts updating success message");

			// Go to Employee
			
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/employees");
			//headerHelper.clickOnEmployee();
			//ExecutionLog.Log("Go to Employee");

			//Submit Employee Details
			accountsHelper.submitEmployeeDetails();
			ExecutionLog.Log("Submit Employee Details");

			// Check success message
			headerHelper.checkSuccessMessage("Record was successfully created.");	
			ExecutionLog.Log("Contacts updating success message");

			// Go to Admin Settings
			getWebDriver().navigate().to("https://app.prime-response.com/accounts/13594/admin_settings");
			//headerHelper.clickOnAdminSettings();
			//ExecutionLog.Log("Go to Employee");

			//Verify default account type is demo in Admin settings
			accountsHelper.adminSettings();
			ExecutionLog.Log("Verify default account type is demo");

		}


		catch (Error e) {
			captureScreenshot("testCreate_Account");
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			captureScreenshot("testCreate_Account");
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}

	}
	
	@AfterMethod
	public void endMethods() throws Exception {
		ExecutionLog.LogEndClass(this.getClass().getName());
	}
}
