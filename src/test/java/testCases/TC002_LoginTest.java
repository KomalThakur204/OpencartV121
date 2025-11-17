package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("*****Starting the TC002_LoginTest*****");
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickSubmit();
		
		//my account page
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExist();
		
		Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true,"Login Failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished the TC002_LoginTest*****");
		
		
	}
	

}
