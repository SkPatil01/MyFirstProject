package testNG_15082022;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestNG_Prt5_Amazon_MouseHover_20082022 {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions action;
  @Test
  public void checkTodaysDealsMenu() throws Throwable{
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Today')]")));
	  driver.findElement(By.xpath("//a[contains(text(), 'Today')]")).click();
	  List<WebElement>subMenu=wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@id='nav-subnav']/a"), 8));
	  for(WebElement e:subMenu) {
		  action.moveToElement(e).perform();
		  Reporter.log(e.getText(),true);
	  }
	  Thread.sleep(2000);
  }
  @BeforeMethod
  public void signIn() throws Throwable {
	  driver.get("https://www.amazon.in/");
	  WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-link-accountList")));
	  action.moveToElement(login).perform();
	  driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
	  Thread.sleep(500);
	  driver.findElement(By.id("ap_email")).sendKeys("k2kishor234@gmail.com");
	  driver.findElement(By.id("continue")).click();
	  Thread.sleep(500);
	  driver.findElement(By.id("ap_password")).sendKeys("@Gravity_UpSide22");
	  driver.findElement(By.id("signInSubmit")).click();
	  Thread.sleep(500);
	  Reporter.log("-----LOGIN Success-----",true);
  
  }

  @AfterMethod
  public void signOut()throws Throwable {
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='nav-link-accountList']")));
	  WebElement logOut=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	  action.moveToElement(logOut).perform();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
	  Reporter.log("-----LogOut Success-----",true);
  }

  @BeforeClass
  public void startBrowser() {
	  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  wait=new WebDriverWait(driver,20);
	  action=new Actions(driver);
	  
  }
  
  @AfterClass
  public void closeBroser() {
	  driver.close();
	  driver.quit();
	  
  }
  
  
  
}
