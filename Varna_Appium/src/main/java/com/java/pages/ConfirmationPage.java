package com.java.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;
import utility.TestUtils;

public class ConfirmationPage extends BaseTest{
	@AndroidFindBy(xpath ="//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]")
	private MobileElement orderConfirmationMessage;
	
	
		
	public boolean confirmationSuccessCheck() {
		return isVisible(orderConfirmationMessage);
	}
	

}
