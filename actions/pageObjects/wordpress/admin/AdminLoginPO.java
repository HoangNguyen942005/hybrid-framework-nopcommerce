package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage{

	private WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
		
	}

	public AdminDashBoardPO clickToLoginButton() {
	waitForElementClickAble(driver, AdminLoginPageUI.LOGIN_BUTTON);
	clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
	return PageGeneratorManager.getAdminDashBoardPage(driver);
	}
}
