package com.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class TestListener implements ITestListener , ISuiteListener{

	private static Logger log = LogManager.getLogger();
	private static long beginTime , endTime;

	static {
		beginTime = System.currentTimeMillis();
		endTime = 0;
	}

	// Same as Before Method
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("*********************** STARTED TEST CASE EXECUTION FOR : " +result.getName()+ " ***********************");
		ExtentReport.createTest(result.getMethod().getMethodName()); // fetching method name on run time
	}

	// Same as AfterMethod
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("*********************** PASSED TEST CASE : " +result.getName()+ " ***********************");
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("*********************** FAILED TEST CASE : " +result.getName()+ " ***********************");
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed" ,true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("*********************** SKIPPED TEST CASE : " +result.getName()+ " ***********************");
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	// Same as Before Suite
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("\n*********************** TEST CASE EXECUTION STARTED ***********************");
		ExtentReport.initReports();
	}

	// Same as After Suite
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		log.info("*********************** TEST CASE EXECUTION COMPLETED ***********************\n");
		endTime = System.currentTimeMillis();
		log.info("Total Test Execution Duration is : " + (((endTime - beginTime) / 3600) % 60) + " Hrs "
				+ (((endTime - beginTime) / 60) % 60) + " mins " + (endTime - beginTime) % 60 + " seconds");
		ExtentReport.flushReports();
	}

}
