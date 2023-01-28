package selenium21;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Sel_Prt24_TakeScreenShot_09082022 {
	
	public static void main(String[] args) throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	
	TakesScreenshot sc=(TakesScreenshot)driver;
	JavascriptExecutor js=(JavascriptExecutor)driver;
	Date date=new Date();
	System.out.println("date is: "+date);
	driver.get("https:\\google.co.in");
	Thread.sleep(1000);
	//take screenshot using getScreenshotAs method
	File source=sc.getScreenshotAs(OutputType.FILE);
	File target=new File("E:\\Screenshots\\GeneralScreenShot.png");
	FileHandler.copy(source, target);
	
	driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	Thread.sleep(3000);
	
	WebElement userName=driver.findElement(By.id("txtUsername"));
	WebElement pswd=driver.findElement(By.id("txtPassword"));
	
	userName.sendKeys("Admin");
	pswd.sendKeys("12345");
	
	js.executeScript("window.confirm('Do u want to login')");
	Thread.sleep(3000);
	driver.switchTo().alert().accept();
	Thread.sleep(1000);
	
	driver.findElement(By.id("btnLogin")).click();
	
	String expErrMsg="Username or Password Wrong";
	WebElement actErr=driver.findElement(By.xpath("//span[@id='spanMessage']"));
	String actErrMsg=actErr.getText();
	if(actErrMsg.equalsIgnoreCase(expErrMsg)) {
		System.out.println("TEST PASS");
	}else {
		File s1=sc.getScreenshotAs(OutputType.FILE);
		File t1=new File("E:\\Screenshots\\TestFailed_1.png");
		FileHandler.copy(s1, t1);
	}
	System.out.println("Simple ScreenShot Captured ");
	
	driver.quit();
		
		
	}

}
