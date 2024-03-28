package com.hfw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hfw.Helper.Utility;

public class UserRegistrationPage {
	
	WebDriver driver;
	public  UserRegistrationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By Name=By.id("name");
	By Email=By.id("email");
	By Password=By.id("password");
	By state=By.id("state");
	By hobbies=By.id("hobbies");
	
	
	public static void createNewUser( String Name) {
		
		
		 
	}
	

}
