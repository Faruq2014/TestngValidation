		package com.TestNGiTestListenerPackage;
		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.chrome.ChromeOptions;
		import org.testng.Assert;
		import org.testng.SkipException;
		import org.testng.annotations.AfterTest;
		import org.testng.annotations.Test;
		
		import com.TestNGUtility.ScreenShoot1;
		
		import io.github.bonigarcia.wdm.WebDriverManager;
		
		public class LoginTest {
		
			public static WebDriver driver;
		
			@Test
			public void m1() {
				System.out.println("this test one");
			}
		
			@Test
			public void m2() {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				System.setProperty("webdriver.chrome.silentOutput", "true");
				driver = new ChromeDriver(options);
				driver.get("http://www.facebook.com");
				driver.findElement(By.id("email")).sendKeys("faruq");
				driver.findElement(By.id("ass")).sendKeys("12345");
		
			}
		
			@Test
			public void m3() {
				System.out.println("this test three");
				throw new SkipException("test three, fix it later");
			}
		
			@AfterTest
			public void destriy() {
				driver.quit();
			}
		
		}
