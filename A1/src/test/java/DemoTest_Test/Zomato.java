package DemoTest_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Zomato {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.zomato.com/");
		 
		 String title=driver.getTitle();
		 System.out.println("page Title :"+ title );
		 
	}

}
