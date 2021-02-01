package com.TestNGiTestListenerPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AssuranceLitener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+ "   OnTest started");	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	 System.out.println(result.getMethod().getMethodName()+"   on testSuccess ");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" is fail");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on tesSkipp  "+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
	System.out.println(" context start "+context.getSuite().getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" context finish "+context.getSuite().getName());
		
	}

}
