package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browsers;
import com.constants.Envir;
import com.utility.BrowserUtility;
import com.utility.JSONEnvirUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {
	
	Logger logger = LoggerUtility.getLog(this.getClass());
	
	public LoginPage(WebDriver driver) {
		super(driver);
		goToWebSite(JSONEnvirUtility.readConfigJason(Envir.QA).getURL());
	}
	
	public LoginPage(Browsers browsername,boolean isHeadless) {
		super(browsername, isHeadless);
		
		goToWebSite(JSONEnvirUtility.readConfigJason(Envir.QA).getURL());
	}
	
	private static final By USERNAME= By.xpath("//input[@id=\"user-name\"]");
	private static final By PASSWORD = By.id("password");
	private static final By LOGIN_BUTTON = By.id("login-button");
	
	
	public ProductPage loginWith(String username, String password) {
		logger.info("Entering the Username and Password");
		enterText(USERNAME, username);
		enterText(PASSWORD, password);
		clickOn(LOGIN_BUTTON);
		
		return new ProductPage(getDriver());
		
	}
	
}
