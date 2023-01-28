package selenium21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_11_TutorialsNinja_30072022 {
	//incomplete test script
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver =new ChromeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		WebElement search=driver.findElement(By.xpath("//input[@name='search']"));
		search.sendKeys("MacBook");
		String s=search.getAttribute("value");
		System.out.println("The enetered text in search box is: "+s);
		
		driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
		Thread.sleep(3000);
		
		//if(driver.findElement(By.xpath("//div[@id='content']//h1[ text()='Search - Macbook']")).isDisplayed()) {
			//System.out.println("Test Pass: correct element is displayed");
		//}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h4//a[contains(@href,'id=43')]")).click();
		 if(driver.getCurrentUrl().contains("id=43")) {
			 System.out.println("Test Pass: Page navigated to correct URL");
		 }
		driver.findElement(By.xpath("//a[contains(@href,'macbook_1')]")).click();
		Thread.sleep(1000);
		
		WebElement next=driver.findElement(By.xpath("//button[contains(@title,'Right')]"));
		next.click();
		Thread.sleep(1000);
		
		
		
		

	}

}
