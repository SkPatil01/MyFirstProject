package Demo_test1;

import java.io.File;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot2 {

	
	public static void main(String[] args) throws Exception {
WebDriverManager.chromedriver().setup();

WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.facebook.com");

		Thread.sleep(2000);
		
	//TakesScreenshot ss=(TakesScreenshot)driver;
	 WebElement ss = driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));////img[@class='fb_logo _8ilh img']
	File source=ss.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\om\\Desktop\\p.png");
	FileUtils.copyFile(source, dest);
	

	}

}
