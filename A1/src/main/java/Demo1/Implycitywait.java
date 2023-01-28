package Demo1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Stopwatch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implycitywait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://sellglobal.ebay.in/seller-center/");
		
		//wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Stopwatch watch= null;
		
		try {
			 watch=Stopwatch.createStarted();
		//find webelement 
		driver.findElement(By.linkText("worngelement")).click();
		}
		catch(Exception e )
		{
			
			System.out.println(e);
			System.out.println(watch.elapsed(TimeUnit.SECONDS)+" second");
		}
		
		  
		
		

	}

}
