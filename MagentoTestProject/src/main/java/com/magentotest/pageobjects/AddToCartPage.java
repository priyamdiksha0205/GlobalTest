package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magentotest.actiondriver.Action;
import com.magentotest.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(id="option-label-size-143-item-168")
	private WebElement productSize;
	
	@FindBy(id="option-label-size-143-item-167")
	private WebElement productSize1;
	
	@FindBy(id="option-label-color-93-item-53")
	private WebElement productColor;
	
	@FindBy(id="option-label-color-93-item-60")
	private WebElement productColor1;
	
	@FindBy(id="product-addtocart-button")
	private WebElement AddToCart;
	
	//@FindBy(xpath = "//*[@id=\"product-addtocart-button\"]/span")
	//private WebElement addToCart;
	
	@FindBy(id="qty")
	private WebElement productQuantity;
	
	@FindBy(xpath="//div[@class=\"page messages\"]")
	private WebElement addToCartMessag;
	
//	@FindBy(xpath="/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")
//	private WebElement addToCartLogo;
	
	@FindBy(xpath = "//a[contains(text(),\"shopping cart\")]")
	private WebElement shoppingCart;
	
//	@FindBy(id="top-cart-btn-checkout")
//	private WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//li[@class=\"item\"]//button[@type=\"button\"]")
	private WebElement proceedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSize() throws Throwable {
		action.explicitWait(getDriver(), productSize, 20);
		action.click(getDriver(), productSize);
		
	}
	
	public void selectSize1() throws Throwable {
		action.explicitWait(getDriver(), productSize1, 20);
		action.click(getDriver(), productSize1);
		
	}
	
	public void selectColor() throws Throwable{
		action.click(getDriver(), productColor);
	}
	
	public void selectColor1() throws Throwable{
		action.click(getDriver(), productColor1);
	}
	
	public void enterQuantity(String quantity1) throws Throwable {
		action.type(productQuantity, quantity1);
	}
	
	public void clickOnAddToCart() throws Throwable {
		action.click(getDriver(), AddToCart);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		action.fluentWait(getDriver(), addToCartMessag, 10);
		return action.isDisplayed(getDriver(), addToCartMessag);
	}
	
		
//	public OrderPage clickOnCheckOut() throws Throwable {
//	    action.JSClick(getDriver(), addToCartLogo);
//		action.JSClick(getDriver(), proceedToCheckOutButton);
//		return new OrderPage();
//	}
	
	public OrderPage clickOnCheckOut1() throws Throwable {
	    action.JSClick(getDriver(), shoppingCart);
	    Thread.sleep(2000);
		action.JSClick(getDriver(), proceedToCheckoutBtn);
		return new OrderPage();
	}
	
	public OrderPage clickOnShoppingCart() throws Throwable {
	    action.JSClick(getDriver(), shoppingCart);
		return new OrderPage();
	}
	
}
