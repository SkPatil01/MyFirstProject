package Demo_test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frist_test {
@Test	
public void test (){
	
	
}

	public static void main(String[] args) {
     
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://github.com/");
		  //capture page title
		String title =driver.getTitle();
		System.out.println("Page Title :"+ title);
		
		//capture the url 
		System.out.println("URL:"+driver.getCurrentUrl());
		
		//capture web page
		System.out.println(driver.getPageSource());
	}

}
