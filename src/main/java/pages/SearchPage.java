package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By stockPageHeader = By.xpath("//div[@id='quoteNav']//a");
	private By wkHi = By.id("week52highVal");
	private By wkLo = By.id("week52lowVal");
	public static String fiftyTwoWeekHigh;
	public static String fiftyTwoWeekLow;
	
	
	
	public  SearchPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void getStockValues(String stockName) throws InterruptedException{
	Thread.sleep(5000);
	fiftyTwoWeekHigh = driver.findElement(wkHi).getText();
	fiftyTwoWeekLow = driver.findElement(wkLo).getText();
	}
}
