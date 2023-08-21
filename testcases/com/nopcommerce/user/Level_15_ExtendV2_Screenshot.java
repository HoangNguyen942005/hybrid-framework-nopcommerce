package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentManager;

public class Level_15_ExtendV2_Screenshot extends BaseTest {

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
		ExtentManager.startTest(method.getName(), "User_01_Register");
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
        
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToLastNameTextbox(lastName);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05 : Enter to Password Textbox with value is '" +password + "'");
		registerPage.inputToPasswordTextbox(password);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06 : Enter to Confirm Pasword Textbox with value is '" +password + "'");
		registerPage.inputToConfirmPasswordTextbox(password);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07 : Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08 : Verify Register Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed!");
	}
	
	@Test
	public void User_02_Login(Method method) {
		ExtentManager.startTest(method.getName(), "User_02_Login");
		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09 : Click to Log out link");
		homePage = registerPage.clickToLogoutLink();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email Textbox with value is '" + emailAddress +"' ");
		loginPage.inputToEmailTextbox(emailAddress);
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Password Textbox with value is '" + password +"' ");
		loginPage.inputToPasswordTextbox(password);

		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Navigate to Login page");
		homePage = loginPage.clickToLoginButton();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify Customer info page is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
