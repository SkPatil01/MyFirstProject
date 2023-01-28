package DemoTest_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {

	public static void main(String[] args) {
		
		
        WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.ebay.in/");
		
		WebElement element = driver.findElement(By.linkText("Shipping & Payments "));
		
		Actions act =new Actions(driver);
		
		act.moveToElement(element).perform();//move to Element () for mouse over S
		
	}

}
