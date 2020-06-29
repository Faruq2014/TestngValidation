package com.TestNGIRetry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Khaled implements IRetryAnalyzer{
 int limit=0;
 int trylimit=3;
	@Override
	public boolean retry(ITestResult result) {
	if ( limit<trylimit) {
		limit++;
		return true;	
	}
		return false;
	}

}
