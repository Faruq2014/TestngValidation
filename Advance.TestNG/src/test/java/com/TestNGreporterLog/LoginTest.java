package com.TestNGreporterLog;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.*;

public class LoginTest {

	@Test
	public void test1() {

		System.out.println("this is test one");
		Reporter.log("this is test one");
	}

	@Test
	public void test2() {

		System.out.println("this is test two");
		Reporter.log("this is test two");
	}

	@Test
	public void test3() {

		System.out.println("this is test three");
		Reporter.log("this is test three");
		assertEquals(true, false);
	}

	@Test(dependsOnMethods = "test3")
	public void test4() {
		System.out.println("this is test Four");
		Reporter.log("4th method ignored");

	}
}
