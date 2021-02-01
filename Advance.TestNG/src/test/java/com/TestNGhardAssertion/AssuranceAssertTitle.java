package com.TestNGhardAssertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssuranceAssertTitle {
	


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
		
		String homeTitle=driver.getTitle();
		System.out.println(homeTitle);
		
		String NotactualTitleString="faruq.com";
		Assert.assertNotEquals(NotactualTitleString, homeTitle, "this is not actual title");
		
		
		
		String actualHometitleString="Lifeline Cell Phone Service Provider | Assurance Wireless";
		Assert.assertEquals(actualHometitleString, homeTitle);
		
		Assert.assertSame(actualHometitleString, homeTitle);
		
		
		
		WebElement login = driver.findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]"));
		boolean b=login.isEnabled();
		Assert.assertTrue(b);
		//Assert.assertFalse(b);
		System.out.println("functional test pass");
		
		
		
		// look and feel
		String loginText = login.getText();// getText() return string.
		System.out.println(loginText);
		String acutualtString ="My Account Login";
		Assert.assertEquals(acutualtString, loginText);
		Assert.assertEquals(acutualtString, loginText, "test fail");
		
	}

	
	
	
	@AfterTest
	public void destroy() {
		driver.quit();
	}


	
	

}
