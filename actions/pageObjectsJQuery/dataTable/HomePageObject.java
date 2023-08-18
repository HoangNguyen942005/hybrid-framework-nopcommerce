package pageObjectsJQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageNumber(String pageNumber) {
		waitForElementClickAble(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void inputToTextboxByLabel(String headerLabel, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		senkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, value, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);

		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua tất cả các page number
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));

		// Get Text của all row mỗi page đưa vào ArrayList
		List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
		for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// In tất cả các giá trị row của tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		
		return allRowValueAllPage;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String value) {
		// Lấy ra column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		
		// Senkey vào dòng nào dựa vào vị trí của cột và hàng
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickAble(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToLoadButton() {
       waitForElementClickAble(driver, HomePageUI.LOAD_BUTTON);
       clickToElement(driver, HomePageUI.LOAD_BUTTON);		
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickAble(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX , rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX , rowNumber, String.valueOf(columnIndex));
	}

	public void unCheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) +1;
		waitForElementClickAble(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX , rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumBer(String rowNumber, String iconName) {
       waitForElementClickAble(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, iconName);	
       clickToElement(driver, HomePageUI.ICON_BY_ROW_NUMBER, rowNumber, iconName);	
	}
}
