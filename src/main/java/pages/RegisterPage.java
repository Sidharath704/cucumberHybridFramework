package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	private WebElement firstNameField;
	
	@FindBy(id="lastname")
	private WebElement lastNameField;
	
	@FindBy(id="email_address")
	private WebElement emailField;
	
	@FindBy(id="password")
	private WebElement registrationPassword;
	
	@FindBy(id="password-confirmation")
	private WebElement confirmPassword;
	
	@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
	private WebElement clickOnCreateAnAccountButton;
	
	@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
	private WebElement warningMessage;
	
	@FindBy(id="firstname-error")
	private WebElement firstNameWarning;
	
	@FindBy(id="lastname-error")
	private WebElement lastNameWarning;
	
	@FindBy(id="email_address-error")
	private WebElement emailAddressWarning;
	
	@FindBy(id="password-error")
	private WebElement passwordErrorWarning;
	
	@FindBy(id="password-confirmation-error")
	private WebElement passwordConfirmationWarning;
	
	
	
	public void enterFirstName(String firstNameText)
	{
		firstNameField.sendKeys(firstNameText);
	}
    
	
	public void enterLastName(String lastNameText)
	{
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText)
	{
		emailField.sendKeys(emailText);
	}
	
	public void enterOnRegistratioPassword(String passwordText)
	{
		registrationPassword.sendKeys(passwordText);
	}
	
	public void enterOnConfirmPassword(String confirmPasswordText)
	{
		confirmPassword.sendKeys(confirmPasswordText);
	}
	
	public void clickOnCreateAnAccountButton()
	{
		clickOnCreateAnAccountButton.click();
	}
	
	public String getproperWarningMessageText()
	{
		return warningMessage.getText();
	}
	
	public String getfirstNameWarning()
	{
		return firstNameWarning.getText();
	}
	
	public String getLastNameWarning()
	{
		return lastNameWarning.getText();
	}
	
	public String getEmailAddressWarning()
	{
		return emailAddressWarning.getText();
	}
	
	public String getpasswordErrorWarning()
	{
		return passwordErrorWarning.getText();
	}
	
	public String getpasswordConfirmationWarning()
	{
		return  passwordConfirmationWarning.getText();
	}
}
