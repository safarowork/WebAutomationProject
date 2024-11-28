package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SignupLoginPage;
import testBase.BaseClass;


public class test extends BaseClass{
		
	@Test()
	public void testing() {
		HomePage home = new HomePage(driver);
		SignupLoginPage sign = new SignupLoginPage(driver);
		home.clickSinupLogin();
		sign.signUpName(fakerData().name().name());
		sign.signUpEmail(fakerData().internet().emailAddress());
		sign.clickSignUp();
		String s[] = sign.validateMandatoryFieldsMarked();
		String s1[] = {"true", "false"};
//		for(int i=0;i<s.length;i++) {
//			System.out.println(s[i]);
//		}
		boolean flag=false;
		for(String i:s) {
			if(i.equals("true")) {
				flag = true;
			}
			else {
				flag=false;
			}
		}
		
		Assert.assertEquals(flag, true);
		
	}
	
	


}

