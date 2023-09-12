package pageObjectsLivePanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.livePanda.RegisterPageUI;

public class RegisterPageObject  extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public void inputToTextbox(String textboxName, String value) {
		waitForElementVisible(RegisterPageUI.INPUT_TEXTBOX, textboxName);
		senkeyToElement(RegisterPageUI.INPUT_TEXTBOX, value, textboxName);
	}
	
	public void clickToRegisterButton() {
		waitForElementClickAble(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);
	}

	public  String getRegisterSuccessMessage() {
		waitForElementVisible(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}
	
}
