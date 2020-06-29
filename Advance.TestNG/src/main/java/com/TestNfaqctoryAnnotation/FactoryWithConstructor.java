	package com.TestNfaqctoryAnnotation;
	
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestNGTakeScreenShotWithBaseTest.RegistrationTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.*;
	
	public class FactoryWithConstructor {
		String username;
		String password;
		public FactoryWithConstructor(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public WebDriver driver=null;
	
		@BeforeClass
		public void init() {
			WebDriverManager.chromiumdriver().setup();
			ChromeOptions options= new ChromeOptions();
			System.setProperty("webdriver.chrome.silentOutput","true"); 
			System.setProperty("webdriver.chrome.args","--disable-logging");
			driver= new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		@Test 
		public void LoginTest() throws InterruptedException {
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.id("loginbutton")).click();
			Thread.sleep(2000);
			System.out.println("this is login test");
		}
		
		 @Test
	public void SFloginTest() {
		System.out.println("this is salesforce  test");
		driver.get("https://www.salesforce.com/");
		driver.findElement(By.xpath("//div[@class='global-nav-login-flydown global-login']/div/div/a")).click();
		driver.findElement(By.cssSelector("[type='email']")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='pw'][type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("[id^='forgot_password']")).click();
    
		    }
		@Test
		public void RegistrationTest() {
			System.out.println("this is registration");
		}

		 @Test
			public void messangerTest() {
				System.out.println("this is messanger test");
			}
		 
		@AfterClass
		public void Destroyable() {
			 driver.quit();
		}
	
	
	
	
}