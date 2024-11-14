package com.selenium.utlility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	

	public static WebDriver startApplication(WebDriver driver, String browser, String url) {
		
		if(browser.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
	
		}
		else if(browser.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		
		}
		else if(browser.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			
		}
		else {
			
			System.out.println("No Driver Found");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get(url);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
}
