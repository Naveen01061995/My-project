package com.Zoho.lib;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import com.Zoho.TestCases.CommonPaths;

public class ExecllMethods implements CommonPaths {

	public static FileInputStream fis;
	public static int rowCount;
	public static int columnCount;
	public static String geCellValue;
	public static Object[][] obj;

	public static int getRowCount(String excelFileName, String excelSheetName) {

		try {

			rowCount = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
					.getSheet(excelSheetName).getLastRowNum();

		} catch (Exception e) {

		}
		return rowCount;

	}

	public static int getColumnCount(String excelFileName, String excelSheetName, int rowNumber) {

		try {

			columnCount = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
					.getSheet(excelSheetName).getRow(rowNumber).getLastCellNum();

		} catch (Exception e) {

		}
		return columnCount;

	}

	public static String getPerticularCellValue(String excelFileName, String excelSheetName, int rowNumber,
			int columnNmuber) {

		try {

			geCellValue = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
					.getSheet(excelSheetName).getRow(rowNumber).getCell(columnNmuber).toString();

		} catch (Exception e) {

		}
		return geCellValue;

	}

	public static Object[][] getAllCellValue(String excelFileName, String excelSheetName) {

		try {

			int rowcount = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
					.getSheet(excelSheetName).getLastRowNum();
			int columncount = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
					.getSheet(excelSheetName).getRow(1).getLastCellNum();
			obj = new Object[rowcount][columncount];
			for (int i = 1; i <= rowcount; i++) {
				for (int j = 0; j < columncount; j++) {
					obj[i - 1][j] = WorkbookFactory.create(new FileInputStream(EXCEL_PATH + excelFileName + ".xlsx"))
							.getSheet(excelSheetName).getRow(i).getCell(j).toString();
				}
			}

		} catch (Exception e) {

		}
		return obj;

	}
}
