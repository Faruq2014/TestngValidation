	package com.TestNGParallelWithSingleTonClass;
	
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
	
	public class SearchTest {
	public WebDriver driver=null;
	
	@BeforeClass
	@Parameters({"Browser"})
	 void setUp(String Browser) {
		driver= BrowserFactory.getBrowser(Browser);
		DriverFactory.getInstance().setDriver(driver);
		DriverFactory.getInstance().getDriver();
		driver.get("https://www.google.com/");
	}
	@Test
	@Parameters({"search"})
	public void searchTest(String search) {
		//driver.get("https://www.google.com/");
		//System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the title is "+driver.getTitle());
		driver.findElement(By.name("q")).sendKeys(search);
		
	}
	
	//@AfterClass
	public void tearDownTest() {
		DriverFactory.getInstance().removeDriver();
	}
	
	
	
	
	}
