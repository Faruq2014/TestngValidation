package com.TestNGIRetry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput","true"); 
	driver= new ChromeDriver(options);
	driver.get("http://www.facebook.com");
	}
	
	@Test(priority = 1, retryAnalyzer=com.TestNGIRetry.RetryAnalyzer.class, groups = "smoke")
	public void userNameCricketTest() {
		driver.findElement(By.id("email")).sendKeys("faruq");
	}
	@Test(priority = 2,retryAnalyzer=com.TestNGIRetry.RetryAnalyzer.class, groups = "sanity" )
	public void passwordCricketTest() {
		driver.findElement(By.id("pass")).sendKeys("12345");
	}
	@Test(priority = 3,retryAnalyzer=com.TestNGIRetry.RetryAnalyzer.class, groups = "functional")
	public void loginButtonCricketTest() {
		driver.findElement(By.id("button")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
