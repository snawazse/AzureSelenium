package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.Constants.AppConstants;
import com.qa.opencart.Utils.ElementUtil;

public class SearchPage {

	private final WebDriver driver;
	private final ElementUtil eleUtil;

	private final By searchProductResults = By.cssSelector("div#content div.product-layout");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	public int getSearchProductsCount() {
		int productCount = eleUtil.waitForElementsVisible(searchProductResults, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("Product Count:::" + productCount);
		return productCount;
	}

	public ProductInfoPage selectProduct(String productName) {
		By productLocator = By.linkText(productName);
		eleUtil.waitForElementVisible(productLocator, AppConstants.DEFAULT_MEDIUM_TIME_OUT).click();
		return new ProductInfoPage(driver);
	}

}
