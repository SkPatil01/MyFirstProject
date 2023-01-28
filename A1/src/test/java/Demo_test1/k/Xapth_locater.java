package Demo_test1.k;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xapth_locater {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.saucedemo.com");		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.className("submit-button")).click();
		
	  String currentWindowHandle=driver .getWindowHandle();
	  driver.switchTo().window(currentWindowHandle);
	  
	  
	  //locating  sauce lab T-shrit
	 List <WebElement> ElementList = driver.findElements(By.partialLinkText(" Sauce"));
	 System.out.println("Element size:" + ElementList.size());
	  
	  
	}

}
