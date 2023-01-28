package TestClasses;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/");
		
		//capture full page screenshot 
		//step1 :convert webdriver object to takeScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		
		//step2; call getscreenshotAs method  to create image file
		
		
		
	}

}
