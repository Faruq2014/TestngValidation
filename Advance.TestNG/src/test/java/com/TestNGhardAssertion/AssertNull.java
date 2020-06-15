package com.TestNGhardAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertNull {

	WebDriver driver=null;
	String name;
	int id =2;

	//@Test(priority = 1)
	public void CheckVariable() {
		Assert.assertNull(name, "not null");
		System.out.println("name is null – Assert passed");
		Assert.assertNotNull(id, "isnull");
		System.out.println("id is not null – Assert Not Null  passed");
	}

	//@Test(priority = 2)
	public void driverNull() {

		Assert.assertNull(driver);
		System.out.println("Driver is null – Assert passed");
	}

	//@Test(priority = 3)
	public void driverNotNull() throws InterruptedException {
		// WebDriver driver=null;
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		driver = new ChromeDriver(options);
		Assert.assertNotNull(driver);
		System.out.println("Driver is not null – Assert passed");
		driver.quit();
	}
	
	@Test(priority = 4)
	public void checkAttributes() throws InterruptedException {
		 //WebDriver driver=null;
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		driver = new ChromeDriver(options);
		driver.get("https://www.gmail.com/");
		driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		WebElement element = driver.findElement(By.xpath("//*[@class='o6cuMc']"));
		String EXperrorMessage = element.getText();
		System.out.println(EXperrorMessage);
		Assert.assertNotNull(EXperrorMessage);
		System.out.println("Attributes is not null – Assert passed");
		driver.quit();
	}
}
