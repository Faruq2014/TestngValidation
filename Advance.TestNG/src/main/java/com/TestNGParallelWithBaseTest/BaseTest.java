package com.TestNGParallelWithBaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected ThreadLocal<ChromeDriver> driver = new ThreadLocal<>();
   @BeforeMethod
	public void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver.set(new ChromeDriver());
	  getDriver().get("https://www.facebook.com/");
      }
   
   public WebDriver getDriver() {
	return driver.get();
	   
   }
   
   @AfterMethod
   public void tearDown(){
	  getDriver().quit(); 
   }
}
