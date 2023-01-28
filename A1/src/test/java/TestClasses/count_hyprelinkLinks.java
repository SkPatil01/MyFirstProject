package TestClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class count_hyprelinkLinks {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe");
   WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       
       driver.manage().window().maximize();
       
       //launch web page https://www.calculator.net/
       driver.get("https://www.calculator.net/");
       
     List < WebElement >linkElement = driver.findElements(By.tagName("a"));
     
     System.out.println("Total links on webpage:"+ linkElement.size());
      
     for(WebElement el:linkElement)
     {
    	 System.out.println(el.getText());
     }
       
       driver.close();
	}

}
