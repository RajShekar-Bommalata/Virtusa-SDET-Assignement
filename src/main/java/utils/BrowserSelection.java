package main.java.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSelection {

	public static WebDriver getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		}
		throw new IllegalArgumentException("Browser not supported");
	}
}