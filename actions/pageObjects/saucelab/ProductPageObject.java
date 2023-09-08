package pageObjects.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPageObject extends BasePage {
	WebDriver driver;

	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickAble(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		// Khai báo ra 1 ArrayList để chứa product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để get text và add vào ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList
		Collections.sort(productSortList);

		// So sánh 2 List đã bằng nhau

		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		// Khai báo ra 1 ArrayList để chứa product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// Lấy ra hết tất cả các text product name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp để get text và add và ArrayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tạo ra 1 ArrayList mới để sort dữ liệu trong ArrayList cũ xem đúng hay không
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList
		Collections.sort(productSortList);

		// Reverse cái productSortList
		Collections.reverse(productSortList);

		// So sánh 2 List đã bằng nhau

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}
		
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}
		
		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
				ArrayList<Float> productUIList = new ArrayList<Float>();
				List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

				for (WebElement productPrice : productPriceText) {
					productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
				}

				ArrayList<Float> productSortList = new ArrayList<Float>();
				for (Float product : productUIList) {
					productSortList.add(product);
				}

				Collections.sort(productSortList);
				Collections.reverse(productSortList);

				return productSortList.equals(productUIList);
	}
}
