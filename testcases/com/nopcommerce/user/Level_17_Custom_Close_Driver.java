package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		// Pre-condition
		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";

		log.info("Pre-conditon - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-conditon - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-conditon - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);

		log.info("Pre-conditon - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-conditon - Step 05 : Enter to Password Textbox with value is '" + password + "'");
		registerPage.inputToPasswordTextbox(password);

		log.info("Pre-conditon - Step 06 : Enter to Confirm Pasword Textbox with value is '" + password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);

		log.info("Pre-conditon - Step 07 : Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-conditon - Step 08 : Verify Register Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed!...");

		log.info("Pre-conditon - Step 09 : Click to Log out link");
		homePage = registerPage.clickToLogoutLink();

		log.info("Pre-conditon - Step 10: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-conditon - Step 11: Enter to Email Textbox with value is '" + emailAddress + "' ");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Pre-conditon - Step 12: Enter to Password Textbox with value is '" + password + "' ");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-conditon - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();

//		log.info("Pre-conditon - Step 14: Verify 'My account' link is displayed");
//		verifyTrue(homePage.isMyAccountLinkDisplayed());
//		
//		log.info("Pre-conditon - Step 15: Navigate to 'My account' page");
//		customerInfoPage = homePage.openMyAccountPage();
//		
//		log.info("Pre-conditon - Step 16: Verify Customer info page is displayed");
//		verifyFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void Search_01_Name() {

	}

	@Test
	public void Search_02_Address() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
