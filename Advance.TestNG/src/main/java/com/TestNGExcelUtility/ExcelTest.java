package com.TestNGExcelUtility;

public class ExcelTest {

	public static void main(String[] args) {
		String projectPath=System.getProperty("user.dir");
		// String projectPath1="C:\\Users\\Faruq\\git\\TestngValidation\\Advance.TestNG\\excel\\data.xlsx";
		
		ExcelUtils excel= new ExcelUtils(projectPath+"/excel/data2.xlsx", "sheet1");
		excel.getRowCount();
		excel.getColCount();
		System.out.println();
		
		System.out.println("<<<<<<< getting String data using string value method>>>>>");
		excel.getStringCellData(0, 0);
		System.out.println();
		
		System.out.println("<<<<<<< getting numeric data using numeric value method>>>>>");
		excel.getNumericCellData(4, 0);
		System.out.println();
		
		System.out.println("<<<<<<< getting anytype data using iterator>>>>>");
		excel.itreator();
		System.out.println();
		
		System.out.println("<<<<<<< getting only string  data using Loop>>>>>");
		excel.AllStringCellData();
		System.out.println();
		
		System.out.println("<<<<<<< getting only numeric  data using Loop>>>>>");
		excel.AllNumericCellData();
		

	}

}
