/**
 * 
 */
package com.magentotest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.magentotest.base.BaseClass;
import com.magentotest.pageobjects.AddToCartPage;
import com.magentotest.pageobjects.CheckOutPage;
import com.magentotest.pageobjects.HomePage;
import com.magentotest.pageobjects.LoginPage;
import com.magentotest.pageobjects.SearchResultPage;
import com.magentotest.utility.Log;

/**
 * @author Diksha
 *
 */
public class CheckOutPageTest extends BaseClass {
	
	private SearchResultPage searchResultPage;
	private HomePage homePage;
	private AddToCartPage addToCartPage;
	private CheckOutPage checkOutPage;
	private LoginPage loginPage;
	
	@Parameters("browser")
	@BeforeClass()
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterClass()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(priority = 0)
	public void verifyCartTotal() throws Throwable {
		Log.startTestCase("verifyCartTotal");
		homePage= new HomePage();
		Log.info("user is going to click on SignIn");
		loginPage=homePage.clickOnSign();
		Log.info("Enter Username and Password");
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchResultPage=homePage.searchProduct(prop.getProperty("product1"));
		Thread.sleep(3000);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.selectSize();
		addToCartPage.selectColor();
		addToCartPage.enterQuantity(prop.getProperty("quantity1"));
		addToCartPage.clickOnAddToCart(); //
		Thread.sleep(3000);
		addToCartPage.clickOnShoppingCart();
		Thread.sleep(3000);
		checkOutPage= new CheckOutPage();
		Double unitPrice=checkOutPage.getUnitPrice();
		Double orderTotal=checkOutPage.getOrderTotal();
		Double discount = checkOutPage.getDiscount();
		Double shippingRate=checkOutPage.getShippingRate();
		Double actualPrice = unitPrice*Double.parseDouble(prop.getProperty("quantity1"))-discount+shippingRate;
		Double totalExpectedPrice=orderTotal;
		Assert.assertEquals(actualPrice, totalExpectedPrice);
		Log.info("Expected Price equals actual Price");
		Log.endTestCase("verifyCartTotal");
	}
	
	@Test(priority = 1)
	public void verifyQuantityUpdate() throws Throwable {
		Log.startTestCase("verifyQuantityUpdate");
		String expectedQty=checkOutPage.updateQuantity(prop.getProperty("updateQuantity"));
		checkOutPage.clickOnUpdateShoppingCart();
		Thread.sleep(3000);
		String actualQty=checkOutPage.verifyQuantityBoxValue();
		Assert.assertEquals(actualQty, expectedQty);
		Log.info("Product quantity is updated successfully");
		Log.endTestCase("verifyQuantityUpdate");
	
	}
	
	@Test(priority = 2)
	public void addToCart() throws Throwable {
		Log.startTestCase("verifyaddToCart-Gwyn Endurance Tee Small Yellow");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(prop.getProperty("product1"));
		Thread.sleep(3000);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.selectSize1();
		addToCartPage.selectColor1();
		addToCartPage.enterQuantity(prop.getProperty("quantity2"));
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.info("Gwyn Endurance Tee Small Yellow is added to cart successfully");
		Log.endTestCase("verifyaddToCart-Gwyn Endurance Tee Small Yellow");		
		Log.startTestCase("verifyaddToCart-Quest Lumaflex™ Band");
		searchResultPage=homePage.searchProduct(prop.getProperty("product2"));
		Thread.sleep(3000);
		addToCartPage = searchResultPage.clickOnProduct1();
		Thread.sleep(3000);;
		addToCartPage.clickOnAddToCart();
		boolean result1=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result1);
		Log.info("Cart-Quest Lumaflex™ Band is added to cart successfully");
		Log.endTestCase("verifyaddToCart-Quest Lumaflex™ Band");
	}
	
   @Test(priority = 3)
   public void verifyUpdatedCartTotal() throws Throwable {
       Log.startTestCase("verifyUpdatedCartTotal");
       addToCartPage.clickOnShoppingCart();
       Double unitPriceProd1=checkOutPage.getUnitPrice1();
       Double subTotalPriceProd1 = unitPriceProd1*Double.parseDouble(prop.getProperty("prod1quantity"));
       Double unitPriceProd2=checkOutPage.getUnitPrice2();
       Double subTotalPriceProd2 = unitPriceProd2*Double.parseDouble(prop.getProperty("prod2quantity"));
       Double unitPriceProd3=checkOutPage.getUnitPrice3();
       Double subTotalPriceProd3 = unitPriceProd3*Double.parseDouble(prop.getProperty("prod3quantity"));
       Double subTotal = subTotalPriceProd1+subTotalPriceProd2+subTotalPriceProd3;
       Double orderTotal=checkOutPage.getOrderTotal1();
       Double shippingRate=checkOutPage.getShippingRate();
       Double actualPrice = subTotal-shippingRate;
       Double totalExpectedPrice=orderTotal;
       Assert.assertEquals(actualPrice, totalExpectedPrice);//140//116
       Log.info("Cart Total is updated successfully");
       Log.endTestCase("verifyUpdatedCartTotal");
}

}
