package com.TestNGcustomAssert;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;

public class RegistrationTest {
	
@Test
public void Retest1() {
	CustomAssert.customAssertEquals("faruq", "faruq");
	System.out.println(" this is test one Reg");
}

@Test
public void Retest2() {
CustomAssert.customAssertEquals("faruq", "q");
System.out.println("this is test two Reg");
}

@Test
public void Retest3() {
CustomAssert.customAssertEquals(6, 3);
System.out.println("this is test three Reg");
}

@Test
public void Retest4() {
	String name = "Faruq";
CustomAssert.customAssertTrue(name.contains("q"));
System.out.println("this is test Four Reg");
}

@Test
public void Retest5() {
	String name = "Faruq";
CustomAssert.customAssertrFalse(name.contains("q"));
System.out.println("this is test Five Reg");
}

@Test
public void Retest6() {
	Reporter.log("this is REGtest Six ignored");
System.out.println("this is test Six Reg");
 new SkipException("working on method Reg six");
}

}
