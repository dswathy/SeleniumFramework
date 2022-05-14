package com.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.dataproviders.CustomDataProvider;
import com.driver.DriverManager;
import com.pages.HRMHomePage;
import com.pages.HRMLoginPage;

public final class HRMHomePageTests extends HRMBaseTest{

	private HRMHomePageTests() {}
	
	@Test(description = "Login and Logout HRM system" , dataProvider = "getTestData" , dataProviderClass = CustomDataProvider.class)
	public void TC_003(HashMap<String, String> data) {
		HRMHomePage obj = new HRMLoginPage().inputUserName(data.get("User Name")).inputPassword(data.get("Password")).clickLogin();
		System.out.println(DriverManager.getDriver().getTitle());
		obj.doLogout();
	}
	
}
