package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManagerV5;

public class Level_15_ExtendV5 extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	
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
	public void User_01_Register(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "User_01_Register");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
        
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 05 : Enter to Password Textbox with value is '" +password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 06 : Enter to Confirm Pasword Textbox with value is '" +password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 07 : Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 08 : Verify Register Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentTestManagerV5.startTest(method.getName(), "User_02_Login");
		ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 09 : Click to Log out link");
		homePage = registerPage.clickToLogoutLink();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Enter to Email Textbox with value is '" + emailAddress +"' ");
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 02: Enter to Password Textbox with value is '" + password +"' ");
		loginPage.inputToPasswordTextbox(password);

		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 04: Navigate to Login page");
		homePage = loginPage.clickToLoginButton();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		ExtentTestManagerV5.getTest().log(Status.INFO, "Login - Step 07: Verify Customer info page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
