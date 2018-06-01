package com.primeresponse.pagehelper;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.primeresponse.locators.LocatorReader;
import com.primeresponse.util.DriverHelper;

public class TrainingHelper extends DriverHelper {

	private LocatorReader trainingLocator;
	private LocatorReader headerLocator;

	public TrainingHelper(WebDriver driver) {
		super(driver);

		trainingLocator = new LocatorReader("Training.xml");
		headerLocator = new LocatorReader("Header.xml");
	}

	//**********Verify process of creating new page**************************** 
	public void create_NewPage()
	{
		String locator1=trainingLocator.getLocator("Training.NewPage.NewPageLink");
		clickOn(locator1);

		String locator2=trainingLocator.getLocator("Training.NewPage.Title");
		sendKeys(locator2,"Test");

		String locator3=trainingLocator.getLocator("Training.NewPage.Source");
		clickOn(locator3);

		String locator4=trainingLocator.getLocator("Training.NewPage.TextArea");
		sendKeys(locator4,"writing in text area");

		String locator5=trainingLocator.getLocator("Training.NewPage.RolesList");
		clickOn(locator5);

		String locator6=trainingLocator.getLocator("Training.NewPage.RolesValue");
		clickOn(locator6);

		String locator7=trainingLocator.getLocator("Training.NewPage.CategoryList");
		clickOn(locator7);

		String locator8=trainingLocator.getLocator("Training.NewPage.CategoryValue");
		clickOn(locator8);

		String locator9=trainingLocator.getLocator("Training.NewPage.Submitbutton");
		clickOn(locator9);

	}

	//*********Verify process of deleting already created new page on Training section*******************//
	public void delete_NewPage()
	{
		String str="Test";
		int totalval=getSize(trainingLocator.getLocator("Training.NewPage.TotalTitle"));
		//System.out.println("total val="+totalval);

		for(int i=1;i<=totalval;i++)
		{
			if(str.equals(getText("//div[@id='data-wiselinks-container']//div["+i+"]/h1/a")))
			{
				clickOn(trainingLocator.getLocator("Training.NewPage.DeleteLink"));
				acceptAlert();
				break;
			}
		}

	}

	//********Verify process of creating new page**********************// 
	public void pdf_DownloadFaq()
	{

		String str="pdf";
		String locator1=trainingLocator.getLocator("Training.Faq.FaqLink");
		clickOn(locator1);
		waitForLoading();

		String locator2=trainingLocator.getLocator("Training.Faq.ClickingHereLink");
		clickOn(locator2);
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

	//***************Verify process of creating new page***************************************// 
	public void create_Category()
	{
		String locator1=trainingLocator.getLocator("Training.NewCategory.NewCategoryLink");
		clickOn(locator1);

		String locator2=trainingLocator.getLocator("Training.NewCategory.Name");
		sendKeys(locator2,"Test360 Training");

		String locator3=trainingLocator.getLocator("Training.NewCategory.Submitbutton");
		clickOn(locator3);
	}

	//**************Verify process of creating new page********************************// 
	public void verify_WebinarRedirectSameUrl()
	{
		String locator1=trainingLocator.getLocator("Training.Webinars.WebinarsLink");
		clickOn(locator1);

		String str=getAttribute(trainingLocator.getLocator("Training.Webinars.RecordingUrl"),"href");
		//System.out.println("Site url:"+str);
		
		String[] newstr=str.split("http://");
		String newstr1=newstr[1];
				
		String[] newstr123=newstr1.split("/");
		String newstr1234=newstr123[0];
		//System.out.println("newstr1234:"+newstr1234);
			
		//System.out.println("new site url:"+newstr1);
		
		String locator2=trainingLocator.getLocator("Training.Webinars.RecordingUrl");
		clickOn(locator2);
		waitForLoading();

		//Focus on the new window opened
		Set<String> windows = getWebDriver().getWindowHandles();
		String parent = null;
		String child = null;
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			parent = (String) it.next();
			child = (String) it.next();
		}
		getWebDriver().switchTo().window(child);
		//Thread.sleep(5000);
		String url12 = getWebDriver().getCurrentUrl();
		//System.out.println("New URL:"+url12);
		
		String[] newstr12=url12.split("https://");
		String newstr122=newstr12[1];
		//System.out.println("Site url122:"+newstr122);
		
		String[] newstr11=newstr122.split("/");
		String newstr111=newstr11[0];
		//System.out.println("Site newstr111:"+newstr111);
		Assert.assertTrue(newstr1234.contains(newstr111));
		getWebDriver().close();

		//Switch back to main window
		getWebDriver().switchTo().window(parent);
	}
	
	//Verify process of creating new page 
	public void pdf_DownloadRecommendedGuideLine()
	{
		String str="pdf";
		String locator1=trainingLocator.getLocator("Training.RecommendedGuidelines.RecommendedGuidelinesLink");
		clickOn(locator1);
		waitForLoading();

		String locator2=trainingLocator.getLocator("Training.RecommendedGuidelines.ClickHereLink");
		clickOn(locator2);
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
	
	//**************Verify filter of Tags by Search************************************************** 
	public void verify_SearchByTags()
	{
		String locator1=trainingLocator.getLocator("Training.SearchByTags.SearchTagsTextField");
		sendKeys(locator1,"te");
		waitForLoading();
        
		String locator2=trainingLocator.getLocator("Training.SearchByTags.SelectTags");
        clickOn(locator2);
        waitForLoading();
	}
}

