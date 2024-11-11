package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id="pass")
	private WebElement passwordField;
	
	@FindBy(id="send2")
	private WebElement loginButton;
	
	@FindBy(id="pass-error")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText)
	{
		emailField.sendKeys(emailText);
	}
	
	public void enterPasswordField(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public String getWarningMessageText()
	{
		return warningMessage.getText();
	}
	

}
