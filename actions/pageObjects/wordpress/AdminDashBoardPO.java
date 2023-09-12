package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminDashboardPageUI;

public class AdminDashBoardPO  extends BasePage{
	private WebDriver driver;

	public AdminDashBoardPO(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostsMenuLink() {
		waitForElementClickAble(AdminDashboardPageUI.POST_MENU_LINK);
		clickToElement(AdminDashboardPageUI.POST_MENU_LINK);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
