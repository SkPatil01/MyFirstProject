package TestClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpathdemo {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		System.setProperty("webdriver.chrome.driver","C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe" );
		
		WebDriver driver = new ChromeDriver();
		
		//open Swag lab web page
		driver.get("http://www.saucedemo.com");
		
		//locate username using single attribute
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		//driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys("standard_user");
		
		//locate password using multiple attribute
		driver.findElement(By.xpath("//*[@id='password'][@name='password']")).sendKeys("secret_sauce");
		
		//locate login button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
	   //Switch to product page-
		String CurrentWindowHandle =driver.getWindowHandle();
		driver.switchTo().window(CurrentWindowHandle);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack'and @name='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light'or @name='add-to-cart-sauce-labs-bike-light']")).click();
		
		
	}

}
