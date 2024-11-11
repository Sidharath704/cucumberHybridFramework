package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;

	@Given("User  navigates to login page")
	public void user_navigates_to_login_page1() {
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSignin();
		// no need to hard code here for all WebElement
		// driver.findElement(By.xpath("//div[@class='panel
		// header']//a[contains(text(),'Sign In')]")).click();
	}

	@When("User has entered valid email address {string} into the email field")
	public void user_has_entered_valid_email_address_into_the_email_field(String emailAddress) {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(emailAddress);
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("email")).sendKeys(emailAddress);
	}

	@And("User has entered valid password {string} into the password field")
	public void user_has_entered_valid_password_into_the_password_field(String password) {
		loginPage.enterPasswordField(password);
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("pass")).sendKeys(password);

	}

	@And("User clicks on Login Button")
	public void user_clicks_on_login_button1() {
		loginPage.clickLoginButton();
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("send2")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		AccountPage accountPage = new AccountPage(driver);
		//no need to hard code here for all WebElement
		// Assert.assertTrue(driver.findElement(By.linkText("Edit")).isDisplayed());
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());

	}

	@When("User enters invalid email address {string} into the email field")
	public void user_enters_invalid_email_address_into_the_email_field(String invalidEmail) {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(invalidEmail);
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("email")).sendKeys(invalidEmail);
	}

	@And("User enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidPassword) {
		loginPage = new LoginPage(driver);
		loginPage.enterPasswordField(invalidPassword);
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("pass")).sendKeys(invalidPassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(loginPage.getWarningMessageText().contains("This is a required field."));
		//no need to hard code here for all WebElement
		// Assert.assertTrue(driver.findElement(By.id("pass-error")).getText().contains("This
		// is a required field."));

	}

	@When("User do not enters email address into email field")
	public void user_do_not_enters_email_address_into_email_field() {
		loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress("");
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("email")).sendKeys("");
	}

	@When("User do not enters password into password field")
	public void user_do_not_enters_password_into_password_field() {
		loginPage = new LoginPage(driver);
		loginPage.enterPasswordField("");
		//no need to hard code here for all WebElement
		// driver.findElement(By.id("pass")).sendKeys("");
	}

}
