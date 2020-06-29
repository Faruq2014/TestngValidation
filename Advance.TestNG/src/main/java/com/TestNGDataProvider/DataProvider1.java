	package com.TestNGDataProvider;
	
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestNGTakeScreenShotWithBaseTest.RegistrationTest;

import org.testng.*;
	
	public class DataProvider1 {
		
		public WebDriver driver=null;
	
		@BeforeTest
		public void init() {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		
		@Test(dataProvider = "loginData") // name method
		
		//@Test(dataProvider = "getData") // data provider method name. 
		
		public void LoginTest(String username, String password) throws InterruptedException {
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.id("pass")).sendKeys(password);
			driver.findElement(By.id("loginbutton")).click();
			Thread.sleep(2000);
			System.out.println("this is log in test");
		}
		
		
		@DataProvider(name="loginData") // name method
		
		
	  // @DataProvider
		public Object[][] getData() {
			Object[][] pData =new Object[2][2];
			
			pData[0][0]="user1";
			pData[0][1]="1234";
			
			pData[1][0]="user2";
			pData[1][1]="456";
			
			
			return pData;
		}
	    
	    @Test
		public void RegistrationTest() {
			System.out.println("this is registration test");
		}
	    
	    @Test
		public void messangerTest() {
			System.out.println("this is messanger test");
		}
	    
		@AfterTest
		public void Destroyable() {
			// driver.quit();
		}
	
	
	
	
}