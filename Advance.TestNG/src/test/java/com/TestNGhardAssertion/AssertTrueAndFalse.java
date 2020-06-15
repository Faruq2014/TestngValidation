package com.TestNGhardAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertTrueAndFalse {
	WebDriver driver;

	@BeforeTest
	public void openGmail() {
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		driver = new ChromeDriver(options);
		driver.get("https://www.gmail.com/");// Open browser and pass URL in address bar

	}

	@Test(priority = 1)
	public void verifyAssertTrue() {

		WebElement SignInButton = driver.findElement(By.xpath("//*[@id='identifierNext']"));

		Boolean checkButtonPresence = SignInButton.isDisplayed();

		Assert.assertTrue(checkButtonPresence);

		System.out.println("Button is displayed");
	}

	@Test(priority = 2)
	public void assertTrue() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		WebElement element = driver.findElement(By.xpath("//*[@class='o6cuMc']"));
		System.out.println(element.getText());
		String EXperrorMessage = element.getText();
		String actualErrorMessageString = "Enter an email or phone number";

		Assert.assertTrue(EXperrorMessage.contains(actualErrorMessageString));

		System.out.println("Error message are true");

	}

	 @Test(priority = 3)
	public void assertFalse() {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		WebElement element = driver.findElement(By.xpath("//*[@class='o6cuMc']"));
		System.out.println(element.getText());
		String EXperrorMessage = element.getText();
		String actualErrorMessageString = "Enter an email or phone number1234";
		Assert.assertFalse(EXperrorMessage.contains(actualErrorMessageString));

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
