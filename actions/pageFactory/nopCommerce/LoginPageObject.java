package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);  
	}
	
	@FindBy(id="Email")
	private WebElement emailTextbox;
	
	@FindBy(id="Password")
	private WebElement passwordTextbox;

	@FindBy(xpath ="//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(id="Email")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath ="//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessErrorMessage;
	
	public void clickToLoginButton() {
		waitForElementClickAble(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public void inputToEmailTextbox(String inValidEmail) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, inValidEmail);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unsuccessErrorMessage);
		return getElementText(driver, unsuccessErrorMessage);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}
	
}
