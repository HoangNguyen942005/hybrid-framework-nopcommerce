package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest  {

	private WebDriver driver;
	private String firstName, lastName, emailAddress,  password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointPageObject rewardPointPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		 driver = getBrowserDriver(browserName); 
		 
		 homePage = PageGeneratorManager.getUserHomePage(driver);
	
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";

	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		loginPage =  homePage.openLoginPage();
		
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(password);
		
		homePage = loginPage.clickToLoginButton(); 
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Một page A khi chuyển qua page B thì phải viết 1 hàm (action: open, click/... link/ button)
		
		// Customer Infor -> Address
		addressPage = customerInfoPage.openAddresspage(driver);
		
		// Address -> My Product Review
	   myProductReviewPage =	addressPage.openMyProductReviewPage(driver);
	   
		// My Product Review -> Reward Point
	  rewardPointPage =  myProductReviewPage.openRewardPoint(driver);
		
		// Reward Point -> Address
	  addressPage =  rewardPointPage.openAddresspage(driver);
		
		// Address -> Reward Point
	  rewardPointPage = addressPage.openRewardPoint(driver);
		
		// Reward Point -> My Product Review
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
	  customerInfoPage = addressPage.openCustomerInfoPage(driver);
	}
	
	@Test
	public void User_05_Switch_Role() {
		// Role User -> Role Admin
		
		// Role Admin -> Role User
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
