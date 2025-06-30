package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class ProductPage extends BrowserUtility{

	public ProductPage(WebDriver driver) {
		super(driver);
		
	}
	
	private static final By TITLE = By.xpath("//span[@class='title']");
	
	
	public String getTitle() {
		
		return getVisibleText(TITLE);
	}
	
	

}
