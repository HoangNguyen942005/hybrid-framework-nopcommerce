package pageObjectsLivePanda;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.livePanda.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public void dissMissAlert() {
		waitForElementClickAble(AdminDashboardPageUI.ALERT);
		clickToElement(AdminDashboardPageUI.ALERT);
	}
}
