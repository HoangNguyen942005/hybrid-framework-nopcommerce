package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import page.UIs.facebook.FacebookLoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;
    
    public LoginPageObject(WebDriver driver) {
    	super(driver);  // dùng super gọi đến driver của BasePage
    	this.driver = driver;
    }

	public void clickToCreateNewAccountButton() {
		waitForElementClickAble(FacebookLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(FacebookLoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementDisplayed(FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		
	}

	public void enterToEmailAddressTextbox(String emailAddress) {
      waitForElementVisible(FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX);		
      senkeyToElement(FacebookLoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(FacebookLoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}

	public void clickCloseIconAtRegisterForm() {
		clickToElement(FacebookLoginPageUI.CLOSE_ICON);
		
	}

	public boolean isConfirmEmailAddressTextboxUndisplayed() {
		return isElementUndisplayed(FacebookLoginPageUI.CONFIRM_EMAIL_ADDRESS_TEXTBOX);
	}
	
	
}
