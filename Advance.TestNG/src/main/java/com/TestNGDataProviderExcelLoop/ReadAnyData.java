package com.TestNGDataProviderExcelLoop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadAnyData {

	public WebDriver driver = null;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		Object data [][]=UtilLoop.getData("Sheet2");
		return data;
	}
	

	@Test(dataProvider = "getLoginData")
	public void LoginTest(String username, String password) throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void Destroyable() {
		driver.quit();
	}
}
