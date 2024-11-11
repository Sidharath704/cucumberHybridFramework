package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement signIn;
	
	@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
	private WebElement createAnAccount;
	
	public void clickOnSignin()
	{
		signIn.click();
	}
	
	public void clickOnCreateAnAccount()
	{
		createAnAccount.click();
	}
	
	

}
