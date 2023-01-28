package DemoTest_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Click_on_img {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//open url
		driver.get("https://www.opencart.com/index.php?route=cms/demo");
		
		//find web element image link open cart
		driver.findElement(By.xpath("//img[@tital='opencart")).click();
		
		if(driver.getTitle().equals("openCart-open Source Shopping Cart Solution"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
			
		}
		driver.close();
	}

}
