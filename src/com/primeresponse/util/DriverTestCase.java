package com.primeresponse.util;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.primeresponse.pagehelper.HeaderHelper;
import com.primeresponse.pagehelper.LoginHelper;

public abstract class DriverTestCase {

	enum DriverType {
		Firefox, IE, Chrome, PhantomJS
	}

	// Define objects
	public WebDriver driver;
	protected LoginHelper loginHelper;
	protected HeaderHelper headerHelper;

	// Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	// Define variables
	protected java.lang.String applicationUrl = propertyReader.readApplicationFile("Application-URL");
	protected String userEmail;
	String password;
	

	@BeforeClass
	public void setUp() {
		String driverType = propertyReader.readApplicationFile("BROWSER");

		if (DriverType.Firefox.toString().equals(driverType)) {
			// initialize FirefoxDriver
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//driver = new FirefoxDriver();
			
			driver = new FirefoxDriver();
		}

		else if (DriverType.IE.toString().equals(driverType)) {
			// File file = new File("E:/Jar_Files/IEDriverServer.exe");
			// System.setProperty("webdriver.ie.driver",
			// file.getAbsolutePath());
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
		} else if (DriverType.Chrome.toString().equals(driverType)) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		// Maximize window
		//driver.manage().window().maximize();

		// Delete cookies
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void afterMainMethod() throws InterruptedException {
	  //driver.quit();
		driver.close();
	}

	// login to the application
	public void login(String userType) {

		loginHelper = new LoginHelper(this.getWebDriver());
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		userEmail = propertyReader
				.readApplicationFile(userType + "_Email");
		password = propertyReader.readApplicationFile(userType
				+ "_Password");
		loginHelper.enterUserID(userEmail);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		loginHelper.enterPassword(password);
		loginHelper.clickLogin();
		headerHelper.checkSuccessMessage("Signed in successfully.");

	}

	// Select 'Selenium Test' account if its not selected
	public void selectAccount() {

		loginHelper = new LoginHelper(getWebDriver());

		String account = propertyReader.readApplicationFile("Account");
		//System.out.println("ACCCCCount Value:"+account);
		//loginHelper.selectAccount(account);
		
		//change raj on 7th sept
		loginHelper.selectAccountttt(account);
		headerHelper.checkSuccessMessage("You are now logged into "+account+".");
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	// Handle child windows
	public String switchPreviewWindow() {
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}

	// Get random integer
	public int getRandomInteger(int aStart, int aEnd) {
		Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	// Get random string
	public String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// Get absolute path
	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	// Get current timestamps 
	public Timestamp getCurrentTimeStamp() {

		java.util.Date date= new java.util.Date();
		Timestamp current_timeStamp = (new Timestamp(date.getTime()));
		return current_timeStamp;
	}


	// Get absolute path
	public String getPathUpload() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "/");
		return path;
	}
	
	

	// Switch frame
	public void switchFrame(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			getWebDriver().switchTo().frame(arr[i]);
		}
	}

	// capturing screenshot
	public void captureScreenshot(String fileName) {
		try {
			String screenshotName = this.getFileName(fileName);
			FileOutputStream out = new FileOutputStream("screenshots//"
					+ screenshotName + ".jpg");
			out.write(((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES));
			out.close();
			String path = getPath();
			String screen = "file://" + path + "/screenshots/" + screenshotName
					+ ".jpg";
			Reporter.log("<a href= '" + screen + "'target='_blank' >"
					+ screenshotName + "</a>");
		} catch (Exception e) {

		}
	}

	// Creating file name
	public String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}
}
