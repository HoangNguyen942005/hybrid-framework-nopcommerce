package pageObjectsLivePanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.livePanda.HomePageUI;

public class HomePageObject  extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject createAccount() {
		waitForElementClickAble(driver, HomePageUI.CREATE_ACOUNT_BUTTON);
		clickToElement(driver, HomePageUI.CREATE_ACOUNT_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);
	}
	
}
