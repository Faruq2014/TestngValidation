package com.TestNGiTestListenerPackage;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class RegistrationTest {

	@Test
	public void m1() {
		System.out.println("this test one");
	}

	@Test
	public void m2() {
		System.out.println("this test two");
		Assert.assertTrue(false);
	}

	@Test
	public void m3() {
		System.out.println("this test three");
		throw new SkipException("test three, fix it later");
	}

}
