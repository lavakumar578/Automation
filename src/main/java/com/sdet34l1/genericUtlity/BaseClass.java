package com.sdet34l1.genericUtlity;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This class  is  used to get the common annotations
 * @author LAVA KUMAR
 * Super Most Class
 */
public class BaseClass {

	public WebDriver driver;
	public JavaLangUtility javaLangUtility;
	public long longTimeOut;
	public int randomNum;
	public String username;
	public String password;
	public String url;
	public String browser;
	public DriverUtility driverUtility; 
	public static WebDriver staticdriver;
	
	/**
	 * This annotation is used to open Excel and Property file
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuite() throws IOException
	{
		PropertiesUtility.openPropertyFile(ILocation.PROPERTYPATH);
		XlsxUtility.openExcel(ILocation.EXCELPATH);		
	}
	/**
	 * This annotation is used to close the excel file
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuiteTest() throws IOException
	{
		XlsxUtility.setDataToExcel(ILocation.EXCELPATH);
		XlsxUtility.closeExcel();
	}
	
	
	/**
	 * This annotation is used to get common data from propertyfile
	 * create instance for all generic utilities
	 */
	@BeforeClass(groups="baseclass")
	public void beforeClassTest()
	{
		javaLangUtility=new JavaLangUtility();
		XlsxUtility.openDataFormtter();
		String timeout=PropertiesUtility.getDataFromProperty("timeOut");
		longTimeOut=javaLangUtility.stringToLong(timeout);
		randomNum=javaLangUtility.getRandomNumber(1000);
		url=PropertiesUtility.getDataFromProperty("url");
		browser=PropertiesUtility.getDataFromProperty("browser");
		switch(browser)
		{
		case "chrome":
			{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			}
		case "edge":
			{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			}
		case "firefox":
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		}
		}
		
		staticdriver=driver;
		driverUtility = new DriverUtility(driver);
		DriverUtility.navigateApp(url, driver);
		DriverUtility.browserSetting(driver, longTimeOut);
		
		driverUtility.intiallizeAction(driver);

	}
	/**
	 *This annotation is used to logout
	 * @throws IOException 
	 */
	@AfterClass(groups="baseclass")
	public void afterClassTest() throws IOException
	{
		DriverUtility.quitBrowser(driver);
	}
	
	
	
	
}
