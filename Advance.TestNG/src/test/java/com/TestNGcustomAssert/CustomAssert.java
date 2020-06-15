package com.TestNGcustomAssert;

import org.testng.Assert;
import org.testng.Reporter;

public class CustomAssert extends Assert{
	
	public static  void customAssertEquals(String actual,String expected) {
	try {
		assertEquals(actual, expected);
	} catch (Error  e) {
	Reporter.log("Error"+ e.getLocalizedMessage());
	}
}
	
	public static  void customAssertEquals(int actual,int expected) {
		try {
			assertEquals(actual, expected);
		} catch (Error  e) {
		Reporter.log("Error"+ e.getLocalizedMessage());
		}
	}
	
	
	public static  void customAssertTrue(boolean condition) {
	try {
		assertTrue(condition);
	} catch (Error  e) {
	Reporter.log("Error"+ e.getLocalizedMessage());
	}
}
	
	public static  void customAssertrFalse(boolean condition) {
		try {
		assertFalse(condition);
		} catch (Error  e) {
		Reporter.log("Error"+ e.getLocalizedMessage());
		}
	}
}
