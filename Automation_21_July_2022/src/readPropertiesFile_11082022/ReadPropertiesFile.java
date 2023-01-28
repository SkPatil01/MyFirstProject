package readPropertiesFile_11082022;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropertiesFile {

	public static void main(String[] args) throws Throwable{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(".\\TestData_KK_01\\config.properties");
		prop.load(fis); //non static method from Properties class ... using object of that class
		String url=prop.getProperty("URL");
		driver.get(url);
		Thread.sleep(3000);
		WebElement un=driver.findElement(By.xpath("//input[@type='email']"));
		un.sendKeys(prop.getProperty("Username"));
		Thread.sleep(2000);
		WebElement ps=driver.findElement(By.xpath("//button[@type='button']"));
		ps.click();
		
		Thread.sleep(2000);
		
		WebElement cell=driver.findElement(By.id("yDmH0d"));
		cell.sendKeys("7498842272");
		
		

	}

}
