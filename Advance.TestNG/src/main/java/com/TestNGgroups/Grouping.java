package com.TestNGgroups;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Grouping {
	@BeforeTest
	public void openTest() {
		System.out.println("opening test");
		
	}
	
	@Test(groups={"smoke, functional"})
	public void test1() {
		
	}
	
	@Test(groups={"functional"})
	public void test2() {
		
	}
	@Test(groups={"regression"})
	public void test3() {
		
	}
	@Test(groups={"e2e test"})
	public void test4() {
		
	}
	@Test(groups={"intigration"})
	public void test5() {
		
	}
	
	@Test(groups={"smoke"})
	public void test6() {
		
	}

}
