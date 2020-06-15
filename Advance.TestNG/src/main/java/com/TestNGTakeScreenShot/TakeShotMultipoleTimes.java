package com.TestNGTakeScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TestNGUtility.ScreenShoot1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeShotMultipoleTimes {
	public static WebDriver driver;
	public static void main(String[] args) {

	    WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();
	   System.setProperty("webdriver.chrome.silentOutput","true"); 
	driver= new ChromeDriver(options);
driver.get("http://www.facebook.com");
ScreenShoot1.captureScreenShot(driver, "facebookOpen");
driver.findElement(By.id("email")).sendKeys("faruq");
ScreenShoot1.captureScreenShot(driver, "userName");
driver.findElement(By.id("pass")).sendKeys("12345");
ScreenShoot1.captureScreenShot(driver, "password");
 driver.quit();

		
		
	}

}
