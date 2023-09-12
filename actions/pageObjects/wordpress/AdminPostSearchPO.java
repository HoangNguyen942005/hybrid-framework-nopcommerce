package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage{
	private WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickAble(AdminPostSearchPageUI.ADD_NEW_BUTTON);
		clickToElement(AdminPostSearchPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		// TODO Auto-generated method stub
		
	}

	public boolean isPostSearchTableDisplayed(WebDriver driver2, String string, String postTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
