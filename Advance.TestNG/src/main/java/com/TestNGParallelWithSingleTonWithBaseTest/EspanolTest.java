package com.TestNGParallelWithSingleTonWithBaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EspanolTest extends BaseTest {
	@Test
	public void EspanolLanguageTest () {
		System.out.println("Assalamualaikum");
		driver.findElement(By.linkText("En Español")).click();
		System.out.println("Espanol title is "+ driver.getTitle());
	}

}
