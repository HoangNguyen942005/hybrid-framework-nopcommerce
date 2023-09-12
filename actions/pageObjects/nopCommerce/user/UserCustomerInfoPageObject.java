package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage{

	private WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	
}
