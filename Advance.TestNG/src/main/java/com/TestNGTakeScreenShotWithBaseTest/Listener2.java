package com.TestNGTakeScreenShotWithBaseTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener2 extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" :>>>>>>>Test starteing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("PASSED Test: "+result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		captureScreenShot( result.getMethod().getMethodName());
		System.out.println("Failed Test:  "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		captureScreenShot( result.getMethod().getMethodName());
		System.out.println("Skipped Test: "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("bismillah");
		System.out.println(context.getName()+" *******   STARTED   ********* ");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getName()+" *******   EXECUTED   ********* ");
		
	}

}
