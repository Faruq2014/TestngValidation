package com.TestNGhardAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertWithTryCatch {
	public static WebDriver driver;

	@BeforeClass
	public void setUP() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * you can avoid hard assert by try catch and finally block.
	 * all the code we should write on finally block
	 * as a result we will still have our finally block working.
	 * same thing we can do with soft assert. 
	 */
	@Test
	public void testOne() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,5);
			Boolean isTitleContain = wait.until(ExpectedConditions.titleContains("Salesforce:"));
			System.out.println("title Contains Salesforce " + isTitleContain);
			Assert.assertEquals(driver.getTitle(), " Faruq Molla ");
		} catch (Exception e) {

			e.printStackTrace();
		}finally {

			WebDriverWait	wait = new WebDriverWait(driver, 10);
			By dropdown = By.xpath("//div[@class='dropdown']/a");
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dropdown));
			element.click();
			System.out.println("Executed Finaly block eventhough Assertion is failed");
			driver.quit();
		}
	}
}
