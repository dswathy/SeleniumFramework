package com.enums;

public enum ExcelColumnConstants {
	
	TEST_CASE_NAME("Test Case Name"),
	TEST_CASE_DESCRIPTION("Test Case Description"),
	EXECUTE("Execute"),
	PRIORITY("Priority");
	
	private String value;
	
	ExcelColumnConstants(String value){
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

}
