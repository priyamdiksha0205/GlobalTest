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

	
//	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/div/button/span")
//	private WebElement nextButton;
	
	@FindBy(xpath = "//button[contains(@class,\"action login primary\")]")
	private WebElement signInButton;
	
	@FindBy(xpath ="//input[@id=\"login-email\"]")
	private WebElement loginEmail;
	
	@FindBy(xpath ="//input[@id=\"login-password\"]")
	private WebElement loginPasswod;
	
	@FindBy(xpath="//div[@id=\"modal-content-7\"]//button[@type=\"submit\"]")
	private WebElement loginInButton;
	
	
//	public PaymentsPage clickNextButton() throws Throwable {
//	    action.click(getDriver(), nextButton);
//		return new PaymentsPage();
//	}
	
	
	public String verifyCountryName() throws Throwable {
	    String countryName = shippingAddress.getText();
		return countryName;
	}
	
	public LoginPage clickSignInButton() throws Throwable {
	    action.click(getDriver(), signInButton);
        return new LoginPage();
	}
	
	public OrderPage login(String email, String pwd, OrderPage orderPage) throws Throwable {
		action.type(loginEmail, email);
		action.type(loginPasswod, pwd);
		action.click(getDriver(), loginInButton);
		Thread.sleep(2000);
		return new OrderPage();
	}
	
}
