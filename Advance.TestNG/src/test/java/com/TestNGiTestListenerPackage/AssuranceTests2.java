package com.TestNGiTestListenerPackage;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class AssuranceTests2 {
	
	@Test
	public void test1() {
		
		System.out.println("this is test one");
	}

	@Test
	public void test2() {
		
		System.out.println("this is test 2");
		
	}
	
	@Test
	public void test3() {
		Assert.assertEquals("abs", "efg");
		System.out.println("this is test 3");
	}
	
	@Test(dependsOnMethods ="test3" )
	public void test4() {
		
		
	}
	@Test
	public void test5() {
		
		System.out.println("this is test 5");
	}
	@Test
	public void test6() {
		Assert.assertNotEquals("Faruq", "Faruq");
		System.out.println("this is test 6");
	}
}
