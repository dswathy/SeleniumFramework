package com.enums;

public enum ExcelSheetNames {

	TEST_MANAGER("Test Manager"),
	LOGIN_TEST("Login Test");
	
	private String value;
	
	ExcelSheetNames(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
}
