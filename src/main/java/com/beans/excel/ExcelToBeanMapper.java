package com.beans.excel;

import com.enums.ExcelSheetNames;
import com.utils.XceliteUtils;

public final class ExcelToBeanMapper {
	
	private static XceliteUtils excelObj;
	private static ExcelDataBean beanObj;
	
	/**
	 * Read Excel data from Excel sheets and map it to POJO object.
	 */
	private static void mapData() {
		
		excelObj = new XceliteUtils().getInstance();
		beanObj.setTestManager(excelObj.readSheet(ExcelSheetNames.TEST_MANAGER.getValue(), TestManager.class));
		beanObj.setLoginTest(excelObj.readSheet(ExcelSheetNames.LOGIN_TEST.getValue(), LoginTest.class));
		
	}
	
	public static void printPOJOValuesForExcel() {
		mapData();
		int size = beanObj.getTestManager().size();
		for(int i = 0; i<size; i++) {
			System.out.println(beanObj.getTestManager().get(i));
		}
		
		size = beanObj.getLoginTest().size();
		for(int i = 0; i<size; i++) {
			System.out.println(beanObj.getLoginTest().get(i));
		}
		
	}
	

}
