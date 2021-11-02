package com.mindtree.UIstore;

import org.openqa.selenium.By;

public class LandingPageUI {
	public static By login=By.cssSelector("input[id='searchbox']");
	public static By signIn=By.xpath("/html/body/div[2]/div[1]/div/div[1]/div/div/div[2]/div/ul/li[4]/a");
	public static By email=By.cssSelector("input[name='login[username]']");
	public static By pass=By.cssSelector("input[name='login[password]']");
	public static By enter=By.id("send2");
	public static By text=By.xpath("//*[@id=\'maincontent\']/div/div/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div/div[1]");

}
