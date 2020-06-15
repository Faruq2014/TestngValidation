package com.TestNGIReporter;

import org.testng.SkipException;
import org.testng.annotations.*;

public class RegistrationTest {
	
@Test
public void Retest1() {
	
	System.out.println(" this is test one Reg");
}

@Test
public void Retest2() {

System.out.println("this is test two Reg");
}

@Test
public void Retest3() {

System.out.println("this is test three Reg");
}

@Test
public void Retest4() {
	String name = "Faruq";

System.out.println("this is test Four Reg");
}

@Test
public void Retest5() {
	String name = "Faruq";

System.out.println("this is test Five Reg");
}

@Test
public void Retest6() {

System.out.println("this is test Six Reg");
 new SkipException("working on method Reg six");
}

}
