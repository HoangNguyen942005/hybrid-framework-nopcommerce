package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;

public class Level_11_Upload_File extends BaseTest {
	private pageObjects.jQuery.uploadFile.HomePageObject homePage;
	private WebDriver driver;
	String beachFileName = "beach.jpg";
	String computerFileName = "computer.jpg";
	String doraemonFileName = "doraemon.jpg";

	String[] multipleFileNames = { beachFileName, computerFileName, doraemonFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void Upload_01_File_Per_Time() {

		// Step 01 - Load single file
		homePage.uploadMultipleFiles(beachFileName);

		// Step 02 -Verify single file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));

		// Step 03 - Click to start buntton
		homePage.clickToStartButton();

		// Step 04 - Verfy single file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(beachFileName));

		// Step 05 - Verify single file image uploaded success
		Assert.assertTrue(homePage.isFileUpLoadedByName(beachFileName));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage();
		// Step 01 - Load multiple file
		homePage.uploadMultipleFiles(multipleFileNames);

		// Step 02 -Verify multiple file loaded success
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(doraemonFileName));

		// Step 03 - Click to start buntton
		homePage.clickToStartButton();

		// Step 04 - Verfy multiple file link uploaded success
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(doraemonFileName));

		// Step 05 - Verify multiple file image uploaded success
		Assert.assertTrue(homePage.isFileUpLoadedByName(beachFileName));
		Assert.assertTrue(homePage.isFileUpLoadedByName(computerFileName));
		Assert.assertTrue(homePage.isFileUpLoadedByName(doraemonFileName));

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}
