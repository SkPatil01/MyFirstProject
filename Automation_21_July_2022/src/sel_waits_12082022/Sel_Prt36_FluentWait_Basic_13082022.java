package sel_waits_12082022;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_Prt36_FluentWait_Basic_13082022 {
	public static WebDriver driver;
	public static void main(String[] args)throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Implicit wait 20seconds
		
		//below are ways to implement Explicit waits 
		//1.Using WebDriverWait class
		//2.Using FluentWait class
		
		WebDriverWait wait=new WebDriverWait(driver,60);//explicit wait max time 60 seconds
		
		FluentWait<WebDriver> fwait=new FluentWait<WebDriver>(driver);
		//setting max time for searching
		//fwait.withTimeout(10, TimeUnit.SECONDS);
		//setting how frequently the element to be searched before timeout
		//fwait.pollingEvery(250, TimeUnit.MILLISECONDS);
		//setting for ignoring the exception
		fwait.ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.alertIsPresent());
		
		
		driver.get("https:\\amazon.in");
		
		WebElement Element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		System.out.println("Print: "+Element);
		
	}

}
