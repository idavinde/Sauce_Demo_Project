package com.ui.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;

import com.utility.LoggerUtility;

public class TestListner implements ITestListener {
	
	private final Logger logger = LoggerUtility.getLog(this.getClass());
	
	public void onStart(ITestContext context) {
		
		logger.info("The Test Suit Started");
		ExtentReportUtility.setupSparkReporter("report.html");
	}
	
	
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());	
	}
	
	
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName()+ " "+ "PASSED");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+ " "+ "PASSED");
	}
	
	
	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+ " "+ "SKIPPED");
	}
	
	public void onTestFailure(ITestResult result) {
		
		logger.error(result.getMethod().getMethodName()+" "+"FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+ " "+ "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());
		
Object testClass = result.getInstance();
		
		BrowserUtility browserUtility= ((TestBase)testClass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");
		
		String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the screenshot to the HTML file");
		
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}
		
	
	
	
	public void onFinish(ITestContext context) {
		logger.info("Test Finished");
		ExtentReportUtility.flushReport();
	}
}
