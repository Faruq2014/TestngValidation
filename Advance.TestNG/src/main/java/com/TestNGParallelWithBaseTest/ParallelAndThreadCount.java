package com.TestNGParallelWithBaseTest;

import org.testng.annotations.Test;

public class ParallelAndThreadCount extends BaseTest{

	
	@Test //(priority = 1) // if you use priority then parallel testing will not work.
	public void getURL1() {
		getDriver().get("https://www.google.com/");
		System.out.println("Thread number  | "+Thread.currentThread().getId());
		System.out.println("the title is "+getDriver().getTitle());
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
		System.out.println("pass test 4.......");
	}
	
	
	
}
