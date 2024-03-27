package com.hfw.DataProvider;

import org.testng.annotations.DataProvider;

public class CustomeData {

	@DataProvider(name="loginData")
	
	public static Object[][] loginCrediantional(){
		System.out.println("*************LOG INFO: Setting up Test Data*******************");

		Object[][] data=ExcelReader.getdata("LoginData");
		System.out.println("*************LOG INFO: Test Data Set up completed *******************");

		return data;
		
		
	}
}
