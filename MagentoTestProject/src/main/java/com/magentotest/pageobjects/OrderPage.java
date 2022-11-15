package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magentotest.actiondriver.Action;
import com.magentotest.base.BaseClass;

public class OrderPage extends BaseClass{
	
	Action action= new Action();
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class=\"shipping-address-item selected-item\"]")
	private WebElement shippingAddress;
	
	@FindBy(xpath = "//button[@class=\"action action-auth-toggle\"]")
	private WebElement signInButton;
	
	@FindBy(xpath ="//input[@id=\"login-email\"]")
	private WebElement loginEmail;
	
	@FindBy(xpath ="//input[@id=\"login-password\"]")
	private WebElement loginPassword;
	
	@FindBy(xpath="//a[@class=\"action action-remind\"]//preceding::div[@class=\"primary\"]")
	private WebElement loginButton;
	
	public String verifyCountryName() throws Throwable {
	    String countryName = shippingAddress.getText();
		return countryName;
	}
	
	public LoginPage clickSignInButton() throws Throwable {
		Thread.sleep(5000);
	    action.click(getDriver(), signInButton);
	    Thread.sleep(2000);
        return new LoginPage();
	}
	
	public OrderPage login(String email, String pwd, OrderPage orderPage) throws Throwable {
		action.type(loginEmail, email);
		action.type(loginPassword, pwd);
		action.fluentWait(getDriver(), loginButton);
		action.click(getDriver(), loginButton);
		Thread.sleep(2000);
		return new OrderPage();
	}
	
}
