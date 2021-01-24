package com.TestNGAnnotationAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Priority {
	
	WebDriver driver=null;
	
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://www.assurancewireless.com/");
		System.out.println("before test starting");
	}
	
	@Test(priority = 0)
	public void khaled() {
		System.out.println("this is khaled and test1");
		System.out.println(driver.getTitle());
	}
	
	@Test(priority = 1)
	public void murad() {
		System.out.println("this is murad and test2");
		System.out.println(driver.getTitle());
	}
	@Test(priority = 2)
	public void asma() {
		System.out.println("this is asma and test3");
		System.out.println(driver.getTitle());
	}
	@Test(priority = 3)
	public void farid() {
		System.out.println("this is farid and test4");
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
