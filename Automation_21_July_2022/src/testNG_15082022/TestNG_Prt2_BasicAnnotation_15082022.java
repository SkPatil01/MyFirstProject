package testNG_15082022;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class TestNG_Prt2_BasicAnnotation_15082022 {
	
	public static WebDriver driver;
  @Test
  public void verifyIt() {
	  Reporter.log("Url launch", true);
	  driver.get("https:\\www.google.co.in");
	  WebElement search=driver.findElement(By.name("q"));
	  search.sendKeys("India",Keys.ENTER);
	  Reporter.log("Name searched", true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}
