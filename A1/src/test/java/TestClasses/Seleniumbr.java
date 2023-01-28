package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumbr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
	System.setProperty("webdriver.chrome.driver","C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe" );
	
	WebDriver driver=new ChromeDriver();
	
	//driver.get("http://www.google.com");
	driver.manage().window().maximize();
	
	driver.get("http://www.google.com");
	
	driver.close();
	
	driver.navigate().to("http://www.Amazon.com");
	
	driver.close();
	}

}
