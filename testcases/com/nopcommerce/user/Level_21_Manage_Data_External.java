package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_21_Manage_Data_External extends BaseTest {

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password, date, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	UserDataMapper userData;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();
		
		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakeemail.com";
		password = userData.getPassword();
		date = userData.getDate();
		month = userData.getMonth();
		year = userData.getYear();
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to Register page");
		registerPage = homePage.openRegisterPage();
		
		registerPage.clickToRadioButtonByLabel(driver, "Female");
        
		log.info("Register - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver,"FirstName", firstName);
		
		log.info("Register - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver,"LastName", lastName);
		
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", date);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);
		
		log.info("Register - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver,"Email", emailAddress);
		
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");
		
		log.info("Register - Step 05 : Enter to Password Textbox with value is '" +password + "'");
		registerPage.inputToTextboxByID(driver,"Password", password);
		
		log.info("Register - Step 06 : Enter to Confirm Pasword Textbox with value is '" +password + "'");
		registerPage.inputToTextboxByID(driver,"ConfirmPassword", password);
		
		log.info("Register - Step 07 : Click to 'Register' Button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 08 : Verify Register Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}
	
	@Test
	public void User_02_Login() {
		log.info("Register - Step 09 : Click to Log out link");
		homePage = registerPage.clickToLogoutLink();
		
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email Textbox with value is '" + emailAddress +"' ");
		loginPage.inputToEmailTextbox(emailAddress);
		
		log.info("Login - Step 02: Enter to Password Textbox with value is '" + password +"' ");
		loginPage.inputToPasswordTextbox(password);

		log.info("Login - Step 04: Navigate to Login page");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'My account' page");
		customerInfoPage = homePage.openMyAccountPage();
		
		log.info("My Account - Step 02: Verify Customer info page is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		
		log.info("My Account - Step 03: Verify 'First Name ' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);
		
		log.info("My Account - Step 04: Verify 'Last Name ' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);
		
		log.info("My Account - Step 05: Verify 'Email ' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
