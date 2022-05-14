package com.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.constants.FrameworkConstants;
import com.driver.DriverManager;
import com.enums.WaitStrategyOptions;

// Final class so that it should not be extended
public final class WaitStrategyUtils {

	// So that no object should be created
	private WaitStrategyUtils() {}
	
	private static Logger log = LogManager.getLogger();
	
	public static WebElement ExplicitWaitStrategy(By by, WaitStrategyOptions waitOption) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver());
		wait.withTimeout(Duration.ofSeconds(FrameworkConstants.getMaxExplicitWaitInSeconds())).
				pollingEvery(Duration.ofSeconds(FrameworkConstants.getExplicitWaitPollingDuration())).ignoring(NoSuchElementException.class);
		if(waitOption.equals(WaitStrategyOptions.PRESENCE)) {
			log.info("Inside WaitStrategy PRESENCE of element: "+by);
			return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if(waitOption.equals(WaitStrategyOptions.CLICKABLE)) {
			log.info("Inside WaitStrategy CLICKABLE of element: "+by);
			return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(by));
		} else if(waitOption.equals(WaitStrategyOptions.DISPLAYED)) {
			log.info("Inside WaitStrategy DISPLAYED of element: "+by);
			return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else {
			return DriverManager.getDriver().findElement(by);
		}
	}
}
