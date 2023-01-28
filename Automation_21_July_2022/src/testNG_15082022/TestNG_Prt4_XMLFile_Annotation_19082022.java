package testNG_15082022;

import org.testng.annotations.Test;
import utility.Screenshot;
import utility.Waits;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Prt4_XMLFile_Annotation_19082022 {
	public static WebDriver driver;
  @Test(priority=-1)
  public void checkPhoneInStock()throws Throwable {
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Phones']")));
	  driver.findElement(By.xpath("//a[text()='Phones']")).click();
	  Waits.explicit(driver, 20, ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@id='tbodyid']/div"), 8));
	  List<WebElement>phoneQty=driver.findElements(By.xpath("//div[@id='tbodyid']/div"));
	  Reporter.log("---Total phones in Stock are : "+phoneQty.size(), true);
	 
  }
  
  @Test(priority=0)
  public void checkLaptopsInStock() throws InterruptedException {
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Laptops']")));
	  driver.findElement((By.xpath("//a[text()='Laptops']"))).click();
	  Thread.sleep(3000);
	  List<WebElement>laptopStock=driver.findElements(By.xpath("//div[@id='tbodyid']/div"));
	  Reporter.log("---Total laptops in stock are :"+laptopStock.size(),true);
	  for(WebElement e:laptopStock)
		  Reporter.log(e.getText(),true);
		  
  }
  
  @Test(priority=1)
  public void checkMonitorsInStock() throws InterruptedException {
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Monitors']")));
	  WebElement monitor=driver.findElement(By.xpath("//a[text()='Monitors']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView()", monitor);
	  driver.findElement(By.xpath("//a[text()='Monitors']")).click();
	  Thread.sleep(3000);
	  List<WebElement>monitorStock=driver.findElements(By.xpath("//div[@id='tbodyid']/div"));
	  Reporter.log("---Total Monitors in Stock are: "+monitorStock.size(),true);
	  for(WebElement e:monitorStock)
		  Reporter.log(e.getText(),true);
	  
  }
  
  @Test(priority=2)
  public void checkContactMenu() throws Throwable{
	  Waits.explicit(driver,10, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact']")));
	  driver.findElement(By.xpath("//a[text()='Contact']")).click();
	  Thread.sleep(500);
	  WebElement email=driver.findElement(By.id("recipient-email"));
	  Actions action = new Actions(driver);
	  action.moveToElement(email).click().sendKeys("k2kishor234@gmail.com").perform();
	  Thread.sleep(1000);
	  WebElement name=driver.findElement(By.id("recipient-name"));
	  name.sendKeys("Kishor");
	  Thread.sleep(1000);
	  WebElement msg=driver.findElement(By.id("message-text"));
	  msg.sendKeys("Add iframe_WebTable_Calendar_Dropdown");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//button[text()='Send message']")).click();
	  Thread.sleep(1000);
	  String msgs=driver.switchTo().alert().getText();
	  driver.switchTo().alert().accept();
	  Reporter.log("---Contact menu successfully verified: ---"+msgs,true);
   
  }
  
  @Test(priority=3)
  public void addPhoneToCart() throws Throwable {
	  Waits.explicit(driver, 10, ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sony vaio i5']")));
	  WebElement sonyX=driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView()", sonyX);
	  driver.findElement(By.xpath("//a[text()='Sony vaio i5']")).click();
	  Screenshot.takeShot(driver, "Sonyi5");
	  driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
	  Thread.sleep(1000);
	  driver.switchTo().alert().accept();
	  Reporter.log("-------Item added in Cart------",true);
  }
  
  @Test(priority=4)
  public void checkCartItems() throws Throwable {
	  driver.findElement(By.xpath("//a[text()='Cart']")).click();
	  Waits.explicit(driver, 20, ExpectedConditions.presenceOfElementLocated(By.xpath("//img[contains(@src,'_5')]")));
	  Screenshot.takeShot(driver, "CartItem");
	  List<WebElement>wTable=driver.findElements(By.xpath("//tr"));
	  for(WebElement w:wTable)
	   System.out.println(w.getText());
	  Reporter.log("Item Added-------Webtable  Printed--------------", true);
  }
  
  @Test(priority=5)
  public void placeOrder() throws Throwable {
	  driver.findElement(By.xpath("//a[text()='Cart']")).click();
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
	  driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	  Thread.sleep(500);
	  driver.findElement(By.id("name")).sendKeys("Kishor");
	  Thread.sleep(200);
	  driver.findElement(By.id("country")).sendKeys("India");
	  Thread.sleep(200);
	  driver.findElement(By.id("city")).sendKeys("Aurangabad");
	  Thread.sleep(200);
	  driver.findElement(By.id("card")).sendKeys("1234567");
	  Thread.sleep(200);
	  WebElement purchase=driver.findElement(By.xpath("//button[text()='Purchase']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView()", purchase);
	  driver.findElement(By.id("month")).sendKeys("Sept");
	  Thread.sleep(200);
	  driver.findElement(By.id("year")).sendKeys("2024");
	  Thread.sleep(200);
	  driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	  Thread.sleep(3000);
	  Screenshot.takeShot(driver, "OrderPlaced");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[text()='OK']")).click();
	  Reporter.log("------Order Placed Successfully---------", true);
	  
  }
  
  @Test(priority=6)
  public void verifyAboutUsPage() throws Throwable {
	  driver.findElement(By.xpath("//a[text()='About us']")).click();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[contains(@class,'big-play')]")).click();
	  Thread.sleep(500);
	  WebElement pause=driver.findElement(By.xpath("//span[text()='Pause']"));
	  Actions action=new Actions(driver);
	  action.moveToElement(pause).click().perform();
	  Thread.sleep(500);
	  driver.findElement(By.xpath("(//button[text()='Close'])[4]")).click();
	  Reporter.log("-----About us video plugin works fine----");
	  
  }
 
  @BeforeMethod
  public void refreshThePage() {
	  driver.navigate().refresh();
	  Reporter.log("-----Page refreshed successfully : "+driver.getTitle());
  }

  @AfterMethod
  public void returnToHomePage() {
	  Waits.explicit(driver, 0, ExpectedConditions.elementToBeClickable(By.id("nava")));
	  driver.findElement(By.id("nava")).click();
	  Reporter.log("----Returned to Homepage :"+driver.getCurrentUrl());
  }

  @BeforeClass
  public void homePageItemsList() {
	Waits.explicit(driver, 0, ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@id='tbodyid']/div"), 9));
	 List<WebElement>allItems=driver.findElements(By.xpath("//div[@id='tbodyid']/div"));
	 Reporter.log("----Total items present on home page are: "+allItems.size(),true);
	 
  }

  @AfterClass
  public void getAllLinks() {
	  driver.findElement(By.id("nava")).click();
	  List<WebElement>links=driver.findElements(By.tagName("a"));
	 	  for(WebElement l:links) {
		  if(l.getAttribute("href")!=null)
			  
		  Reporter.log(l.getAttribute("href"),true);
	  }
  }

  @BeforeTest
  public void signIN() throws Throwable {
	  driver.get("https://www.demoblaze.com/");
	  Waits.explicit(driver,20,ExpectedConditions.elementToBeClickable(By.id("login2")));
	  driver.findElement(By.id("login2")).click();
	  Thread.sleep(500);
	  driver.findElement(By.id("loginusername")).sendKeys("K2Kishor_");
	  Thread.sleep(500);
	  driver.findElement(By.id("loginpassword")).sendKeys("123456");
	  Thread.sleep(500);
	  driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
	  Thread.sleep(500);
  }

  @AfterTest
  public void signOut() {
	  Waits.explicit(driver, 20, ExpectedConditions.elementToBeClickable(By.id("logout2")));
	  driver.findElement(By.id("logout2")).click();
  }

  @BeforeSuite
  public void openBrowser() {
	  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterSuite
  public void closeBrowser() {
	  driver.close();
	  driver.quit();
  }

}
