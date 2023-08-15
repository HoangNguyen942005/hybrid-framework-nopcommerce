package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private String  userEmailAddress, userPassword;
	private String adminEmailAddress, adminPassword;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginpage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		userEmailAddress = "automation@gmail.com";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		// Home page -> Customer Info
		userCustomerInfoPage = userHomePage.openMyAccountPage();
		
		// Customer Info click log out -> Home Page
		userHomePage = userCustomerInfoPage.clickToLogOutLinkAtUserPage(driver);
		
		// User Home Page -> Open Admin Page -> Login Page (Admin)
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
	    adminLoginpage = PageGeneratorManager.getAdminLoginPage(driver);
	      
	      // Login as Admin role
	      adminDashboardPage = adminLoginpage.loginAsAdmin(adminEmailAddress, adminPassword);
	      Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
	      
	      // Dashboard Page -> Click logout -> Login Page (Admin)
	      adminLoginpage = adminDashboardPage.clickToLogOutLinkAtAdminPage(driver);
	}

	@Test
	public void User_02_Admin_To_User() {
      // Login Page (Admin)
		adminLoginpage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		// Home Page -> Login page (User)
		userLoginPage = userHomePage.openLoginPage();
		
		// Login as User role
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
