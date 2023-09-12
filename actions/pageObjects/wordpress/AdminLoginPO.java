package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{

	private WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(AdminLoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		
	}

	public AdminDashBoardPO clickToLoginButton() {
	waitForElementClickAble(AdminLoginPageUI.LOGIN_BUTTON);
	clickToElement(AdminLoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
}
