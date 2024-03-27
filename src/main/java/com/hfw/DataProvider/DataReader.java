package com.hfw.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataReader {
	
	
	public static String ConfigRead(String Key) {
		Properties prop=new Properties();
		

		try {
			prop.load(new FileInputStream(new File("./Configations/Config")));
		} 
		catch (FileNotFoundException e) {
			System.out.println("File Not Found Please check the File Location"+ e.getMessage());
		} 
		catch (IOException e) {
			System.out.println("Could Not Found the File"+e.getMessage());
		}
		String value=prop.getProperty(Key);
		return value;
	}

}
