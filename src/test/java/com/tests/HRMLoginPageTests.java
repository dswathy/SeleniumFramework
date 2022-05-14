package com.tests;

import java.util.HashMap;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.assertions.Validations;
import com.dataproviders.CustomDataProvider;
import com.listeners.MethodInterceptorListener;
import com.listeners.RetryAnalyzer;
import com.listeners.TestListener;
import com.pages.HRMLoginPage;

@Listeners({TestListener.class, MethodInterceptorListener.class})
public final class HRMLoginPageTests extends HRMBaseTest{
	
	@Test(dataProvider = "getTestData" , dataProviderClass = CustomDataProvider.class)
	public void testLoginIntoHRM(HashMap<String, String> data) {
		HRMLoginPage loginObj = new HRMLoginPage();
		loginObj.inputUserName(data.get("User Name")).inputPassword(data.get("Password")).clickLogin().doLogout();
		Validations.verifyPageTitle("OrangeHRM", loginObj.getPageTitle());
	}
	
	@Test(dataProvider = "getTestData" , dataProviderClass = CustomDataProvider.class)
	public void testLoginPagewithValidCredential(HashMap<String, String> data) {
		HRMLoginPage loginObj = new HRMLoginPage();
		loginObj.inputUserName(data.get("User Name")).inputPassword(data.get("Password")).clickLogin().doLogout();
		Validations.verifyPageTitle("OrangeHRM", loginObj.getPageTitle());
	}
	
}
