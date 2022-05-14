package com.assertions;

import org.openqa.selenium.By;
import org.testng.Assert;

public final class Validations {

	private Validations() {}
	
	public static void verifyPageTitle(String expected, String actual) {
		Assert.assertEquals(expected, actual, "Page Title mismatch");
	}
	
	public static void verifyElementDisplayed(boolean expected, boolean actual) {
		Assert.assertEquals(actual, expected, "Element displayed mismatch");
	}
}
