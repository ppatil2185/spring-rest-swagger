package com.page;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import com.base.*;
import com.utils.FileIO;
import com.utils.Screenshot;

import junit.framework.Assert;

public class UrbanLadder extends DriverSetup 
{
	//This method compare the home page title of urban ladder
	public static void getPageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Furniture Online: @Upto 70% Off on Wooden Furniture Online in India at Best Price - Urban Ladder", title);
		Reporter.log(title, true);
		System.out.println(" ");
	}
	
	//This method compare that logo of urban ladder is displayd in webpage or not
	public static void logoDisplayed(String locatorKey)
	{
		boolean Logo = Elements.getElement(locatorKey).isDisplayed();
		Assert.assertEquals(true, Logo);
		Reporter.log("Logo Of Urban Ladder is Displayed", true);
		System.out.println(" ");
	}
	
	//This method close the header offer popup
	public static void closeHeaderPopup(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Thread.sleep(2000); 
		Reporter.log("USer is able to close header offer popup", true);
		System.out.println(" ");
	}
	
	//This method mouse hover to Study menu
	public static void study(String locatorKey) throws InterruptedException
	{
		Elements.mouseHover(locatorKey);
		Thread.sleep(2000);
		Reporter.log("User is able to mouseHover to Study", true);
		System.out.println(" ");
	}
	
	//This method select Bookshelves submenu from Study
	public static void bookshelves(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Thread.sleep(5000);
		Reporter.log("User is able to click Bookshelves under Study", true);
		System.out.println(" ");
	}
	
	//This method closes the login popup
	public static void closePopup() throws InterruptedException
	{
		String currentwindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> i = allWindows.iterator();
		while(i.hasNext())
		{String childwindow = i.next();
		if(!childwindow.equalsIgnoreCase(currentwindow))
		{
			 driver.switchTo().window(childwindow);
		}
		
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[contains(text(),'Close') and @class='close-reveal-modal hide-mobile']")).click();;
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Reporter.log("User is able to close the popup", true);
		System.out.println(" ");
		Thread.sleep(2000);
	}
	
	//This method compare the bookshelves page title and search result 
	public static void bookshelvesPageTitle() throws InterruptedException
	{
		String title = driver.getTitle();
		Assert.assertEquals("Bookshelf @70% Off: Buy Bookshelves Online at Low Prices - Urban Ladder", title);
		String searchres = Elements.getElement("Result_Xpath").getText();
		Assert.assertEquals("Bookshelves", searchres);
		Reporter.log("User is Navigated to correct page", true);
		Reporter.log(title, true);
		System.out.println(" ");
	}
	
	//This method applies filter of exclude out of stock
	public static void selectExcludeOutOfStock(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Reporter.log("User is able to apply filter", true);
		System.out.println(" ");
		Thread.sleep(5000);
	}
	
	//This filter mouse hover to storage type
	public static void mouseHoverStorageType(String locatorKey) throws InterruptedException
	{
		Elements.mouseHover(locatorKey);
		Reporter.log("user is able to get Storage Type", true);
		System.out.println(" ");
		Thread.sleep(3000);
	}
	
	//This method select storage type as open
	public static void selectOpenType(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Reporter.log("User is able to select valid Storage type", true);
		System.out.println(" ");
		Thread.sleep(5000);
	}
	
	//This method mouse hover to price filter
	public static void goToPrice(String locatorKey) throws InterruptedException
	{
		Elements.mouseHover(locatorKey);
		Reporter.log("User is able to get price filter", true);
		System.out.println(" ");
		Thread.sleep(2000);
	}
	
	//This method set the lower and higher price through price slider
	public static void setPrice(String sliderA, String sliderB) throws InterruptedException
	{
		WebElement sliderLower = Elements.getElement(sliderA);
		Actions move = new Actions(driver);
		move.dragAndDropBy(sliderLower, 0, 0).click();
		move.build().perform();
		Thread.sleep(3000);

		WebElement sliderHigher = Elements.getElement(sliderB);
		move.dragAndDropBy(sliderHigher, -202, 0).click();
		move.build().perform();
		Thread.sleep(3000);
		Reporter.log("User is able to set price filter through Slider", true);
		System.out.println(" ");
		Elements.mouseHover("Exclude_Xpath");
	}
	
	//This method prints the result of bookshelves
	public static void printResultOfBookshelves(String nameLocatorKey, String priceLocatorKey)
	{
		List<WebElement> ShNames = Elements.getElements(nameLocatorKey);
		List<WebElement> ShPrice = Elements.getElements(priceLocatorKey);
		
		String[] name = new String[3];
		String[] price = new String[3];
		
		System.out.println(" ");
		System.out.println("Top Three Recommended Bookshelves with prices which Excludes out of stocks:");
		
		for (int i=0; i<3; i++)
		{
			name[i] = ShNames.get(i).getText();
			price[i] = ShPrice.get(i).getText();
			System.out.print(ShNames.get(i).getText() +" ");
			System.out.println(ShPrice.get(i).getText());
			FileIO.output1(name, price);
		}
		System.out.println(" ");
	}
	
	//This method print result of bookshelves
	public static void printResultOfBookshelvesOutOfStock(String nameLocatorKey, String priceLocatorKey)
	{
		List<WebElement> ShNames = Elements.getElements(nameLocatorKey);
		List<WebElement> ShPrice = Elements.getElements(priceLocatorKey);
		
		String[] name = new String[3];
		String[] price = new String[3];
		
		System.out.println(" ");
		System.out.println("Top Three Recommended Bookshelves with prices which Includes out of stocks also:");
		
		for (int i=0; i<3; i++)
		{
			name[i] = ShNames.get(i).getText();
			price[i] = ShPrice.get(i).getText();
			System.out.print(ShNames.get(i).getText() +" ");
			System.out.println(ShPrice.get(i).getText());
			FileIO.output3(name, price);
		}
		System.out.println(" ");
	}
	
	//This method navigate back to urban ladder homepage by urban ladder logo
	public static void navigate() throws InterruptedException
	{
		try
		{
			Elements.mouseHover("ULLogo_Xpath");
			Thread.sleep(2000);
			Elements.clickElement("ULLogo_Xpath");
			getPageTitle();
			Reporter.log("User is navigated back to home page of urban ladder", true);
			Thread.sleep(5000);
		} catch(Exception e)
		{
			Reporter.log(e.getMessage(), true);
			scrollup();
			Elements.mouseHover("ULLogo_Xpath");
			Thread.sleep(2000);
			Elements.clickElement("ULLogo_Xpath");
			getPageTitle();
			Reporter.log("User is navigated back to home page of urban ladder", true);
		} 
		/*Elements.mouseHover("ULLogo_Xpath");
		Thread.sleep(2000);
		Elements.clickElement("ULLogo_Xpath");
		getPageTitle();
		Reporter.log("User is navigated back to home page of urban ladder", true);*/
		Thread.sleep(5000);
	}
	
	//This method navigate back to home page from Gift Cards page
	public static void navigateFromGiftcard() throws InterruptedException
	{
		Elements.mouseHover("ULLOgoGiftCards_Xpath");
		Thread.sleep(2000);
		Elements.clickElement("ULLOgoGiftCards_Xpath");
		getPageTitle();
		Reporter.log("User is navigated back to home page of urban ladder", true);
		Thread.sleep(5000);
	}
	
	//This method mouse hover to collections menu
	public static void collections(String locatorKey) throws InterruptedException
	{
		Elements.mouseHover(locatorKey);
		//Elements.clickElement(locatorKey);
		Reporter.log("User is navigated to Collections", true);
		Thread.sleep(2000);
	}
	
	//This method ptints result of collections submenu "Best Seller"
	public static void printResultOfCollections(String locatorKey) throws InterruptedException
	{
		List<WebElement> submenuItems = Elements.getElements(locatorKey);
		String prodName[] = new String[7];
		
		System.out.println(" ");
		System.out.println("Submenu items of Collections menu:");
		
		for(int i=0; i<7; i++)
		{
			prodName[i] = submenuItems.get(i).getText();
			System.out.println(submenuItems.get(i).getText() +" ");
			FileIO.Output(prodName);
		}
		System.out.println(" ");
		Thread.sleep(2000);
	}
	
	//This method search for Study Chairs and select first option of auto suggestion
	public static void StudyChairs(String locatorKey, String studyChairLocatorKey) throws InterruptedException
	{
		Elements.mouseHover(locatorKey);
		Thread.sleep(2000);
		Elements.enterText(locatorKey, "Study Chairs");
		Thread.sleep(3000);
		boolean StudyCahirs = Elements.getElement(studyChairLocatorKey).isDisplayed();
		Assert.assertEquals(true, StudyCahirs);
		Elements.clickElement(studyChairLocatorKey);
		String StudyRes = Elements.getElement("Result2_Xpath").getText();
		Reporter.log(StudyRes+"Is displayed in auto suggestion", true);
		Reporter.log("user is able to search Study Chairs", true);
		System.out.println(" ");
	}
	
	//This method validate that user is able to search Study Chairs or not
	public static void StudyChairsVisibility(String locatorKey, String studyChairLocatorKey) throws InterruptedException
	{
		Elements.enterText(locatorKey, "Study Chairs");
		Thread.sleep(3000);
		boolean StudyCahirs = Elements.getElement(studyChairLocatorKey).isDisplayed();
		Assert.assertEquals(true, StudyCahirs);
		Reporter.log("USer is able to search for study chairs", true);
	}
	
	//This method print top three result of study chairs
	public static void printResultOfTopThreeStudyChairs(String nameLocatorKey, String priceLocatorKey) throws InterruptedException
	{
		Thread.sleep(5000);
		List<WebElement> ShNames = Elements.getElements(nameLocatorKey);
		List<WebElement> ShPrice = Elements.getElements(priceLocatorKey);
		
		String[] name = new String[3];
		String[] price = new String[3];
		
		System.out.println(" ");
		System.out.println("Top Three Recommended Study Chairs with prices:");
		
		for (int i=0; i<3; i++)
		{
			name[i] = ShNames.get(i).getText();
			price[i] = ShPrice.get(i).getText();
			System.out.print(ShNames.get(i).getText() +" ");
			System.out.println(ShPrice.get(i).getText());
			FileIO.output2(name, price);
		}
		System.out.println(" ");
	}
	
	//This method validate that gift cards is displayed in webpage
	public static void giftCardsPresent(String locatorKey)
	{
		boolean giftCardsIsPresent = Elements.getElement(locatorKey).isDisplayed();
		Assert.assertEquals(true, giftCardsIsPresent);
		Reporter.log("Gift Cards link is displayed in webpage", true);
	}
	
	//This method click on gift cards link
	public static void goToGiftCards(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Reporter.log("user is able to click Gift cards link", true);
		System.out.println(" ");
		Thread.sleep(5000);
	}
	
	//This method validate that gift cards page is opening or not
	public static void giftpageTitle()
	{
		String title = driver.getTitle();
		Assert.assertEquals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder", title);
		Reporter.log("User is navigated to correct page", true);
		System.out.println(" ");
	}
	
	//This method scroll down the page
	public static void scrolldown() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	}
	
	//This method scroll up the page
		public static void scrollup() throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)");
			Thread.sleep(3000);
		}
	
	//This method selects birthday/Anniversary gift card from options
	public static void selectBirthdayCard(String cardLocatorKey, String chooseThisLocatorKey) throws InterruptedException
	{
		scrolldown();
		Elements.mouseHover(cardLocatorKey);
		Thread.sleep(3000);
		Elements.clickElement(chooseThisLocatorKey);
		Thread.sleep(3000);
		Reporter.log("User is able to select Birthday/Anniversay card", true);
		System.out.println(" ");
	}
	
	//This method selects valid amount of gift cards
	public static void selectValidValue(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Reporter.log("user is able to select valid amount value of gift card", true);
		System.out.println(" ");
		Thread.sleep(2000);
	}
	
	//This method click on next button
	public static void nextBtn(String locatorKey) throws InterruptedException
	{
		Elements.clickElement(locatorKey);
		Reporter.log("user is able to click on Next Button", true);
		System.out.println(" ");
		Thread.sleep(3000);
	}
	
	//This method fill the form and submit it and capture the screen shot of error
	public static void fillTheFormAndSubmit(String lo1, String lo2, String lo3, String lo4, String lo5, String recName, String recEmail, String yName, String yMail, String yMob, String locatorKey) throws InterruptedException
	{
		Elements.enterText(lo1, recName);
		Elements.enterText(lo2, recEmail);
		Elements.enterText(lo3, yName);
		Elements.enterText(lo4, yMail);
		Elements.enterText(lo5, yMob);
		Elements.clickElement(locatorKey);
		Thread.sleep(2000);
		try {
			Screenshot.getScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
	}
	
	//This methid return to home page from Gift Cards page
	public static void returnToHomePage() throws InterruptedException
	{
		try {
			Elements.mouseHover("ULLOgoGiftCards_Xpath");
			Thread.sleep(2000);
			Elements.clickElement("ULLOgoGiftCards_Xpath");
			Reporter.log("User is able to navigate back to home page", true);
		} catch(Exception e)
		{
			Reporter.log(e.getMessage(), true);
			scrollup();
			Elements.mouseHover("ULLOgoGiftCards_Xpath");
			Thread.sleep(2000);
			Elements.clickElement("ULLOgoGiftCards_Xpath");
			Reporter.log("User is able to navigate back to home page", true);
			
		}
		/*Elements.mouseHover("ULLOgoGiftCards_Xpath");
		Thread.sleep(2000);
		Elements.clickElement("ULLOgoGiftCards_Xpath");
		Reporter.log("User is ablr to navigate back to home page", true);*/
	}
}
