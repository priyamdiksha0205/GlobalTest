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
import com.magentotest.pageobjects.HomePage;
import com.magentotest.pageobjects.SearchResultPage;
import com.magentotest.utility.Log;

/**
 * @author Diksha
 *
 */
public class SearchResultPageTest extends BaseClass {
	
	private HomePage homePage;
	private SearchResultPage searchresultPage;

	
	@Parameters("browser")
	@BeforeClass(groups = {"Sanity"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterClass(groups = {"Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Sanity"})
	public void productAvailabilityTest() throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		homePage= new HomePage();
		Log.info("user is going search product");
		searchresultPage=homePage.searchProduct(prop.getProperty("product1"));
		Thread.sleep(3000);
		Log.info("Verifying if searched product is available");
		boolean result=searchresultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.info("Search is Sucess");
	    Log.endTestCase("productAvailabilityTest");
		
	}
	
}
