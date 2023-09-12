package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashBoardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {
     AdminLoginPO adminLoginPage;
     AdminDashBoardPO adminDashBoardPage;
     AdminPostSearchPO adminPostSearchPage;
     AdminPostAddNewPO adminPostAddNewPage;
     UserHomePO userHomePage;
     UserPostDetailPO userPostDetailPage;
     
	String adminUsername = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body" + randomNumber;
	String authorName = "Automation FC";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();
	
	private WebDriver driver;
	@Parameters({"browser", "urlAdmin", "urlUser"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-condition - Step 01 : Open browser and admin Url");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-condition - Step 02 : Enter to Username textbox with value : " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);
		
		log.info("Pre-condition - Step 03 : Enter to Username textbox with value :" + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);
		
		log.info("Pre-condition - Step 04 : Click to Login button");
		adminDashBoardPage =  adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_Post - Step 01 : Click to Posts menu link");
		adminPostSearchPage =	adminDashBoardPage.clickToPostsMenuLink();
		
		log.info("Create_Post - Step 02 : Get Search Posts page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl();
		
		log.info("Create_Post - Step 03 : Click to Add New button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();
		
		log.info("Create_Post - Step 04 : Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);
		
		log.info("Create_Post - Step 05 : Enter to body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);
		
		log.info("Create_Post - Step 06 : Click to Publish button");
		adminPostAddNewPage.clickToPrePublishButton();
		
		log.info("Create_Post - Step 07 : Click to Publish button");
		adminPostAddNewPage.clickToPublishButton();
		
		log.info("Create_Post - Step 08 : Verify Post published message displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));
	}
	
	@Test
	public void Post_02_Search_View_Post() {
		log.info("Search_Post - Step 01 : Open Search Post page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostUrl);
		
		log.info("Search_Post - Step 02 : Enter to Search Textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);
		
		log.info("Search_Post - Step 03 : Click to 'Seach Posts' button");
		adminPostSearchPage.clickToAddNewButton();
		
		log.info("Search_Post - Step 04 : Verify Search table contains" + postTitle);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed(driver, "title", postTitle));
		
		log.info("Search_Post - Step 05 : Verify Search table contains" + authorName);
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed(driver, "author", authorName));
		
		log.info("Search_Post - Step 06 : Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(this.endUserUrl );
		
		log.info("Search_Post - Step 07 : Verify Post infor displayed at Home Page");
		verifyTrue(userHomePage.isPostInforDisplayedOnHomePage(postTitle));
		verifyTrue(userHomePage.isPostInforDisplayedOnHomePage(postBody));
		verifyTrue(userHomePage.isPostInforDisplayedOnHomePage(authorName));
		verifyTrue(userHomePage.isPostInforDisplayedOnHomePage(currentDay));
		
		log.info("Search_Post - Step 08 : Click to Post title");
		userHomePage.clickToPostTitle(postTitle);
		
		log.info("Search_Post - Step 09 : Verify Post infor displayed at Post detail page");
		verifyTrue(userPostDetailPage.isPostInforDisplayed(postTitle));
		verifyTrue(userPostDetailPage.isPostInforDisplayed(postBody));
		verifyTrue(userPostDetailPage.isPostInforDisplayed(authorName));
		verifyTrue(userPostDetailPage.isPostInforDisplayed(currentDay));
		
		
	}
	
	@Test
	public void Post_03_View_Post() {
	
	}
	
	@Test
	public void Post_04_Edit_Post() {
	
	}
	
	@Test
	public void Post_05_Delete_Post() {
	
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
