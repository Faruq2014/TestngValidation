package com.TestNGAnnotationAttributes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dependsOn {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.assurancewireless.com/");
		System.out.println("before test starting");
	}
	
	@Test()
	public void khaled() {
		driver.findElement(By.xpath("ffffff")).click();// Purposely fail
		System.out.println("this is khaled and test1");
		System.out.println(driver.getTitle());
	}
	
	@Test(dependsOnMethods = "khaled")
	public void murad() {
		System.out.println("this is murad and test2");
		System.out.println(driver.getCurrentUrl());
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
