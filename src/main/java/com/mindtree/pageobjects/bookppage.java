package com.mindtree.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.bookpageUI;

public class bookppage {
	public WebDriver driver;
	
	
			public bookppage(WebDriver driver) {
		this.driver=driver;
	}
			
			public WebElement clickaddcart() {
				return driver.findElement(bookpageUI.addcart);
			}

}
