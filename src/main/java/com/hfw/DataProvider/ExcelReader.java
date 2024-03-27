package com.hfw.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static Object[][] getdata(String SheetName ) {

		XSSFWorkbook wb =null;

		 try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData\\LoginData.xlsx")));
		} 
		 catch (FileNotFoundException e) {
		System.out.println("File not found"+e.getMessage());
		} 
		 catch (IOException e) {
			System.out.println("could not read file"+e.getMessage());
		}
		int rowcount = wb.getSheet(SheetName).getPhysicalNumberOfRows();
		int colcount = wb.getSheet(SheetName).getRow(0).getPhysicalNumberOfCells();
		System.out.println("Row count" + " " + rowcount);
		System.out.println("column count" + " " + colcount);
		Object[][] arr = new Object[rowcount - 1][colcount];

		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++)

			{

				String value = "";
				CellType type = wb.getSheet(SheetName).getRow(i).getCell(j).getCellType();
				if (type == CellType.NUMERIC) {
					value = String.valueOf(wb.getSheet(SheetName).getRow(i).getCell(j).getNumericCellValue());
				} 
				else if (type == CellType.STRING) {
					value=wb.getSheet(SheetName).getRow(i).getCell(j).getStringCellValue();

				} else if (type == CellType.BOOLEAN) {
					value = String.valueOf(wb.getSheet(SheetName).getRow(i).getCell(j).getBooleanCellValue());

				} else if (type == CellType.BLANK) {
					value = "";
				}
				arr[i - 1][j] = value;
			}
		}
		return arr;

	}
}
