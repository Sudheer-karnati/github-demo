package com.mindtree.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverHelper{
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializedriver() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\karna\\eclipse-workspace\\atlanticBooks\\testdata\\confg.properties");
	    prop.load(fis);
	    String browserName=prop.getProperty("browser");
	    if(browserName.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\karna\\eclipse-workspace\\atlanticBooks\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
	    }
	    
	    else if(browserName.equalsIgnoreCase("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver","C:\\Users\\karna\\eclipse-workspace\\atlanticBooks\\Driver\\geckodriver.exe");
			driver=new FirefoxDriver();
	    }
   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		//WebDriver driver =initializedriver();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\karna\\eclipse-workspace\\atlanticBooks\\SS\\"+result+".jpg"));
		
	}

}
