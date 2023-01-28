package DemoTest_Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Co_radiobutton {

	public static void main(String[] args) {

		
		//chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://udyamregistration.gov.in/Udyam_Login.aspx");
		
		//find radio button web element on webpage
	List	<WebElement > radioButtonList = driver.findElements(By.xpath("//input[@type='radio']"));
		
		//print total no.of radio button on webpage
				System.out.println("Total no.of radio button on web page:"+radioButtonList.size());
				driver.close();
 		
		//Firefox browser
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver =new FirefoxDriver();
		//driver.get("http://www.google.com");
		
		//edge browser
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver =new EdgeDriver();
		//driver.get("http://www.google.com");
		
		
		
	}

}
