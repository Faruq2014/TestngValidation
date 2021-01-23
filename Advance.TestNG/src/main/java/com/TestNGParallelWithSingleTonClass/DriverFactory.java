	package com.TestNGParallelWithSingleTonClass;
	
	import org.openqa.selenium.WebDriver;
	
	/**In object-oriented programming, a singleton class is a class that can have only one object
	 *  (an instance of the class) at a time.After first time, if we try to instantiate the Singleton class,
	 *   the new variable also points to the first instance created. So whatever modifications we do to any variable inside the class through any instance, it affects the variable of the single instance created and is visible if we access that variable through any variable of that class type defined.
     To design a singleton class:
      Make constructor as private.
       Write a static method that has return type object of this singleton class.
        Here, the concept of Lazy initialization is used to write this static method.
	 * @author Faruq
	 *
	 */
	public class DriverFactory {
		
		private DriverFactory() { // making the constructor private
			
		}
		private static DriverFactory instatnce = new DriverFactory();
		// creating only one instance/object for the class
		
	public static DriverFactory getInstance() {
		// returning the instance
		return instatnce;
		
	}
	
	ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	// creating Thread for running parallel test. 
	
	// getter method for private instance
	public WebDriver getDriver() {
		return driver.get();
		
	}
	
	// setter method for private instance
	public void setDriver(WebDriver driverparam) {
		driver.set(driverparam);
		
	}
	
	// to kill the browser only quit is not enough. we also need to kill the local thread. 
	public void removeDriver() {
		driver.get().quit();
		driver.remove();
		
	}
	
	
	
	}
