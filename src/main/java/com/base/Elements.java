package com.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Elements extends DriverSetup
{
	//This method accept argument of locator key and according to that find the element and return it.
	public static WebElement getElement(String locatorKey)
	{
		WebElement element = null;
		
		if(locatorKey.endsWith("_Id"))
		{
			element = driver.findElement(By.id(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Name"))
		{
			element = driver.findElement(By.name(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Xpath"))
		{
			element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Css"))
		{
			element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Class"))
		{
			element = driver.findElement(By.className(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Text"))
		{
			element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
		}
		return element;
	}
	
	//This method accept argument of locator key and according to that find the elements and return it.
	public static List<WebElement> getElements(String locatorKey)
	{
		List<WebElement> element = null;
		
		if(locatorKey.endsWith("_Id"))
		{
			element = driver.findElements(By.id(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Name"))
		{
			element = driver.findElements(By.name(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Xpath"))
		{
			element = driver.findElements(By.xpath(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Css"))
		{
			element = driver.findElements(By.cssSelector(prop.getProperty(locatorKey)));
		} else if(locatorKey.endsWith("_Class"))
		{
			element = driver.findElements(By.className(prop.getProperty(locatorKey)));
		} 
		return element;
	}
	
	//This method accepts arguments of locator key and according to that click on that particular element.
	public static void clickElement(String locatorKey)
	{
		getElement(locatorKey).click();
	}
	
	//This method accepts argument of locator key of text box and data and send that data into particular text box 
	public static void enterText(String locatorKey, String text)
	{
		getElement(locatorKey).sendKeys(text);
	}
	
	//This method mouse hover to element according to argument
	public static void mouseHover(String locatorKey)
	{
		Actions a = new Actions(driver);
		WebElement mouseHov = getElement(locatorKey);
		a.moveToElement(mouseHov).perform();
	}
	
}
