package com.TestNGExcelUtility;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	

	
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	

	public ExcelUtils(String excelPath, String sheetName) {
		try {
		 workbook = new XSSFWorkbook(excelPath);
		 sheet=workbook.getSheet(sheetName);	
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}

	
	public  void getRowCount() {
	
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("number of row "+rowCount);
	}
	
	public  void getColCount() {
		int colCount=0; 
		 colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("number of column "+colCount);
	
	}
	
	public  void getStringCellData(int row, int column) {
		String StringcellData=sheet.getRow(row).getCell(column).getStringCellValue();
		
		System.out.println("Cell Data is: "+StringcellData);
	}
	
	public  void getNumericCellData(int row, int column) {
		Double cellDataNumeric=sheet.getRow(row).getCell(column).getNumericCellValue();
		System.out.println("Cell Data is: "+cellDataNumeric);
	}
	
	public  void AllStringCellData() {
		int rowCount=sheet.getPhysicalNumberOfRows();
		int  colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String StringcellData=sheet.getRow(i).getCell(j).getStringCellValue();
				if (StringcellData.equals("khaled")) {
					break;
				}
				System.out.print(StringcellData.toString() + " | ");
			}
			System.out.println();
			break;
		}
	
	}
	
	
	public  void AllNumericCellData() {
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int  colCount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		for (int i = 4; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				Double numericData=sheet.getRow(i).getCell(j).getNumericCellValue();
				System.out.print(numericData + " | ");
			}
			System.out.println();
		
		}
		
	}
	
	
	
	
	public void itreator() {
		Iterator <Row> rowItr=sheet.iterator();
		
		while (rowItr.hasNext()) {
			Row row=rowItr.next();
		Iterator<Cell> cellItr=	row.cellIterator();
		while (cellItr.hasNext()) {
		Cell cell=cellItr.next();
		System.out.print(cell.toString()+ " | ");
		}
		System.out.println();
		}
	}
	
}
