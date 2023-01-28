package selenium21;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt19_AlertHandling_05082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.automationtesting.in/");
		Thread.sleep(2000);
		WebElement emailBox=driver.findElement(By.id("email"));
		System.out.println("The text inside the emailBox is :"+emailBox.getText());
		emailBox.sendKeys("k2kishor234@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href='Register.html'])[2]")).click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		Thread.sleep(1000);
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		Thread.sleep(1000);
		alert.dismiss();
		Thread.sleep(1000);
		driver.navigate().to("https://jqueryui.com/draggable/");
		Thread.sleep(1000);
		//webpage into the another webpage-----frame into the browser page
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		WebElement iframe=driver.findElement(By.xpath("//iframe[contains(@src,'default')]"));
		driver.switchTo().frame(iframe);//switching to frame with webelement as argument
		Thread.sleep(1000);
		WebElement te=driver.findElement(By.id("draggable"));
		System.out.println(te.getText());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();//switching to main window back
		WebElement t=driver.findElement(By.xpath("//h1[text()='Draggable']"));
		System.out.println(t.getText());
		driver.switchTo().frame(0);//switching to frame again using int argument
		WebElement te1=driver.findElement(By.id("draggable"));
		System.out.println(te1.getText());
		driver.navigate().to("http:\\google.co.in")	;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='gb_yf']")).click();
		Thread.sleep(3000);
		WebElement gframe=driver.findElement(By.xpath("//iframe[@name='app']"));
		driver.switchTo().frame(gframe);
		System.out.println("iframe title is: "+driver.getTitle());
		System.out.println("-------Printing all app names present in iframe-------------");
		List<WebElement>allApps=driver.findElements(By.xpath("//ul//li"));
		for(WebElement apps:allApps) {
			System.out.println(apps.getText());
			}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li//span[text()='Account']")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.close();
		
		
		

	}

}
