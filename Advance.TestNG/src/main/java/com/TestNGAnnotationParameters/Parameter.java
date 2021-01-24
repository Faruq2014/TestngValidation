package com.TestNGAnnotationParameters;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameter {
	
	WebDriver driver=null;
	
	@BeforeTest
	@Parameters({"browser"})
	public void openApp(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}else {
			System.out.println("driver is not good");
		}
		
		
		driver.get("https://www.assurancewireless.com/");
		System.out.println("before test starting");
	}
	
	@Test()
	@Parameters({"userName","password"})
	public void loginTest(String userName, String password ) {
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		Set<String> handle=driver.getWindowHandles();
		 
		Iterator<String>iter=handle.iterator();
		String pWindow=iter.next();
		String cWindow=iter.next();
		driver.switchTo().window(cWindow);
		
		driver.findElement(By.id("min")).sendKeys(userName);
		driver.findElement(By.name("vkey")).sendKeys(password);
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
