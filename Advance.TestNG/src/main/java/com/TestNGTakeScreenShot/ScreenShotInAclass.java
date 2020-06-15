package com.TestNGTakeScreenShot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShotInAclass {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		driver = new FirefoxDriver();
		driver.get("https://www.salesforce.com/");
		System.out.println("fairfox driver manager with supress console log coding ");
		System.out.println(driver.getCurrentUrl());
		// screen shot method
		TakesScreenshot tScreenshot=(TakesScreenshot)driver;
		 File src=tScreenshot.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("./ScreenShot/ScreenShotInAclass.png"));
		 
		driver.quit();
	}

}
