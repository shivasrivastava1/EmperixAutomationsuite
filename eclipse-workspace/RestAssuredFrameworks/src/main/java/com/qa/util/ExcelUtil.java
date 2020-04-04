package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	
	public static Workbook book;
	public static Sheet sheet;
	
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\shiva srivastava\\eclipse-workspace\\RestAssuredFrameworks\\src\\main\\java\\com\\qa\\TestData\\GoRestsTestData.xlsx";

	
	
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			try {
				book = WorkbookFactory.create(file);
				
				sheet = book.getSheet(sheetName);
				
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// For Loop
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0; i<sheet.getLastRowNum(); i++)
		{
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
			
		}
		
		return data;
		
	}
	
	
	
}
