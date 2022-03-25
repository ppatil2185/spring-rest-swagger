package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DriverSetup 
{
	public static Date d1 = new Date();
	public static String FileName1 = d1.toString().replace(":", "_").replace(" ", "_") + ".html";
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\displayBookshelves-OutPut\\"+FileName1);
	public static ExtentReports extent = new ExtentReports();
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static FileInputStream fis;
	
	//This method load the properties file and also opens the browser from taking name of browser from properties file
	public static void openBrowser()
	{
		String userDir = System.getProperty("user.dir");
		
		if(prop==null)
		{
			prop = new Properties();
			try {
				fis = new FileInputStream(userDir+"\\src\\main\\java\\com\\config\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", userDir+"\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", userDir+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if(prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", userDir+"\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
	}
	
	//This method quit the browser
	public static void tearDown()
	{
		driver.close();
	}
	
	//This method close the browser
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	//This method launch the url taking from properties file
	public static void launchUrl(String urlKey) throws IOException
	{
		driver.get(prop.getProperty(urlKey));
	}
}
