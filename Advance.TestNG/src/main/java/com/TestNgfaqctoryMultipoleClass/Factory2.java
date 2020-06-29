		package com.TestNgfaqctoryMultipoleClass;
		import org.testng.annotations.Factory;
		public class Factory2 {
			@Factory
			public Object[] invokeClass() {
				Object[] data = new Object[3];
				data[0] = new LoginTest();
				data[1] = new FunctionalTest();
				data[2] = new RegressionTest();
				return data;
			}
		}
