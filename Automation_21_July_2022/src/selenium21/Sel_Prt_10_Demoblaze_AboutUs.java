package selenium21;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.interactions.Actions;

public class Sel_Prt_10_Demoblaze_AboutUs {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(1000);
		
//		driver.findElement(By.linkText("About us")).click();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//button[@title='Play Video']")).click();
//		Thread.sleep(3000);
//		
//		//i am using Action class for performing mouse hovering effect and handling that elements 
//		//Actions actions=new Actions(driver);
//		//JavascriptExecutor js=(JavascriptExecutor)driver;
//		//WebElement playMenu=driver.findElement(By.xpath("//div[@class='vjs-control-bar']"));
//		//actions.moveToElement(playMenu).perform();
//		//js.executeScript("document.getElementByXPath(//button[@title='Play']')[0].click();");
//		WebElement playBtn=driver.findElement(By.xpath("//button[@title='Play']"));
//		playBtn.click();
//		//actions.moveToElement(playBtn).click().perform();
//		//actions.moveToElement(playBtn);
//		//js.executeScript("arguments[0].click();", playBtn);
//		Thread.sleep(1000);
//		boolean isSelected=driver.findElement(By.xpath("//button[@title='Play']")).isSelected();
//		boolean isEnabled=driver.findElement(By.xpath("//button[@title='Play']")).isEnabled();
//		boolean isDisplayed=driver.findElement(By.xpath("//button[@title='Play']")).isDisplayed();
//		System.out.println(isSelected+" "+isEnabled+" "+isDisplayed);
//		
//		//WebElement volume=driver.findElement(By.xpath("//button[contains(@class,'vjs-mute-control')]"));
//		//actions.moveToElement(volume).perform();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//div[@id='videoModal']//button[contains(@class,'secondary')]")).click();
//
	}

}
