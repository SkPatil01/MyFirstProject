package DemoTest_Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Upload_file {

	public static void main(String[] args) throws Exception {

		
		WebDriverManager.chromiumdriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/upload-download");
		
		//find webElement choose file
		//driver.findElement(By.xpath("//input[@id='uploadfile']")).sendKeys("C:\\Users\\om\\Documents\\krishna id.txt");
		
		
		WebElement button =driver.findElement(By.xpath("//input[@id='uploadfile']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(button).click().perform();
		 
		Robot rb =new Robot();
		rb.delay(2000);
		
		//copy to file clip board
		StringSelection ss = new StringSelection("C:\\Users\\om\\Documents\\krishna id.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//perform control + v action to paste file
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
