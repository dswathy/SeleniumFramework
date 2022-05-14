package com.beans.excel;

import com.ebay.xcelite.annotations.Column;

public final class LoginTest {
	
	@Column(name = "Test Case Name")
	private String testCaseName;
	
	@Column(name = "Execute")
	private String execute;
	
	@Column(name = "Browser")
	private String browser;
	
	@Column(name = "User Name")
	private String userName;
	
	@Column(name = "Password")
	private String password;

	/**
	 * @return the testCaseName
	 */
	public String getTestCaseName() {
		return testCaseName;
	}

	/**
	 * @param testCaseName the testCaseName to set
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	/**
	 * @return the execute
	 */
	public String getExecute() {
		return execute;
	}

	/**
	 * @param execute the execute to set
	 */
	public void setExecute(String execute) {
		this.execute = execute;
	}

	/**
	 * @return the browser
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
