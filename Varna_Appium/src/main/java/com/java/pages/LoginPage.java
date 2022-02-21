package com.java.pages;

import java.io.FileInputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.BaseTest;



public class LoginPage extends BaseTest{
	
	

	@AndroidFindBy(accessibility = "test-Username")
	public MobileElement usernameTxtFld;

	@AndroidFindBy(accessibility = "test-Password")
	public MobileElement passwordTxtFld;

	@AndroidFindBy(accessibility = "test-LOGIN")
	public MobileElement loginBtn;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
	public MobileElement errTxt;

	public LoginPage enterUserName(String username) {
		clear(usernameTxtFld);
		sendKeys(usernameTxtFld, username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		clear(passwordTxtFld);
		sendKeys(passwordTxtFld, password);
		return this;
	}

	public ProductsPage pressLoginBtn() {
		click(loginBtn );
		return new ProductsPage();
	}

	public ProductsPage login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		return pressLoginBtn();
	}

	public String getErrTxt() {
		String err = getText(errTxt);
		return err;
	}
	

	
	
}
