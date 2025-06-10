package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.java.pages.HomePage;
import test.java.base.BaseTest;
import main.java.pages.SearchPage;

public class StockInfoTest extends BaseTest{
	@Test(priority =1, dataProvider = "stockData")
	public void searchStock(String stockName, String high, String low) throws Exception {
		HomePage homepage = new HomePage(driver, wait);

		SearchPage searchpage = new SearchPage(driver, wait);
		
		homepage.navigateToApplication();
		takeScreenshot("launch Application");
		
		homepage.searchStock(stockName);
		takeScreenshot("Search Stock_" +stockName);
		
		Assert.assertEquals(homepage.stockSearchResult, stockName);
		
		homepage.selectStock(stockName);
		
		takeScreenshot("Search Stock_" +stockName);
	
		
		searchpage.getStockValues(stockName);
		System.out.println("52 Week Hi " + SearchPage.fiftyTwoWeekHigh);
		System.out.println("52 Week Low " + SearchPage.fiftyTwoWeekLow);
		
		takeScreenshot("Stock Information Page");
		Assert.assertEquals(SearchPage.fiftyTwoWeekHigh, high, "Mismatch in 52 Week High");
		Assert.assertEquals(SearchPage.fiftyTwoWeekLow, low, "Mismatch in 52 Week Low");
		
	}
	
	
	@DataProvider(name = "stockData")
	public Object[][] getStockData(){
		return new Object[][] {
			{"RCOM", "2.58", "1.34"},
			{"RCOM", "2.50", "1.34"},
		};
		
	}

}
