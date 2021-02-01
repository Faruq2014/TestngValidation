package com.TestNGDataProvider;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider {
	WebDriver driver= null;

	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "LoginData")

	public void loginTest(String userName, String password) {
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		// window handle
		Set<String>	handle=driver.getWindowHandles();	
		Iterator<String> itor=handle.iterator();
		String pwindow=itor.next();
		String Cwindow=itor.next();

		driver.switchTo().window(Cwindow);

		driver.findElement(By.id("min")).sendKeys(userName);
		driver.findElement(By.name("vkey")).sendKeys(password);
		// lets go back to parent window
		driver.switchTo().window(pwindow);

	}

	@org.testng.annotations.DataProvider(name="LoginData")
	private Object[][] dataProvider(){

		return new Object[][]{
			{"Shasin", "1234"},
			{"nahida",  "2435"},
			{"Murad",  "02435"}
		};

	}
	@AfterTest
	public void destroy() {
		driver.quit();
	}

}
