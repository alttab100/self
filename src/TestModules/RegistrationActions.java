package TestModules;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import ConfigFiles.Constants;
import ConfigFiles.ScreencastCapturing;
import ConfigFiles.XLHandlingMethods;
import PageObjects.RegistrationPageObjects;

public class RegistrationActions {

	public static int country_count;
	public static String country_text;
	public static int DOB_Month_count;
	public static String DOB_Month_text;
	public static int DOB_Day_count;
	public static String DOB_Day_text;
	public static int DOB_Year_count;
	public static String DOB_Year_text;
	public static String firstname;
	public static String lastname;
	public static String country;
	public static String DOB_month;
	public static String DOB_Day;
	public static String DOB_year;
	public static String phonenumebr;
	public static String username;
	public static String emailid;
	public static String aboutyourself;
	public static String password;
	public static String confirmpassword;

	public static void execute(WebDriver driver) throws IOException {
		// Verify Registration Button exist in the Web Page
		try {
			Reporter.log("Verify whether the registration buttion is displayed at right pannel top");
			Assert.assertEquals(RegistrationPageObjects.RegButton(driver).isDisplayed(), true);
			Reporter.log("Registration buttion is successfully displayed at right pannel top");
			ScreencastCapturing.Snapshot(driver, "RegistartionButton_Pass");
		} catch (Exception e) {
			Reporter.log("Registration buttion is not displayed at right pannel top" + e);
			ScreencastCapturing.Snapshot(driver, "RegistartionButton_Fail");
		}

		// Clicking Registration Button
		try {
			RegistrationPageObjects.RegButton(driver).click();
			Reporter.log("Registration buttion is successfully clicked at right pannel top");
			ScreencastCapturing.Snapshot(driver, "RegistartionButton_Clicked");
		} catch (Exception e) {
			Reporter.log("Registration buttion is not clicked at right pannel top" + e);
			ScreencastCapturing.Snapshot(driver, "RegistartionButton_NotClicked");
		}

		// Verify the alert messages for all the mandatory fields
		try {
			RegistrationPageObjects.Submitbutton(driver).click();
			Reporter.log("Without enter values in all the fields and clicked on submit button successfully");
			Assert.assertEquals(RegistrationPageObjects.FirstlastNameAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Assert.assertEquals(RegistrationPageObjects.PhoneNumebrAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Assert.assertEquals(RegistrationPageObjects.UserNameAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Assert.assertEquals(RegistrationPageObjects.EmailIDAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Assert.assertEquals(RegistrationPageObjects.PassworddAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Assert.assertEquals(RegistrationPageObjects.ConfirmPasswordAlert(driver).getText(),
					Constants.MandatoryAlertMessage);
			Reporter.log("Mandatory fields alert messages are successfully displayed");
			ScreencastCapturing.Snapshot(driver, "RegistartionAlertMessage_Displayed");
		} catch (Exception e) {
			Reporter.log("Mandatory fields alert messages are not successfully displayed" + e);
			ScreencastCapturing.Snapshot(driver, "RegistartionAlertMessage_NotDisplayed");
		}

		/*// Entering the values in the Registration form by directly
		try {
			Reporter.log("Enter values in all the fields and clicked on submit button successfully");
			RegistrationPageObjects.firstname(driver).sendKeys("Testersss");
			RegistrationPageObjects.lastname(driver).sendKeys("seleniumss");
			RegistrationPageObjects.MaritalStatus(driver).click();
			RegistrationPageObjects.Hobby(driver).click();
			Select countries = new Select(RegistrationPageObjects.countryele(driver));
			countries.selectByVisibleText("India");
			Select DOB_Months = new Select(RegistrationPageObjects.DOB_Monthele(driver));
			DOB_Months.selectByVisibleText("1");
			Select DOB_Days = new Select(RegistrationPageObjects.DOB_DDele(driver));
			DOB_Days.selectByVisibleText("1");
			Select DOB_years = new Select(RegistrationPageObjects.DOB_YYele(driver));
			DOB_years.selectByVisibleText("2014");
			RegistrationPageObjects.PhoneNumber(driver).sendKeys("9876543210");
			RegistrationPageObjects.UserName(driver).sendKeys("mayswttrad");
			RegistrationPageObjects.EmailID(driver).sendKeys("mays@mays.com");
			RegistrationPageObjects.AboutYourself(driver).sendKeys("testingjobss");
			RegistrationPageObjects.Password(driver).sendKeys("Sriramajayam@1989");
			RegistrationPageObjects.ConfirmPassword(driver).sendKeys("Sriramajayam@1989");
			RegistrationPageObjects.wait(driver,".//*[@id='pie_register']/li[14]/div/input");
			RegistrationPageObjects.Submitbutton(driver).click();
			Reporter.log("Successfully Clicked on submit button");
			Reporter.log("Registration done successfully");
			ScreencastCapturing.Snapshot(driver, "RegistartionSuccess");
		} catch (Exception e) {
			Reporter.log("Registration Not done successfully" + e);
			ScreencastCapturing.Snapshot(driver, "RegistartionNotSuccess");
		}
*/
		// Entering the values in the Registration form using XLS file
		try {
			Reporter.log("Enter values in all the fields and clicked on submit button successfully");

			int rowcount = XLHandlingMethods.rowcount();
			System.out.println("rowcount" + rowcount);
			for (int k = 1; k < rowcount + 1; k++) {

				firstname = XLHandlingMethods.readdata(k, 1);
				RegistrationPageObjects.firstname(driver).sendKeys(firstname);

				lastname = XLHandlingMethods.readdata(k, 2);
				RegistrationPageObjects.lastname(driver).sendKeys(lastname);

				RegistrationPageObjects.MaritalStatus(driver).click();
				RegistrationPageObjects.Hobby(driver).click();

				country = XLHandlingMethods.readdata(k, 3);
				Select countries = new Select(RegistrationPageObjects.countryele(driver));
				countries.selectByVisibleText(country);

				DOB_month = XLHandlingMethods.readdata(k, 4);
				Select DOB_Months = new Select(RegistrationPageObjects.DOB_Monthele(driver));
				DOB_Months.selectByVisibleText(DOB_month);

				DOB_Day = XLHandlingMethods.readdata(k, 5);
				Select DOB_Days = new Select(RegistrationPageObjects.DOB_DDele(driver));
				DOB_Days.selectByVisibleText(DOB_Day);

				DOB_year = XLHandlingMethods.readdata(k, 6);
				Select DOB_years = new Select(RegistrationPageObjects.DOB_YYele(driver));
				DOB_years.selectByVisibleText(DOB_year);

				phonenumebr = XLHandlingMethods.readdata(k, 7);
				RegistrationPageObjects.PhoneNumber(driver).sendKeys(phonenumebr);

				username = XLHandlingMethods.readdata(k, 8);
				RegistrationPageObjects.UserName(driver).sendKeys(username);

				emailid = XLHandlingMethods.readdata(k, 9);
				RegistrationPageObjects.EmailID(driver).sendKeys(emailid);

				aboutyourself = XLHandlingMethods.readdata(k, 10);
				RegistrationPageObjects.AboutYourself(driver).sendKeys(aboutyourself);

				password = XLHandlingMethods.readdata(k, 11);
				RegistrationPageObjects.Password(driver).sendKeys(password);

				confirmpassword = XLHandlingMethods.readdata(k, 12);
				RegistrationPageObjects.ConfirmPassword(driver).sendKeys(confirmpassword);
 				
 				RegistrationPageObjects.wait(driver,".//*[@id='pie_register']/li[14]/div/input");
				RegistrationPageObjects.Submitbutton(driver).click();
				RegistrationPageObjects.Submitbutton(driver).click();
				Reporter.log("Successfully Clicked on submit button");
				Reporter.log("Registration done successfully");
				XLHandlingMethods.writedata("Pass", Constants.XLFilepath, k, 13);
				ScreencastCapturing.Snapshot(driver, XLHandlingMethods.readdata(k, 0) + " " + k + " " + "Pass" + "");
			}

		} catch (Exception e) {
			Reporter.log("Registration Not done successfully" + e);
			XLHandlingMethods.writedata("Fail", Constants.XLFilepath, 1, 13);
			ScreencastCapturing.Snapshot(driver, XLHandlingMethods.readdata(1, 0) + " " + 1 + " " + "Fail" + "");
		}

		// Verify registration Success message
		try {
			RegistrationPageObjects.wait(driver,".//*[@id='post-49']/div/p");
			Assert.assertEquals(RegistrationPageObjects.SuccessMessage(driver).getText(), Constants.Reg_SuccessMessage);
			Reporter.log("Registration success message is displayed");
			ScreencastCapturing.Snapshot(driver, "RegistartionSuccessMessage_Displayed");
		} catch (Exception e) {
			Reporter.log("Registration success message not displayed" + e);
			ScreencastCapturing.Snapshot(driver, "RegistartionSuccessMessage_NotDisplayed");
		}

	}

}
