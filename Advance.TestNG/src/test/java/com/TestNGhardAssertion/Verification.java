package com.TestNGhardAssertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verification {

	WebDriver driver;
	@Test
	public void test() throws InterruptedException {

		String expectedTitle = "Google";
		String wrongTitle = "Google1";
		String expectedText = "selenium - Google Search";
		String wrongText = "selenium1 - Google Search";
		
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");

// Verify if actual web page title matches with that of expected title using if else
		if (wrongTitle.equalsIgnoreCase(driver.getTitle())) {
		System.out.println("Verification title pass");	
		} else {
			System.out.println("Verification title fail");
		}
		
		// Validate if actual web page title matches with that of expected title using assert true method
		Assert.assertTrue(expectedTitle.equals(driver.getTitle()));

// Enter the keyword selenium on the search textbox
		WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
		searchBox.sendKeys("selenium");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(8000);

// Verify the actual page title with expected page title using if else
		if (wrongText.equalsIgnoreCase(driver.getTitle())) {
			System.out.println("Verification text pass");
		} else {
			System.out.println("Verification text fail");
		}
		
		// Validate the actual page title with expected page title using assert equals method
		Assert.assertEquals(expectedText, driver.getTitle());

		System.out.println("Assert false method validation");
		Assert.assertFalse(expectedTitle.equals(driver.getTitle()));

// Close the current browser
		driver.close();
	}
}
