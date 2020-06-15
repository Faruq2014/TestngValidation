package com.TestNGUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShoot1 {

	public static void captureScreenShot(WebDriver driver, String ScreenShot) {
		 try {
		TakesScreenshot ts = (TakesScreenshot)driver;
	   File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShot/"+ScreenShot+".png"));
		System.out.println("screen shot taken");
		
	} catch (IOException e) {
		System.out.println("screen shot were not taken"+e.getMessage());
		
	}
	}
}
