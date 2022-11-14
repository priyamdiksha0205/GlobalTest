package com.magentotest.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {

	//Added all user actions abstract methods to achieve Abstraction  

		public void click(WebDriver ldriver, WebElement ele);
		public boolean isDisplayed(WebDriver ldriver, WebElement ele);
		public boolean type(WebElement ele, String text);
		public boolean findElement(WebDriver ldriver, WebElement ele);
		public boolean JSClick(WebDriver driver, WebElement ele);
		public int getColumncount(WebElement row);
		public int getRowCount(WebElement table);
		public boolean launchUrl(WebDriver driver,String url);
		public String getCurrentURL(WebDriver driver);
		public void fluentWait(WebDriver driver,WebElement element, int timeOut);
		public void implicitWait(WebDriver driver, int timeOut);
		public void explicitWait(WebDriver driver, WebElement element, int timeOut);
		public void pageLoadTimeOut(WebDriver driver, int timeOut);
		public String screenShot(WebDriver driver, String filename);
		public String getCurrentTime();

}
