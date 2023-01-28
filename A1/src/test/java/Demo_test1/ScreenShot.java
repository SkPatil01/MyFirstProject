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

public class ScreenShot {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(2000);
		
		
		/*TakesScreenshot ss=(TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		File Folder=new File("C:\\Users\\om\\Desktop\\New folder\\Facebook.png");
		FileUtils.copyFile(source, Folder); */
		
/*	WebElement section = driver.findElement(By.xpath("//h2[@class='uiHeaderTitle']"));
		//step 2: call getscreenshotAs method to create image file
		
		File src=section.getScreenshotAs(OutputType.FILE);
		
		
		File Folder=new File("C:\\Users\\om\\Desktop\\k\\h2.png");
		
		//Step:3 copy image to destination
        FileUtils.copyFile(src, Folder);     */
		
		
		
		
		driver.close();
		
		
		

	}
}
