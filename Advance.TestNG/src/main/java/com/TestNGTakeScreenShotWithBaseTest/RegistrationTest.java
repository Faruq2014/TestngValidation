package com.TestNGTakeScreenShotWithBaseTest;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RegistrationTest extends BaseTest{
	
	@BeforeMethod
	public void setUpBrowser() {
		init("firefox");
		driver.get("http://www.facebook.com");
	}
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
	
@Test(priority = 1,groups = "smoke")
public void userName() {
	
	driver.findElement(By.id("email")).sendKeys("faruq");
}


@Test(priority = 2,groups = "sanity")
public void password() {
driver.findElement(By.id("pass")).sendKeys("faruq");
}

@Test(priority = 3,groups = "smoke")
public void loginButton() {
driver.findElement(By.id("button")).click();
}


@Test(priority = 3,groups = "smoke")
public void skipTest() {
	throw new SkipException("will fix it later");
}

}
