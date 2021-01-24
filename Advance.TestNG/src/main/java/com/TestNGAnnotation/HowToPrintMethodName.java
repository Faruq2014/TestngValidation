package com.TestNGAnnotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToPrintMethodName {
	
	WebDriver driver;
	
	@BeforeTest
	public void openApp() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.assurancewireless.com/");
		System.out.println(name+ " opnening ");
	}
	
	@Test
	public void titleTest() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(driver.getTitle());
		System.out.println(name+" pass");
	}
	
	
	@Test
	public void urlTest() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(driver.getCurrentUrl());
		System.out.println(name+" pass");
	}
	
	@AfterTest
	public void tearDown() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		driver.quit();
		System.out.println(name+" executed");
	}
}
