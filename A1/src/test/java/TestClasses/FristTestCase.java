package TestClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FristTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		//open sauce demo web page
		driver.get("https://www.saucedemo.com");
		
		//locate username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		//locate password by name
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		//locate login button
	    driver.findElement(By.className("submit-button")).click();
	    //swith to product page
	    String currentWindowHandle = driver.getWindowHandle();
	    driver.switchTo().window(currentWindowHandle);
	    
	    //locate sauce labs bolt T-shirt
	   List <WebElement> elementList = driver.findElements(By.partialLinkText("Sauce"));
	   System.out.println("Element size:" + elementList.size());
		
		
		
		
		
	}

}
