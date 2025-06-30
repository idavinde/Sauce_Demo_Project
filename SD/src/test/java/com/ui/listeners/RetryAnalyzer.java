package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	
	private static final int MAX_NUMBER_OF_ATTEMPTS = 3;
	private static  int currentAttempt=1;
	
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			
			currentAttempt++;
			return true;
		}
		
		return false;
		
	}
}
