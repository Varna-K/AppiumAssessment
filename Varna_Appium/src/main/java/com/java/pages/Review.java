package com.java.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;
import utility.TestUtils;

public class Review extends BaseTest{
	TestUtils utils = new TestUtils();
	
	
	@AndroidFindBy(accessibility = "test-FINISH")
	private MobileElement finishButton;

	@AndroidFindBy(xpath ="//*[contains(@text,'CHECKOUT: OVERVIEW')]")
	private MobileElement SLBPageTitle;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]")
	private MobileElement SLBProductTitle;
	
	
	public String getTitle() {
		String title = getText(SLBPageTitle);
		return title;
	}
	
	public String getProductTitle() {
		String prodTitle = getText(SLBProductTitle);
		return prodTitle;
	}
	
	public ConfirmationPage finishReview() {
		scrollToText("FINISH");
		click(finishButton);
		return new ConfirmationPage();
	}
	
	}
