package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import freemarker.core.Environment;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import utilities.Environments;

public class Level_23_Multiple_Enviroment_Owner extends BaseTest {
	Environments environment;

	private WebDriver driver;
	private String firstName, lastName, emailAddress, password, date, month, year;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	UserDataMapper userData;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		ConfigFactory.setProperty("env", environmentName);   // tạo giá trị động env trong Environments, giá trị động = value
		environment = ConfigFactory.create(Environments.class);  // khởi tạo environment
		
		driver = getBrowserDriver(browserName, environment.appUrl()); // gọi đến hàm appUrl() trong file Environements.java
		
		System.out.println(environment.appUrl());
		System.out.println(environment.appPassword());
		System.out.println(environment.appUsername());
		System.out.println(environment.dbHostname());
		System.out.println(environment.dbPassword());
		System.out.println(environment.dbUser());
		
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
		
		registerPage.clickToRadioButtonByLabel("Female");
        
		log.info("Register - Step 02 : Enter to Firstname Textbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID("FirstName", firstName);
		
		log.info("Register - Step 03 : Enter to Lastname Textbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID("LastName", lastName);
		
		registerPage.selectToDropdownByName("DateOfBirthDay", date);
		registerPage.selectToDropdownByName("DateOfBirthMonth", month);
		registerPage.selectToDropdownByName("DateOfBirthYear", year);
		
		log.info("Register - Step 04 : Enter to Email Textbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID("Email", emailAddress);
		
		registerPage.clickToCheckboxByLabel("Newsletter");
		
		log.info("Register - Step 05 : Enter to Password Textbox with value is '" +password + "'");
		registerPage.inputToTextboxByID("Password", password);
		
		log.info("Register - Step 06 : Enter to Confirm Pasword Textbox with value is '" +password + "'");
		registerPage.inputToTextboxByID("ConfirmPassword", password);
		
		log.info("Register - Step 07 : Click to 'Register' Button");
		registerPage.clickToButtonByText("Register");

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
		loginPage.clickToButtonByText("Log in");
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
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("FirstName"), firstName);
		
		log.info("My Account - Step 04: Verify 'Last Name ' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("LastName"), lastName);
		
		log.info("My Account - Step 05: Verify 'Email ' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("Email"), emailAddress);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
