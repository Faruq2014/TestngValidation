		package com.TestNfaqctoryAnnotation;
		
		import org.testng.annotations.Factory;
		
		public class Factory1 {
			@Factory
			public Object[] invokeClass() {
				Object[] data = new Object[2];
				data[0] = new FactoryWithConstructor("Faruq", "1234");
				data[1] = new FactoryWithConstructor("messi", "$@123");
				return data;
			}
		}
