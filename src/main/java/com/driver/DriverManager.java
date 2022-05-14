package com.driver;

import org.openqa.selenium.WebDriver;

// Final so that no class can extend this class
public final class DriverManager {
	
	// Private constructor so that other class cannot create object of this class
	private DriverManager() {}
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driver) {
		dr.set(driver);
	}
	
	public static void unload() {
		dr.remove();
	}

}
