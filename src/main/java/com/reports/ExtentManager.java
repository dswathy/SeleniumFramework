package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {}
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	protected static ExtentTest getExtentTest() {
		return extentTest.get();
	}
	
	protected static void setExtentTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	protected static void uload() {
		extentTest.remove();
	}
	
}
