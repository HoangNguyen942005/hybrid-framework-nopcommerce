package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage{
	private WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		super(driver); 
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitleValue) {
		waitForElementVisible(AdminPostAddNewPageUI.TITLE_TEXTBOX);
		senkeyToElement(AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToAddNewPostBody(String postBodyValue) {
		waitForElementClickAble(AdminPostAddNewPageUI.BODY_BUTTON);
		clickToElement(AdminPostAddNewPageUI.BODY_BUTTON);
		
		waitForElementVisible(AdminPostAddNewPageUI.BODY_TEXTBOX);
		senkeyToElement(AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
		
	}
	
	public void clickToPrePublishButton() {
		waitForElementClickAble(AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		
	}

	public void clickToPublishButton() {
		waitForElementClickAble(AdminPostAddNewPageUI.PUBLISH_BUTTON);
		clickToElement(AdminPostAddNewPageUI.PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishedMessage) {
		waitForElementVisible(AdminPostAddNewPageUI.PUBLISHIED_MESSAGE, postPublishedMessage);
		return isElementDisplayed(AdminPostAddNewPageUI.PUBLISHIED_MESSAGE, postPublishedMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostUrl) {
		openPageUrl(searchPostUrl);
		return PageGeneratorManager.getAdminPostSearchPage(driver);
	}
}
