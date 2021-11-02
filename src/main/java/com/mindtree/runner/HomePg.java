package com.mindtree.runner;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageobjects.LandingPage;
import com.mindtree.pageobjects.bookppage;
import com.mindtree.pageobjects.nextPage;
import com.mindtree.reusablecomponents.WebdriverHelper;
import com.mindtree.utilities.excelClass;


public class HomePg extends WebdriverHelper{
	private static Logger log=(Logger) LogManager.getLogger(HomePg.class.getName());
	public static WebDriver driver;
	@BeforeMethod
	public void initialize() throws IOException {
		driver = initializedriver();
		driver.manage().window().maximize();
	}

	@Test(dataProvider="excel")
	public void basePageNavigation(String key) throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		//log.info("successfully opened browser");

		LandingPage l = new LandingPage(driver);
		l.clicksearchbox().sendKeys(key);
		//Thread.sleep(4000);
		log.info("sent keys in search box");
		l.clicksearchbox().sendKeys(Keys.ARROW_DOWN);
		l.clicksearchbox().sendKeys(Keys.ENTER);
		log.info("book search successful");
		nextPage n=new nextPage(driver);
		n.clickBook().click();
		log.debug("searching for book");

		bookppage bk=new bookppage(driver);
		bk.clickaddcart();
		log.debug("book added to the cart");

	}


	@Test(dataProvider="getData")
	public void login(String username,String password) throws InterruptedException {

		driver.get(prop.getProperty("url"));
		log.info("successfully opened browser");

		LandingPage s = new LandingPage(driver);
		s.getsignIN().click();
		s.getemail().sendKeys(username);
		s.getpassword().sendKeys(password);
		//Thread.sleep(3000);
		s.getenter().click();

	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="kskr@gmail.com";
		data[0][1]="123456";
		return data;
	}
	@Test
	public void validateTitle() {

		driver.get(prop.getProperty("url"));
		
		log.info("successfully opened browser");

		LandingPage l = new LandingPage(driver);

		Assert.assertEquals(l.getext().getText(), "Book Deals of the Day123");
	}

	@DataProvider
	public Object[][] excel() throws IOException
	{
		excelClass e=new excelClass();
		ArrayList<String> al=e.getDetailsOfSheet();
		Object[][] a=new Object[3][1];
		a[0][0]=al.get(1);
		a[1][0]=al.get(2);
		a[2][0]=al.get(3);
		return a;
	}


	@AfterMethod
	public void closebrowser() {
		driver.close();
	}

}
