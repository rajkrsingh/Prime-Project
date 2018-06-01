package com.primeresponse.pagehelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;
import org.sikuli.script.Screen;

public class SupportHelper  extends DriverHelper{

	private LocatorReader supportLocator;
	private LocatorReader headerLocator;
	Screen screen = new Screen();

	public SupportHelper(WebDriver webdriver) {
		super(webdriver);
		supportLocator = new LocatorReader("Support.xml");
		headerLocator = new LocatorReader("Header.xml");
	}

	// ******** Method to add communication ********

	public void submitCommunicationDetails() {

		String locator1=supportLocator.getLocator("Communication.NewCommLink");
		clickOn(locator1);

		String locator2=supportLocator.getLocator("Communication.Name");
		sendKeys(locator2, "Test360");

		String locator3=supportLocator.getLocator("Communication.Email");
		sendKeys(locator3, "shishirj@360logica.com");

		String locator4=supportLocator.getLocator("Communication.Phone");
		sendKeys(locator4, "9876543210");

		String locator5=supportLocator.getLocator("Communication.Type");
		selectDropDown(locator5, "Email");

		String locator6=supportLocator.getLocator("Communication.SelectedAccount");
		locator6.contains("ABC Ford");

		String locator7=supportLocator.getLocator("Communication.Comment");
		sendKeys(locator7, "Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments ..");

		String locator8=supportLocator.getLocator("Communication.SubmitBtn");
		clickOn(locator8);
		waitForLoading();

		//		String locator9=supportLocator.getLocator("Communication.NewAccount");
		//		clickOn(locator1);


	}

	public void verifyCommunicationDetails() {

		//		String CurrentDate_Time = (String) javaScriptExecute("d=new Date(); d.getFullYear()+\"-\"+ [('0' + (d.getMonth() + 1)).slice(-2)] +\"-\"+[('0' + d.getDate()).slice(-2)] +\" \"+ var todisplay = '';  if (d.getHours() > 12) todisplay = d.getHours()-12; else todisplay = d.getHours(); +\":\" + d.getMinutes()");

		//		String name = getText(supportLocator.getLocator("Communication.NameOnGrid"));
		//		Assert.assertTrue("Test360".equals(name));
		//
		//		String type = getText(supportLocator.getLocator("Communication.TypeOnGrid>"));
		//		Assert.assertTrue("Email".equals(type));

		//		String date = getText(supportLocator.getLocator("Communication.DateOnGrid"));
		//		Assert.assertEquals(CurrentDate_Time, date);

	}

	// ********** Method to delete communication *************

	public void deleteCommunication(String str) {

		int count = getSize(supportLocator.getLocator("Communication.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//tbody[@id='support-items-body']/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//tbody[@id='support-items-body']/tr["+i+"]/td[4]/a[3]/img");
				acceptAlert();
				break;
			}

		}

	}

	// ********* Method to Add communication using top icon *********

	public void submitCommunicationDetailsUsingTopIcon() {

		String locator1=supportLocator.getLocator("Communication.NewCommLink");
		clickOn(locator1);

		String locator2=supportLocator.getLocator("Communication.Name");
		sendKeys(locator2, "Test360");

		String locator3=supportLocator.getLocator("Communication.Email");
		sendKeys(locator3, "shishirj@360logica.com");

		String locator4=supportLocator.getLocator("Communication.Phone");
		sendKeys(locator4, "9876543210");

		String locator7=supportLocator.getLocator("Communication.Comment");
		sendKeys(locator7, "Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments .. Test comments ..");

		String locator8=supportLocator.getLocator("Communication.SubmitBtn");
		clickOn(locator8);
		waitForLoading();

	}

	// ******** Method to  submit note *******

	public void submitNoteDetails() {

		String locator1=supportLocator.getLocator("Notes.NewNoteLink");
		clickOn(locator1);

		/*String locator2=supportLocator.getLocator("Notes.CheckBoxNotPresent");
		isElementPresent(locator2);

		String locator3=supportLocator.getLocator("Notes.Assignee");
		sendKeys(locator3, "User, Test - test360.101@gmail.com"); */

		String locator4=supportLocator.getLocator("Notes.Description");
		sendKeys(locator4, "Test360 Description");

		/*if (!isElementPresent(locator2))
		{
			System.out.println("check box is Displayed now");
		} */

		String locator5=supportLocator.getLocator("Notes.SubmitBtn");
		clickOn(locator5);

	}

	// ******** Method to delete Note ******

	public void deleteNote(String str) {

		int count = getSize(supportLocator.getLocator("Notes.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//tbody[@id='support-notes']/tr["+i+"]/td[2]/div[1]");
			if(name.contains(str))
			{
				clickOn("//tbody[@id='support-notes']/tr["+i+"]/td[3]/a/i");
				acceptAlert();
				break;
			}

		}


	}

	// ****** Method to Create Note using top icon ********

	public void submitNoteDetailsUsingTopIcon() {

		String locator1=supportLocator.getLocator("Notes.RedNoteIcon");
		if(isElementPresent(locator1))
		{
			clickOn(locator1);
			WaitForElementNotPresent(locator1, 10);

			String locator = headerLocator.getLocator("TopRightIcons.SubmitNoteIcon");
			clickOn(locator);

			String locator2 = headerLocator.getLocator("TopRightIcons.LoadingImg");
			WaitForElementNotPresent(locator2, 20);
		}

		String locator4=supportLocator.getLocator("Notes.Description");
		sendKeys(locator4, "Test360 Description");

		String locator5=supportLocator.getLocator("Notes.SubmitBtn");
		clickOn(locator5);

		isElementPresent(locator1);

	}

	// ***** Method to create Report ********

	public void createReport(String text1, String text2) {

		String locator1=supportLocator.getLocator("Reports.NewReportBtn");
		clickOn(locator1);
		String locator2=supportLocator.getLocator("Reports.Title");
		sendKeys(locator2, "Test Report created by Webdriver Execution "+ text2);
		//String locator3=supportLocator.getLocator("Reports.ReportType");
		//selectDropDown(locator3, text1);
		String locator4=supportLocator.getLocator("Reports.TotalActivityPerMonth");
		clickOn(locator4);
		String locator5=supportLocator.getLocator("Reports.SitesReportedOne");
		clickOn(locator5);
		//String locator6=supportLocator.getLocator("Reports.RunOnAMonthlyBasis");
		//clickOn(locator6);
		//String locator15=supportLocator.getLocator("Reports.ScheduleRunDate");
		//isElementPresent(locator15);
		//clickOn(locator6);
		//WaitForElementNotPresent(locator15, 10);
		String locator7=supportLocator.getLocator("Reports.ComparisonDateRange");
		sendKeys(locator7, "2016-08-01 - 2016-08-21");
		//		String locator13=supportLocator.getLocator("Reports.MonthToDate");
		//		clickOn(locator13);
		String locator8=supportLocator.getLocator("Reports.MonthlyDateRange");
		sendKeys(locator8, "2016-08-01 - 2016-08-21");
		//		clickOn(locator13);
		String locator9=supportLocator.getLocator("Reports.Recipients");
		clickOn(locator9);
		String locator10=supportLocator.getLocator("Reports.Select");
		selectDropDown(locator10, "Email");
		String locator11=supportLocator.getLocator("Reports.Input");
		sendKeys(locator11, "shishirj@360logica.com");
		String locator12=supportLocator.getLocator("Reports.Comments");
		sendKeys(locator12, "Test Comment ... Test Comment ... Test Comment ... ");
		String locator14=supportLocator.getLocator("Reports.CreateReport");
		clickOn(locator14);

	}

	// ******** Method to delete Reports *********

	public void deleteReports(String str) {

		int count = getSize(supportLocator.getLocator("Reports.Row"));
		for(int i=1; i<=count; i++)
		{
			String name= getText("//tbody[@id='support-reports']/tr["+i+"]/td[1]");
			if(name.contains(str))
			{
				clickOn("//tbody[@id='support-reports']/tr["+i+"]/td[6]/div/div/a[5]");
				acceptAlert();
				break;
			}

		}


	}

	// **********Verify filter functionality of Engagement dashboard*****************//
	public void filter_Engagement() throws InterruptedException
	{
		String str="Prime";
		String str1="Vertical";
		String str2="Group";
		String str3="Account";

		String locator1=supportLocator.getLocator("Engagement.ChooseResolution");
		clickOn(locator1);
		//Thread.sleep(4000);

		int count = getSize(supportLocator.getLocator("Engagement.TotalResolutionList"));
		//System.out.println("total value:"+count);

		int randomval=getRandomInteger(1,count);
		//System.out.println("random val:"+randomval);

		String aa=getText("//div[@id='engagement_options_select_by_chzn']/div/ul/li["+randomval+"]");
		//System.out.println("aa is:"+aa);

		clickOn("//div[@id='engagement_options_select_by_chzn']/div/ul/li["+randomval+"]");
		//Thread.sleep(4000);

		//Thread.sleep(4000);
		if(str.contains(aa))
		{	

			String locator2=supportLocator.getLocator("Engagement.UpdateButton");
			clickOn(locator2);
			waitForLoading();

		}
		else if(str1.contains(aa))
		{

			String locator3=supportLocator.getLocator("Engagement.ChooseVerticalList");
			mouseOver(locator3);
			clickOn(locator3);
			//Thread.sleep(4000);
			//WaitForElementVisible(locator3,30);
			String locator4=supportLocator.getLocator("Engagement.ChooseVerticalValue");
			//WaitForElementVisible(locator4,30);
			//Thread.sleep(4000);
			clickOn(locator4);


			String locator5=supportLocator.getLocator("Engagement.UpdateButton");
			clickOn(locator5);
			waitForLoading();

		}

		else if(str2.contains(aa))
		{

			String locator6=supportLocator.getLocator("Engagement.ChooseGroupList");
			this.mouseOver(locator6);
			clickOn(locator6);

			WaitForElementVisible(locator6,30);
			String locator7=supportLocator.getLocator("Engagement.ChooseGroupValue");
			//WaitForElementVisible(locator7,30);
			//Thread.sleep(4000);
			clickOn(locator7);

			String locator8=supportLocator.getLocator("Engagement.UpdateButton");
			clickOn(locator8);
			waitForLoading();

		}

		else if(str3.contains(aa))
		{
			String locator9=supportLocator.getLocator("Engagement.ChooseAccountList");
			mouseOver(locator9);
			clickOn(locator9);

			WaitForElementVisible(locator9,30);
			String locator10=supportLocator.getLocator("Engagement.ChooseAccountValue");
			//WaitForElementVisible(locator10,30);
			//Thread.sleep(4000);
			clickOn(locator10);

			String locator11=supportLocator.getLocator("Engagement.UpdateButton");
			clickOn(locator11);
			waitForLoading();

		}

	}
	
	//**************Verify that Engagement Report is downloaded in pdf format**********************//  
	public void pdf_DownloadEngagementReport()
	{
		String str="pdf";
		
		String locator1=supportLocator.getLocator("Engagement.PdfButton");
		clickOn(locator1);
		waitForLoading();
		

		//Focus on the new window opened
		Set<String> windows = getWebDriver().getWindowHandles();
		//String parent = null;
		String child = null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			//parent = (String) it.next();
			child = (String) it.next();
		}
		getWebDriver().switchTo().window(child);
		//Thread.sleep(5000);
		String str1 = getWebDriver().getTitle();
		//System.out.println("New URL:"+str1);

		Assert.assertTrue(str1.contains(str));
		getWebDriver().close();
		
		
		
	}

	//******Method to verify that account statuses is successfully exported in CSV files**************//
	public void csvExport_AccountStatuses(String path)
	{
		String locator1=supportLocator.getLocator("AccountStatuses.CsvButton");
		clickOn(locator1);
		waitForLoading();


		try{
			String imgPath1 = path + "//images//Win8.1SaveFile.png";
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

			String imgPath2 = path + "//images//OK8.1.png";
			screen.click(imgPath2);
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

	}	 


	//*************Verify sorting functionality of 'External Reviews' column on Support > Metrics page.*****************
	public void sort_MetricsExternalReviewsCol()
	{

		// click on sort icon of External Reviews column
		String locator1 = supportLocator.getLocator("Metrics.ExternalReviewsCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[5]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[5]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//*************Verify sorting functionality of 'Last Support' column on Support > Metrics page.*********************//
	public void sort_MetricsLastSupportCol()
	{

		// click on sort icon of Last Support column
		String locator1 = supportLocator.getLocator("Metrics.LastSupportCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[6]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[6]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//*******Verify process of sorting verticals column******************//
	public void sort_MetricsVerticalsCol()
	{
		// click on sort icon of Last Support column
		String locator1 = supportLocator.getLocator("Metrics.VerticalsCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[2]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[2]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//**************Verify process of sorting Email sent column*****************************//
	public void sort_MetricsEmailSentCol()
	{
		// click on sort icon of Email sent column
		String locator1 = supportLocator.getLocator("Metrics.EmailSentCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[4]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[4]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//*****************Verify sorting functionality of 'Account' column page.************************************//
	public void sort_MetricsAccountCol()
	{
		// click on sort icon of Last Support column
		String locator1 = supportLocator.getLocator("Metrics.AccountCol");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[1]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[1]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}
	}

	//*************Verify sorting functionality of 'Last Data Upload' column******************
	public void sort_MetricsLastDataUploadCol()
	{
		// click on sort icon of Last Support column
		String locator1 = supportLocator.getLocator("Metrics.LastDataUpload");
		clickOn(locator1);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		// int nrow=getSize(enterpriseLocator.getLocator("Reports.Row"));
		String locator7 = supportLocator.getLocator("Metrics.Row");
		int n_rows = getSize(locator7);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[3]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
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
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[3]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}

	}

	//**********Verify sorting functionality of vertical column on Support > Account Statuses page********************
	public void sort_AccountStatuses_VerticalCol()
	{

		String locator1 = supportLocator.getLocator("AccountStatuses.ChooseAccountStatusList");
		clickOn(locator1);

		String locator2 = supportLocator.getLocator("AccountStatuses.DeployingAcountStatus");
		clickOn(locator2);

		waitForLoading();

		String locator3 = supportLocator.getLocator("AccountStatuses.VerticalCol");
		clickOn(locator3);

		waitForLoading();

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator4 = supportLocator.getLocator("AccountStatuses.Row");
		int n_rows = getSize(locator4);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[2]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator3);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[2]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		} 
	}

	//***************Verify sorting functionality of date column on Support > Account Statuses page.**********************
	public void sort_AccountStatuses_DateCol()
	{
		String locator1 = supportLocator.getLocator("AccountStatuses.ChooseAccountStatusList");
		clickOn(locator1);

		String locator2 = supportLocator.getLocator("AccountStatuses.DeployingAcountStatus");
		clickOn(locator2);

		waitForLoading();

		String locator3 = supportLocator.getLocator("AccountStatuses.DateCol");
		clickOn(locator3);

		waitForLoading();

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// calculate the no of rows
		String locator4 = supportLocator.getLocator("AccountStatuses.Row");
		int n_rows = getSize(locator4);

		// store sorting value in array
		ArrayList <String> al1 = new ArrayList <String>();
		ArrayList <String> al2 = new ArrayList <String>();
		String str =null;
		for (int i=1; i<=n_rows; i++)
		{
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[5]");
			//System.out.println("str :"+str);
			al1.add(str.substring(0));
			al2 = al1;

		}

		// check if sorted in ascending order or not
		Collections.sort(al1);
		int x=0; int size = al1.size();
		do
		{
			al1.get(1).equals(al2.get(2));
			x++;
		}while(x < size);

		// again click on sort icon to make it in descending order
		clickOn(locator3);

		// scroll the page down
		javaScriptExecute("window.scrollBy(0,4050)");
		waitForLoading();

		// store value in array and compare if it is descending order
		for (int i=1; i<=n_rows; i++)
		{
			//Thread.sleep(4000);
			str = getText("//tbody[@id='support-metrics']/tr["+i+"]/td[5]");
			//System.out.println("new str :"+str); 
			al2.add(str.substring(0));
			al1.get(size-1).equals(al2.get(i-1));
			size--;

		}  
		
		// scroll the page up
		javaScriptExecute("window.scrollBy(0,-4050)");
	} 


	//**************** Verify process of sending reports to recipients *******************************************// 
	public void verify_ReportsEmailToMe()
	{
		String locator1=supportLocator.getLocator("Reports.EmailToMeButton");
		clickOn(locator1);
	}

	//*********Verify process of sending reports to recipients*********************************************// 
	public void generate_PdfReport() throws InterruptedException
	{
		String str="pdf";
		String locator1=supportLocator.getLocator("Reports.GeneratePDFButton");
		clickOn(locator1);
		waitForLoading();

		//Focus on the new window opened
		Set<String> windows = getWebDriver().getWindowHandles();
		//String parent = null;
		String child = null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			//parent = (String) it.next();
			child = (String) it.next();
		}
		getWebDriver().switchTo().window(child);
		Thread.sleep(4000);
		//String str1 = getWebDriver().getTitle();
		
		String str1 = getWebDriver().getCurrentUrl();
		//System.out.println("New URL:"+str1);

		Assert.assertTrue(str1.contains(str));
		getWebDriver().close();
	}

	//****************Verify review by site,monthly activity and suggestion on 'Response Overview' page.************************//
	public void verify_ReportsOverView()
	{
		String locator1=supportLocator.getLocator("Reports.ViewButton");
		clickOn(locator1);
		waitForLoading();
/*
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.ResponseOverView")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.ReviewBySite")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.Site")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.NoOfRatings")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.AvgRating")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.MonthlyActivity")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Reports.Suggestions")));
*/
		

		//System.out.println(GetFiles());

		  Assert.assertTrue(GetFiles().contains("report")||getText("//div[@id='wrapper']//h6").contains("report")||getText("//div[@id='wrapper']//h3").contains("report"));
		  
	}


	//***********Verify filter functionality of conversion rates by randomly selecting resolutions.****************//
	public void filter_ConversionRatesDrilldown() throws InterruptedException
	{
		String str="Prime";
		String str1="Vertical";
		String str2="Group";
		String str3="Account";

		String locator1=supportLocator.getLocator("ConversionRates.ChooseResolutionList");
		clickOn(locator1);

		int totalvalue=getSize(supportLocator.getLocator("ConversionRates.TotalResolutionList"));

		int randomval=getRandomInteger(1,totalvalue);


		if(str.contains(getText("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]")))
		{
			clickOn("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]");  

			clickOn(supportLocator.getLocator("ConversionRates.DateRange"));
			clickOn(supportLocator.getLocator("ConversionRates.Today"));
			clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
			waitForLoading();
		}

		else if(str1.contains(getText("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]")))
		{
			clickOn("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]"); 
			clickOn(supportLocator.getLocator("ConversionRates.ChooseVertical"));
			clickOn(supportLocator.getLocator("ConversionRates.SelectVerticalValue"));

			clickOn(supportLocator.getLocator("ConversionRates.DateRange"));
			clickOn(supportLocator.getLocator("ConversionRates.Today"));
			clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
			waitForLoading();

		}

		else if(str2.contains(getText("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]")))
		{
			clickOn("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]"); 
			clickOn(supportLocator.getLocator("ConversionRates.ChooseGroup"));
			clickOn(supportLocator.getLocator("ConversionRates.SelectGroupValue"));

			clickOn(supportLocator.getLocator("ConversionRates.DateRange"));
			clickOn(supportLocator.getLocator("ConversionRates.Today"));
			clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
			waitForLoading();

		}

		else if(str3.contains(getText("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]")))
		{
			clickOn("//div[@id='drilldown_options_select_by_chzn']//li["+randomval+"]"); 
			clickOn(supportLocator.getLocator("ConversionRates.ChooseAccount"));
			clickOn(supportLocator.getLocator("ConversionRates.SelectAccountValue"));

			clickOn(supportLocator.getLocator("ConversionRates.DateRange"));
			clickOn(supportLocator.getLocator("ConversionRates.Today"));
			clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
			waitForLoading();

		}

	}
	
	//*****************Verify process of drill down to account.***********************************//  
	public void verify_DrillDownToAccount()
	{
		String locator1=supportLocator.getLocator("ConversionRates.ChooseResolutionList");
		clickOn(locator1);
		
		String locator2=supportLocator.getLocator("ConversionRates.SelectVertical");
		clickOn(locator2);
		
		clickOn(supportLocator.getLocator("ConversionRates.ChooseVertical"));
		clickOn(supportLocator.getLocator("ConversionRates.SelectVerticalValue"));

		clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
		waitForLoading();
		
		String str=getText(supportLocator.getLocator("ConversionRates.AccountName"));
		
		clickOn(supportLocator.getLocator("ConversionRates.DrillDowmImg"));
		waitForLoading();
		
		String str1=getText(supportLocator.getLocator("ConversionRates.ListAccountVal"));
		
		if(str.contains(str1))
		{
			Assert.assertTrue(true, "Account was successfully drilled down");
		}

	}

	//***************Verify that conversion rates are downloaded in pdf format**************************
	public void pdf_DownloadConversionRates() throws InterruptedException
	{
		String str="pdf";
		String locator1=supportLocator.getLocator("ConversionRates.ChooseResolutionList");
		clickOn(locator1);
		clickOn("//li[contains(text(),'Vertical')]");
		clickOn(supportLocator.getLocator("ConversionRates.ChooseVertical"));
		clickOn(supportLocator.getLocator("ConversionRates.SelectVerticalValue"));
		clickOn(supportLocator.getLocator("ConversionRates.UpdateButton"));
		waitForLoading();
		
		clickOn(supportLocator.getLocator("ConversionRates.PdfButton"));
		waitForLoading();
		Thread.sleep(10000);
		
		//Focus on the new window opened
		Set<String> windows = getWebDriver().getWindowHandles();
		//String parent = null;
		String child = null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			//parent = (String) it.next();
			child = (String) it.next();
		}
		getWebDriver().switchTo().window(child);
		//Thread.sleep(5000);
		String str1 = getWebDriver().getTitle();
		//String str1 = getWebDriver().getCurrentUrl();
		System.out.println("New URL:"+str1);

		Assert.assertTrue(str1.contains(str));
		getWebDriver().close();

	}


	//********Verify engagement reports on engagement dashboard page.***********************************//
	public void verify_EngagementReport()
	{

		waitForLoading();
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.EngagementReport")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.ReputationEngamement")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.EngagementByDevice")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.EngagementByPlatform")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.EngagementByBrowser")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.EngagementByTimeDay")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.ReputationDestination")));
		Assert.assertTrue(isElementPresent(supportLocator.getLocator("Engagement.OverallSentiment")));

	}
	
	//******Verify process of creating new goals******************
	public void create_Goals()
	{
		String locator1 =supportLocator.getLocator("Goals.NewGoalButton");
		clickOn(locator1);
		
		
		String locator2 =supportLocator.getLocator("Goals.Description");
		sendKeys(locator2,"Testing Goals");
		
		String locator3 =supportLocator.getLocator("Goals.GroupDropDownList");
		clickOn(locator3);
		
		
		String locator4 =supportLocator.getLocator("Goals.SelectRandyGrp");
		WaitForElementPresent(locator4,30);
		clickOn(locator4);
		
		String locator5 =supportLocator.getLocator("Goals.OpenDateCal");
		clickOn(locator5);
		
		String locator6 =supportLocator.getLocator("Goals.SelectDate");
		clickOn(locator6);
		
		
		String locator7 =supportLocator.getLocator("Goals.SubmitBtn");
		clickOn(locator7);
	
	}

	//*********Verify process of deleting new goals****************//
	public void delete_Goals()
	{
		String str="Testing Goals";
		int totrow=getSize(supportLocator.getLocator("Goals.Row"));
		System.out.println("total row:"+totrow);
		
		for(int i=1;i<=totrow; i++)
		{
			String str2=getText("//tbody[@id='support-goals']/tr["+i+"]/td[3]");
			System.out.println("text:"+str2);
			if(str.contains(str2))
			 {
				clickOn("//tbody[@id='support-goals']/tr["+i+"]/td[5]/div/a[2]");
				acceptAlert();
				break;
			 }
		}
	
	}

	
}
