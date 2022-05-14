package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.constants.FrameworkConstants;
import com.enums.ExcelSheetNames;

// Final class so that no class should directly extend this class
public final class ExcelUtils {

	// Private constructor so that no class should create object of this class
	private ExcelUtils() {}

	private static Logger log = LogManager.getLogger();
	
	/**
	 * This utility will fetch test data from excelsheet passed as param and return data in the form of List of HashMap
	 * @param sheetName
	 * @return 
	 */
	public static ArrayList<HashMap<String, String>> getDataFromExcel(ExcelSheetNames sheetName) {

		HashMap<String,String> excelDataMap = null;
		ArrayList<HashMap<String, String>> excelDataList = new ArrayList<>();
		FileInputStream excelFile = null;
		try {
			excelFile = new FileInputStream(FrameworkConstants.getTestDataFilePath().toString());
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = workbook.getSheet(sheetName.getValue());
			// Fetch total rows in excelsheet
			int lastRowNum = sheet.getLastRowNum();
			// Fetch total columns in excelsheet
			int lastColumnNum = sheet.getRow(0).getLastCellNum();

			for(int i=1;i<=lastRowNum;i++) {
				excelDataMap = new HashMap<>();
				for(int j=0;j<lastColumnNum;j++) {
					excelDataMap.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
				}
				excelDataList.add(excelDataMap);
			}

		} catch (FileNotFoundException e) {
			log.warn("Error while Loading Excel file for reading: " +e.getMessage());
		} catch (IOException e) {
			log.warn("Error while reading excel file data: " +e.getMessage());
		}finally {
			try {
				if(Objects.nonNull(excelFile))
					excelFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("Data read from excel successful for sheet: " +sheetName);
		return excelDataList;
	}

}
