package com.w2a.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;

import com.w2a.utlitites.ExcelReader;
import com.w2a.utlitites.Utilties;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
//	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Logger log = Logger.getLogger(Page.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testData.xlsx");
	public static WebDriverWait wait;
	public static ExtentTest test;

	@SuppressWarnings("deprecation")
	public Page() {
		if (driver == null) {
			

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			log.debug("Config file loaded!!");
			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.debug("OR file loaded!!");
			
			
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\gecko.exe"); // if firefox
																											// verison
																											// is
																											// greater
																											// than 3
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
//				System.setProperty("webdriver.chrome.driver",
//						System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();

			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings_values_notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);

			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executable\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				log.debug("Chrome Launched!!!");
				
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("url is"+config.getProperty("testsiteurl"));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//			driver.get("http://automationpractice.com/index.php");
//			driver.manage().window().maximize();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
	public void click(String locator) {
		if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_Xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
			}
		else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
//		test.log(Status.INFO, "Clicking on "+locator);
		
	}
	public void type(String locator, String value) {
		if(locator.endsWith("_CSS")) {
		driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_Xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		
//		test.log(Status.INFO, "Typing in "+locator+"entered value as "+value);
}
	
	static WebElement dropdown;
	public void select(String locator,String value) {
		if(locator.endsWith("_CSS")) {
			    dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
			}
			else if(locator.endsWith("_Xpath")) {
			    dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
			}else if(locator.endsWith("_ID")) {
				dropdown=driver.findElement(By.id(OR.getProperty(locator)));
			}
		
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
	}
	
	
	public static void quit() {
		driver.quit();
	}
	
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public static void verifyEquals(String expected, String actual) {
		try {
			Assert.assertEquals(actual, expected);
		}catch(Throwable t){
			Utilties.captureScreenshot();
			//ReportNG
			Reporter.log("<br>"+"Verification failure:"+t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\" href="+Utilties.screenshotName+">Screenshot</a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			//extent reports
			//test.log(Status.FAIL, "verification failed with exception "+t.getMessage());
			
		}
	}

}
