package pageObjects.nopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickAble(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);

	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(RegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.LASTNAME_ERROR_MESSAGE);

	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.EMAIL_ERROR_MESSAGE);

	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.PASSWORD_ERROR_MESSAGE);

	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);

	}

	@Step("Enter to Fistname textbox with value is {0}")
	public void inputToFirstnameTextbox(String firstName) {
		waitForElementVisible(RegisterPageUI.FIRSTNAME_TEXTBOX);
		senkeyToElement(RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	@Step("Enter to Lastname textbox with value is {0}")
	public void inputToLastNameTextbox(String lastName) {
		waitForElementVisible(RegisterPageUI.LASTNAME_TEXTBOX);
		senkeyToElement(RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	@Step("Enter to Email textbox with value is {0}")
	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		senkeyToElement(RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter to Password textbox with value is {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to Confirm password textbox with value is {0}")
	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	@Step("Verify register success message is displayed")
	public String getRegisterSuccessMessage() {
		waitForElementClickAble(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("Click to Log out link")
	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickAble(RegisterPageUI.LOGIN_LINK);
		List<WebElement> elements = getListWebElement(RegisterPageUI.LOGIN_LINK);
		if (elements.size() != 0) {
			clickToElement(RegisterPageUI.LOGIN_LINK);
		} else {
			clickToElement(RegisterPageUI.LOGOUT_LINK);
		}
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementClickAble(RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
