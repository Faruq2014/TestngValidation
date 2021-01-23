package com.TestNGParallelWithSingleTonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver getBrowser(String Browser) {
		WebDriver driver=null;
		try {
			if (Browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			}
			if (Browser.equalsIgnoreCase("Fifefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return driver;
	}

}
