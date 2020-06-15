package com.TestNGavoidConsoleLog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeConsoleLog {
	
	public static WebDriver driver;
@Test
public void m1() {
	System.out.println("Bismillah");
	
	
}

//@Test
public void m2() {
	//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	WebDriverManager.chromiumdriver().setup();
	ChromeOptions options= new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput","true"); 
	System.setProperty("webdriver.chrome.args","--disable-logging");
	driver= new ChromeDriver(options);
	//driver = new ChromeDriver();
	driver.get("https://www.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.quit();
}


//@Test
public void m3() {
	// if set up driver with chrome option with silent mode, then there will be no Chrome error log
	ChromeOptions options= new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput","true"); 
    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver(options);
	
	//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup(); 
	//driver = new ChromeDriver();
	driver.get("https://www.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.quit();
}


@Test
public void m4() {
	ChromeOptions options= new ChromeOptions();
	System.setProperty("webdriver.chrome.silentOutput","true"); 
	System.setProperty("webdriver.chrome.args","--disable-logging");
System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver(options);
	
	//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
	//WebDriverManager.chromedriver().setup(); 
	//driver = new ChromeDriver();
	driver.get("https://www.salesforce.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.quit();
}

//@Test
public void m5() {
	 //setup the chromedriver using WebDriverManager
    WebDriverManager.chromedriver().setup();

    //Create Chrome Options
    ChromeOptions options = new ChromeOptions();
   
	System.setProperty("webdriver.chrome.silentOutput","true"); 
   
   // WebDriver driver = new ChromeDriver(option);
	driver= new ChromeDriver(options);
    //Navigate to a URL
    driver.get("http://toolsqa.com");

    //quit the browser
    driver.quit();
}

}