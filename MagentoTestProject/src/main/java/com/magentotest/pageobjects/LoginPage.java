package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magentotest.base.BaseClass;
import com.magentotest.actiondriver.Action;

public class LoginPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(id = "email")
	private WebElement emailId;
	
	@FindBy(id = "pass")
	private WebElement passWord;
	
	@FindBy(xpath = "//button[contains(@class,\"action login primary\")]")
    private WebElement logSiginBtn;	
//	
//	@FindBy(xpath ="//input[@id=\"login-email\"]")
//	private WebElement loginEmail;
//	
//	@FindBy(xpath ="//input[@id=\"login-password\"]")
//	private WebElement loginPasswod;
//	
//	@FindBy(xpath="//div[@id=\"modal-content-7\"]//button[@type=\"submit\"]")
//	private WebElement loginInButton;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	
	}
	
	public HomePage login(String email, String pwd) throws Throwable {
		action.type(emailId, email);
		action.type(passWord, pwd);
		action.click(getDriver(), logSiginBtn);
		Thread.sleep(2000);
		return new HomePage();
	}
//	public OrderPage login(String email, String pwd, OrderPage orderPage) throws Throwable {
//		action.type(loginEmail, email);
//		action.type(loginPasswod, pwd);
//		action.click(getDriver(), loginInButton);
//		Thread.sleep(2000);
//		return new OrderPage();
//	}
	
}
