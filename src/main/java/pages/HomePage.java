package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By searchBox = By.xpath("//div[@class='input-group get-quote-search']//input");
	private By searchResults = By.xpath("//div[@id='async-navbar-search']//span[2]");
	public String stockSearchResult;
	
	
	public  HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void navigateToApplication() {
		driver.get("https://www.nseindia.com/");
	}
	
	public void searchStock(String stockName){
		wait.until(ExpectedConditions.elementToBeClickable(searchBox));
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(stockName);
		stockSearchResult = driver.findElement(searchResults).getText();
	}
	
	public void selectStock(String stockName) {
		driver.findElement(By.xpath( "//div[@id='async-navbar-search']//span[.='"+stockName+"']")).click();
	}
	
}
