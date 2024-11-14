package com.selenium.utlility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CustomLibrary {

	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		
		String screenshotPath= System.getProperty("user.dir")+ "/Screenshots/"+CustomLibrary.getCurrentDate()+".png";
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(screenshotPath));
		return screenshotPath;
		
	}
	
	public static String getCurrentDate() {
		
		DateFormat format = new SimpleDateFormat("ddMMyyyy");
		Date currentDate = new Date();
		return format.format(currentDate);
	}
}
