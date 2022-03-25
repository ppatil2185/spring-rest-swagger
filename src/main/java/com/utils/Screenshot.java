package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.base.DriverSetup;
import com.google.common.io.Files;

public class Screenshot extends DriverSetup
{
	//This method captures screenshot and save as name with time stamp
	public static void getScreenshot() throws IOException
	{
		String userDrir = System.getProperty("user.dir");
		
		Date d = new Date();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Files.copy(screenshot, new File(userDrir+"\\displayBookshelves-OutPut\\screenshots\\"+FileName));
		
		System.out.println("Screenshot is captured and stord in: "+userDrir+"\\displayBookshelves-OutPut\\screenshots\\"+FileName);
	}
}
