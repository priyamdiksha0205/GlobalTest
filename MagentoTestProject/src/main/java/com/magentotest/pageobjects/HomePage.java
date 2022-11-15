package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.magentotest.actiondriver.Action;
import com.magentotest.base.*;


public class HomePage extends BaseClass {
	
	Action action = new Action();
	@FindBy(xpath = " //div[@class=\"panel header\"]//ul[@class=\"header links\"]//li[@class=\"authorization-link\"]//a[contains(text(),\"Sign In\")]")
	private WebElement signInBtn;
	
	@FindBy(id = "search") 
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@type=\"submit\" and @title=\"Search\"]") 
	private WebElement searchButton;
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSign() {
		
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	public boolean validateSignInButton() throws Throwable {
		return action.isDisplayed(getDriver(), signInBtn);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(getDriver());
		return homePageURL;
	}

	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchBox, productName);
		Thread.sleep(3000);	
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
     }
}
