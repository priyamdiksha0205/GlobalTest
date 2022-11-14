/**
 * 
 */
package com.magentotest.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.magentotest.actiondriver.Action;
import com.magentotest.base.BaseClass;
import com.magentotest.pageobjects.SearchResultPage;

/**
 * @author Diksha
 *
 */
public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[@style=\"padding-bottom: 125%;\"]/img[@alt=\"Gwyn Endurance Tee\"]")
	private WebElement productResult;
	
	@FindBy(xpath = "//a//img[@alt=\"Quest Lumaflex™ Band\"]")
	private WebElement productResult1;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
	
	public AddToCartPage clickOnProduct1() throws Throwable {
		action.click(getDriver(), productResult1);
		return new AddToCartPage();
	}
}
