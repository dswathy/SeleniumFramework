package com.beans.excel;

import java.util.List;

public final class ExcelDataBean {
	
	private List<TestManager> testManager;
	private List<LoginTest> loginTest;
	/**
	 * @return the testManager
	 */
	public List<TestManager> getTestManager() {
		return testManager;
	}
	/**
	 * @param testManager the testManager to set
	 */
	public void setTestManager(List<TestManager> testManager) {
		this.testManager = testManager;
	}
	/**
	 * @return the loginTest
	 */
	public List<LoginTest> getLoginTest() {
		return loginTest;
	}
	/**
	 * @param loginTest the loginTest to set
	 */
	public void setLoginTest(List<LoginTest> loginTest) {
		this.loginTest = loginTest;
	}
	
	

}
