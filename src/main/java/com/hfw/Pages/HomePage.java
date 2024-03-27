package com.hfw.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hfw.Helper.Utility;

public class HomePage {
	WebDriver driver;
	
	private By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
	private By Managebutton= By.xpath("//span[normalize-space()='Manage']");
	private By Managecource= By.xpath("//a[normalize-space()='Manage Courses']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public String WelComeMessage() {
		
	String welcomemessage= 	Utility.getElement(driver, welcomeMsg).getText();
		
		System.out.println(welcomemessage);
		return welcomemessage;
	}
	
	
	

}
