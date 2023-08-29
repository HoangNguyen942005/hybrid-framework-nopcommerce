package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import pageObjectsJQuery.dataTable.HomePageObject;
import pageObjectsJQuery.dataTable.PageGeneratorManager;

public class Level_10_Data_Grid extends BaseTest {
	HomePageObject homePage;
	List<String> actualAllCoutryValues;
	List<String> expectedAllCoutryValues;
	
	private WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

// @Test
	public void Table_01_Paging() {
		homePage.openPagingPageNumber("10");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("10"));

		homePage.openPagingPageNumber("20");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("20"));

		homePage.openPagingPageNumber("7");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("7"));

		homePage.openPagingPageNumber("18");
		homePage.sleepInSecond(2);
		Assert.assertTrue(homePage.isPageNumberActived("18"));
	}

//	@Test
	public void Table_02_Input_To_Header() {
		homePage.inputToTextboxByLabel("Females", "1411");
		homePage.inputToTextboxByLabel("Country", "Guam");
		homePage.inputToTextboxByLabel("Males", "1561");
		homePage.inputToTextboxByLabel("Total", "2973");
		homePage.sleepInSecond(3);

		homePage.inputToTextboxByLabel("Females", "89017");
		homePage.inputToTextboxByLabel("Country", "Honduras");
		homePage.inputToTextboxByLabel("Males", "91387");
		homePage.inputToTextboxByLabel("Total", "180403");
		homePage.sleepInSecond(3);
	}
	
	public void Table_03_Input_To_Header() {
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> = Expected Value = expectedAllCoutryValues
		
		// Actual Value
		actualAllCoutryValues = homePage.getValueEachRowAtAllPage();
		
		//Assert.assertEquals(actualAllCoutryValues, expectedAllCoutryValues);
	}
	
	//@Test
	public void Table_04_Action_To_Textbox_At_Any_Row() {
		homePage.clickToLoadButton();
		homePage.sleepInSecond(3);
		// Value để nhập liệu - tham số 1
		// Row number : tại hàng nào
		// Ex : nhập vào textbox tại dòng số 3/ 5/ 7,...
		// Column name : tại cột nào 
//		homePage.enterToTextboxByColumnNameAtRowNumber("Company" , "1", "Apple");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Contact Person" , "2", "Steve Jobs");
//		homePage.enterToTextboxByColumnNameAtRowNumber("Order Placed" , "3", "New York");
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country" , "4", "Japan");
//		homePage.sleepInSecond(2);
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country" , "5", "Malaysia");
//		homePage.sleepInSecond(2);
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country" , "6", "Hong Kong");
//		homePage.sleepInSecond(2);
//		
//		homePage.selectDropdownByColumnNameAtRowNumber("Country" , "7", "Taiwan");
//		homePage.sleepInSecond(2);
//		
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
//		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "6");
//		
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "4");
//		homePage.unCheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		
		homePage.clickToIconByRowNumBer("1", "Remove Current Row");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumBer("1", "Insert Row Above");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumBer("1", "Move Up");
		homePage.sleepInSecond(2);
		
		homePage.clickToIconByRowNumBer("5", "Remove Current Row");
		homePage.clickToIconByRowNumBer("4", "Remove Current Row");
		homePage.clickToIconByRowNumBer("3", "Remove Current Row");
		homePage.clickToIconByRowNumBer("2", "Remove Current Row");
		homePage.clickToIconByRowNumBer("1", "Remove Current Row");
		
	}

	@AfterClass
	public void afterClass() {
	//	driver.quit();
	}
}
