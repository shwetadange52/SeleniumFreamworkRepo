package com.hfw.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.hfw.DataProvider.DataReader;
import com.hfw.Factory.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		System.out.println("*************LOG INFO: Running Set up*******************");
		System.out.println("*************LOG INFO: Application is running on "+ DataReader.ConfigRead("Browser") +"*******************");

		driver= BrowserFactory.startbrowser(DataReader.ConfigRead("Browser"),(DataReader.ConfigRead("appURL")));
	}
	
	@AfterClass
	public void teardown() {
		System.out.println("*************LOG INFO: Application is Closed *******************");

		BrowserFactory.closeAllBrowser(driver);

	}

}
