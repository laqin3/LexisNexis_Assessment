package com.lexisnexis.newJob;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LexisNexis_Assessment {

	public static void main(String[] args) throws InterruptedException {

// initialize the driver		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\laqin3\\eclipse-workspace\\Tord_in\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
//		1.       Open Google search engine
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		 

//			2.       Search from “LexisNexis” 

			
		WebElement searchBox= driver.findElement(By.xpath("//*[@title='Search']"));
		
		Thread.sleep(500);
		
		searchBox.sendKeys("LexisNexis");
		
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
		
//		3.       Open the third link in the search result 			
		List<WebElement> searchResults= driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		
		for(int i=0; i<searchResults.size();i++) {
			
			if( i==2) {
			searchResults.get(i).click();
			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			

//			4.       Return the page title
			System.out.println(driver.getTitle());
			
			
			}
		}
		
		
		
		driver.close();
		driver.quit();
		
		
		
	}

}
