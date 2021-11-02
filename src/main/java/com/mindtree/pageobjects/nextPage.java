package com.mindtree.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.nextPageUI;

public class nextPage {
	public WebDriver driver;
	
			public nextPage(WebDriver driver) {
		this.driver=driver;
	}
			
			public WebElement clickBook() {
				return driver.findElement(nextPageUI.book);
			}
			
}
