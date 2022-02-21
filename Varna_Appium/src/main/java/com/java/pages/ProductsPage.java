package com.java.pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;
import utility.TestUtils;

public class ProductsPage extends BaseTest{
TestUtils utils = new TestUtils();
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView") 
	private MobileElement productTitleTxt;
	
	@AndroidFindBy (xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]") 
	private MobileElement SLBTitle;
	
	@AndroidFindBy (xpath = "(//android.widget.TextView[@content-desc=\"test-Price\"])[1]") 
	private MobileElement SLBPrice;
	
	@AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])") 
	private List<MobileElement> AddToCartButtons;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView") 
	private MobileElement cart;
	
public String getTitle() {
	String title = getText(productTitleTxt);
	return title;
}

public String getSLBTitle() {
	String title = getText(SLBTitle);
	return title;
}

public String getSLBPrice() {
	String price = getText(SLBPrice);
	return price;
}

public ProductDetailsPage pressSLBTitle() {
	click(SLBTitle);
	return new ProductDetailsPage();
}

public void additem() {
	click(AddToCartButtons.get(0));
}

public void clickCart() {
	click(cart);
}


public void addProduct(String s) {	
	String xpath="(//android.widget.TextView[@text='"+s+"'])//following-sibling::android.view.ViewGroup";
	MobileElement addButton = (MobileElement)(driver.findElementsByXPath(xpath).get(2));
	click(addButton);
}

}
