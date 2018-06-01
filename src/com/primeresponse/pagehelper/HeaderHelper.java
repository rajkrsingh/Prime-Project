package com.primeresponse.pagehelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class HeaderHelper extends DriverHelper {

	private LocatorReader headerLocator;

	public HeaderHelper(WebDriver driver) {
		super(driver);
		headerLocator = new LocatorReader("Header.xml");		
	}

	// Verify success message 
	public void checkSuccessMessage(String text)
	{
		String locator = headerLocator.getLocator("FlashMessage");
		WaitForElementVisible(locator, 30);
		isTextPresent(locator, text);
	}

	// Verify facebox (popup)
	public void checkFacebox()
	{
		String spinner_locator = headerLocator.getLocator("FaceboxLoadingSpinner");
		WaitForElementNotVisible(spinner_locator, 20);
		String popup_locator = headerLocator.getLocator("Facebox");
		WaitForElementEnabled(popup_locator, 60);
	}

	// Click on edit icon of logged user
	public void clickOnEditIconOfLoggedInUser()
	{
		String locator = headerLocator.getLocator("TopRightIcons.EditLoggedInUser");
		clickOn(locator);
		waitForLoading();

	}

	// Click on edit icon of logged account
	public void clickOnEditIconOfLoggedAccount()
	{
		String locator = headerLocator.getLocator("TopRightIcons.EditAccount");
		clickOn(locator);
		waitForLoading();
	}
	
	//**********Go to Training page
	 public void clickOnTraining()
	{
				
		String locator = headerLocator.getLocator("Header.Training");
		clickOn(locator);
		waitForLoading();
		
		//String locator1 = getText(headerLocator.getLocator("Header.HeaderAdminNotes"));
		//return locator1;
	
	}
	 
	
	 

	public void clickOnSupportNoteIcon()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator = headerLocator.getLocator("TopRightIcons.SubmitSupportNoteIcon");
		mouseOver(locator);

		String locator2 = headerLocator.getLocator("TopRightIcons.LoadingImg");
		WaitForElementNotPresent(locator2, 20);
	}

	public void clickOnNewNoteIcon() {
		String locator = headerLocator.getLocator("TopRightIcons.SubmitNoteIcon");
		clickOn(locator);

		String locator2 = headerLocator.getLocator("TopRightIcons.LoadingImg");
		WaitForElementNotPresent(locator2, 20);

	}
	
	public void clickOnAllAccountSubMenu()
	{
		String locator = headerLocator.getLocator("Header.Accounts");
		clickOn(locator);
		
		String locator1 = headerLocator.getLocator("AccountsSubmenu.All");
		clickOn(locator1);
		
	}
	
	public String clickOnAccountOfficialProfile()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		//String locator = headerLocator.getLocator("Header.Accounts");
		//clickOn(locator);
		
		String locator3= headerLocator.getLocator("AccountsSubmenu.OfficialProfile");
		clickOn(locator3);
		
		String str=getText(headerLocator.getLocator("TopRightIcons.SelectedAccount"));
		
		return str;
		
	}

	
	// Methods to go from Enterprise > Sub menus
	public void clickonEnterpriseMyAccount() {

		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("EnterpriseSubMenu.MyAccounts");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonEnterpriseDashboard() {

		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("EnterpriseSubMenu.Dashboard");
		clickOn(locator2);
		waitForLoading();
		
		//String locator3 = getText(headerLocator.getLocator("Header.HeaderAdminNotes"));
		//return locator3;
		
	}
	
	public void clickonResponsePenetration()
	{
		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 =headerLocator.getLocator("EnterpriseSubMenu.ResponsePenetration");
		clickOn(locator2);
		
	}

	public void clickonEnterpriseSummary() {

		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("EnterpriseSubMenu.Summary");
		clickOn(locator2);
		waitForLoading();

	}

	public void clickonEnterpriseExternalFeed() {

		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("EnterpriseSubMenu.ExternalFeed");
		clickOn(locator2);
		waitForLoading();

	}

	public void clickonEnterprisInternalFeed() {

		String locator1 = headerLocator.getLocator("Header.Enterprise");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("EnterpriseSubMenu.InternalFeed");
		clickOn(locator2);
		waitForLoading();

	}

   public void clickonEnterpriseReports()
   {
	   String locator1 = headerLocator.getLocator("Header.Enterprise");
	   clickOn(locator1);
	   String locator2 = headerLocator.getLocator("EnterpriseSubMenu.Reports");
	   clickOn(locator2);
	   waitForLoading();
   }

	// Methods to go from Accounts > Sub menus
	public void randomClickOnAccountSubMenu()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		WaitForElementVisible(locator2, 30);
		
		String locator3 = headerLocator.getLocator("AccountsSubmenu.AccountsMenuList");
		int n_submenu = getSize(locator3);

		// select any random sub menu	
		
		int randomval=getRandomInteger(1,n_submenu);
		clickOn("//div[@id='header']/div//ul/li/ul/li[@class='dropdown-submenu active']/ul/li["+randomval+"]");
		//int n_start=2+(int)(Math.random()*((n_submenu-2)+1));
		//Click on Accounts from Header	
		
		//this.WaitForElementVisible(locator3, 30);
		//clickOn(locator3+"["+n_start+"]/a");	
		waitForLoading();

	}

	public void clickOnAccountAll() throws InterruptedException
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		//Thread.sleep(2000);
		String locator2=headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		//WaitForElementNotPresent(locator2, 30);
		  
         String locator3=headerLocator.getLocator("AccountsSubmenu.All");
         //WaitForElementPresent(locator3, 40);
         
        WebElement element = getWebDriver().findElement(By.xpath(locator3));
        ((JavascriptExecutor)getWebDriver()).executeScript("arguments[0].click();", element);
       // clickOn(locator3);
		waitForLoading();
	}

	public void clickOnOfficialProfile() 
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		
		String locator2=headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		//WaitForElementPresent(locator2,30);
		
		//String locator3=headerLocator.getLocator("Header.Accounts");
		//clickOn(locator3);
		String locator3=headerLocator.getLocator("AccountsSubmenu.OfficialProfile");
		//WaitForElementPresent(locator3,30);
		clickOn(locator3);
		
		waitForLoading();
	}

	public void clickOnUsers()
	{
		String locator=headerLocator.getLocator("Header.More");
		clickOn(locator);
		
		String locator1=headerLocator.getLocator("Header.Accounts");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("AccountsSubmenu.Users");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickOnContacts()
	{
		String locator1=headerLocator.getLocator("Header.Accounts");
		clickOn(locator1);
		String locator2=headerLocator.getLocator("AccountsSubmenu.Contacts");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickOnEmployee()
	{
		String locator1=headerLocator.getLocator("Header.Accounts");
		clickOn(locator1);
		String locator2=headerLocator.getLocator("AccountsSubmenu.Employee");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickOnAdminSettings()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Accounts");
		clickOn(locator2);
		
		String locator3=headerLocator.getLocator("AccountsSubmenu.AdminSettings");
		clickOn(locator3);
		waitForLoading();
	}
   
	
	public void clickOnGreatPlainsContracts()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("SubMenu.AccountsSubmenu.GreatPlainsContract");
		clickOn(locator3);
	}

	
	

	// Click on Access Keys
	public void clickOnAccessKeys()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		clickOn(locator2);
		
		String locator3 = headerLocator.getLocator("SubMenu.AccountsSubmenu.AccessKeys");
		WaitForElementVisible(locator3, 30);
		clickOn(locator3);
		
		waitForLoading();
	}

	
	//Click on Accounts->Support Settings
	public void clickOnSupportSettings()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Accounts");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("SubMenu.AccountsSubmenu.SupportSettings");
		clickOn(locator3);
		waitForLoading();
	}
	
	//**********Click on Supports > Conversion Rates ***************************//
	
	public void clickOnSupportConversionRates()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Support");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("SupportSubmenu.ConversionsRates");
		clickOn(locator3);
		waitForLoading();
	}

	// Methods to go from Social > Sub menus
	public void clickonSocialContent()
	{
		String locator1 = headerLocator.getLocator("Header.Social");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("SocialSubmenu.Content");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonSocialPost()
	{
		String locator1 = headerLocator.getLocator("Header.Social");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("SocialSubmenu.Posts");
		clickOn(locator2);
		waitForLoading();
	}
	
	public void clickonSocialPostReport()
	{
		String locator1 = headerLocator.getLocator("Header.Social");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("SocialSubmenu.Report");
		clickOn(locator2);
		waitForLoading();	
	}
	
	public void pinnedContentReport()
	{
		String locator1 = headerLocator.getLocator("Header.Social");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("SocialSubmenu.PinnedContentReport");
		clickOn(locator2);
		waitForLoading();	
	}


	public void clickOnSocialDashBoard()
	{
		String locator1 = headerLocator.getLocator("Header.Social");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("SocialSubmenu.Dashboard");
		clickOn(locator2);
		waitForLoading();
	}

	// Methods to go from Reputation > Influence > Sub menus

	public void clickonInfluenceDashboard() {
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Dashboards");
		clickOn(locator2);
		waitForLoading();

	}

	public void clickonInfluenceCampaign() throws InterruptedException
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		mouseOver(locator);
		Thread.sleep(1000);
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Campaigns");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonInfluenceLists()
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Lists");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonInfluenceSurvey() 
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		//WaitForElementPresent(locator1,30);
		//Thread.sleep(4000);
		clickOn(locator1);
		
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		//WaitForElementPresent(locator,30);
		//Thread.sleep(4000);
		mouseOver(locator);
		
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Surveys");
		//Thread.sleep(4000);
		//WaitForElementPresent(locator2,30);
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonInfluenceCustomers() 	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Customers");
		mouseOver(locator2);
		//WaitForElementPresent(locator2,30);
		//Thread.sleep(4000);
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonInfluenceRedirects()
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Influence");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("InfluenceSubmenu.Redirects");
		clickOn(locator2);
		waitForLoading();
	}

	// Methods to go from Reputation > Track > Sub menus

	public void clickonTrackInternalFeed()
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Track");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("TrackSubmenu.InternalFeed");
		clickOn(locator2);
		waitForLoading();
	}

	public void clickonTrackExternalFeed()
	{
		try
		{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Track");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("TrackSubmenu.ExternalFeed");
		this.WaitForElementPresent(locator2, 5);	
		clickOn(locator2);
		waitForLoading();
		}
		catch(Exception e)
		{
			String locator1 = headerLocator.getLocator("Header.Reputation");
			clickOn(locator1);
			String locator = headerLocator.getLocator("ReputationSubmenu.Track");
			mouseOver(locator);
			String locator2 = headerLocator.getLocator("TrackSubmenu.ExternalFeed");
			this.WaitForElementPresent(locator2, 5);	
			clickOn(locator2);
			waitForLoading();
		}
	}
		
		
	

	public void clickonTrackSummary() {
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		
		String locator = headerLocator.getLocator("ReputationSubmenu.Track");
		mouseOver(locator);
		
		String locator2 = headerLocator.getLocator("TrackSubmenu.Summary");
		clickOn(locator2);
		waitForLoading();

	}

	
	//*********************
	public void clickonTrackCompetitors() throws InterruptedException {
	   String locator=headerLocator.getLocator("Header.Reputation");
	   clickOn(locator); 
	   waitForLoading();
	   
	   String locator1 = headerLocator.getLocator("ReputationSubmenu.Track");
		mouseOver(locator1);
		
	   //String one = getWebDriver().findElement(By.xpath("//a[@href='/track/competitors']")).getText();
	   //System.out.print("Team: "+one);
	   
	   String locator2=headerLocator.getLocator("TrackSubmenu.Competitors");
	   waitForLoading();
	   clickOn(locator2);
	   waitForLoading();

		}
	
	public void clickonTrackProductReviewFeed() 
	{
		String locator=headerLocator.getLocator("Header.Reputation");
		clickOn(locator); 
		waitForLoading();
		   
		 String locator1 = headerLocator.getLocator("ReputationSubmenu.Track");
		 mouseOver(locator1);
		 
		 String locator2=headerLocator.getLocator("TrackSubmenu.ProductReviewFeed");
		 waitForLoading();
		 clickOn(locator2);
	 
	}

	
	//*********************

	// Methods to go from Reputation > Profile > Sub menus

	public void clickonProfilePageCapture()
	{
		String locator1 = headerLocator.getLocator("Header.Reputation");
		clickOn(locator1);
		String locator = headerLocator.getLocator("ReputationSubmenu.Profile");
		mouseOver(locator);
		String locator2 = headerLocator.getLocator("ProfileSubmenu.PageCapture");
		clickOn(locator2);
		waitForLoading();
	}

	// Go to Profile > Site Detail
		public void clickonProfileSiteDetail()
		{
			
			/*String locator1 = headerLocator.getLocator("Header.Reputation");
			clickOn(locator1);
			String locator = headerLocator.getLocator("ReputationSubmenu.Profile");
			mouseOver(locator);
			String locator2 = headerLocator.getLocator("ProfileSubmenu.SiteDetail");
			clickOn(locator2);
			waitForLoading();  */
	
		}

	// Methods to go from Web > SERP Capture

	public void clickonWebSERP()
	{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		String locator2 = headerLocator.getLocator("WebSubMenu.SERPCapture");
		clickOn(locator2);
		waitForLoading();
	}
	
	public void clickonWebLandingPages()
	{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("WebSubMenu.LandingPages");
		clickOn(locator2);
		waitForLoading();
			
	}
	
	public void clickonWebTrackingURLs()
	{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("WebSubMenu.TrackUrl");
		clickOn(locator2);
		waitForLoading();
	}
	
	public void clickOnWebReferralAnalysis()
	{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		String locator2 =headerLocator.getLocator("WebSubMenu.ReferralAnalysis");
		clickOn(locator2);
		waitForLoading();
		
	}
	
	public void clickonWebGoogleCampaigns() throws InterruptedException
	{
		try{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		Thread.sleep(4000);
		String locator2 =headerLocator.getLocator("WebSubMenu.GoogleCampaigns");
		clickOn(locator2);
		waitForLoading();
		}
		catch(Exception e)
		{
			String locator1 = headerLocator.getLocator("Header.Web");
			clickOn(locator1);
			Thread.sleep(4000);
			String locator2 =headerLocator.getLocator("WebSubMenu.GoogleCampaigns");
			this.WaitForElementPresent(locator2, 10);
			clickOn(locator2);
			waitForLoading();
		}
	}
	
	public void clickonWebCampaignsReport()
	{
		String locator1 = headerLocator.getLocator("Header.Web");
		clickOn(locator1);
		
		String locator2 =headerLocator.getLocator("WebSubMenu.CampaignsReport");
		clickOn(locator2);
		waitForLoading();
	}
	
	
	


	// Methods to go from More > Admin > Users

	public void clickonAdminUsers() 
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		//isElementVisible(locator2);
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("AdminSubmenu.Users");
		//this.isElementPresent(locator3);
		//isElementVisible(locator3);
		clickOn(locator3);

	}
	
	public void clickOnAdminKpiTemplate()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("AdminSubmenu.Kpi");
		clickOn(locator3);

	}
	public void clickOnAdminNotifications()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("AdminSubmenu.Notifications");
		clickOn(locator3);
		
	}		

	public void clickOnAdminRssSeeds()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("AdminSubmenu.RssSeeds");
		clickOn(locator3);
		
	}		
	
	public void clickOnAdminJobs()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3 = headerLocator.getLocator("AdminSubmenu.Jobs");
		clickOn(locator3);
	}
	
	public void clickOnAdminTrackerPackage()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
				
		String locator3 = headerLocator.getLocator("AdminSubmenu.TrackerPackages");
		clickOn(locator3);
		waitForLoading();
	}

	public void clickOnAdminVerticals()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Admin");
		mouseOver(locator2); 
		
		String locator3=headerLocator.getLocator("AdminSubmenu.Verticals");
		clickOn(locator3); 
		waitForLoading();
	}

	public void clickOnAdminEmailTemplates()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Admin");
		mouseOver(locator2); 
		
		String locator3=headerLocator.getLocator("AdminSubmenu.EmailTemplates");
		clickOn(locator3);
		waitForLoading();
	}


	public void clickOnAdminCategories() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
				
		String locator2=headerLocator.getLocator("Header.Admin");
		WaitForElementPresent(locator2,30);
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("AdminSubmenu.Categories");
		clickOn(locator3);
		waitForLoading();
	}


	public void clickOnAdminWhiteLabels() {
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
				
		String locator2=headerLocator.getLocator("Header.Admin");
		WaitForElementPresent(locator2,30);
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("AdminSubmenu.WhiteLabels");
		clickOn(locator3);
		waitForLoading();
	}

	public void clickOnAdminApplicationProduct() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
				
		String locator2=headerLocator.getLocator("Header.Admin");
		WaitForElementPresent(locator2,30);
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("Header.Admin");
		clickOn(locator3); 
		String locator4=headerLocator.getLocator("AdminSubmenu.ApplicationProduct");
		clickOn(locator4);
		waitForLoading();
	}
	
	public void clickOnAdminGreatPlainsImport()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
				
		String locator2=headerLocator.getLocator("Header.Admin");
		WaitForElementPresent(locator2,30);
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("Header.Admin");
		clickOn(locator3); 
		String locator4=headerLocator.getLocator("AdminSubmenu.GreatPlainsImport");
		clickOn(locator4);
		waitForLoading();
	}
	

	public void clickOnAdminGroups() {
		
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
				
		String locator2=headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("AdminSubmenu.Groups");
		clickOn(locator3);
		
		waitForLoading();

	}

	public void clickOnAdminRecipientTemplates()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("AdminSubmenu.RecipientTemplates");
		clickOn(locator3);

	}

	public void clickOnAdminListeners()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("AdminSubmenu.Listeners");
		clickOn(locator3);

	}

	public void clickOnAdminGreatPlainsContracts()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2 = headerLocator.getLocator("Header.Admin");
		mouseOver(locator2);

		String locator3 = headerLocator.getLocator("AdminSubmenu.GreatPlainsProducts");
		clickOn(locator3);
	}


	//***** Go to Support > Communication sub menu *****

	public void clickonSupportCommunication() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Communications");
		clickOn(locator3);
		waitForLoading();
		
	}
	
    public void clickonSupportGoals()
    {
    	String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Goals");
		clickOn(locator3);
		waitForLoading();
    }

	
	public void clickonSupportMetrics()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Metrics");
		clickOn(locator3);
		waitForLoading();

	}
	public void clickOnAccountStatuses()
	{
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2); 
		
		String locator3=headerLocator.getLocator("SupportSubmenu.AccountsStatuses");
		clickOn(locator3);
		waitForLoading();

	}
	
	public void clickOnSupportEngagement()
	{
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2); 
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Engagement");
		clickOn(locator3);
		waitForLoading();
		
	}

	public void clickonSupportNotes() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2);
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Notes");
		clickOn(locator3);
		waitForLoading();
	}


	public void clickonSupportReports() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		String locator2=headerLocator.getLocator("Header.Support");
		mouseOver(locator2); 
		
		String locator3=headerLocator.getLocator("SupportSubmenu.Reports");
		clickOn(locator3);
		waitForLoading();

	}


	// Methods to go from Settings > Sub menus
	public void clickonSettingsCompetitors() {
		String locator=headerLocator.getLocator("Header.Settings");
		clickOn(locator); 

		String locator1=headerLocator.getLocator("SettingsSubmenu.Competitors");
		clickOn(locator1);
		waitForLoading();

	}
	
	
	public void clickOnSettingsFeeds() throws InterruptedException
	{Thread.sleep(4000);
		String locator=headerLocator.getLocator("Header.Settings");
		
		//this.WaitForElementVisible(locator, 30);
		WaitForElementPresent(locator, 5);
		clickOn(locator); 
		Thread.sleep(4000);
		
		try{
			String locator1=headerLocator.getLocator("SettingsSubmenu.Feeds");
			WaitForElementVisible(locator1, 5);
			//WaitForElementPresent(locator1, 50);
			clickOn(locator1);
		}
		catch(Exception e)
		{
			WaitForElementPresent(locator, 5);
			clickOn(locator); 
			Thread.sleep(4000);
			String locator1=headerLocator.getLocator("SettingsSubmenu.Feeds");
			WaitForElementVisible(locator1, 5);
			//WaitForElementPresent(locator1, 50);
			clickOn(locator1);
		}
		
	
		waitForLoading();
	}

	public void clickOnSettingsTrackListeners()
	{
		String locator1 = headerLocator.getLocator("Header.Settings");
		clickOn(locator1);
		String locator3 = headerLocator.getLocator("SettingsSubmenu.TrackListeners");
		clickOn(locator3);
		waitForLoading();

	}

	public void clickOnSettingsAlert() {
		String locator1 = headerLocator.getLocator("Header.Settings");
		clickOn(locator1);
		String locator3 = headerLocator.getLocator("SettingsSubmenu.Alerts");
		clickOn(locator3);
		waitForLoading();
	}


	public void clickOnSettingsSocialIntegration() {
		String locator1 = headerLocator.getLocator("Header.Settings");
		clickOn(locator1);
		String locator3 = headerLocator.getLocator("SettingsSubmenu.Integrations");
		clickOn(locator3);
		waitForLoading();

	}

	public void clickOnSettingsSiteMap()
	{
		String locator1=headerLocator.getLocator("Header.Settings");
		clickOn(locator1); 

		String locator2=headerLocator.getLocator("SettingsSubmenu.SiteMap");
		clickOn(locator2);
		waitForLoading();
	}

	

	public void clickOnSettingsDigests()
	{
		String locator1=headerLocator.getLocator("Header.Settings");
		clickOn(locator1); 

		String locator2=headerLocator.getLocator("SettingsSubmenu.Digest");
		clickOn(locator2);
		waitForLoading();
	}


	// Delete Methods
	// text is which want to delete and no_column is at which column delete icon is present in table
	public void delete(String text, int no_column)
	{
		String locator1 = headerLocator.getLocator("Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{
			if(isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[contains(text(), '"+text+"')]"))
			{
				if(!isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td["+no_column+"]/a/img"))
				{
					isTextPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[2]", "Sent");
					break;

				}

				else
				{
					clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td["+no_column+"]/a/img");
					acceptAlert();
					break;
				}
			}

			if((isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[*]/div[contains(text(), '"+text+"')]"))&&(isElementPresent("//h1[contains(text(), 'Lists')]")))
			{
				clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td["+no_column+"]/a[*]/img[@title='Remove']");
				acceptAlert();
			}
		}
	}

	// *********** Verify Main Menus list fucntions ***********
	public void verifyEnterpriseSubMenus() {

		clickOn(headerLocator.getLocator("Enterprise"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.Dashboard"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.Summary"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.ExternalFeed"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.InternalFeed"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.ProductReviewFeed"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.MyAccounts"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.ResponsePenetration"));
		isElementPresent(headerLocator.getLocator("EnterpriseSubMenu.Reports"));

	}

	public void verifyAccountsSubMenus() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);
		
		clickOn(headerLocator.getLocator("Accounts"));
		isElementPresent(headerLocator.getLocator("AccountsSubmenu.All"));
		isElementPresent(headerLocator.getLocator("AccountsSubmenu.Demo"));
		isElementPresent(headerLocator.getLocator("AccountsSubmenu.Production"));
		isElementPresent(headerLocator.getLocator("AccountsSubmenu.Competitors"));

	}

	public void verifyReputationSubMenus() {

		clickOn(headerLocator.getLocator("Header.Reputation"));
		mouseOver(headerLocator.getLocator("ReputationSubmenu.Profile"));
		isElementPresent(headerLocator.getLocator("ProfileSubmenu.AccountProfile"));
		isElementPresent(headerLocator.getLocator("ProfileSubmenu.SiteDetail"));
		isElementPresent(headerLocator.getLocator("ProfileSubmenu.PageCapture"));
		mouseOver(headerLocator.getLocator("ReputationSubmenu.Track"));
		isElementPresent(headerLocator.getLocator("TrackSubmenu.Summary"));
		isElementPresent(headerLocator.getLocator("TrackSubmenu.ExternalFeed"));
		isElementPresent(headerLocator.getLocator("TrackSubmenu.InternalFeed"));
		//this.WaitForElementVisible(headerLocator.getLocator("TrackSubmenu.ProducrReviewFeed"), 30);
		isElementPresent(headerLocator.getLocator("TrackSubmenu.ProductReviewFeed"));
		isElementPresent(headerLocator.getLocator("TrackSubmenu.Competitors"));
		mouseOver(headerLocator.getLocator("ReputationSubmenu.Influence"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Dashboards"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Redirects"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Lists"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Customers"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Surveys"));
		isElementPresent(headerLocator.getLocator("InfluenceSubmenu.Campaigns"));

	}

	public void verifySocialSubMenus() {

		clickOn(headerLocator.getLocator("Social"));
		isElementPresent(headerLocator.getLocator("SocialSubmenu.Dashboard"));
		isElementPresent(headerLocator.getLocator("SocialSubmenu.Content"));
		isElementPresent(headerLocator.getLocator("SocialSubmenu.Posts"));
		isElementPresent(headerLocator.getLocator("SocialSubmenu.Report"));

	}

	public void verifyWebSubMenus() {

		clickOn(headerLocator.getLocator("Header.Web"));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.Dashboard")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.ReferralAnalysis")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.SERPCapture")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.SERPSpy")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.SERPSpySetup")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.LandingPages")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.GoogleCampaigns")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.CampaignsReport")));
		Assert.assertTrue(isElementPresent(headerLocator.getLocator("WebSubMenu.TrackUrl")));
		

	}

	public void verifySettingsSubMenus() {

		clickOn(headerLocator.getLocator("Settings"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.Integrations"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.Feeds"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.TrackListeners"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.Alerts"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.Digest"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.Competitors"));
		isElementPresent(headerLocator.getLocator("SettingsSubmenu.SiteMap"));

	}

	public void verifySupportSubMenus() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);

		clickOn(headerLocator.getLocator("Header.Support"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.Metrics"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.Notes"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.Reports"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.AccountsStatuses"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.Communications"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.ConversionsRates"));
		isElementPresent(headerLocator.getLocator("SupportSubmenu.Engagement"));

	}

	public void verifyTrainingSubMenus() {

		clickOn(headerLocator.getLocator("Training"));


	}

	public void verifyAdminSubMenus() {
		
		String locator1=headerLocator.getLocator("Header.More");
		clickOn(locator1);

		clickOn(headerLocator.getLocator("Header.Admin"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.ApplicationProduct"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Categories"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.EmailTemplates"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.RecipientTemplates"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.GMIntegralinkFiles"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Groups"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Jobs"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Listeners"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Notifications"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.ReviewImportFiles"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Roles"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.RssSeeds"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Soap"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.TrackerPackages"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Users"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.Verticals"));
		isElementPresent(headerLocator.getLocator("AdminSubmenu.WhiteLabels"));

	}


	//***************Verify process of submitting new support note.***********************************//
			public void submit_NewSupportNote()
			{
				String locator1=headerLocator.getLocator("TopRightIcons.SubmitSupportNoteIcon");
				clickOn(locator1);
				waitForLoading();
				
				String locator2=headerLocator.getLocator("SupportNote.ContactName");
				sendKeys(locator2,"Shishir");
				
				String locator3=headerLocator.getLocator("SupportNote.ContactEmail");
				sendKeys(locator3,"shishirj@360logica.com");
				
				String locator4=headerLocator.getLocator("SupportNote.ContactPhone");
				sendKeys(locator4,"9999999999");
				
				String locator5=headerLocator.getLocator("SupportNote.Comments");
				sendKeys(locator5,"testing support note");
				
				String locator6=headerLocator.getLocator("SupportNote.SubmitButton");
				clickOn(locator6);
			
			}
			
			//*************Verify process of submitting note to logged in user.********************************//
			public void submit_NoteToLoggedInUser()
			{
				String locator1=headerLocator.getLocator("TopRightIcons.SubmitNoteIcon");
				clickOn(locator1);
				waitForLoading();
				
				Assert.assertTrue(isElementPresent(headerLocator.getLocator("SubmitNote.AssignTo")));
							
				
				String locator2=headerLocator.getLocator("SubmitNote.Description");
				sendKeys(locator2,"Testing submitting note .");
				
				String locator3=headerLocator.getLocator("SubmitNote.SubmitButton");
				clickOn(locator3);
			
			}


}

