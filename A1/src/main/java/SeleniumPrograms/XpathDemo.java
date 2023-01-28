package SeleniumPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathDemo {
     static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/flights/");
	
		//capture title of webpage &print
		 String title= driver.getTitle();
		 System.out.println("page title:"+title);
		 
		 //capture url of the webpage 
		 
		System.out.println( driver.getCurrentUrl());
		
		//capture page source
		System.out.println(driver.getPageSource());
		driver.close();
		
		
		
		
		
		
		
		

	}

}
