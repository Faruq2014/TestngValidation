package com.TestNGDataProviderText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithCSV {

	public WebDriver driver = null;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "loginData")
	public void LoginTest(String username, String  password) throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("u_0_b")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void Destroyable() {
		driver.quit();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		Object[][] pData = testData();
		return  pData;
	}

	
	@Test
	public Object[][] testData() {
		String path="./excel/data.csv.txt";
		String line="";
		Object[][] data = null;
		int row;
		try {
			BufferedReader bReader=new BufferedReader(new FileReader(path));
			
			while ((line=bReader.readLine()) !=null) {
			System.out.println(line);
			  // data = line.split(",");
			//System.out.println(data[2]);
		 //row=data.length;
		//System.out.println(row);
			
			}
			return data;
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return null;
		
	}

}
