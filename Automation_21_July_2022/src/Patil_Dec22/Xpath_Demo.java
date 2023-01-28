package Patil_Dec22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Demo {
	
	public static WebDriver driver;
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https:\\google.co.in");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		System.out.println("Browser Launched");
		
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("Shrikrishna Honrao"+Keys.ENTER);
		System.out.println("Patil search result in google");
		System.out.println("123456");

	}

}


