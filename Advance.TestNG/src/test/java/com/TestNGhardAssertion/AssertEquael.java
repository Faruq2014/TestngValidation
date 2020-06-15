package com.TestNGhardAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertEquael {
	WebDriver driver;
 @BeforeTest
 public void openTest() {
	 
			//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromiumdriver().setup();
			ChromeOptions options= new ChromeOptions();
			System.setProperty("webdriver.chrome.silentOutput","true"); 
			System.setProperty("webdriver.chrome.args","--disable-logging");
			driver= new ChromeDriver(options);
			//driver = new ChromeDriver();
			driver.get("https://www.gmail.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
			
		}
 
 @Test(priority = 1)
 public void equalTest() {
	 
	 boolean b=driver.findElement(By.xpath("//*[@class='o6cuMc']")).isDisplayed();
		Assert.assertTrue(b);
		
		WebElement element=driver.findElement(By.xpath("//*[@class='o6cuMc']"));
		System.out.println(element.getText());
		String  EXperrorMessage=element.getText();
		String actualErrorMessageString="Enter an email or phone number";
		
		Assert.assertEquals(actualErrorMessageString, EXperrorMessage);
		
		System.out.println("equalTest test pass");
		System.out.println(driver.getTitle());
 }
 
 @Test(priority = 2)
 public void notequalTest() {
	 boolean b=driver.findElement(By.xpath("//*[@class='o6cuMc']")).isDisplayed();
		Assert.assertTrue(b);
		WebElement element=driver.findElement(By.xpath("//*[@class='o6cuMc']"));
		System.out.println(element.getText());
		String  EXperrorMessage=element.getText();
		String actualErrorMessageString="Enter an email or phone ";
		
		//Assert.assertEquals(actualErrorMessageString, EXperrorMessage, "thery are not same");
		
		Assert.assertNotSame(actualErrorMessageString, EXperrorMessage, "they are notSame");
		
		
		
		Assert.assertNotEquals(actualErrorMessageString, EXperrorMessage, "notEquals");
		System.out.println("notequalTest test pass");	 
 }
 @AfterTest
	public void teardown() {
		//driver.quit();
	}
}
