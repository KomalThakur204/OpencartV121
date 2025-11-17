package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-email")
	WebElement txtemail;
	
	@FindBy(id="input-password")
	WebElement txtpass;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnsubmit;
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setPassword(String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void clickSubmit() {
		btnsubmit.click();
	}
	

}
