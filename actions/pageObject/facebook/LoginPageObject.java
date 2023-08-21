package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import page.UIs.facebook.FacebookLoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    
    public LoginPageObject(WebDriver driver) {
    	this.driver = driver;
    }

	public void clickToCreateNewAccountButton() {
		waitForElementClickAble(driver, FacebookLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, FacebookLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(driver, FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
      waitForElementVisible(driver, FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);		
      senkeyToElement(driver, FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, FacebookLoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		clickToElement(driver, FacebookLoginPageUI.CLOSE_ICON);
		
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		return isElementUndisplayed(driver, FacebookLoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
	
	
}
