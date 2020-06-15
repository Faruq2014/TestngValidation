package com.TestNGcustomAssert;

import org.testng.annotations.*;

public class LoginTest {
	
@Test
public void test1() {
	CustomAssert.customAssertEquals("faruq", "faruq");
	System.out.println("this is test one");
}

@Test
public void test2() {
CustomAssert.customAssertEquals("faruq", "q");
System.out.println("this is test two");
}

@Test
public void test3() {
CustomAssert.customAssertEquals(6, 3);
System.out.println("this is test three");
}

@Test
public void test4() {
	String name = "Faruq";
CustomAssert.customAssertTrue(name.contains("q"));
System.out.println("this is test Four");
}
}
