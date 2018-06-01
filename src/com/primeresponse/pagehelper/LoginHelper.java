package com.primeresponse.pagehelper;

import org.openqa.selenium.WebDriver;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class LoginHelper extends DriverHelper 
{
	private LocatorReader loginLocator;	

	
	public LoginHelper(WebDriver driver) {
		super(driver);
		loginLocator = new LocatorReader("Login.xml");
	}

	public void enterUserID(String text)
	{
		String locator = loginLocator.getLocator("Login.UserEmail");
		sendKeys(locator, text);		
	}
	
	public void enterPassword(String text)
	{
		String locator = loginLocator.getLocator("Login.Password");
		sendKeys(locator, text);		
	}
	
	public void clickLogin()
	{
		String locator = loginLocator.getLocator("Login.Submit");
		clickOn(locator);
		waitForLoading();
		
	}
	
	//Method to select account
	
	public void selectAccountttt(String acc)
	{
		String textt="Selenium Test";
		String locator = loginLocator.getLocator("SelectAccount.SelectAccounttt");
		String sttr=getText(locator);
		//System.out.println("Locator:"+sttr);
		
		if(textt.equals(sttr))
		{
			System.out.println("Selenium Test account already logged in");
		}
		else
		{
		  clickOn(locator);
		 String locator1 = loginLocator.getLocator("SelectAccount.SearchAccount");
		 sendKeys(locator1,"Selenium Test");
		 
		 String locator2 = loginLocator.getLocator("SelectAccount.SearchAccount");
		 WaitForElementPresent(locator2, 20);
		 clickOn(locator2);
		 
		 String locator3 = loginLocator.getLocator("SelectAccount.SeleniumTestAccount");
		 clickOn(locator3);
		}
	
	}
	public void selectAccount(String acc)
	{
		
		String locator = loginLocator.getLocator("SelectAccount.ImgLock");
		String sttr=getText(locator);
		System.out.println("Locator value:::::"+sttr);
		
		if(isElementPresent(locator))
		{	
			String locator1 = loginLocator.getLocator("SelectAccount.SelectedAcc");
			if(!isTextPresent(locator1, acc))
			{
				String locator2 = loginLocator.getLocator("SelectAccount.AccountName");
				sendKeys(locator2, acc);
				String locator3 = loginLocator.getLocator("SelectAccount.SearchResult");
				clickOn(locator3);
			}
		}
		if(!isElementPresent(locator))
		{
			String locator2 = loginLocator.getLocator("SelectAccount.AccountName");
			sendKeys(locator2, acc);
			String locator3 = loginLocator.getLocator("SelectAccount.SearchResult");
			clickOn(locator3);
		}
	}
	
}
