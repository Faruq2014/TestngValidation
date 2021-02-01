package com.TestNGDataProvider;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider2 {
	WebDriver driver=null;

	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "test-data")
	public void loginTest(String userName, String password) {
		driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		//how to switch to child window, since we have two window open
		Set<String> wHandle=driver.getWindowHandles();
		Iterator<String> itor=wHandle.iterator();
		String parentWindow=itor.next();
		String childWindow=itor.next();
		driver.switchTo().window(childWindow);
		// now we are on child window.
		
		//driver.findElement(By.id("min")).clear(); // deleting pre existing user name
		driver.findElement(By.id("min")).sendKeys(userName);
		//driver.findElement(By.id("vkey")).clear(); // deleteing pre existing password
		driver.findElement(By.name("vkey")).sendKeys(password);
		// lets go back to parent window
		driver.switchTo().window(parentWindow);
	}
	
	@DataProvider(name = "test-data")
    public Object[][] dataProvider(){
		return new Object[][] {
			{"Kamal","1234"},
			{"Nahida","5678"}

		};

	}

	//@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
