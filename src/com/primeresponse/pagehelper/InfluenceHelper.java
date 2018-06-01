package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;


public class InfluenceHelper extends DriverHelper{

	private LocatorReader influenceLocator;
	Screen screen = new Screen();

	public InfluenceHelper(WebDriver webdriver) {
		super(webdriver);
		influenceLocator = new LocatorReader("Influence.xml");
	}

	// *************** Create new campaigns methods **************************************
	public void clickOnNewCampaign()
	{
		String btn_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.NewCampaignLink");
		clickOn(btn_locator);
	}

	public void submitBasicDetails(String append_str)
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.BasicTab");
		isElementPresent(tab_locator);
		String name_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.Name");
		sendKeys(name_locator, "Test Campaign by Webdriver script execution" + append_str);
		String sub_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.Subject");
		sendKeys(sub_locator, "Test Subject by Webdriver Automation script execution");
		String desc_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.Description");
		sendKeys(desc_locator, "Test Description by Webdriver Automation script execution");
		String survey_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.Survey");
		String nosurveymsg_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.NoSurveyMessage");
		if(isElementPresent(survey_locator))
		{
			selectDropDown(survey_locator, "TestSurvey copy");
		}
		else
		{
			isElementPresent(nosurveymsg_locator);
		}
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);

	}

	public void selectSender()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.SenderTab");
		isElementPresent(tab_locator);
		String radiobtn_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.SelectUserRadio");
		isChecked(radiobtn_locator);
		String selectuser_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.SelectUser");
		selectDropDown(selectuser_locator, "Jain, Shishir - shishirj@360logica.com");
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	public void submitRecipientsDetails()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.RecipientsTab");
		isElementPresent(tab_locator);
		String radiobtn_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.SelectRecipientsRadio");
		clickOn(radiobtn_locator);
		String list_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ListDropDown");
		isTextPresent(list_locator, "Please select a list.");
		clickOn(list_locator);
		String listName_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ListName");
		clickOn(listName_locator);
		String preview_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.PreviewLink");
		clickOn(preview_locator);
		String previewtitle_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.PreviewTitle");
		WaitForElementVisible(previewtitle_locator , 30);
		//		String count_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.RecipientsCount");
		//		getSize(count_locator);
		String close_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ClosePreview");
		clickOn(close_locator);
		WaitForElementNotVisible(previewtitle_locator , 30);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);

	}
	

	//*********Method to verify events of surveys on Influence > Surveys page.******************//
	 public void verify_SurveysEvents()
	 {
		 String locator1 = influenceLocator.getLocator("Surveys.Events.EventsButton");
		 clickOn(locator1);
		 waitForLoading();
		 
		 Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Events.SurveysEventTitle")));
		 Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Events.Name")));
		 Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Events.PreSurveyCompleteDate")));
		 Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Events.SurveyStartDate")));
		 Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Events.SurveyCompleteDate")));
		
	 }
	 
	//Verify reports of surveys on Influence > Surveys page.
		public void verify_SurveysReport()
		{
			String locator1 = influenceLocator.getLocator("Surveys.Reports.ReportButton");
			clickOn(locator1);
			waitForLoading();
			
			Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Reports.SurveySummaryChart")));
			Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Reports.DateCreated")));
			Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Reports.NumberofSurveysCompleted")));
			Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Reports.ResponsePercent")));
			Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.Reports.ResponseCount")));
			
		}

	public void scheduleCampaign()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ScheduleTab");
		isElementPresent(tab_locator);
		String radiobtn_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.OneTimeRadioButton");
		isChecked(radiobtn_locator);
		String chckbox_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.OverSendingCheckBox");
		isChecked(chckbox_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);

	}

	public void selectTemplate()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.TemplateTab");
		isElementPresent(tab_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);

	}

	public void submitBodyContent()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ContentTab");
		isElementPresent(tab_locator);
		String textbox_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.TextBody");
		WaitForElementPresent(textbox_locator, 30);
		String mergfield_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.MergeFields");
		String insert_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.InsertLink");
		if(isElementPresent("Survey Link"))
		{
			selectDropDown(mergfield_locator, "Survey Link");
		}
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Unsubscribe Link");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member Addr");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member Country");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member Busname");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Profile Center Link");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member PostalCode");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member City");
		clickOn(insert_locator);
		selectDropDown(mergfield_locator, "Member State");
		clickOn(insert_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	//	public void reviewDetails()
	//	{
	//		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
	//		clickOn(nextbtn_locator);
	//	}

	public void sendCampaign()
	{
		String tab_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.ReviewTab");
		isElementPresent(tab_locator);
		String preview_locator = influenceLocator.getLocator("Campaigns.CreateCampaigns.PreviewImage");
		WaitForElementPresent(preview_locator, 30);
		String sendbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.SendButton");
		clickOn(sendbtn_locator);
		//acceptAlert();
	}


	//************ Create New List method ***********************
	public void clickOnNewList()
	{
		String btn_locator = influenceLocator.getLocator("List.UploadList.NewListLink");
		clickOn(btn_locator);
	}

	public void uploadList(String path, String str) throws InterruptedException
	{
		String name_locator = influenceLocator.getLocator("List.UploadList.Name");
		sendKeys(name_locator, "List uploaded by Webdriver automation script execution" + str);
		Thread.sleep(3000);
		String file_locator = influenceLocator.getLocator("List.UploadList.Browse");
		String csvPath = path + "\\Upload_list.csv";
		Thread.sleep(4000);
		System.out.println("Path Value is ::"+csvPath);
		sendKeys(file_locator, csvPath);
		String checkbox_locator = influenceLocator.getLocator("List.UploadList.ReadDisclaimer");
		clickOn(checkbox_locator);
		String nextbtn_locator  = influenceLocator.getLocator("List.UploadList.UploadButton");
		clickOn(nextbtn_locator);
		waitForLoading();
	}
	
	//Verify that list is downloading in CSV file.
	
	public void downloadCSV_List(String path)
	{
		String locator1 = influenceLocator.getLocator("List.FileLink");
		clickOn(locator1);

		//String locator2 = influenceLocator.getLocator("Customers.DisabledDownloadBtn");
		//this.WaitForElementNotPresent(locator2, 40);
		//			Thread.sleep(9000);
		//Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Customers.SuccessMsg")));
		//Thread.sleep(5000);
		try{

			String imgPath1 = path + "//images//Win8.1SaveFile.png";
			screen.click(imgPath1);
		}
		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
		try{

			String imgPath1 = path + "//images//Win8_Save.png";
			screen.click(imgPath1);
		}
		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
		
		try{

			String imgPath1 = path + "//images//Win8.1OK.png";
			screen.click(imgPath1);
		}
		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
		try{
			String  imgPath1 = path + "//images//SaveAsWin7.png";
			screen.click(imgPath1);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
		try{

			String imgPath2 = path + "//images//OKWin7.png";
			screen.click(imgPath2);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
/*
		try{

			String imgPath2 = path + "//images//Win8.1_OK.png";
			screen.click(imgPath2);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		}  */
	}

	public void mapFileds()
	{
		String name_locator = influenceLocator.getLocator("List.UploadList.DropDownName");
		clickOn(name_locator);
		String mapname_locator = influenceLocator.getLocator("List.UploadList.MapName");
		clickOn(mapname_locator);
		String email_locator = influenceLocator.getLocator("List.UploadList.DropDownEmail");
		String mapemail_locator = influenceLocator.getLocator("List.UploadList.MapEmail");
		clickOn( email_locator);
		clickOn(mapemail_locator);
		String date_locator = influenceLocator.getLocator("List.UploadList.DropDownDate");
		String mapdate_locator = influenceLocator.getLocator("List.UploadList.MapDate");
		clickOn(date_locator);
		clickOn(mapdate_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	// *************** Create New Surveys Methods ***********************
	public void clickOnNewSurvey()
	{
		String btn_locator = influenceLocator.getLocator("Surveys.CreateSurvey.NewSurveyButton");
		clickOn(btn_locator);
	}

	public void submitDetails(String text)
	{
		String name_locator = influenceLocator.getLocator("Surveys.CreateSurvey.Name");
		sendKeys(name_locator, "Test Survey created by Webdriver Script execution" + text);
		String editbox_locator = influenceLocator.getLocator("Surveys.CreateSurvey.EditBox");
		WaitForElementPresent(editbox_locator, 30);
		String wlcmtab_locator = influenceLocator.getLocator("Surveys.CreateSurvey.WelcomeTab");
		isElementPresent(wlcmtab_locator);
		String wlcmsrc_locator = influenceLocator.getLocator("Surveys.CreateSurvey.WelcomeSource");
		clickOn(wlcmsrc_locator);
		String wlcmtext_locator = influenceLocator.getLocator("Surveys.CreateSurvey.WelcomeTextArea");
		sendKeys(wlcmtext_locator, "Welcome Webdriver Scripts");
		clickOn(wlcmsrc_locator);
		String thankutab_locator = influenceLocator.getLocator("Surveys.CreateSurvey.ThankYouTab");
		clickOn(thankutab_locator);
		String thankusrc_locator = influenceLocator.getLocator("Surveys.CreateSurvey.ThankYouSource");
		clickOn(thankusrc_locator);
		String thankutext_locator = influenceLocator.getLocator("Surveys.CreateSurvey.ThankYouTextArea");
		sendKeys(thankutext_locator, "Thank You Webdriver Scripts");
		clickOn(thankusrc_locator);
		String pretab_locator = influenceLocator.getLocator("Surveys.CreateSurvey.PreSurveyTab");
		clickOn(pretab_locator);
		String chckbox_locator = influenceLocator.getLocator("Surveys.CreateSurvey.EnablePreSurvey");
		clickOn(chckbox_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	public void checkNoQuesMessage()
	{
		String noques_locator  = influenceLocator.getLocator("Surveys.CreateSurvey.NoQuestion");
		isTextPresent(noques_locator, "Currently there are no questions provided. Please add a question to the survey.");
	}

	// **************** Add questions method in survey **************

	public void checkFlashMessage(String text)
	{
		String firstques_locator  = influenceLocator.getLocator("Surveys.AddQuestion.FlashInfo");
		isTextPresent(firstques_locator, text);

	}

	public void addQuestion(String text1, String text2)
	{
		String questype_locator  = influenceLocator.getLocator("Surveys.AddQuestion.QuestionType");
		selectDropDown(questype_locator, text1);
		String category_locator  = influenceLocator.getLocator("Surveys.AddQuestion.Category");
		selectDropDown(category_locator, text2);
		String questext_locator  = influenceLocator.getLocator("Surveys.AddQuestion.QuesText");
		sendKeys(questext_locator, "Question created by Webdriver script execution");
		String chckbox1_locator  = influenceLocator.getLocator("Surveys.AddQuestion.IncludeCommentBox");
		clickOn(chckbox1_locator);
		String chckbox2_locator  = influenceLocator.getLocator("Surveys.AddQuestion.IncludeCommentInReview");
		clickOn(chckbox2_locator);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	public void addAnswer(String text)
	{
		String category_locator  = influenceLocator.getLocator("Surveys.AddQuestion.AnsText");
		sendKeys(category_locator, text);
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	// ************* Submit internal reviews methods *********************

	public void getPreSurvey(String applicationUrl)
	{
		String locator1 = influenceLocator.getLocator("Surveys.SubmitSurvey.Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{
			if (isElementPresent("//table[contains(@class, 'survey-table')]/tbody/tr["+i+"]/td[1]/div[contains(text(), 'Test Survey created by Webdriver Script execution')]"))
			{
				String PreSurvey_url = getText("//table[contains(@class, 'survey-table')]/tbody/tr["+i+"]/td[5]");
				String suburl = PreSurvey_url.substring(31);
				//				System.out.println("suburl:" + applicationUrl+suburl);
				getWebDriver().navigate().to(applicationUrl+suburl);
			}
		}
	}

	public void enterCustomerDetails()
	{ 
		String cname_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.CustomerFName");
		sendKeys(cname_locator, "Shishir");
		String cemail_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.CustomerEmail");
		sendKeys(cemail_locator, "shishir.jain@drivedominion.com");
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	public void fillSurvey()
	{
		String threestar_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.ThreeStar");
		clickOn(threestar_locator);
		String cmnt1_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.Comment1");
		sendKeys(cmnt1_locator, "Comment1 enter by Webdriver script execution for 5 star question");
		String lngtext_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.LongText");
		sendKeys(lngtext_locator, "long text by Webdriver script execution for long text question");
		String cmnt2_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.Comment2");
		sendKeys(cmnt2_locator, "Comment1 enter by Webdriver script execution for long text question");
		String shrttext_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.ShortText");
		sendKeys(shrttext_locator, "short text enter by Webdriver script execution for long text question");
		String cmnt3_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.Comment3");
		sendKeys(cmnt3_locator, "Comment3 enter by Webdriver script execution for short text question");
		String nextbtn_locator  = influenceLocator.getLocator("Campaigns.CreateCampaigns.NextButton");
		clickOn(nextbtn_locator);
	}

	public void verifyThanksText()
	{
		String thanks_locator = influenceLocator.getLocator("Surveys.SubmitSurvey.ThanksText");
		isElementPresent(thanks_locator);
	}

	// *************** Delete Survey Method ****************

	public void deleteSurvey(String text)
	{
		String locator1 = influenceLocator.getLocator("Surveys.Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{

			if((isElementPresent("//div[@class='row-fluid']/table/tbody/tr["+i+"]/td[1]/div[contains(text(), '"+text+"')]")))
			{
				clickOn("//div[@class='row-fluid']/table/tbody/tr["+i+"]/td[7]/div/a[6]/i");
				acceptAlert();
			}

		}
	}


	// ********************* Create New Customer Methods ********************

	public void clickOnNewCustomer()
	{
		String btn_locator = influenceLocator.getLocator("Customers.CreateCustomer.NewCustomerLink");
		clickOn(btn_locator);
	}

	public void clickOnAddMultipleCustomer()
	{
		String btn_locator = influenceLocator.getLocator("Customers.CreateCustomer.AddMultipleCustomer");
		clickOn(btn_locator);
	}

	public void submitCustomerDetails(String text1, String text2)
	{
		String email_locator = influenceLocator.getLocator("Customers.CreateCustomer.Email");
		sendKeys(email_locator, text1);
		String fname_locator = influenceLocator.getLocator("Customers.CreateCustomer.FName");
		sendKeys(fname_locator, text2);
		String lname_locator = influenceLocator.getLocator("Customers.CreateCustomer.LName");
		sendKeys(lname_locator, "Test");
	}

	// ********** Delete Customer Methods **********

	public void deleteCustomer(String text)
	{
		String locator1 = influenceLocator.getLocator("Customers.Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{
						System.out.println("inside loop");
			//if(isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[3][contains(text(), '"+text+"')]"))
			if(isElementPresent("//tbody[@id='customers-table']//tr["+i+"]/td[3][contains(text(), '"+text+"')]"))	
			{	
				//System.out.println("inside if");
				clickOn("//tbody[@id='customers-table']//td[6]/div/a[3]/i");
				acceptAlert();
				break;
			}
			
		}
		//			
		//			String locator2 = influenceLocator.getLocator("Customers.NextButton");
		//			clickOn(locator2);
	}

	// ******** Creating redirect methods ****************88

	public void clickOnNewRedirect()
	{
		String btn_locator = influenceLocator.getLocator("Redirects.CreateRedirect.NewRedirectLink");
		clickOn(btn_locator);
	}

	public void enterOriginalUrl(String label) throws InterruptedException
	{	
		String label_locator = influenceLocator.getLocator("Redirects.CreateRedirect.Label");
		sendKeys(label_locator ,label);
		
		String showAdvOptions = influenceLocator.getLocator("Redirects.CreateRedirect.ShowAdvOptions");
		clickOn(showAdvOptions);
		
		String orgnlurl_locator = influenceLocator.getLocator("Redirects.CreateRedirect.OriginalUrl");
		Thread.sleep(1500);
		sendKeys(orgnlurl_locator ,"https://app.prime-response.com/influence/redirects");
		
	}

	public void enterDestinationUrl1(String url, String weight) throws InterruptedException
	{
		Thread.sleep(3000);
		String addurllink_locator = influenceLocator.getLocator("Redirects.CreateRedirect.AddUrlLink");
		clickOn(addurllink_locator);
		
		//String attribute = getAttribute(enterurl_locator, "id");
					//System.out.println(attribute);
		//sendKeys(attribute, url);
		
		String enterurl = influenceLocator.getLocator("Redirects.CreateRedirect.AddUrl");
		sendKeys(enterurl,url);
		
		String enterurl_locator = influenceLocator.getLocator("Redirects.CreateRedirect.TrackerList");
		clickOn(enterurl_locator);
		
		String enterurl_locator1 = influenceLocator.getLocator("Redirects.CreateRedirect.TrackerValue");
		clickOn(enterurl_locator1);
		
		//String enterurl_locator2 = influenceLocator.getLocator("Redirects.CreateRedirect.TrackerWeight");
		//sendKeys(enterurl_locator2,"10");
		
		String enterurl_locator3 = influenceLocator.getLocator("Redirects.CreateRedirect.SubmitButton");
		clickOn(enterurl_locator3);
		
		
		//String attribute = getAttribute(enterurl_locator, "id");
		//		System.out.println(attribute);
		//sendKeys(attribute, url);
		//sendKeys(attribute.substring(0, 55)+"_weight", weight);
	}

	public void enterDestinationUrl2(String url, String weight)
	{
		String addurllink_locator = influenceLocator.getLocator("Redirects.CreateRedirect.AddUrlLink");
		clickOn(addurllink_locator);
		String enterurl_locator = influenceLocator.getLocator("Redirects.CreateRedirect.EnterUrl2");
		String attribute = getAttribute(enterurl_locator, "id");
		//		System.out.println(attribute);
		sendKeys(attribute, url);
		sendKeys(attribute.substring(0, 55)+"_weight", weight);
	}

	// ******** Check_Redirect_Counts Methods **********
	public void verifyAddedRedirect(String text)
	{
		String row_locator = influenceLocator.getLocator("Redirects.Row");
		int no_rows = getSize(row_locator);
		for (int i = 1; i<=no_rows; i++)
		{
			if(isElementPresent("//tbody/tr["+i+"]/td[1]/div/a[contains(text(), 'text')]"))
			{
				//			System.out.println("Found created redirect");
				isTextPresent("//tbody/tr["+i+"]/td[2]/div[2]", "From: https://app-qa.prime-response.com/influence/redirects");
				isTextPresent("//tbody/tr["+i+"]/td[2]/div[4]", "http://gmail.com (0)");
				isTextPresent("//tbody/tr["+i+"]/td[2]/div[5]", "http://google.com (0)");
			}
		}	
	}

	public void clickonLabel(String text) throws InterruptedException
	{
		String row_locator = influenceLocator.getLocator("Redirects.Row");
		int no_rows = getSize(row_locator);
		for (int i = 1; i<=no_rows; i++)
		{
			if(isTextPresent("//tbody/tr["+i+"]/td[1]/div/a", text))
			{
				for (int x = 1; x<=6; x++)
				{
					clickOn("//tbody/tr["+i+"]/td[1]/div/a");
					Thread.sleep(1000);
					//				System.out.println("Clicked" + x + "times");
				}
			}
		}
	}

	public void checkCounts()
	{
		String row_locator = influenceLocator.getLocator("Redirects.Row");
		int no_rows = getSize(row_locator);
		for (int i = 1; i<=no_rows; i++)
		{
			if(isTextPresent("//tbody/tr["+i+"]/td[1]/div/a", "Test Redirect created by Webdriver script execution"))
			{
				isTextPresent("//tbody/tr["+i+"]/td[3]", "6");
				//				System.out.println("count matched");
			}
		}


	}

	// ******** Delete Redirect Method **************

	public void deleteRedirect(String text)
	{
		String locator1 = influenceLocator.getLocator("Redirects.Row");
		int no_rows = getSize(locator1);
		for (int i = 1; i<=no_rows; i++)
		{
			//			System.out.println("inside loop");
			if(isElementPresent("//div[@class='table']/table/tbody/tr["+i+"]/td[1]/div/a[contains(text(), '"+text+"')]"))
			{	
				System.out.println("indide if");
				clickOn("//div[@class='table']/table/tbody/tr["+i+"]/td[4]/a[2]/img");
				acceptAlert();
				break;
			}
		}
	}

	// ******** Click on submit button ******************
	public void clickonSubmit()
	{
		String submitbtn_locator  = influenceLocator.getLocator("SubmitButton");
		clickOn(submitbtn_locator);
		waitForLoading();
	}

	//**************Method to verify the functionality of sending campaign preview****************//
	public void send_CampaignPreview() throws InterruptedException
	{
		String locator1=influenceLocator.getLocator("Campaigns.SendPreviewButton");
		clickOn(locator1);

		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.Email")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.FirstName")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.LastName")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.RemoveLink")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.AddRecipientbutton")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.SendButton")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.CancelButton")));


		int randomvalue=getRandomInteger(1,9);
		String locator3=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.Email");
		sendKeys(locator3,"test"+randomvalue+"@yopmail.com");

		String locator4=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.FirstName");
		sendKeys(locator4,"test"+randomvalue);

		String locator5=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.LastName");
		sendKeys(locator5,"test"+randomvalue);

		//Enter value for another recipients

		String locator2=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.AddRecipientbutton");
		clickOn(locator2);
		Thread.sleep(4000);		
		int randomvalue1=getRandomInteger(1,9);
		String locator6=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.Email1");
		sendKeys(locator6,"emailtest"+randomvalue1+"@yopmail.com");

		String locator7=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.FirstName1");
		sendKeys(locator7,"test"+randomvalue1);

		String locator8=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.LastName1");
		sendKeys(locator8,"test"+randomvalue1);

		String locator9=influenceLocator.getLocator("Campaigns.RecipientPreviewEmailDialog.SendButton");
		clickOn(locator9);	

	}

	//********************Method to verify the functionality of copy surveys****************************
	public void copySurvey() throws InterruptedException
	{
		int rowsize =getSize(influenceLocator.getLocator("Surveys.Row"));
		
		String name=getText("//table[contains(@class,'table table-striped survey-table')]/tbody/tr[1]/td[1]");
		
		String locator1 = influenceLocator.getLocator("Surveys.CopyButton");
		clickOn(locator1);
		
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.CurrentAccount")));
		
		String locator2 = influenceLocator.getLocator("Surveys.SubmitButton");
		clickOn(locator2);
		
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Surveys.SeleniumAccount")));
		String locator3 = influenceLocator.getLocator("Surveys.CopyStatus");
		clickOn(locator3);
		
		String locator4 = influenceLocator.getLocator("Surveys.CloseIcon");
		clickOn(locator4);
		
		for(int i=1;i<=rowsize;i++)
		{
			String copyname=getText("//table[contains(@class,'table table-striped survey-table')]/tbody/tr["+i+"]/td[1]");
			
			if(copyname.equals(name+" copy"))
			{	
				Assert.assertTrue(isElementPresent("//table[@class='table table-striped survey-table']/tbody/tr["+i+"]"));
				break;
			}	
		}

	}

	//**************Method to download customers in CSV file**************************//
	public void downloadCustomersCSV(String path) throws FindFailed, InterruptedException
	{

		String locator1 = influenceLocator.getLocator("Customers.DownLoadCsvButton");
		clickOn(locator1);

		String locator2 = influenceLocator.getLocator("Customers.DisabledDownloadBtn");
		this.WaitForElementNotPresent(locator2, 40);
		//Thread.sleep(9000);
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Customers.SuccessMsg")));
	    Thread.sleep(3000);
		try{

			String imgPath1 = path + "//images//Win8.1SaveFile.png";
			screen.click(imgPath1);
		}
		catch(Exception e)
		{				 
			System.out.println("Catch");

		}
		/*try{
			String  imgPath1 = path + "//images//SaveAsWin7.png";
			screen.click(imgPath1);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		} 
		try{

			String imgPath2 = path + "//images//OKWin7.png";
			screen.click(imgPath2);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		} */

		try{

			String imgPath2 = path + "//images//Win8.1OK.png";
			screen.click(imgPath2);
		}

		catch(Exception e)
		{				 
			System.out.println("Catch");

		}


	}

	//******Method to Get Surveys count on Survey page *******************//
	public int getSurveyCount()
	{
		String locator1 = influenceLocator.getLocator("Surveys.Row");
		int no_rows = getSize(locator1);
		return no_rows;

	}

	//Method to verify the name of all available widgets on influence dashboard page
	public void verifyWidgetsInfluenceDashboard(int count) throws InterruptedException
	{
		waitForLoading();
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Dashboard.InternalSurveysResponse")));
		//Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Dashboard.TransactionSummary")));
		//Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Dashboard.ActivityByMonth")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Dashboard.ReputationEngagement")));
		Assert.assertTrue(isElementPresent(influenceLocator.getLocator("Dashboard.DetailedSurveyResults")));

		//			//*********For moving page to bottom side**********//
		//			 JavascriptExecutor jse = (JavascriptExecutor)driver;
		//			 jse.executeScript("window.scrollBy(0,250)", "");

		//*******************//
		Thread.sleep(9000);
		int surveycount=getSize(influenceLocator.getLocator("Dashboard.DetailedSurveyCount"));
		//int aa=this.getSize("//div[@class='surveys ui-accordion ui-widget ui-helper-reset']/h3");
		System.out.println("Total Surveys:"+surveycount);
		System.out.println("Count:"+count);

		if(surveycount==count)
		{

			Assert.assertTrue(true, "Surveys matched");
		}

	}

	//*********Method to verify sorting functionality of Name column************************//
	public void sort_SurveyName()
	{
		 
		 String locator = influenceLocator.getLocator("Surveys.Events.EventsButton");
		 clickOn(locator);
		 waitForLoading();
		
		//Click on sort icon of name columns
		String locator1 = influenceLocator.getLocator("Surveys.Events.Name");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = influenceLocator.getLocator("Surveys.Events.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[1]");
			al1.add(str.substring(7));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(0).equals(al2.get(0));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[1]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}
	
	
	//*************Method to verify sorting functionality of Pre Survey Complete Date column on survey events page.**************************//
	public void sort_PreSurveyCompleteDate()
	{
		 String locator = influenceLocator.getLocator("Surveys.Events.EventsButton");
		 clickOn(locator);
		 waitForLoading();
		
		// click on sort icon of rating columns
		String locator1 = influenceLocator.getLocator("Surveys.Events.PreSurveyCompleteDate");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = influenceLocator.getLocator("Surveys.Events.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[2]");
			al1.add(str.substring(7));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(0).equals(al2.get(0));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[2]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
		
	}
	
	
	//****************Method to verify sorting functionality of survey complete date column**************************************//
	public void sort_SurveyCompleteDate()
	{
		 String locator = influenceLocator.getLocator("Surveys.Events.EventsButton");
		 clickOn(locator);
		 waitForLoading();
		
		// click on sort icon of rating columns
		String locator1 = influenceLocator.getLocator("Surveys.Events.SurveyCompleteDate");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = influenceLocator.getLocator("Surveys.Events.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[4]");
			al1.add(str.substring(7));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(0).equals(al2.get(0));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[4]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
		
		
	}
	
	//*****************Method to verify sorting functionality of Survey Start Date column***************************//
	public void sort_SurveyStartDate()
	{
		 String locator = influenceLocator.getLocator("Surveys.Events.EventsButton");
		 clickOn(locator);
		 waitForLoading();
		
		// click on sort icon of rating columns
		String locator1 = influenceLocator.getLocator("Surveys.Events.SurveyStartDate");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator2 = influenceLocator.getLocator("Surveys.Events.Row");
		int n_rows = getSize(locator2);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[3]");
			al1.add(str.substring(7));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(0).equals(al2.get(0));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//div[@id='data-wiselinks-container']//tbody/tr["+i+"]/td[3]");

			al2.add(str.substring(7));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

}

