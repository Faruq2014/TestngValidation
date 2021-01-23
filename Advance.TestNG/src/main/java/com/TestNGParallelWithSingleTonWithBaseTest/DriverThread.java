	package com.TestNGParallelWithSingleTonWithBaseTest;
	
	import org.openqa.selenium.WebDriver;
	
	/**In object-oriented programming, a singleton class is a class that can have only one object
	 * @author Faruq
	 *
	 */
	public class DriverThread {
		
		private DriverThread() {
			
		}
		
	private static  DriverThread instance = new DriverThread();
	
	public static DriverThread getInstance() {
		return instance;	
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public WebDriver getDriver() {
		return driver.get();	
	}
	
	public void setDriver(WebDriver driverP) {
		driver.set(driverP);
	}
	
	public void removeDriver() {
		driver.get().quit();
		driver.remove();
	}
	}
