package com.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;

public final class ExtentReport {

	private ExtentReport() {}

	private static ExtentReports extent;

	public static void initReports() {

		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Test Execution Report");
			spark.config().setReportName("Test Execution Report");
		}
	}

	public static void flushReports() {

		if(Objects.nonNull(extent))
			extent.flush();
	}

	public static void createTest(String testCaseName) {

		ExtentManager.setExtentTest(extent.createTest(testCaseName));
	}
}
