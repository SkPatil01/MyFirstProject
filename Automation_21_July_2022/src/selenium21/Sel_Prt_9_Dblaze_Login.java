package selenium21;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_9_Dblaze_Login {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("cartur")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[starts-with(@href,'index') and contains(text(),'Home')]")).click();
		
		Thread.sleep(3000);
		
		List<WebElement>menu=driver.findElements(By.xpath("//li[@class='nav-item']"));
		int menuCount=0;
		for(WebElement m:menu) {
			System.out.println(m.getText());
			menuCount++;
		}
		System.out.println(menuCount);
		if(menuCount==6) {
			System.out.println("Test Pass");
		}
		else {
			System.out.println("Test Fail");
		}
		System.out.println("----do RCA if it fails-----");
		
		//finding hidden element
		
		
		WebElement hidden=driver.findElement(By.id("logout2"));
		String s=hidden.getAttribute("textContent");
		String s1=hidden.getAttribute("innerText");
		String s2=hidden.getAttribute("innerHTML");
		System.out.println("Hidden element is: "+s+" "+s1+" "+s2);
		
	}

}
