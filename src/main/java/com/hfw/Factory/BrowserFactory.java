package com.hfw.Factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.hfw.DataProvider.DataReader;

public class BrowserFactory {
	public static String CaptureDateAndTime() {
		String formatedDate = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return formatedDate;

		/*
		 * Date date=new Date(); System.out.println(date);
		 * 
		 * SimpleDateFormat formatdate=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		 * formatdate.format(date);
		 */
	}

	public static void Screenshotmethod(WebDriver driver) {

		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./ScreenShot/Screenshot1" + BrowserFactory.CaptureDateAndTime() + ".png"));
			System.out.println("screenshot captured");
		} catch (WebDriverException e) {
			System.out.println("screenshot not captured");

		} catch (IOException e) {
			System.out.println("screenshot  not captured");

		}
	}

	public static WebDriver startChromeBrowser(String ApplicationURL) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(ApplicationURL);

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(DataReader.ConfigRead("ImplicitWait"))));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Long.parseLong(DataReader.ConfigRead("PageLoadTime"))));
		driver.manage().timeouts()
				.scriptTimeout(Duration.ofSeconds(Long.parseLong(DataReader.ConfigRead("ScriptTimeOut"))));
		return driver;
	}

	
	
	public static void closeAllBrowser(WebDriver driver) {
		driver.quit();
	}

	public static void closeCurrentBrowser(WebDriver driver) {
		driver.close();
	}

	
	public static void dropdownvalues(WebDriver driver, By locator, String value) {

		List<WebElement> listofdates = driver.findElements(locator);
		for (WebElement ele : listofdates) {

			if (ele.getText().equalsIgnoreCase(value))
				;
			ele.click();
			break;
		}

	}

	public static WebDriver startbrowser(String Browser, String ApplicationURL) {

		WebDriver driver = null;

		if (Browser.equalsIgnoreCase("Chrome")) 
		{
			ChromeOptions opt=new  ChromeOptions();
			Map<String, String> map=new HashMap<String, String>();
			String downloadDirectory= System.getProperty("user.dir") +"/DownloadFles/";
			map.put("download.default_directory", downloadDirectory);
			opt.setExperimentalOption("prefs", map);
			
			if(DataReader.ConfigRead("headLess").equalsIgnoreCase("true")) {
				opt.addArguments("--headLess=new");
			}
			driver = new ChromeDriver(opt);

		} 
		else if (Browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
			
		} else if (Browser.equalsIgnoreCase("Fiefox")) {

			driver = new FirefoxDriver();
		}

		else {
			System.out.println("Browser is not suporteed" +Browser);
		}

		driver.manage().window().maximize();

		driver.get(ApplicationURL);

		return driver;

	}

}
