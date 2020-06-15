package com.TestNGTakeScreenShotWithBaseTest;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener2.class)
public class LoginTest extends BaseTest{
	
	@BeforeMethod
	public void setUpBrowser() {
		init("chrome");
		driver.get("http://www.facebook.com");
	}
	@AfterMethod
	public void closeTest() {
		driver.quit();
	}
	
@Test(priority = 1,groups = "smoke")
public void userName() {
	
	driver.findElement(By.id("mail")).sendKeys("faruq");
}


@Test(priority = 2,groups = "sanity")
public void password() {
driver.findElement(By.id("pass")).sendKeys("faruq");
}

@Test(priority = 3,groups = "smoke")
public void loginButton() {
driver.findElement(By.id("button")).click();
}

}
