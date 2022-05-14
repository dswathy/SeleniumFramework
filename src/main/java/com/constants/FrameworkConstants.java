package com.constants;

import com.enums.PropertyFileConstants;
import com.utils.PropertyUtils;

//Final class so that no one can inherit it
public final class FrameworkConstants {

	// Private constructor so that other class can not create object
	private FrameworkConstants() {}
	
	private static final String RESOURCE_PATH = System.getProperty("user.dir");
	private static final String CONFIG_PROPERTY_PATH = RESOURCE_PATH + "\\src\\main\\resources\\config.properties";
	private static final String TEST_DATA_FILE_PATH = RESOURCE_PATH + "\\src\\main\\resources\\data\\Test Data.xlsx";
	private static final String EXTENT_REPORT_FILE_PATH = RESOURCE_PATH + "\\extent-reports";
	private static final int MAX_EXPLICIT_WAIT_IN_SECONDS = 10;
	private static final int EXPLICIT_WAIT_POLLING_DURATION = 2;
	
	public static String getConfigPropertyPath() {
		return CONFIG_PROPERTY_PATH;
	}
	public static String getTestDataFilePath() {
		return TEST_DATA_FILE_PATH;
	}
	public static int getMaxExplicitWaitInSeconds() {
		return MAX_EXPLICIT_WAIT_IN_SECONDS;
	}
	public static int getExplicitWaitPollingDuration() {
		return EXPLICIT_WAIT_POLLING_DURATION;
	}
	public static String getExtentReportFilePath() {
		if(PropertyUtils.readProperty().get(PropertyFileConstants.OVERRIDEREPORTS.toString()).equalsIgnoreCase("yes")) {
			return EXTENT_REPORT_FILE_PATH + "\\index_" + System.currentTimeMillis()+ ".html";
		} else { 
			return EXTENT_REPORT_FILE_PATH + "\\index.html";
		}
	}
	
	
}
