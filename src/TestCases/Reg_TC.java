package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ConfigFiles.Constants;
import ConfigFiles.XLHandlingMethods;
import TestModules.RegistrationActions;


public class Reg_TC {
	
	public WebDriver driver;
	
	@Parameters("Browser")
	@BeforeTest
	public void beforeexecution(String Browser)
	{
		if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",Constants.firefoxpath);
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Constants.chromepath);
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", Constants.IEPath);
			driver=new InternetExplorerDriver();
		}
	}
	
	@Test
	public void testmethod() throws IOException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		XLHandlingMethods.setfilepath(Constants.XLFilepath, Constants.SheetName);
		RegistrationActions.execute(driver);
	}
	
	@AfterTest
	public void afterexecution()
	{
		driver.close();
	}

}
