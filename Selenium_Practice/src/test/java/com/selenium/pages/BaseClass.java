package com.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.selenium.utlility.BrowserFactory;
import com.selenium.utlility.ConfigDataProvider;
import com.selenium.utlility.CustomLibrary;
import com.selenium.utlility.ExcelDataProvider;

public class BaseClass {
	
	WebDriver driver;
	ExcelDataProvider excel;
	ConfigDataProvider config;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeSuite
	public void getData() {
		
		Reporter.log("Setting up Reports and Test is getting ready", true);
		excel = new ExcelDataProvider();
	    config = new ConfigDataProvider();
	    extent = new ExtentReports();
	    ExtentSparkReporter reporter= new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/Reports_"+CustomLibrary.getCurrentDate()+".html");
	    extent.attachReporter(reporter);
	    //extent.createTest("Login Test Case");
	    Reporter.log("Settings   done- Test can be started");
	}
	
	@BeforeClass
	public void setUp() {
		Reporter.log("Trying to start browser and getting Application ready", true);
		BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		Reporter.log("Browser and application is up and ready", true);
	}
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(CustomLibrary.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(CustomLibrary.captureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
		logger.fail("Test case failed", MediaEntityBuilder.createScreenCaptureFromPath(CustomLibrary.captureScreenshot(driver)).build());
	}
	extent.flush();
	Reporter.log("Test completed>>Reports generated", true);
	
	}
}
