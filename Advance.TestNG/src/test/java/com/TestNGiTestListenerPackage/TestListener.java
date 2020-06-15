package com.TestNGiTestListenerPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started : "+ result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Pass : "+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed : "+ result.getName());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipeed : "+ result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test finish********** : "+ context.getName()+"**************");
		
	}

}
