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
import com.magentotest.pageobjects.LoginPage;
import com.magentotest.utility.Log;

/**
 * @author Diksha
 *
 */
public class LoginPageTest extends BaseClass {

	private HomePage homePage;
	private LoginPage loginPage;

	
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
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		homePage= new HomePage();
		Log.info("user is going to click on SignIn");
		loginPage=homePage.clickOnSign();
		Log.info("Enter Username and Password");
	    
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    String actualURL=homePage.getCurrURL();
	    String expectedURL=prop.getProperty("url");
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}
	
	
	
	
}
