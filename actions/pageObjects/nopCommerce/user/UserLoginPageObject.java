package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	@Step("Click to Login button")
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickAble(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(LoginPageUI.UNSUCESSFUL_ERROR_MESSAGE);
		return getElementText(LoginPageUI.UNSUCESSFUL_ERROR_MESSAGE);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		inputToEmailTextbox(emailAddress);
		inputToPasswordTextbox(password);
		return clickToLoginButton();
	}
}
