package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjectsLivePanda.AdminDashboardPageObject;
import pageObjectsLivePanda.AdminLoginPageObject;
import pageObjectsLivePanda.HomePageObject;
import pageObjectsLivePanda.PageGeneratorManager;
import pageObjectsLivePanda.RegisterPageObject;

public class Level_10_Tech_Panda_Exercise extends BaseTest{
	HomePageObject homePage;
	RegisterPageObject registerPage;
	AdminLoginPageObject adminLoginPage;
	AdminDashboardPageObject adminDashBoardPage;
    private WebDriver driver;
    private String firstName, lastName, emailAddress, password, confirmPassword, adminUserName, adminPassword;
    
    @Parameters({"browser" , "url"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
    	driver = getBrowserDriver(browserName, appUrl);
    	homePage = PageGeneratorManager.getHomePage(driver);
    	
   	    firstName = "Automation";
    	lastName = "Training";
    	emailAddress = "auto" + generateFakeNumber() + "@gmail.com";
    	password = "123456";
    	confirmPassword = "123456";
    	
    	adminUserName = "user01";
    	adminPassword ="guru99com";
    }
    
    @Test
    public void TC_01_Register() {
    	registerPage = homePage.createAccount();
    	
    	registerPage.inputToTextbox("firstname", firstName);
    	registerPage.inputToTextbox("lastname", lastName);
    	registerPage.inputToTextbox("email_address", emailAddress);
    	registerPage.inputToTextbox("password", password);
    	registerPage.inputToTextbox("confirmation", confirmPassword);
    	
    	registerPage.clickToRegisterButton();
    	
    	Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
    }
    
    @Test
    public void TC_02_Register_To_Admin () {
    	registerPage.openPageUrl(driver, GlobalConstants.LIVE_PANDA_ADMIN_LOGIN_PAGE);
    	adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
    	
    	adminDashBoardPage = adminLoginPage.loginAsAdmin(adminUserName, adminPassword);
    	
    	adminDashBoardPage.dissMissAlert();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @AfterClass
    public void afterClass() {
    	//	driver.quit();
    	}
}
