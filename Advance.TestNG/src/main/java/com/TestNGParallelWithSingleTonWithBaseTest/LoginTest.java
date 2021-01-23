package com.TestNGParallelWithSingleTonWithBaseTest;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	@Test
	public void windowHandleTest() {
		driver.findElement(By.xpath("//*[@id='topmost']/div/div/div[3]//a[2]")).click();
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> iter=handler.iterator();
	String parentWindow=iter.next();
	String childWindow=iter.next();
	driver.switchTo().window(childWindow);
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	driver.findElement(By.id("min")).sendKeys("345566666");
	driver.findElement(By.name("vkey")).sendKeys("qwe2334444");
	driver.findElement(By.id("submit")).submit();
	driver.switchTo().window(parentWindow);
	driver.switchTo().window(childWindow);
	}

	

	
}
