/**
 * 
 */
package com.magentotest.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.magentotest.base.BaseClass;
import com.magentotest.pageobjects.AddToCartPage;
import com.magentotest.pageobjects.HomePage;
import com.magentotest.pageobjects.SearchResultPage;
import com.magentotest.utility.Log;

/**
 * @author Diksha
 *
 */
public class AddToCartPageTest extends BaseClass {
	
	private SearchResultPage searchresultPage;
	private AddToCartPage addToCartPage;
	private HomePage homePage;

	
	@Parameters("browser")
	@BeforeMethod(groups = {"Sanity"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Sanity"})
	public void AddCartPageTest() throws Throwable {
		Log.startTestCase("addToCartPage");
		homePage= new HomePage();
		searchresultPage=homePage.searchProduct(prop.getProperty("product1"));
		Thread.sleep(3000);
		addToCartPage = searchresultPage.clickOnProduct();
		addToCartPage.selectSize();
		addToCartPage.selectColor();
		addToCartPage.enterQuantity(prop.getProperty("quantity1"));
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}

}
