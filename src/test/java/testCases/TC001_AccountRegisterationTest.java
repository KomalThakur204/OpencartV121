package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {
	
	
	
	@Test(groups={"Regression","Master"})
	public void verifyAccountRegisteration() {
		logger.info("******Starting TC001_AccountRegisterationTest*******");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegisterPage ap=new AccountRegisterPage(driver);
		
		logger.info("Providing customer details.....");
		ap.setFirstName(randomString().toUpperCase());
		ap.setLastName(randomString().toUpperCase());
		ap.setEmail(randomString()+"@gmail.com");
		ap.setTelephone(randomNumber());
		
		String generatedpass=randomAlphaNumeric();
		ap.setPassword(generatedpass);
		ap.setConfirmPassword(generatedpass);
		ap.setPrivacyPolicy();
		ap.clickContinue();
		
		logger.info("Validating expected message...");
		String Msg=ap.getConfirmationMsg();
		if(Msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
//		Assert.assertEquals(Msg,"Your Account Has Been Created!!!");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("*****Finished TC001_AccountRegisterationTest*****");
		
	}
	
	
	

}
