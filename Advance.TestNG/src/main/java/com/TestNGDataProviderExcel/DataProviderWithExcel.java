package com.TestNGDataProviderExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithExcel {

	public WebDriver driver = null;

	@BeforeTest
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(dataProvider = "loginData")
	public void LoginTest(String username, String password) throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void Destroyable() {
		driver.quit();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
		String projectPath = "C:\\Users\\Faruq\\git\\TestngValidation\\Advance.TestNG\\excel\\data.xlsx";
		Object[][] pData = testData(projectPath, "sheet1");
		return pData;
	}

	public Object[][] testData(String excelPath, String sheetName) {

		ExcelUtilsWithReturn excel = new ExcelUtilsWithReturn(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object[][] data = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getStringCellData(i, j);
				
				data[i - 1][j] = cellData;
				
				// Double numericDataString=excel.getNumericCellData(i, j);
				System.out.print(cellData + " | ");
			}
			System.out.println();
		}
		return data;
	}

}
