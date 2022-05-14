package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategyOptions;
import com.reports.ExtentLogger;

public final class HRMLoginPage extends BasePage{
	
	private By txtbox_Username = By.id("txtUsername");
	private By txtbox_Password = By.id("txtPassword");
	private By btn_Login = By.id("btnLogin");
	
	public HRMLoginPage inputUserName(String userName) {
		sendKeys(txtbox_Username, userName, WaitStrategyOptions.DISPLAYED);
		return new HRMLoginPage();
	}
	
	public HRMLoginPage inputPassword(String password) {
		sendKeys(txtbox_Password, password, WaitStrategyOptions.DISPLAYED);
		return new HRMLoginPage();
	}
	
	public HRMHomePage clickLogin() {
		click(btn_Login, WaitStrategyOptions.DISPLAYED);
		return new HRMHomePage();
	}


}
