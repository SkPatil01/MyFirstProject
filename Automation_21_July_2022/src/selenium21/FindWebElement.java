package selenium21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindWebElement {
	static WebDriver driver;
	 public static void searchName() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("http:\\www.google.com");
		 Thread.sleep(2000);
		
		 WebElement text=driver.findElement(By.name("q"));
		 text.click();
		 
		 Thread.sleep(1000);
		 
		 text.sendKeys("Aurangabad MGM");
		 
		 WebElement button=driver.findElement(By.name("btnK"));
		 button.click();
		 
		 Thread.sleep(3000);
		 
		 
		 driver.close();
		  	 
		 }
	

	public static void main(String[] args) {
		
		System.out.println("Searching using google search");
		try{
			searchName();
		}
		catch(Exception e) {
			System.out.println("Searching completed");
		}
		System.out.println("Search completed");

	}

}
