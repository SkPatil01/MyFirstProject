package selenium21;

/// this program for login

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Rakesh_Excp_29072022 {

	public static void main(String[] args) throws InterruptedException {
		

	
				System.setProperty("webdriver.chrome.driver","C:\\path chromedriver\\chromedriver.exe" );
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.demoblaze.com/");
				Thread.sleep(2000);
				driver.findElement(By.id("login2")).click();  
				WebElement userName = driver.findElement(By.id("loginusername"));
				Thread.sleep(2000);
				userName.sendKeys("Rakeshbhadane");
				Thread.sleep(3000);
				WebElement Password = driver.findElement(By.id("loginpassword"));
				Thread.sleep(3000);
				Password.sendKeys("Rakesh@123");
				//driver.findElement(By.className("button")).click();//wrong locator used
				driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
				
				
				
			}

		

	}


