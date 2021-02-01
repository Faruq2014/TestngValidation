package com.TestNGhardAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssuranceSoftAssert {
	


	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void getText() {
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		boolean b=login.isEnabled();
		SoftAssert assertion = new SoftAssert();
		System.out.println("functional test pass");
		//assertion.assertTrue(b);
		assertion.assertFalse(b, "nagative test fail purposly");
		
		// look and feel
		String loginText = login.getText();// getText() return string.
		System.out.println(loginText);
		String acutualtString ="My Account Login";
		Assert.assertEquals(acutualtString, loginText);
		Assert.assertEquals(acutualtString, loginText, "test fail");
		
		assertion.assertAll();
		
	}

	
	
	
	//@AfterTest
	public void destroy() {
		driver.quit();
	}


	
	

}
