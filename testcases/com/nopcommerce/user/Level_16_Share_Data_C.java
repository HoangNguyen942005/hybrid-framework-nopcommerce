package com.nopcommerce.user;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_C extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Login - Step 01: Navigate to Login page"); 
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Set cookies and reload page ");
		loginPage.setCookies(Common_01_Register_Cookie.loggedCookies);
		for (Cookie cookie : Common_01_Register_Cookie.loggedCookies) {
			System.out.println("Cookie at Common class :" + cookie);
		}
		loginPage.refreshCurrentPage();
		
		log.info("Login - Step 05: Verify 'My account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void Search_01_Empty_Data() {
	
	}
	
	@Test
	public void Search_02_Relative_Product_Name() {
	
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
	
	}
	
	@Test
	public void Search_04_Parent_Category() {
	
	}
	
	@Test
	public void Search_05_Incorrect_Manufactorer() {
	
	}
	
	@Test
	public void Search_06_Correct_Manufactorer() {
	
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
