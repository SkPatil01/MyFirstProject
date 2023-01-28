package selenium21;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt17_getWindowHandles_Task8 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.selenium.dev/");
		 Thread.sleep(5000);		
		 driver.findElement(By.xpath("//li[@aria-label='User mailing list']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//li[@aria-label='Selenium in Twitter']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//li[@aria-label='SeleniumConf YouTube Channel']")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//li[@aria-label='Selenium in Facebook']")).click();
		 Thread.sleep(3000);
		WebElement reg= driver.findElement(By.xpath("//a[text()='Register now!']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", reg);
		 Thread.sleep(3000);

		 Set<String>ID=driver.getWindowHandles();
		 List<String>ID1=new ArrayList<String>(ID);
		 System.out.println(ID1);
//		 Object[ ]id2=ID.toArray();
//		 String [] id3=new String[id2.length];
//		 for(int i=0; i<id2.length;i++){
//		 id3[i]=id2[i].toString();
//		 } 
		  driver.switchTo().window(ID1.get(5));
		  if(driver.getCurrentUrl().equals("https://groups.google.com/g/selenium-users")){
		  driver.findElement(By.xpath("//input[@class='Ax4B8 ZAGvjd']")).sendKeys("ElementClickInterceptedException");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//button[@class='gb_mf gb_nf']")).click();
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("(//span[contains(text(),'10 times')])[2]")).click();
		  String issueTitle=driver.getTitle();
		  System.out.println(issueTitle);
		  }
		 Thread.sleep(1000);
		 driver.switchTo().window(ID1.get(0));
		 //driver.findElement(By.xpath("//button[@class='navbar-toggler']")).click();
		 Thread.sleep(1000);
		  driver.findElement(By.xpath("//span[text()='Documentation']")).click();
		 Thread.sleep(2000);
		 System.out.println(driver.getTitle());
		 driver.switchTo().window(ID1.get(4));
		 System.out.println(driver.getTitle());
		 driver.switchTo().window(ID1.get(3));
		 driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Jobless Testers");
		 Thread.sleep(1000);
		 //driver.findElement(By.xpath("//button[@id='searchbox-button']")).click();---->Throws org.openqa.selenium.ElementNotInteractableException
		 WebElement srch=driver.findElement(By.xpath("//button[@id='searchbox-button']"));
		 js.executeScript("arguments[0].click()", srch);//solved by JavascriptExecutor ref.variable.
		 Thread.sleep(3000);
		 System.out.println(driver.getTitle());
		 driver.switchTo().window(ID1.get(2));
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//form[@id='login_form']")).click();
		 System.out.println(driver.getTitle());
		 Thread.sleep(1000);
		 driver.navigate().back();
		 Thread.sleep(2000);
		 driver.switchTo().window(ID1.get(1));
		 Thread.sleep(1000);
		 System.out.println(driver.getTitle());
		 driver.findElement(By.xpath("//a[@data-action='visit-registration']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("(//a[starts-with(@href,'/login?req')])[1]")).click();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[@id='register_section']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Kishor");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Kere");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='new_email'] ")).sendKeys("k2kishor234@gmail.com");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("ZeroGravity@22_3_112");
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@id='confirmation-password']")).sendKeys("ZeroGravity@22_3_112"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		 Thread.sleep(2000);
		 System.out.println(driver.getTitle());
		 driver.switchTo().window(ID1.get(0));
		 System.out.println("Thank You _ All Test Passed");
		

	}

}
