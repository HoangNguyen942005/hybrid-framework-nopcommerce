//package com.nopcommerce.user;
//
//import java.time.Duration;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Apply_Basepage_II {
//	WebDriver driver;
//	String emailAddress;
//	
//	// Declare (Khai báo)
//	BasePage basePage;
//	// BasePage : Class
//	// basePage : Object
//	
//	String projectPath = System.getProperty("user.dir");
//
//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//		// Driver có ID rồi
//		
//		// Initial (Khởi tạo)
//		// Che giấu đi việc khởi tạo 1 đối tượng
//		basePage = BasePage.getBasePageObject();
//         
//		emailAddress = "afc" + generateFakeNumber() + "@gmail.com";
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		// basePage.getElementText(driver, "//span[@id='FirstName-error']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
//	}
//
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.senkeyToElement(driver, "//input[@id='Email']", "123@456!@3");
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//		
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-login']");
//		basePage.clickToElement(driver, "//a[@class='ico-login']");
//	}
//
//	@Test
//	public void TC_04_Register_Existing_Email() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//		
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), 
//				"The specified email already exists");
//	}
//
//	@Test
//	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123");
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), 
//				"Password must meet the following rules:\nmust have at least 6 characters");
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		basePage.waitForElementClickAble(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//		
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//
//		basePage.waitForElementClickAble(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//		
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), 
//				"The password and confirmation password do not match.");
//	}
//
//	@AfterClass
//	public void afterClass() {
//		driver.quit();
//	}
//    public int generateFakeNumber() {
//    	Random rand = new Random();
//    	return rand.nextInt(9999);
//    }
//}
