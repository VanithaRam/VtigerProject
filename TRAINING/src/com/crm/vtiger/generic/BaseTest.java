package com.crm.vtiger.generic;

import java.io.File;
//import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;

public class BaseTest implements InterfaceAutoConst {
	
	public WebDriver driver;
	public WebDriverUtils wdu = new WebDriverUtils();
	public FileLibrary flib = new FileLibrary();
	HomePage hp = new HomePage(driver);
	public ExtentReports report;
	
	@BeforeSuite
	public void GenerateExtReport()
	{
	    report = new ExtentReports("./advanceReport.html");
		report.loadConfig(new File("./extent-config.xml"));
	}

	/*************Launch the browser********************/
	@BeforeClass(groups= {"smoke", "regression"})
	public void launchBrowser() throws IOException 
	{
		System.out.println("Launch the browser");
		String browser = flib.getDataFromProperties("browser");
		if(browser.equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
	}
	
	/***************Logging to Application**************************/
	@BeforeMethod(groups= {"smoke", "regression"})
	public void loginToApp() throws IOException
	{
		System.out.println("Logging to the application");
		String url = flib.getDataFromProperties("URL");
		String username = flib.getDataFromProperties("username");
		String password = flib.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		wdu.waitForElementToLoad(driver);
		wdu.maximizeTheWindow(driver);
		driver.get(url);
		lp.login(username, password);
	}
	
	/***************Logging out the Application*********************/
	@AfterMethod(groups= {"smoke", "regression"})
	public void logoutFromApp()
	{
		System.out.println("Logging out");	
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	/**************Closing the Browser*******************/
	@AfterClass(groups= {"smoke", "regression"})
	public void closeBrowser()
	{
		System.out.println("Closing the browser");
		driver.close();
	}
	
	@AfterSuite
	public void closeReport()
	{
		report.flush();
		report.close();
	}
}
