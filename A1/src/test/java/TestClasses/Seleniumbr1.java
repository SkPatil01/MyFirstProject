package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumbr1 {
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe");
 
		//webDriverManeger.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("https://www.google.com/");
		
		driver.close();
		
	}

}
