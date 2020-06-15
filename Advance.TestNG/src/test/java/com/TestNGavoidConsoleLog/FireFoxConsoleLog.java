package com.TestNGavoidConsoleLog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxConsoleLog {
	public WebDriver driver;
	//@Test
	public void m1() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.salesforce.com/");
		System.out.println(driver.getTitle());
		System.out.println("fairfox driver manager without supress console log coding ");
		driver.quit();
	}
	
	//@Test
		public void m2() {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver = new FirefoxDriver();
			driver.get("https://www.salesforce.com/");
			System.out.println("fairfox driver manager with supress console log coding ");
			System.out.println(driver.getCurrentUrl());
			driver.quit();
		}
		
	
	@Test
	public void m3() {
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe");
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
	driver= new FirefoxDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("fairfox driver with supress console log coding ");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	
	//@Test
	public void m4() {
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver.exe");
	driver= new FirefoxDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("fairfox driver without supress console log coding ");
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
}
