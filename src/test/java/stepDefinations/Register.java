package stepDefinations;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Register {
	WebDriver driver;

	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		driver = DriverFactory.getDriver();
		driver.findElement(By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']")).click();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> datamap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("firstname")).sendKeys(datamap.get("First Name"));
		driver.findElement(By.id("lastname")).sendKeys(datamap.get("Last Name "));
		driver.findElement(By.id("email_address")).sendKeys(datamap.get("Email"));
		driver.findElement(By.id("password")).sendKeys(datamap.get("Password"));
		driver.findElement(By.id("password-confirmation")).sendKeys(datamap.get("Confirm Password"));

	}

	@When("User clicks on create an account button for registration new user")
	public void user_clicks_on_create_an_account_button_for_registration_new_user() {
		driver.findElement(By.xpath("//button[@title='Create an Account']//span[contains(text(),'Create an Account')]"))
				.click();

	}

	@Then("User Account should get created successfully")
	public void user_account_should_get_created_successfully() {

		Assert.assertEquals("Thank you for registering with Main Website Store.",
				driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
						.getText());

	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		Assert.assertEquals(
				"There is already an account with this email address. If you are sure that it is your email address, ",
				driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"))
						.getText());
	}

	@When("User do not enters any details into fields")
	public void user_do_not_enters_any_details_into_fields() {

		// Intentionally kept blank

	}

	@Then("User should get a warning messages for every mandatory field")
	public void user_should_get_a_warning_messages_for_every_mandatory_field() {
		Assert.assertEquals("This is a required field.", driver.findElement(By.id("firstname-error")).getText());
		Assert.assertEquals("This is a required field.", driver.findElement(By.id("lastname-error")).getText());
		Assert.assertEquals("This is a required field.", driver.findElement(By.id("email_address-error")).getText());
		Assert.assertEquals("This is a required field.", driver.findElement(By.id("password-error")).getText());
		Assert.assertEquals("This is a required field.", driver.findElement(By.id("password-confirmation-error")).getText());
	}

}
