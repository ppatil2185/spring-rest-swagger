package com.test;

import com.page.UrbanLadder;

import java.io.IOException;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.*;

public class DisplayBookshelves extends UrbanLadder
{
	@BeforeSuite(alwaysRun=true)
	public static void setup()
	{
		DriverSetup.openBrowser();
		try {
			DriverSetup.launchUrl("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=1, groups= {"Smoke", "Regression"})
	public static  void Test1()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test1", "Test to verify that user is landed on correct page of urban ladder");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify the page title");
		getPageTitle();
		Test1.pass("Test Passed");
	}
	
	@Test(priority=2, groups= {"Smoke", "Regression"})
	public static  void Test2()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test2", "Test to verify that Urban Ladder brand logo is displayed in webpage");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that logo is displayed");
		logoDisplayed("ULLogo_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=3, groups= {"Smoke", "Regression"})
	public static void Test3()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test3", "Test to verify that user is able to close header offer popup");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to close the header offer popup");
		try {
			closeHeaderPopup("HeaderPopup_Xpath");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Test1.pass("Test Passed");
	}
	
	@Test(priority=4, groups= {"Smoke", "Regression"})
	public static void Test4()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test4", "Test to verify that user is able to mouse hover to Study tab");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to mouse hover to Study tab");
		try {
			study("Study_Xpath");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Test1.pass("Test Passed");
	}
	
	@Test(priority=5, groups= {"Smoke", "Regression"})
	public static void Test5()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test5", "Test to verify that user is able to Select Bookshelves sub menu from Study");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select Bookshelves");
		try {
			bookshelves("Bookshelves_Xpath");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Test1.pass("Test Passed");
	}
	
	@Test(priority=6, groups= {"Smoke", "Regression"})
	public static void Test6()
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test6", "Test to verify that user is navigated to correct page of urban ladder");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify the page title");
		try {
			bookshelvesPageTitle();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Test1.pass("Test Passed");
	}
	
	@Test(priority=7, groups= {"Smoke", "Regression"})
	public static void Test7() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test7", "User is able to handle popup");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to close the popup");
		closePopup();
		Test1.pass("Test Passed");
	}
	
	@Test(priority=8, groups= {"Regression"})
	public static void Test8() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test8", "User is able to select filter of Exclude out of stock");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select Exclude out of stock");
		selectExcludeOutOfStock("Exclude_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=9, groups= {"Regression"})
	public static void Test9() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test9", "User is able to see Storage type of Bookshelves");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to see by mouse hovering to it Storage type of bookshelves");
		mouseHoverStorageType("StorageType_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=10, groups= {"Regression"})
	public static void Test10() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test10", "User is able to select storage type as open");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select type of bookshelves as open");
		selectOpenType("OpenType_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=11, groups= {"Regression"})
	public static void Test11() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test11", "User is able to see price range filter");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select valid range of price");
		goToPrice("Price_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=12, groups= {"Regression"})
	public static void Test12() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test12", "User is able to set the price through slider");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to apply price filter through slider");
		setPrice("SliderA_Xpath", "SliderB_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=13, groups= {"Regression"})
	public static void Test13() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test13", "This will retriev the top 3 suggestions of bookshelves");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will retrieve top 3 suggestions");
		printResultOfBookshelves("NameOfItems_Xpath", "PriceOfItems_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=14, groups= {"Regression"})
	public static void Test14() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test14", "User is able to deselect filter of Exclude out of stock");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to deselect Exclude out of stock");
		selectExcludeOutOfStock("Exclude_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=15, groups= {"Regression"})
	public static void Test15() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test15", "This will retriev the top 3 suggestions of bookshelves with including out of stock");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will retrieve top 3 suggestions of bookshelves with out of stocks");
		printResultOfBookshelvesOutOfStock("NameOfItems_Xpath", "PriceOfItems_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=16, groups= {"Smoke", "Regression"})
	public static void Test16() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test16", "Validate User is able to Navigate to home");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to navigate back to home page");
		navigate();
		Test1.pass("Test Passed");
	}
	
	@Test(priority=17, groups= {"Smoke", "Regression"})
	public static void Test17() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test17", "User is able to see collections");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to get collections menu");
		collections("Collections_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=18, groups= {"Regression"})
	public static void Test18() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test18", "This will retrieve submenu items");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will retrieve the submenu items");
		printResultOfCollections("BestSellerList_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=19, groups= {"Smoke", "Regression"})
	public static void Test19() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test19", "Validate User is able search for study chairs");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to search for study chairs");
		StudyChairs("SearchBar_Xpath", "StudyChair_Xpath");
		Test1.pass("Test Passed");
	}

	@Test(priority=20, groups= {"Regression"})
	public static void Test20() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test20", "It fetch top three suggestion of study chairs");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will retrieve top 3 suggestions of Study Chairs");
		printResultOfTopThreeStudyChairs("NameOfItems_Xpath", "PriceOfItem_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=21, groups= {"Smoke", "Regression"})
	public static void Test21() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test21", "Validate User is able to Navigate to home");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to navigate back to home page");
		navigate();
		Test1.pass("Test Passed");
	}
	
	@Test(priority=22, groups= {"Smoke", "Regression"})
	public static void Test22() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test22", "Validate User is able to select gift card");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select Gift Cards");
		goToGiftCards("GiftCard_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=23, groups= {"Smoke", "Regression"})
	public static void Test23() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test23", "Validate User is redirected to correct Gift Cards page");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is navigated to correct next page");
		giftpageTitle();
		Test1.pass("Test Passed");
	}
	
	@Test(priority=24, groups= {"Regression"})
	public static void Test24() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test24", "To validate user is able to select Valid Gift card");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select Birthday/Anniversary gift card");
		selectBirthdayCard("BirthDay_Xpath", "ChooseThisBtn_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=25, groups= {"Regression"})
	public static void Test25() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test24", "Validate User is able to select valid amount of gift card");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select 1000 RS gift card");
		selectValidValue("100RS_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=26, groups= {"Regression"})
	public static void Test26() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test26", "Validate User is able to proceed further with selected valid amount of gift card");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to select 1000 RS gift card and proceed further");
		nextBtn("NextBtn_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=27, groups= {"Regression"})
	public static void Test27() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test27", "Validate User is not able to proceed further with invalid email of gift card receiver");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is not able to send gift card with invalid Receivers mail with all other valid data and capture the screenshot");
		fillTheFormAndSubmit("RecName_Id", "RecMail_Id", "YName_Id", "YMail_Id", "YMob_Id", "Abc", "Abc.abc", "Xyz", "xyz@gmail.com", "9876543210", "Confirm_Xpath");
		Test1.pass("Test Passed");
	}
	
	@Test(priority=28, groups= {"Smoke","Regression"})
	public static void Test28() throws InterruptedException
	{
		extent.attachReporter(reporter);
		ExtentTest Test1 = extent.createTest("Test28", "Validate User is able to navigate back to homepage");
		Test1.log(Status.INFO, "Starting test");
		Test1.info("This will verify that user is able to navigate back to homepage");
		returnToHomePage();
		Test1.pass("Test Passed");
	}
	
	@AfterSuite(alwaysRun=true)
	public void setDown()
	{
		extent.flush();
		DriverSetup.closeBrowser();
	}
}
