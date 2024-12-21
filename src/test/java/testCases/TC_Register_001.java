package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignupLoginPage;
import testBase.BaseClass;

public class TC_Register_001 extends BaseClass{
	
	HomePage homepage;
	SignupLoginPage signuppage;

	@Test()
	public void testSignUpWithEmptyNameField() {
		signuppage = new SignupLoginPage(driver);
		homepage = new HomePage(driver);
		
		homepage.clickSinupLogin();
		signuppage.signUpEmail(fakerData().internet().emailAddress());
		signuppage.clickSignUp();
		
		Assert.assertEquals(signuppage.validateMissingSignUpNameField(), true);
	}
}