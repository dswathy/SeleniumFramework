package com.beans.excel;

import com.ebay.xcelite.annotations.Column;

public final class TestManager {
	
	@Column(name = "Test Case")
	private String testCase;
	
	@Column(name = "Test Case Description")
	private String testCaseDescription;
	
	@Column(name = "Execute")
	private String Execute;
	
	@Column(name = "Priority")
	private String priority;

	/**
	 * @return the testCase
	 */
	public String getTestCase() {
		return testCase;
	}

	/**
	 * @param testCase the testCase to set
	 */
	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	/**
	 * @return the testCaseDescription
	 */
	public String getTestCaseDescription() {
		return testCaseDescription;
	}

	/**
	 * @param testCaseDescription the testCaseDescription to set
	 */
	public void setTestCaseDescription(String testCaseDescription) {
		this.testCaseDescription = testCaseDescription;
	}

	/**
	 * @return the execute
	 */
	public String getExecute() {
		return Execute;
	}

	/**
	 * @param execute the execute to set
	 */
	public void setExecute(String execute) {
		Execute = execute;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

}
