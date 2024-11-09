package stepDefinations;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	WebDriver driver;

	@Given("User  navigates to login page")
	public void user_navigates_to_login_page1() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
	}

	@When("User has entered valid email address {string} into the email field")
	public void user_has_entered_valid_email_address_into_the_email_field(String emailAddress) {
		driver.findElement(By.id("email")).sendKeys(emailAddress);
	}

	@And("User has entered valid password {string} into the password field")
	public void user_has_entered_valid_password_into_the_password_field(String password) {
		driver.findElement(By.id("pass")).sendKeys(password);

	}

	@And("User clicks on Login Button")
	public void user_clicks_on_login_button1() {
		driver.findElement(By.id("send2")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
		Assert.assertTrue(driver.findElement(By.linkText("Edit")).isDisplayed());
	}

	@When("User enters invalid email address {string} into the email field")
	public void user_enters_invalid_email_address_into_the_email_field(String invalidEmail) {
		driver.findElement(By.id("email")).sendKeys(invalidEmail);
	}

	@And("User enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidPassword) {
		driver.findElement(By.id("pass")).sendKeys(invalidPassword);
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		Assert.assertTrue(driver.findElement(By.id("pass-error")).getText().contains("This is a required field."));
	}

	@When("User do not enters email address into email field")
	public void user_do_not_enters_email_address_into_email_field() {
		driver.findElement(By.id("email")).sendKeys("");
	}

	@When("User do not enters password into password field")
	public void user_do_not_enters_password_into_password_field() {
		driver.findElement(By.id("pass")).sendKeys("");
	}

}
