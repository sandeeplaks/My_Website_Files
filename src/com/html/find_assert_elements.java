package com.html;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class find_assert_elements {
	private WebDriver driver;
	@Before
	public void beforeTest()
	{
		driver = new FirefoxDriver();
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException
	{
		driver.get("file:///Users/sandeeplaks/Documents/html/script.html");
		Thread.sleep(2000);
		WebElement header = driver.findElement(By.tagName("h1"));
		String strHeader = header.getText();
		
		String[] splitHeader = strHeader.split(" ");
		System.out.println(splitHeader[2]);
		//WebElement Interested_header = splitHeader[2];
		Assert.assertEquals("Validating Header", "Heading".toLowerCase(), splitHeader[2].toLowerCase());
		
		WebElement formula = driver.findElement(By.tagName("var"));
		System.out.println(formula.getText());
		Assert.assertEquals("Validating formula", "E=MC2".toLowerCase(),formula.getText().toLowerCase() );
		
		
		WebElement table_data = driver.findElement(By.tagName("table"));
		List<WebElement> row_data = table_data.findElements(By.tagName("td"));
		Assert.assertEquals("50", row_data.get(2).getText());

		//Added another row of data to the above table
		
		WebElement table_data1 = driver.findElement(By.tagName("table"));
		List <WebElement> rows = table_data1.findElements(By.tagName("tr"));
	   WebElement data = rows.get(1);
		List <WebElement> td = data.findElements(By.tagName("td"));
		Assert.assertEquals("Validating second row data", "100", td.get(2).getText());
		
		//Added a new table with a row and data
		
		List <WebElement> tables = driver.findElements(By.tagName("table"));
		WebElement data_table2 = tables.get(1);
		List <WebElement> data_tables = data_table2.findElements(By.tagName("td"));
		Assert.assertEquals("Validating second table", "50", data_tables.get(2).getText());
		
		
		
}
	
	@Test
	public void test1() throws InterruptedException
	{
		driver.get("file:///Users/sandeeplaks/Documents/html/test.html");
		Thread.sleep(1000);
		List <WebElement> frames = driver.findElements(By.tagName("frame"));
		String mainFrame = driver.getWindowHandle();
		driver.switchTo().frame(frames.get(0));
		List <WebElement> links = driver.findElements(By.tagName("a"));
		for(WebElement link : links){
			if(!link.isDisplayed()) Assert.assertFalse("link is not displayed", true);
			else System.out.println(link.getText() + " link is present.");
		}
		List <WebElement> frames1 = driver.findElements(By.tagName("frame"));

        driver.switchTo().window(mainFrame);
        frames = driver.findElements(By.tagName("frame"));
        driver.switchTo().frame(frames.get(1));
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Text Validation", "This is main page and content from any link will be displayed here.", text.getText());
        if(!text.isDisplayed()) Assert.assertFalse("text is not displayed", true);
        else System.out.println(text.getText() + "is present");
		
	}
	
	@Test
	public void test2() throws InterruptedException
	{
		driver.get("file:///Users/sandeeplaks/Documents/html/div.html");
		Thread.sleep(1000);
		WebElement div = driver.findElement(By.tagName("p"));
		Assert.assertEquals("Text", "Welcome to our website. We provide tutorials on various subjects.".toLowerCase(), div.getText().toLowerCase());
		
		//Added a table with 2 rows of data
		WebElement chair = driver.findElement(By.tagName("table"));
		List <WebElement> chair_row = chair.findElements(By.tagName("tr"));
		WebElement data_interested = chair_row.get(1);
		List <WebElement> data_needed = data_interested.findElements(By.tagName("td"));
		Assert.assertEquals("Validating table data", "Maybe data driven".toLowerCase(), data_needed.get(1).getText().toLowerCase());
		
	}
	
	
	
	@After
	public void afterTest()
	{
		driver.close();
		driver.quit();
	}

}
