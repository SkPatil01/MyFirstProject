package DemoTest_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts_popup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://uitestpractice.com/Students/Switchto");
		
		//find alert button and perform click action
		//driver.findElement(By.xpath("//button[@id='alert']")).click();
		//driver.findElement(By.xpath("//button[@id='Confirm']")).click();
		
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		
		//switch to alert window and accept the alert
		driver.switchTo().alert().dismiss();//ok button is clicked
		
		//driver.switchTo().alert().dismiss();//to cancle alert
		
		
		
		
		
		
		
	}

}
