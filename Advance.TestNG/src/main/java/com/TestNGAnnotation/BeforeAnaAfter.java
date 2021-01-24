	package com.TestNGAnnotation;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	
	import io.github.bonigarcia.wdm.WebDriverManager;
	
	public class BeforeAnaAfter {
		public WebDriver driver;
		/*
		 * BeforeSuite
			BeforeTest
			BeforeClass
			BeforeMethod
			Test Case 1
			AfterMethod
			BeforeMethod
			Test Case 2
			AfterMethod
			AfterClass
			AfterTest
			AfterSuite
	
		 */
		
		// point to note that before test run before class.
		
		
		@BeforeSuite
		public void beforSuit() {
			System.out.println("this is smoke suit starting");
		}
		
		@BeforeClass
		public void openBrowser() {
			
			System.out.println("Before class is starting");
		}
		
		
		@BeforeTest
		public void openApp() {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
			driver.get("https://www.assurancewireless.com/");
			System.out.println("before test starting");
			String name = new Object(){}.getClass().getEnclosingMethod().getName();
			System.out.println(name);
		}
		@BeforeMethod
		public void BeforeMethod() {
			String name = new Object(){}.getClass().getEnclosingMethod().getName();
			System.out.println(name);

		}
		
		@Test
		public void titleTest() {
			System.out.println(driver.getTitle());	
			System.out.println("this is test");
			urlTest();
		}
		
		
		// this is method.
		public void urlTest() {
			System.out.println(driver.getCurrentUrl());
		}
		
		
		
		@AfterTest
		public void closeApp() {
			
		System.out.println("this is after test ");
		}
		
		@AfterClass
		public void tearDown() {
			System.out.println("this is after class");
			driver.quit();
		}
		
		@AfterSuite
		public void afterSuit() {
			System.out.println("this is after suit");
		}
	
	}
