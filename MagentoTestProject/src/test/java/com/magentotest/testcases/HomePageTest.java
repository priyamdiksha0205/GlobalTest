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
import com.magentotest.pageobjects.HomePage;
import com.magentotest.utility.Log;

/**
 * @author admin
 *
 */
public class HomePageTest extends BaseClass {
	
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
		
	@Test(groups = "Sanity")
	public void verifySignInButton() throws Throwable {
		Log.startTestCase("verifySignInButton");
		homePage = new HomePage();
		boolean result = homePage.validateSignInButton();
		Assert.assertTrue(result);
		Log.endTestCase("verifySignInButton");
	}
	
	

}
