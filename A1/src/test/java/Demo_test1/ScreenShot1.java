package Demo_test1;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot1 {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://uitestpractice.com/");
		
	/*	//Step1 :convert webdriver object to TakeScreenShot interface
		TakesScreenshot ss=(TakesScreenshot)driver;
		
		//step 2: call getscreenshotAs method to create image file
		
		File src=ss.getScreenshotAs(OutputType.FILE);
		File Folder=new File("C:\\Users\\om\\Desktop\\New folder\\fullpage.png");
		
		//Step:3 copy image to destination
        FileUtils.copyFile(src, Folder);     */
		
		//capture section of web page
		//Step1 :convert web driver object to TakeScreenShot interface
				//TakesScreenshot ss=(TakesScreenshot)driver;
			WebElement section = driver.findElement(By.xpath("//button[@name='dblClick']"));
				//step 2: call getscreenshotAs method to create image file
				
				File src=section.getScreenshotAs(OutputType.FILE);
				
				
				File Folder=new File("C:\\Users\\om\\Desktop\\New folder\\button.png");
				
				//Step:3 copy image to destination
		        FileUtils.copyFile(src, Folder);
				
		
		driver.close();
		
	}

}
