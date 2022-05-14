package com.driver;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.enums.PropertyFileConstants;
import com.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {}

	public static WebDriver driver;
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	@SuppressWarnings("unlikely-arg-type")
	public static void initDriver(String browser) {

		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
				log.info("Launched the Chrome browser.");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				DriverManager.setDriver(driver);
				log.info("Launched the Edge browser.");
			} 
			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				DriverManager.setDriver(driver);
				log.info("Launched the Chrome browser.");
			}
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.readProperty().get(PropertyFileConstants.URL.toString()));
		}
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			log.info("Terminated the broswer.");
			DriverManager.unload();
		}
	}

}
