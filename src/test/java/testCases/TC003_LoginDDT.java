package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass{
	
	@Test(groups="Datadriven",dataProvider="LoginData",dataProviderClass=DataProviders.class) //this parameter is required because dp is present in different class
	public void verify_loginDTT(String email, String pwd, String exp) throws InterruptedException {
		logger.info("*****Starting TC002_LoginTDD******");
		//HomePage
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickSubmit();
		
		//my account page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		
		
		//Data is valid-login success-test pass-logout
		//Data is valid-login fail-test fail
		//Data is invalid-login success-test fail-logout
		//Data is invalid-login fail-test pass

		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage==true) {
				macc.clickLogout(); //becz after assertion, no statement will run so put it before
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
				
			}
			
		}
		if(exp.equalsIgnoreCase("invalid")){
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("*****Finished TC002_LoginTDD*****");
		
		
	}

}
