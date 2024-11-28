package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']") WebElement link_signUpLogin;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement btn_logout;
	
	public boolean validateHomePage(){
		if(driver.getTitle().equals("Automation Exercise")) //Automation Exercise
			return true;
		else 
			return false;
	}
	
	public void clickSinupLogin() {
		link_signUpLogin.click();
	}
	
	public boolean validateLogoutDisplay() {
		return btn_logout.isDisplayed();
	}
	
	public void clickLogOut() {
		btn_logout.click();
	}

}
