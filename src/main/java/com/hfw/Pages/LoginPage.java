package com.hfw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hfw.Helper.Utility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	By user=By.xpath("//input[@id='email1']");
	By pass=By.name("password1");
	By submit=By.className("submit-btn");
	
	public HomePage loginpageDetails(String username, String password) {
	
		Utility.getElement (driver, user).sendKeys(username);
		Utility.getElement(driver, pass).sendKeys(password);
		Utility.getElement(driver, submit).click();

	
	HomePage home=new HomePage(driver);
	return home;
	
		
	}

}
