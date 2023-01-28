package Demo_test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action1 {

	public static void main(String[] args) throws Exception {
  WebDriverManager.chromedriver().setup();
  WebDriver driver=new ChromeDriver();
  driver.get("https://jqueryui.com/slider");
  
  Actions a= new Actions(driver);
  driver.switchTo().frame(0);
  WebElement drag= driver.findElement(By.id("slider"));
  
  a.dragAndDropBy(drag, 120, 0).perform();
  Thread.sleep(6000);
  
  a.clickAndHold(drag).moveByOffset(40, 0).release(drag).build().perform();
  
 
  
  
  
  
	  
  
		
		
	}

}
