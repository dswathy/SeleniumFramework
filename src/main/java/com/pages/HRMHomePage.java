package com.pages;

import org.openqa.selenium.By;

import com.enums.WaitStrategyOptions;
import com.utils.WaitStrategyUtils;

// Final class so that it should not be extended
public final class HRMHomePage extends BasePage {
	
	private final By btn_Welcome = By.id("welcome");
	private final By btn_Logout = By.xpath("//a[@href='/index.php/auth/logout']");
	
	public HRMLoginPage doLogout() {
		WaitStrategyUtils.ExplicitWaitStrategy(btn_Welcome, WaitStrategyOptions.CLICKABLE).click();
		WaitStrategyUtils.ExplicitWaitStrategy(btn_Logout, WaitStrategyOptions.CLICKABLE).click();
		return new HRMLoginPage();
	}
	
}
