package testNG_15082022;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.Waits;
import utility.Screenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestNG_Prt3_AnnotationBfAfMethod_18082022  {
	public static WebDriver driver;
	
  @Test(priority=-1,enabled=false)
  public void checkItemDropDown() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	 WebElement itemDpdn=driver.findElement(By.id("searchDropdownBox"));
	 Select sel=new Select(itemDpdn);
	 itemDpdn.click();
	 sel.selectByVisibleText("Music");
	 WebElement srch=wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
	 srch.sendKeys("Ed"+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ENTER);
	 Reporter.log("We are on page :"+driver.getTitle(), true);
     Screenshot.takeShot(driver,"Amazon_Menu_TC1");
  }
  
  @Test(priority=0,enabled=false)
  public void clickOnMenuOptionFresh() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Fresh']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC2");
  }
  
  @Test(priority=1)
  public void clickOnMenuOptionAmazonPay() throws IOException {
	 // WebDriverWait wait=new WebDriverWait(driver,20);
	 // WebElement element=driver.findElement(By.xpath("//a[text()='Amazon Pay']"));
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Amazon Pay']")));
	  driver.findElement(By.xpath("//a[text()='Amazon Pay']")).click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC3");
	  
  }
  
  @Test(priority=2,enabled=false)
  public void clickOnMenuOptionTodaysDeal() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=\"Today's Deals\"]")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC4");
  }
  
  @Test(priority=3,enabled=false)
  public void clickOnMenuOptionPrime() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Prime']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC5");
  }
  
  @Test(priority=4,enabled=false)
  public void clickOnMenuOptionBestSellers() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Best Sellers']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC6");
  }
  
  @Test(priority=5,enabled=false)
  public void clickOnMenuOptionBuyAgain() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Buy Again']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC7");
  }
  
  @Test(priority=6,enabled=false)
  public void clickOnMenuOptionMobiles() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Mobiles']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC8");
  }
 
  @Test(priority=7,enabled=false)
  public void clickOnMenuOptionCustomerService() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Customer Service']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC9");
  }
  
  @Test(priority=8,enabled=false)
  public void clickOnMenuOptionGiftCards() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Gift Cards']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC10");
  }
  
  @Test(priority=9,enabled=false)
  public void clickOnMenuOptionElectronics() throws IOException {
	  WebDriverWait wait=new WebDriverWait(driver,20);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()=' Electronics ']")));
	  element.click();
	  Reporter.log("We are on page: "+driver.getTitle(),true);
	  Screenshot.takeShot(driver,"Amazon_Menu_TC11");
  } 
  
  
  
  
  @Test(priority=10,enabled=false)
  public void clickOnMenuOptionAll() throws IOException {
	  driver.findElement(By.id("nav-hamburger-menu")).click();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()=\"Men's Fashion\"]")));
	  js.executeScript("arguments[0].scrollIntoView()",element);
	  element.click();
	  List<WebElement>MensFashion=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@data-menu-id='10']//li"), 15));
	  for(WebElement e:MensFashion) {
		  Reporter.log(e.getText(), 0, true);
	  }
	  WebElement sWear=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //a[contains(@href,'0_2_10_19')]")));
	  js.executeScript("arguments[0].scrollIntoView()", sWear);
	  sWear.click();
	  Reporter.log("We are on this page: "+driver.getTitle());
	  Screenshot.takeShot(driver,"Amazon_Menu_TC12");
  }
  
  
  @BeforeMethod
  public void signIn()  {
	  driver.get("https://www.amazon.in/");
	  WebDriverWait  wait=new WebDriverWait(driver,30);
	  WebElement login=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']")));     
	  Actions action=new Actions(driver);
	  action.moveToElement(login).perform();
	  driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
	  driver.findElement(By.id("ap_email")).sendKeys("k2kishor234@gmail.com");
	  driver.findElement(By.id("continue")).click();
	  driver.findElement(By.id("ap_password")).sendKeys("@Gravity_UpSide22");
	  driver.findElement(By.id("signInSubmit")).click();
	  
  }

  @AfterMethod
  public void signOut() {
	  WebDriverWait wait=new WebDriverWait(driver,30);
	  WebElement logout=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'youraccount_btn')]")));
	  Actions action=new Actions(driver);
	  action.moveToElement(logout).perform();
	  driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
  }

  @BeforeClass
  public void startBrowser() {
	  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();

  }

  @AfterClass
  public void closeBrower() {
	  driver.close();
	  driver.quit();
  }

}
