package com.TestNGhardAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	WebDriver driver;
	@Test
	public void test() throws InterruptedException {

		String expectedTitle = "Google";
		String expectedText = "selenium - Google Search";
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");

// Validate if actual web page title matches with that of expected title using assert true method
		System.out.println("Assert true method validation");
		Assert.assertTrue(expectedTitle.equals(driver.getTitle()));

// Enter the keyword selenium on the search textbox
		WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
		searchBox.sendKeys("selenium");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(8000);

// Validate the actual page title with expected page title using assert equals method
		System.out.println("Assert equals method validation");
		Assert.assertEquals(expectedText, driver.getTitle());

// Page title validation using assert false method
		System.out.println("Assert false method validation");
		Assert.assertFalse(expectedTitle.equals(driver.getTitle()));

// Close the current browser
		driver.close();
	}
}
