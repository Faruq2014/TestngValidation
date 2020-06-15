package com.TestNGparameter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	
	@BeforeTest
     @Parameters({"browser","url"})
	public void setup(String browser,String url) {if (browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput","true"); 
		driver= new ChromeDriver(options);
		driver.get(url);
		//driver.get("http://www.facebook.com");
	}else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver = new FirefoxDriver();
		driver.get(url);
	}
	
	}
	
	@Test(priority = 1,groups = "functional")
	@Parameters({"userName"})
	public void userNameSoccerTest(String userName ) {
		driver.findElement(By.id("email")).sendKeys(userName);
	}
	@Test(priority = 2,groups = "smoke")
	@Parameters({"pass"})
	public void passwordSoccerTest(String pass) {
		driver.findElement(By.id("pass")).sendKeys(pass);
	}
	
	@Test(priority = 3,groups = "sanity")
	public void loginButtonSoccerTest() {
		driver.findElement(By.id("u_0_b")).click();
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
