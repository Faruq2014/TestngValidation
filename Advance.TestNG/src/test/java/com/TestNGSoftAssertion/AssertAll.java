package com.TestNGSoftAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertAll {
	WebDriver driver;
	SoftAssert  assertion;
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
			
				
			}
	 
	 @Test(priority = 1)
	 public void equalTest() {
		 assertion=new SoftAssert();
		 assertion.assertEquals(driver.getCurrentUrl(), "yyuuiig", "URL does not match"); ;
			driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		 boolean b=driver.findElement(By.xpath("//*[@class='o6cuMc']")).isDisplayed();
		 assertion.assertTrue(b);
			WebElement element=driver.findElement(By.xpath("//*[@class='o6cuMc']"));
			System.out.println(element.getText());
			String  EXperrorMessage=element.getText();
			String wrongmessage="Enter an email or phone number1";
			assertion.assertEquals(wrongmessage, EXperrorMessage);
			System.out.println("equalTest test pass");
		assertion.assertAll();
	 }
	 
	 @Test(priority = 2)
	 public void notequalTest() {
		String AcutalTitle=driver.getTitle();
		 assertion=new SoftAssert();
		 assertion.assertTrue(AcutalTitle.contains("Gmail11111"),"title does not match");
		 System.out.println("Pass assert true test");
		 
		driver.findElement(By.xpath("//*[@id='identifierNext']")).click();
		 boolean b=driver.findElement(By.xpath("//*[@class='o6cuMc']")).isDisplayed();
		     assertion.assertTrue(b);
			WebElement element=driver.findElement(By.xpath("//*[@class='o6cuMc']"));
			System.out.println(element.getText());
			String  EXperrorMessage=element.getText();
			String actualErrorMessageString="Enter an email or phone ";
			
			assertion.assertNotNull(EXperrorMessage, "pass not null test");
			System.out.println("Pass assert not null test");
			
			assertion.assertNull(EXperrorMessage, "pass assert null test");
			
			assertion.assertNotSame(actualErrorMessageString, EXperrorMessage, "they are notSame");
			assertion.assertNotEquals(actualErrorMessageString, EXperrorMessage, "notEquals");
			System.out.println("notequalTest test pass");
			assertion.assertAll();
	 }
	 @AfterTest
		public void teardown() {
			driver.quit();
		}
}
