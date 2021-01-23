package com.TestNGParallelWithSingleTonWithBaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EnglishTest extends BaseTest{
	
	@Test
	public void userPassword() {
		System.out.println("Assalamualaikum");
		driver.findElement(By.linkText("En Español")).click();
		driver.findElement(By.linkText("In English")).click();
		System.out.println("English title is "+ driver.getTitle());
	}
	

}
