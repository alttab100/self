package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPageObjects {
	
	public static WebElement element;
	public static List<WebElement> elements;
	public static WebDriverWait wait;
	
	public static WebElement RegButton(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='menu-item-374']"));
		return element;
	}
	
	public static WebElement firstname(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='name_3_firstname']"));
		return element;
	}

	public static WebElement lastname(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='name_3_lastname']"));
		return element;
	}
	
	public static WebElement MaritalStatus(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[2]/div/div/input[1]"));
		return element;
	}
	
	public static WebElement Hobby(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div/input[1]"));
		return element;
	}
		
	public static WebElement countryele(WebDriver driver)
	{
		element=driver.findElement(By.xpath(".//*[@id='dropdown_7']"));
		return element;
	}
	
	public static WebElement DOB_Monthele(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='mm_date_8']"));
		return element;
	}
	
	public static WebElement DOB_DDele(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='dd_date_8']"));
		return element;
	}

	public static WebElement DOB_YYele(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='yy_date_8']"));
		return element;
	}
	
	public static WebElement PhoneNumber(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='phone_9']"));
		return element;
	}
	
	public static WebElement UserName(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='username']"));
		return element;
	}
	
	public static WebElement EmailID(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='email_1']"));
		return element;
	}
	
	public static WebElement AboutYourself(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='description']"));
		return element;
	}
	
	public static WebElement Password(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='password_2']"));
		return element;
	}
	
	public static WebElement ConfirmPassword(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='confirm_password_password_2']"));
		return element;
	}
	
	public static WebElement Submitbutton(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		element = driver.findElement(By.name("pie_submit"));
		return element;
	}
	
	public static WebElement FirstlastNameAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[1]/div[1]/div[2]/span"));
		return element;
	}

	public static WebElement HobbyAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[3]/div/div[2]/span"));
		return element;
	}
	
	public static WebElement PhoneNumebrAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[6]/div/div/span"));
		return element;
	}
	
	public static WebElement UserNameAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[7]/div/div/span"));
		return element;
	}
	
	public static WebElement EmailIDAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[8]/div/div/span"));
		return element;
	}
	
	public static WebElement PassworddAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[11]/div/div/span"));
		return element;
	}
	
	public static WebElement ConfirmPasswordAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='pie_register']/li[12]/div/div/span"));
		return element;
	}

	public static WebElement SuccessMessage(WebDriver driver)
	{
		element = driver.findElement(By.xpath(".//*[@id='post-49']/div/p"));
		return element;
	}
	
	public static WebDriverWait wait(WebDriver driver, String Xpathexp)
	{
		wait=new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpathexp)));
		return wait;
	}
}
