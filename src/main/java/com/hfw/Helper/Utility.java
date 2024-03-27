package com.hfw.Helper;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import org.openqa.selenium.TakesScreenshot;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hfw.DataProvider.DataReader;
public class Utility {
	
	public static String CaptureDateAndTime() {
		String formatedDate=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new Date());
		return formatedDate;
		
		/*Date date=new Date();
		System.out.println(date);
		
		SimpleDateFormat formatdate=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		formatdate.format(date);*/
	}
	
	public static void Screenshotmethod(WebDriver driver) {
		
		try {
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File ("./ScreenShot/Screenshot1"+Utility.CaptureDateAndTime()+".png"));
			System.out.println("screenshot captured");
		} catch (WebDriverException e) {
			System.out.println("screenshot not captured");
		
		} catch (IOException e) {
			System.out.println("screenshot  not captured");
			
		}
	}
	

	
public static void dropdownvalues(WebDriver driver, By locator, String value){
	
	List<WebElement> listofdates = driver.findElements(locator);
	       for (WebElement ele : listofdates) {
	    	   
		if(ele.getText().equalsIgnoreCase(value));
			ele.click();
			break;
		}
	
}
	
  public static WebDriver startbrowser(String Browser, String ApplicationURL) {
	  
	  WebDriver driver=null;
	  
	  if(Browser.equalsIgnoreCase("Chrome")) {
		driver=   new ChromeDriver();
		   
	  }
	  else if(Browser.equalsIgnoreCase("Edge")) {
		  
		  driver= new EdgeDriver();
	  }
	  else if(Browser.equalsIgnoreCase("Fiefox")) {
		  
		  driver= new FirefoxDriver();
	  }
	  
	  else {
		  System.out.println("Browser is not suporteed");
	  }
	  
		driver.manage().window().maximize();
		
		driver.get(ApplicationURL);
		
		return driver;
	
}
  
  public static void highlightElement(WebDriver driver, WebElement element) {
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].setAttribute('style','background: yellow; border:3px solid red;');", element);
	  try {
		  Thread.sleep(500);
		  }
	  catch(InterruptedException e){
		  
	  }
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid black;');", element);

	  
  } 
  
  public static WebElement getElement(WebDriver driver, By locator) {
	  
	  WebDriverWait  wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement element=  wait.until(ExpectedConditions.elementToBeClickable(locator));
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(true)", element);
	  
	  if(DataReader.ConfigRead("highLightElement").equalsIgnoreCase("true")) 
	  {
		  highlightElement(driver, element)  ;
	  }
	 
	  return element;

	  
	  
  }
  
  
  
  
  
  
  

}
