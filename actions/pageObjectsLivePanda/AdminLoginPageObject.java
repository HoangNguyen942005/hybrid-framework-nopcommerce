package pageObjectsLivePanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageUIs.livePanda.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToUsernameTextbox(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_USERNAME);
		senkeyToElement(driver, AdminLoginPageUI.ADMIN_USERNAME, adminUserName);
	}

	public void inputToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.ADMIN_PASSWORD);
		senkeyToElement(driver, AdminLoginPageUI.ADMIN_PASSWORD, adminPassword);
		
	}

	public pageObjectsLivePanda.AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickAble(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminLivePandaDashboardPage(driver);
	}

	public pageObjectsLivePanda.AdminDashboardPageObject loginAsAdmin(String adminUserName, String adminPassword) {
		inputToUsernameTextbox(adminUserName);
		inputToPasswordTextbox(adminPassword);
		return clickToLoginButton();
	}
}
