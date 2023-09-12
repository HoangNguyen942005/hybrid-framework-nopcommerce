package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	@Step("Navigate to Register page")
	public UserRegisterPageObject openRegisterPage() {
		waitForElementClickAble(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		// 2
		// return new RegisterPageObject(driver);
		
		// 3
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	@Step("Navigate to Login page")
	public UserLoginPageObject openLoginPage() {
		waitForElementClickAble(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	@Step("Verify 'My Account' link is displayed")
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.MYACCOUNT_LINK);
	}

	@Step("Navigate to My Account page")
	public UserCustomerInfoPageObject openMyAccountPage() {
		waitForElementVisible(HomePageUI.MYACCOUNT_LINK);
		clickToElement(HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInfoPage(driver);
	}
}
