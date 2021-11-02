package com.mindtree.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.UIstore.LandingPageUI;

public class LandingPage {
	public WebDriver driver;
	
	
			public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
			
			public WebElement clicksearchbox() {
				return driver.findElement(LandingPageUI.login);
			}
			public WebElement getsignIN() {
				return driver.findElement(LandingPageUI.signIn);
			}
			public WebElement getemail() {
				return driver.findElement(LandingPageUI.email);
			}
			public WebElement getpassword() {
				return driver.findElement(LandingPageUI.pass);
			}
			public WebElement getenter() {
				return driver.findElement(LandingPageUI.enter);
			}
			public WebElement getext() {
				return driver.findElement(LandingPageUI.text);
			}
			
}
