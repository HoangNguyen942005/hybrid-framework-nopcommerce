package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageObject extends BasePage{
      WebDriver driver;
      
      public LoginPageObject( WebDriver driver) {
    	  super(driver); 
    	  this.driver = driver;
      }

	public void enterToUsernameTextbox(String username) {
		waitForElementVisible(LoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(LoginPageUI.USERNAME_TEXTBOX, username);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public ProductPageObject clickToLoginButton() {
		waitForElementClickAble(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getProductPage(driver);
	}
}
