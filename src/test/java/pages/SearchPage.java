package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='search_product']") WebElement txt_search;
	@FindBy(xpath="//button[@id='submit_search']") WebElement btn_search;
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a") WebElement btn_viewFirstSearchProduct;
	
	@FindBy(xpath="//b[normalize-space()='Availability:']") WebElement display_availability;
	@FindBy(xpath="//b[normalize-space()='Condition:']") WebElement display_condition;
	@FindBy(xpath="//b[normalize-space()='Brand:']") WebElement display_brand;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]") WebElement display_category;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span") WebElement display_price;
	
	public boolean validateSearchPageNavigation() {
		if(driver.getCurrentUrl().contains("products"))
			return true;
		else
			return false;
	}
	
	public void SearchProdThroughSearchBtn(String product) {
		txt_search.clear();
		txt_search.sendKeys(product);
		btn_search.click();
	}
	
	public String validateSearchProduct() {
		return driver.getCurrentUrl();
	}
	
	public void SearchProdThroughEnterKey(String product) {
		txt_search.clear();
		txt_search.sendKeys(product);
		txt_search.sendKeys(Keys.ENTER);
	}
	
	public String validateSearchBarPlaceholder() {
		return txt_search.getAttribute("placeholder");
	}
	
	public void clickViewProductOfFirstSearchProduct() {
		javaScriptExecutor().executeScript("arguments[0].click()", btn_viewFirstSearchProduct);
	}
	
	public boolean validateProductDetails(String product) {
		boolean [] flag=new boolean[5];
		flag[0] = display_availability.isDisplayed();
		flag[1] = display_brand.isDisplayed();
		flag[2] = display_category.getText().contains(product);
		flag[3] = display_condition.isDisplayed();
		flag[4] = display_price.isDisplayed();
		boolean status=false;
		for(boolean f:flag) {
			if(f==true) {
				status=true;				
			}
			else 
				status = false;
		}
		return status;
	}
}
