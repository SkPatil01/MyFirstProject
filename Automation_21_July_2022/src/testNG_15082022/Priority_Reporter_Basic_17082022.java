package testNG_15082022;
import org.testng.Reporter;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Priority_Reporter_Basic_17082022 {
  public static WebDriver driver;
	@Test(priority=-1)
  public void startDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
	@Test(priority=0)
	public void checkPageTitle() {
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Reporter.log("Page title is: "+driver.getTitle(),true);
	}
	
	@Test(priority=1)
	public void signUp() {
		
		WebElement login=driver.findElement(By.xpath("//a[text()='Login']"));
		Actions action=new Actions(driver);
		action.moveToElement(login).perform();
		driver.findElement(By.xpath("//div[text()='Sign Up']")).click();
		
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("7498842272"+Keys.ENTER);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("TestNG_@true"+Keys.ENTER);
		Reporter.log("Current page is: "+driver.getTitle(), true);
	}
	
	@Test(priority=2 ,enabled=false)
	public void close() {
		driver.close();
		driver.quit();
		Reporter.log("Window Closed: ", true);
	}
	
	
}
