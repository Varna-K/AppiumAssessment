package com.java.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;
import utility.TestUtils;

public class ProductDetailsPage extends BaseTest{
	TestUtils utils = new TestUtils();

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
	private MobileElement productName;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[2]")
	private MobileElement productDesc;

	@AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
	private MobileElement backToProductsBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView")
	private MobileElement checkoutBtn;
	
	@AndroidFindBy(accessibility = "test-REMOVE")
	private MobileElement removeBtn;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE SHOPPING']/android.widget.TextView")
	private MobileElement continueShoppingBtn;

	public String getSLBTitle() {
		String title = getText(productName);
		return title;
	}

	public String getSLBTxt() {
		String txt = getText(productDesc);
		return txt;
	}

	/*
	 * public String getSLBPrice() { String price = getText(SLBPrice);
	 * utils.log("price is - " + price); return price; }
	 */

	public String scrollToSLBPriceAndGetSLBPrice() {
		return getText(scrollToElement());
	}

	public ProductsPage pressBackToProductsBtn() {
		click(backToProductsBtn);
		return new ProductsPage();
	}
	
	public ProductsPage continueShopping() {
		click(continueShoppingBtn);
		return new ProductsPage();
	}
	
	public ProductsPage removeProduct() {
		click(removeBtn);
		return new ProductsPage();
	}
	
	public CheckoutPage clickCheckout() {
		click(checkoutBtn);
		return new CheckoutPage();
	}
}
