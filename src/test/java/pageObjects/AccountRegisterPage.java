//validations is to be done in test class only
//only we will return message here

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtfirstname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtlastname;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtphone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;

	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtcpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkpolicy;
	
	@FindBy(xpath="//input[@type='submit']") 
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgconfirm;
	
	public void setFirstName(String fname) {
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		txtlastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String telephone) {
		txtphone.sendKeys(telephone);
	}
	
	public void setPassword(String password) {
		txtpassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String password) {
		txtcpassword.sendKeys(password);
	}
	
	public void setPrivacyPolicy() {
		checkpolicy.click();
	}
	
	public void clickContinue() {
		btncontinue.click();
		}
	
	public String getConfirmationMsg() {
		try {
			return msgconfirm.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}


}
