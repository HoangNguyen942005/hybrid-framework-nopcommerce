package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;

	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_Dom() {
		// Nếu như mong đợi 1 hàm vừa verify displayed/ undisplayed thì ko được kết hợp
		// wait
		// chỉ dùng isElementDisplayed

		// Verify True - mong đợi Confirm Email Displayed (true)
		loginPage.enterToEmailAddressTextbox("automationfc@gmail.com");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());

		// Verify False - mong đợi Comfirm Email Undisplayed (false)
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepInSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom() {
		loginPage.clickCloseIconAtRegisterForm();
		loginPage.sleepInSecond(3);

         // Khi close cái form Register đi thì Confirm Email ko còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail vì ko tìm thấy Element
		// 1- Nó sẽ chờ hết time out của implicit : 30s
		// 2- Nó sẽ đánh fail testcase tại đúng step này luôn
		// 3- Ko có chạy các step còn lại nữa 
		
		// isDisplayed : bản chất ko kiểm tra 1 element ko có trong DOM được
		//verifyFalse(loginPage.isConfirmEmailAddressTextboxDisplayed());
		
		// Case 3 : element ko có trong DOM
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}
}
