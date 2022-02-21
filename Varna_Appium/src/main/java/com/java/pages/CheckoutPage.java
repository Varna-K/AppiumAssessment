package com.java.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;
import utility.TestUtils;

public class CheckoutPage extends BaseTest{
	TestUtils utils = new TestUtils();

	@AndroidFindBy(accessibility = "test-First Name")
	private MobileElement firstName;
	
	@AndroidFindBy(accessibility = "test-Last Name")
	private MobileElement LastName;
	
	@AndroidFindBy(accessibility = "test-Zip/Postal Code")
	private MobileElement postalCode;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView")
	private MobileElement continueButton;

	
	  @AndroidFindBy(xpath ="//*[contains(@text,'CHECKOUT: INFORMATION')]")
	  private MobileElement SLBPageTitle;
	  
	  public String getTitle() { String title = getText(SLBPageTitle); return
	  title; }
	 
	
	public CheckoutPage enterFirstName(String fName) {
		sendKeys(firstName,fName);
		return this;
	}
	
	public CheckoutPage enterLastName(String lName) {
		sendKeys(LastName,lName);
		return this;
	}
	
	public CheckoutPage enterzipCode(String zipCode) {
		sendKeys(postalCode,zipCode);
		return this;
	}
	
	public CheckoutPage continueCheckout() {
		click(continueButton);
		return new CheckoutPage();
	}
}
