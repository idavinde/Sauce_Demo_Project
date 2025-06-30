package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browsers;

import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	Logger logger = LoggerUtility.getLog(this.getClass());

	private boolean isLambdaTest;

	protected LoginPage login;

	@Parameters({ "browser", "isLambdaTest" , "isHeadless" })
	@BeforeMethod
	public void setup(@Optional("chrome") String browser,@Optional("true") boolean isLambdaTest,@Optional("false") boolean isHeadless, ITestResult result) {
		
		this.isLambdaTest=isLambdaTest;
		
		WebDriver lambdaDriver;
		if (isLambdaTest) {

			lambdaDriver = LambdaTestUtility.intializeLambdaSession(browser, result.getMethod().getMethodName());
			logger.info("Load the HomePage of WebSite");
			login = new LoginPage(lambdaDriver);
		}

		else {
			logger.info("Load the HomePage of WebSite");
			login = new LoginPage(Browsers.valueOf(browser.toUpperCase()), isHeadless);
		}

	}

	public BrowserUtility getInstance() {

		return login;
	}

	@AfterMethod
	public void tearDown() {
		if (isLambdaTest) {

			LambdaTestUtility.quitSession();
		} else {
			login.quit();
		}
	}
}
