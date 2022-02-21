package com.qa.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.pages.CheckoutPage;
import com.java.pages.ConfirmationPage;
import com.java.pages.LoginPage;
import com.java.pages.ProductDetailsPage;
import com.java.pages.ProductsPage;
import com.java.pages.Review;

import utility.BaseTest;

public class ScenarioTest extends BaseTest {
	
	
	public ScenarioTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPage;
	ProductsPage productsPage;
	ProductDetailsPage productdetailsPage;
	CheckoutPage checkoutPage;
	Review reviewPage;
	ConfirmationPage cnfrm;
	InputStream details;
	JSONObject testData;

	@BeforeClass
	public void beforeClass() throws Exception {
		details = new FileInputStream("C:\\Users\\002GRN744\\eclipse-workspace\\Varna_Appium\\src\\test\\resources\\Data\\testData.json");
		JSONTokener jsonToken = new JSONTokener(details);
		testData = new JSONObject(jsonToken);
		
	}

	@BeforeMethod
	public void beforeMethod(Method m) {
		closeApp();
		launchApp();
		System.out.println("\n" + "****** starting test:" + m.getName() + "******" + "\n");
		
	}

	@Test
	public void scenario1() {
		loginPage = new LoginPage();
		loginPage.enterUserName(testData.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(testData.getJSONObject("validUser").getString("password"));
		loginPage.pressLoginBtn();
		productsPage=new ProductsPage();
		String actualProductTitle = productsPage.getTitle();
		String expectedProductTitle = "PRODUCTS";

		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		//productsPage.additem();
		productsPage.addProduct(testData.getJSONObject("productsList").getString("product1"));
		String itemSelected=productsPage.getSLBTitle();
		productsPage.clickCart();
		productdetailsPage=new ProductDetailsPage();
		Assert.assertEquals(itemSelected, productdetailsPage.getSLBTitle());
		productdetailsPage.clickCheckout();
		
		checkoutPage = new CheckoutPage();
		actualProductTitle = checkoutPage.getTitle();
		expectedProductTitle = "CHECKOUT: INFORMATION";
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		checkoutPage.enterFirstName(testData.getJSONObject("checkoutDetails").getString("firstName"));
		checkoutPage.enterLastName(testData.getJSONObject("checkoutDetails").getString("LastName"));
		checkoutPage.enterzipCode(testData.getJSONObject("checkoutDetails").getString("PostalCode"));
		checkoutPage.continueCheckout();

		reviewPage=new Review();
		actualProductTitle = reviewPage.getTitle();
		expectedProductTitle = "CHECKOUT: OVERVIEW";
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		Assert.assertEquals(itemSelected, reviewPage.getProductTitle());
		reviewPage.finishReview();
		
		
		cnfrm =new ConfirmationPage();
		Assert.assertTrue(cnfrm.confirmationSuccessCheck());
		
		}

	@Test
	public void scenario2() {
		loginPage = new LoginPage();
		loginPage.enterUserName(testData.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(testData.getJSONObject("validUser").getString("password"));
		loginPage.pressLoginBtn();
		productsPage=new ProductsPage();
		String actualProductTitle = productsPage.getTitle();
		String expectedProductTitle = "PRODUCTS";

		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		//productsPage.additem();
		productsPage.addProduct(testData.getJSONObject("productsList").getString("product1"));
		String itemSelected=productsPage.getSLBTitle();
		productsPage.clickCart();
		productdetailsPage=new ProductDetailsPage();
		Assert.assertEquals(itemSelected, productdetailsPage.getSLBTitle());
		productdetailsPage.removeProduct();
		productdetailsPage.continueShopping();
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		//productsPage.additem();
		productsPage.addProduct(testData.getJSONObject("productsList").getString("product2"));
		itemSelected=testData.getJSONObject("productsList").getString("product2");
		productsPage.clickCart();
		productdetailsPage=new ProductDetailsPage();
		Assert.assertEquals(itemSelected, productdetailsPage.getSLBTitle());
		
		productdetailsPage.clickCheckout();
		
		checkoutPage = new CheckoutPage();
		actualProductTitle = checkoutPage.getTitle();
		expectedProductTitle = "CHECKOUT: INFORMATION";
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		checkoutPage.enterFirstName(testData.getJSONObject("checkoutDetails").getString("firstName"));
		checkoutPage.enterLastName(testData.getJSONObject("checkoutDetails").getString("LastName"));
		checkoutPage.enterzipCode(testData.getJSONObject("checkoutDetails").getString("PostalCode"));
		checkoutPage.continueCheckout();

		reviewPage=new Review();
		actualProductTitle = reviewPage.getTitle();
		expectedProductTitle = "CHECKOUT: OVERVIEW";
		Assert.assertEquals(actualProductTitle, expectedProductTitle);
		Assert.assertEquals(itemSelected, reviewPage.getProductTitle());
		reviewPage.finishReview();
		
		
		cnfrm =new ConfirmationPage();
		Assert.assertTrue(cnfrm.confirmationSuccessCheck());
		
	}

/*	@Test
	public void successfulLogin() {
		loginPage.enterUserName(loginUsers.getJSONObject("validUser").getString("username"));
		loginPage.enterPassword(loginUsers.getJSONObject("validUser").getString("password"));
		productsPage = loginPage.pressLoginBtn();

		String actualProductTitle = productsPage.getTitle();
		String expectedProductTitle = "PRODUCTS";

		Assert.assertEquals(actualProductTitle, expectedProductTitle);
	}*/

	@AfterClass
	public void afterClass() throws IOException {
		details.close();
	}

	@AfterMethod
	public void afterMethod() {
	}
}



