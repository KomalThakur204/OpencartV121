package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver );
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAcc;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement reg;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement log;
	
	public void clickMyAccount() {
		myAcc.click();
	}
	
	public void clickRegister() {
		reg.click();
	}
	
	public void clickLogin() {
		log.click();
	}
	

}
