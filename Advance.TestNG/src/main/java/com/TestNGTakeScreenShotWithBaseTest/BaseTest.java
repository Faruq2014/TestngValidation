package com.TestNGTakeScreenShotWithBaseTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	public static WebDriver driver;
	public static String browser;
	
	
	public static void init(String browser) {
	if (browser.equalsIgnoreCase("chrome")){
		ChromeOptions options= new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput","true"); 
	System.setProperty("webdriver.chrome.args","--disable-logging");
    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver(options);
	}else if (browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver= new FirefoxDriver();	
	}	
	
	}
	
	public static void captureScreenShot( String ScreenShot) {
		 try {
		TakesScreenshot ts = (TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShot/"+ScreenShot+".png"));
		System.out.println("screen shot taken");
		
	} catch (IOException e) {
		System.out.println("screen shot were not taken"+e.getMessage());
		
	}
	}

}
