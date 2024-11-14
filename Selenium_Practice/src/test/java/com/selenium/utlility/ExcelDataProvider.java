package com.selenium.utlility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
XSSFWorkbook wb;
XSSFSheet sh;

public ExcelDataProvider() {
	try {
		wb= new XSSFWorkbook(new FileInputStream(new File("C:\\Users\\rajay\\eclipse-workspace\\Selenium_Practice\\TestData.TestData.xlsx")));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
	
	public int getnumericvalue(int sheetNo, int rowNumber, int columnNo) throws IOException{
		
		int n= (int) wb.getSheetAt(sheetNo).getRow(rowNumber).getCell(columnNo).getNumericCellValue();
		return n;
			
	}
	
	public String getStringValue(String sheetName, int rowNumber, int columnNo) throws IOException{
		
		String n= wb.getSheet(sheetName).getRow(rowNumber).getCell(columnNo).getStringCellValue();
		return n;
	}
}
