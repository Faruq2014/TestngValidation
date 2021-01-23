package com.TestNGParallelWithBaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Parallel extends BaseTest{

	
	@Test 
	public void getURL1() {
		getDriver().get("https://www.google.com/");
		System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the title is "+getDriver().getTitle());
		getDriver().findElement(By.name("q")).sendKeys("Selenium Java");
		System.out.println("pass test 1.......");
	}
	
	
	@Test 
	public void getURL2() {
		getDriver().get("https://www.facebook.com/");
		System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the url is "+getDriver().getCurrentUrl());
		System.out.println("pass test 2.......");
	}
	
	@Test 
	public void getURL3() {
		getDriver().get("https://salesforce.com");
		System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the url is "+getDriver().getCurrentUrl());
		System.out.println("pass test 3.......");
	}
	
	@Test
	public void getURL4() {
		getDriver().get("https://www.assurancewireless.com/");
		System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the url is "+getDriver().getCurrentUrl());
		getDriver().findElement(By.xpath("(//a[contains(text(),'My Account Login')])[1]")).click();
		System.out.println("pass test 4.......");
	}
	
	
	
}
