package com.pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;

import com.driver.DriverManager;
import com.enums.WaitStrategyOptions;
import com.reports.ExtentLogger;
import com.utils.WaitStrategyUtils;

public class BasePage {
	
	protected BasePage() {}
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger(BasePage.class);
	
	public static void sendKeys(By by, String input, WaitStrategyOptions waitStrategy) {
		WaitStrategyUtils.ExplicitWaitStrategy(by, waitStrategy).sendKeys(input);
		ExtentLogger.pass("Entered data into element: " +by+ " and data is: " +input);
		log.info("Entered data into element: " +by+ " and data is: " +input);
	}
	
	public static void click(By by, WaitStrategyOptions waitStrategy) {
		WaitStrategyUtils.ExplicitWaitStrategy(by, waitStrategy).click();
		ExtentLogger.pass("Clicked on web element: " +by);
		log.info("Clicked on web element: " +by);
	}
	
	public static void sendKeys(By by, String input) {
		sendKeys(by,input,WaitStrategyOptions.DEFAULT);
	}
	
	public static void click(By by) {
		click(by,WaitStrategyOptions.DEFAULT);
	}
	
	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
