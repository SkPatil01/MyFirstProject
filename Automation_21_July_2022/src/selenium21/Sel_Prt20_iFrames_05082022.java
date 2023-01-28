package selenium21;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Sel_Prt20_iFrames_05082022 {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.navigate().to("http:\\google.co.in");
		//driver.manage().window().maximize();
		Thread.sleep(4000);
		List<WebElement>frames=driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames present on page are: "+frames.size());
		WebElement frame1=driver.findElement(By.xpath("//iframe[@name='callout']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//button[text()='No thanks']")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.confirm('Hey, Shall we start the activity');");//created confirmation alert using js
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@class='gb_yf']")).click();
		Thread.sleep(2000);
		WebElement gframe=driver.findElement(By.xpath("//iframe[@name='app']"));
		//driver.switchTo().frame(0);
		driver.switchTo().frame(gframe);
		
		//String appFrame=driver.getWindowHandle();
		
		Thread.sleep(1000);
		Set<String>IDs=driver.getWindowHandles();
		List<String>IDL=new ArrayList<String>(IDs);
		System.out.println(IDL);
		System.out.println("Total window open windows are: "+IDs.size());
		//driver.switchTo().window(IDL.get(1));
		//System.out.println(appFrame);
		//driver.switchTo().window(appFrame);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("iframe title is: "+driver.getTitle());
		System.out.println("-------Printing all app names present in iframe-------------");
		System.exit(0);
		
		
		//Exit here
		List<WebElement>allApps=driver.findElements(By.xpath("//ul//li"));
		Actions action=new Actions(driver);
		System.out.println("---Created Object of action class and passed argument as webdriver ref.variable-----");
		for(WebElement apps:allApps) {
			System.out.println(apps.getText());
			}
		Thread.sleep(1000);
		System.out.println("All app names printed");
		for(int i=0; i<allApps.size();i++) {
			if(i<allApps.size()-1) {
				Thread.sleep(100);
			action.sendKeys(Keys.TAB).build().perform();//used action class object for switching to apps in iframe using keys.tabmethod
		
			}
		}
		System.out.println("App traversed");
		
		Thread.sleep(4000);
		action.sendKeys(Keys.ARROW_UP).build().perform();//scroll page upward using ARROW_UP method
		Thread.sleep(1000);
		System.out.println("iframe scrolled up");
		driver.findElement(By.xpath("//li//span[text()='News']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@aria-label='India']//span[@class='ICsaqd']")).click();
		Thread.sleep(4000);
		js.executeScript("alert('All Element Printed')");
		Thread.sleep(1000);
		alert.accept();
		Thread.sleep(2000);
		js.executeScript("window.confirm('Activity Completed');");//created confirmation alert using Js.
		Thread.sleep(2000);
		alert.accept();
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		System.out.println("Script Over");
		driver.close();
		driver.quit();
		

	}

}
