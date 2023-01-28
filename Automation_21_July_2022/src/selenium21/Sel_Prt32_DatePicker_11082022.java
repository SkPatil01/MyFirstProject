package selenium21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt32_DatePicker_11082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		WebElement element=driver.findElement(By.id("datepicker1"));
		element.click();
		Thread.sleep(2000);
		
		String k;
		
		do {
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			WebElement my=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			k=my.getText();
		}
		while(!(k.equalsIgnoreCase("May 2018")));
		
		System.out.println("Successfully clicked the item");
		
		driver.findElement(By.xpath("//a[text()='16']"));
		
	}

}
