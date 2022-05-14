package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.enums.PropertyFileConstants;
import com.utils.PropertyUtils;

public class RetryAnalyzer implements IRetryAnalyzer{

	/**
	 * Using this listener we can re-execute a failed test case a couple of times. 
	 * This listener is not implemented at suite level or class level. Instead it can only be implemented at test case level.
	 * So to use this in test case use retryAnalyzer = RetryAnalyzer.class
	 * Implementation is still pending
	 */
	
	private int count = 0;
	
	/**
	 * This method will be invoked only if test case is failed other wise it will not be invoked.
	 * retry() method will retry execution of a test case which is failed for a total of 3 times.
	 * Even after three fail attempts the test will be marked as failed and execution will move to next test case.
	 * 
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(PropertyUtils.readProperty().get(PropertyFileConstants.RETRYFAILEDTESTS).toString().equalsIgnoreCase("yes")) {
			// result.getStatus() = 2 means test case failure
			if(result.getStatus() == 2 && count < 2) {
				count++;
				return true;
			}
		}
		return false;
	}

}
