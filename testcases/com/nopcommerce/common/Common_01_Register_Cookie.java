package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	public static Set<Cookie> loggedCookies;
 
	@Parameters("browser")
	@BeforeTest(description="Create new User for all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
		password = "123456";
		
		log.info("Pre-condition - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
        
		log.info("Pre-condition - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		log.info("Pre-condition - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		log.info("Pre-condition - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 05 : Enter to Password Textbox with value is '" +password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		log.info("Pre-condition - Step 06 : Enter to Confirm Pasword Textbox with value is '" +password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		log.info("Pre-condition - Step 07 : Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08 : Verify Register Success Message");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-condition - Step 09 : Click to Log out link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Pre-condition - Step 10: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-condition - Step 11: Enter to Email Textbox with value is '" + emailAddress +"' ");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Pre-condition - Step 12: Enter to Password Textbox with value is '" + password +"' ");
		loginPage.inputToPasswordTextbox(password);

		log.info("Pre-condition - Step 13: Navigate to Login page");
		homePage = loginPage.clickToLoginButton();
		
		loggedCookies = homePage.getAllCookies(driver);
		for (Cookie cookie : loggedCookies) {
			System.out.println("Cookie at Common class :" + cookie);
		}
	}
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
