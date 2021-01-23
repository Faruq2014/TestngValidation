package com.TestNGParallelWithSingleTonWithBaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
	
public static WebDriver getBrowser(String browser) {
	WebDriver driver=null;
	
	try {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		
	} catch (Exception e) {
		
	}
	return driver;
	
}
}
