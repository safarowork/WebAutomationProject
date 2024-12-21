package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.SignupLoginPage;
import testBase.BaseClass;

public class TC_Register_008 extends BaseClass{

	HomePage homepage;
	SignupLoginPage signuppage;

	@Test(priority=1)
	public void testSignUpWithoutPassword() {
		signuppage = new SignupLoginPage(driver);
		homepage = new HomePage(driver);

		homepage.clickSinupLogin();
		signuppage.signUpName(fakerData().name().name());
		signuppage.signUpEmail(fakerData().internet().emailAddress());
		signuppage.clickSignUp(); 

		Assert.assertEquals(signuppage.validateSignUP(), true);

		signuppage.setAddressFirstName(fakerData().name().firstName());
		signuppage.setAddressLastName(fakerData().name().lastName());
		signuppage.setAddress1(fakerData().address().streetAddress());
		signuppage.setCountry(prop.getProperty("country"));
		signuppage.setState(fakerData().address().state());
		signuppage.setCity(fakerData().address().cityName());
		signuppage.setzip(fakerData().address().zipCode());
		signuppage.setPhone(fakerData().phoneNumber().cellPhone());
		signuppage.clickCreateAccount();

		Assert.assertEquals(signuppage.validateMissingAccountPasswordField(), true);
	}
}