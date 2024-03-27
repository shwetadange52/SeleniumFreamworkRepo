package com.hfw.TestData;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.hfw.Base.BaseClass;
import com.hfw.DataProvider.CustomeData;
import com.hfw.Factory.BrowserFactory;
import com.hfw.Pages.HomePage;
import com.hfw.Pages.LoginPage;

public class LoginToApplication extends BaseClass {

	@Test(priority = 1, description = "This test will verify the login functionality", dataProvider="loginData",
			dataProviderClass=CustomeData.class)
	public void loginApp(String UserName, String Password) {

		LoginPage login = new LoginPage(driver);
		HomePage home = login.loginpageDetails(UserName, Password);

		Assert.assertTrue(home.WelComeMessage().contains("WelCome"), "Welcome msg did not appear");
		BrowserFactory.closeAllBrowser(driver);

	}

}
