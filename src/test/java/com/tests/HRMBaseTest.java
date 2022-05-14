package com.tests;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.driver.Driver;

public class HRMBaseTest {

	@BeforeMethod
	public void launchApp(Object[] data) {
		Driver.initDriver(((HashMap<String, String>) data[0]).get("Browser"));
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quitDriver();
	}
	
}
