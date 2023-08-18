package pageObjectsLivePanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.livePanda.RegisterPageUI;

public class RegisterPageObject  extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextbox(String textboxName, String value) {
		waitForElementVisible(driver, RegisterPageUI.INPUT_TEXTBOX, textboxName);
		senkeyToElement(driver, RegisterPageUI.INPUT_TEXTBOX, value, textboxName);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickAble(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public  String getRegisterSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
}
