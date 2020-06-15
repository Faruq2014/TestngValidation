package com.TestNGIRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=0;
	int restryLimit=3;
	
	@Override
	public boolean retry(ITestResult result) {
		if (counter<restryLimit) {
		counter++;
		return true;
		}
		return false;
	}

}