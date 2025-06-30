package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browsers;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLog(this.getClass());
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(Browsers Name) {
		
		logger.info("Launching the browser: " + Name.toString());
		
		if (Name.equals(Browsers.CHROME)) {
			
			driver.set(new ChromeDriver());
		} 
		else if (Name.equals(Browsers.EDGE)) {
			
			driver.set(new EdgeDriver());
			
		} 
		else if (Name.equals(Browsers.FIREFOX)) {
			
			driver.set(new FirefoxDriver());
		}

	}
	
	public BrowserUtility(Browsers browsername, boolean isHeadless) {
		
logger.info("Launching the browser: " + browsername.toString());
		
		if (browsername.equals(Browsers.CHROME)) {
			if(isHeadless) {
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				//options.addArguments("--window-size=9120,1080");
				driver.set(new ChromeDriver(options));
				
			}
			else {
				driver.set(new EdgeDriver());
			}
			
		} 
		else if (browsername.equals(Browsers.EDGE)) {
			
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				
			} 
			else {
				
				driver.set(new EdgeDriver());
			}
			
		} 
		else if (browsername.equals(Browsers.FIREFOX)) {
			
			if (isHeadless) {

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new FirefoxDriver(options));
			}

			else {
				
				driver.set(new FirefoxDriver());
			}
		}

		
		
		
		
	}

	public void goToWebSite(String URL) {
		logger.info("Visiting the Website: " + URL);
		driver.get().get(URL);
	}

	public void windowMaximize() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Performing click Operation on" +locator);
		driver.get().findElement(locator).click();
	}

	public void enterText(By locator, String text) {
		logger.info("Find the Element using locator: " + locator +" and Enter the text "+text);
		driver.get().findElement(locator).sendKeys(text);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Find the Element using locator: " + locator +" and Get the text");
		return driver.get().findElement(locator).getText();
	}
	
	public void quit() {
		logger.info("Tear Down the Browser");
		driver.get().quit();
	}
	
	public String takeScreenShot(String name) {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String timestamp = format.format(date);
		File screenshotData =takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+ "/screenShot/"+ name+"-"+ timestamp+ ".png";
		File screenshotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	

}
