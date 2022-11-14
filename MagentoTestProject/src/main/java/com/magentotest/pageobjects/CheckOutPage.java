/**
 * 
 */
package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magentotest.actiondriver.Action;
import com.magentotest.base.BaseClass;

/**
 * @author Diksha
 *
 */
public class CheckOutPage extends BaseClass {
	
	Action action= new Action();
	
	//@FindBy(xpath="//table[@id=\"shopping-cart-table\"]")
	//private WebElement shoppingCartTable;
	
	//@FindBy(xpath="//table[@id=\\\"shopping-cart-table\\\"]")
	//private WebElement tableCol;
	
	@FindBy(xpath="//tbody/tr[1]/td[@class=\"col price\"]")
	private WebElement unitPrice;//
	
	@FindBy(xpath="//table[@id=\"shopping-cart-table\"]//thead//tr//th[2]//following::span[5]")
	private WebElement unitPrice1; //
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[1]/td[2]/span/span/span")
	private WebElement unitPrice2;//
	
	@FindBy(xpath="//*[@id=\"shopping-cart-table\"]/tbody[3]/tr[1]/td[2]/span/span/span")
	private WebElement unitPrice3;//
	
//	@FindBy(xpath="//*[@id=\"cart-totals\"]/div/table/tbody/tr[1]/td/span")
//	private WebElement subTotal;//
	
	@FindBy(xpath="//*[@id=\"cart-totals\"]/div/table/tbody/tr[4]/td/strong/span")
	private WebElement orderTotal;//
	
	@FindBy(xpath ="//*[@id=\"cart-totals\"]/div/table/tbody/tr[3]/td/strong/span")
	private WebElement orderTotal1;//
	
	@FindBy(xpath="//table[@class=\"data table totals\"]//tbody//tr[@class=\"totals\"]//td[@class=\"amount\"]")
	private WebElement discount;
	
	@FindBy(xpath ="//table[@class=\"data table totals\"]//tbody//tr[@class=\"totals shipping excl\"]//td[@class=\"amount\"]")
	private WebElement shippingRate;
	
//	@FindBy(xpath ="//table[@class=\"data table totals\"]//tbody//tr[@class=\"totals shipping excl\"]//td[@class=\"amount\"]")
//	private WebElement shippingRate1;
	
	@FindBy(xpath = "//table[@id=\"shopping-cart-table\"]//thead//tr//th[3]//following::input[1]")
	private WebElement quantityBox;
	
	@FindBy(xpath = "//table[@id=\"shopping-cart-table\"]//thead//tr//th[3]//following::input[2]")
	private WebElement quantityBox2;
	
	@FindBy(xpath = "//table[@id=\"shopping-cart-table\"]//thead//tr//th[3]//following::input[3]")
	private WebElement quantityBox3;
	
	@FindBy(xpath ="//button[@class=\"action update\"]")
	private WebElement updateShoppingCart;
	
	public CheckOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getUnitPrice1() {
		String unitPrice_1=unitPrice1.getText();
		String unit=unitPrice_1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitPrice_1=Double.parseDouble(unit);
		return finalunitPrice_1/100;
	}
	
	public double getUnitPrice2() {
		String unitPrice_2=unitPrice2.getText();
		String unit=unitPrice_2.replaceAll("[^a-zA-Z0-9]","");
		double finalunitPrice_2=Double.parseDouble(unit);
		return finalunitPrice_2/100;
	}
	
	public double getUnitPrice3() {
		String unitPrice_3=unitPrice3.getText();
		String unit=unitPrice_3.replaceAll("[^a-zA-Z0-9]","");
		double finalunitPrice_3=Double.parseDouble(unit);
		return finalunitPrice_3/100;
	}
	
	public double getOrderTotal() {
		String orderTotal1=orderTotal.getText();
		String tot=orderTotal1.replaceAll("[^a-zA-Z0-9]","");
		double finalorderTotal1=Double.parseDouble(tot);
		return finalorderTotal1/100;
	}
	
	public double getOrderTotal1() {
		String orderTotal_1=orderTotal1.getText();
		String tot=orderTotal_1.replaceAll("[^a-zA-Z0-9]","");
		double finalorderTotal_1=Double.parseDouble(tot);
		return finalorderTotal_1/100;
	}
	
	public double getDiscount() {
		String discount1=discount.getText();
		String tot=discount1.replaceAll("[^a-zA-Z0-9]","");
		double finaldiscount1=Double.parseDouble(tot);
		return finaldiscount1/100;
	}
	
	public double getShippingRate() {
		String shippingRate1=shippingRate.getText();
		String tot=shippingRate1.replaceAll("[^a-zA-Z0-9]","");
		double finalshippingRate1=Double.parseDouble(tot);
		return finalshippingRate1/100;
	}
	
	
//	public double getShippingRate1() {
//		String shippingRate_1=shippingRate1.getText();
//		String tot=shippingRate_1.replaceAll("[^a-zA-Z0-9]","");
//		double finalshippingRate_1=Double.parseDouble(tot);
//		return finalshippingRate_1/100;
//	}
	
	public String updateQuantity(String qty) throws Throwable {
		action.type(quantityBox, qty);
		Thread.sleep(2000);
		return qty;
	}
	
	public String verifyQuantityBoxValue() throws Throwable {
	    String quantityBoxValue = quantityBox.getAttribute("value");
		return quantityBoxValue;
	}
	public CheckOutPage clickOnUpdateShoppingCart() throws Throwable {
		action.click(getDriver(), updateShoppingCart);
		return new CheckOutPage();
	}
	

}
