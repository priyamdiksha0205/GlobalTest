/**
 * 
 */
package com.magentotest.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.magentotest.base.BaseClass;
import com.magentotest.pageobjects.AddToCartPage;
import com.magentotest.pageobjects.HomePage;
import com.magentotest.pageobjects.OrderPage;
import com.magentotest.pageobjects.SearchResultPage;
import com.magentotest.utility.Log;

/**
 * @author Diksha
 *
 */
public class OrderPageTest extends BaseClass {
	
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Sanity"})
	public void tearDown() {
//		getDriver().quit();
	}
	
	@Test(groups = "Sanity")
	public void verifyCountry() throws Throwable {
		Log.startTestCase("verifyCountryName");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(prop.getProperty("product1"));
		Thread.sleep(3000);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.selectSize();
		addToCartPage.selectColor();
		addToCartPage.enterQuantity(prop.getProperty("quantity1"));
		addToCartPage.clickOnAddToCart();
		Thread.sleep(3000);
		orderPage=addToCartPage.clickOnCheckOut1();		
		orderPage.clickSignInButton();
		orderPage.login(prop.getProperty("username"), prop.getProperty("password"),orderPage);
		String expectedCountryName = prop.getProperty("countryName");
		String shippingAddress = orderPage.verifyCountryName();
//		System.out.println(shippingAddress);
		boolean isUnitedKingdom = shippingAddress.contains(expectedCountryName);
//		System.out.println(isUnitedKingdom);
		Assert.assertTrue(isUnitedKingdom);
		Log.info("shippingAddress contains United Kingdom");
		Log.endTestCase("verifyCountryName");
	}

}
