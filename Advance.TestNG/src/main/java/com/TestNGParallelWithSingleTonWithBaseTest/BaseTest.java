package com.TestNGParallelWithSingleTonWithBaseTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public WebDriver driver=null;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUpBrowser(String browser) {
		driver=Browsers.getBrowser(browser);
		DriverThread.getInstance().setDriver(driver);
		DriverThread.getInstance().getDriver();
		driver.get("https://www.assurancewireless.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	

	@AfterTest
	public void tearDownTest() {
		DriverThread.getInstance().removeDriver();
	}
	

}
