package test.java.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import main.java.utils.BrowserSelection;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) {
		driver = BrowserSelection.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@AfterTest
	public void teardown() {
		if (driver != null)
			driver.quit();
	}

	protected void takeScreenshot(String filenamePrefix) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dest = "screenshots/" + filenamePrefix + "_" + ".png";
		try {
			FileUtils.copyFile(src, new File(dest));
			System.out.println("Screenshot saved :" + dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
