package testNG_15082022;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestNG_Prt6_Assertions_Demoblaze_21082022 {
	 static WebDriver driver;
	 static WebDriverWait wait;
	 static Actions action;
	 static JavascriptExecutor js;
	 
  @Test(priority=-1)
  public void validatePageTitle() throws Exception {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  Assert.assertEquals(driver.getTitle(), "STORE");
	  Assert.assertNotEquals(driver.getTitle(),"STORES");
	  String ExTitle="PRODUCT STORE";
	  Thread.sleep(500);
	  String AcTitle=driver.findElement(By.id("nava")).getText();
	  Assert.assertEquals(ExTitle, AcTitle,"Failed:Not not as per requirement");
	  Thread.sleep(500);
	  Reporter.log("--Pass:TitleValidated: Page Title is as Expected--", true);
	  Thread.sleep(500);
	  int AcTitleWidth=driver.findElement(By.id("nava")).getSize().width;
	  int ExTitleWidth=227;
	  Assert.assertEquals(AcTitleWidth, ExTitleWidth,"--Width not matching--");
	  Reporter.log("--Pass:Title Width Validated: as per specification--", true);
	  Thread.sleep(500);
	  
  }
  
  @Test(priority=0)
  public void validateHomeMenu() throws Exception {
	  Thread.sleep(500);
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home ']"));
	  Assert.assertTrue(home.isDisplayed());
	  Reporter.log("--Pass: Home menu is Displayed--", true);
	  Thread.sleep(500);
	  Assert.assertTrue(home.isEnabled(),"---Test Failed: Button is not enabled");
	  Reporter.log("---Pass: Button is enabled---", true);
	  boolean menuName=home.getText().contains("Home");
	  try {
	  Assert.assertTrue(menuName,"---Failed: Menu Name not matching---");
	  }
	  catch(Exception e) {
		  Reporter.log("Failed:Menu name wrong ",true);
	  }
	  Thread.sleep(500);
	  home.click();
	  Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.demoblaze.com/index.html"));
	  Reporter.log("--Navigated to correct URL", true);
  }
  
  
  @Test(priority=1)
  public void validateContactMenut() throws Exception {
	 WebElement contact=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact']")));
	 Assert.assertTrue(contact.isDisplayed(),"Failed:Contact Menu is not displayed");
	 Reporter.log("--Contact menu displayed", true);
	 Assert.assertTrue(contact.isEnabled(),"Failed: Contact menu is disabled");
	 Reporter.log("---Contact menu is enabled--",true);
	 Assert.assertEquals(contact.getText(), "Contact","--Failed: Name Mismatch");
	 Reporter.log("--Menu name is correct--", true);
	 contact.click();
	 WebElement mail=wait.until(ExpectedConditions.elementToBeClickable(By.id("recipient-email")));
	 Thread.sleep(500);
	 Assert.assertTrue(mail.isEnabled(), "--Failed:mail text box is disabled---");
	 mail.sendKeys("k2kishor234@gmail.com");
	 driver.findElement(By.id("recipient-name")).sendKeys("Kishor");
	 Thread.sleep(200);
	 driver.findElement(By.id("message-text")).sendKeys("This is me");
	 WebElement button=driver.findElement(By.xpath("//button[@onclick='send()']"));
	 Assert.assertEquals(button.isDisplayed(), true, "Failed: button is not visible");
	 button.click();
	 Reporter.log("--Send button is enabled--", true);
	 Thread.sleep(500);
	 String alMsg=driver.switchTo().alert().getText();
	 Assert.assertFalse(alMsg.contains("Proceed"),"Failed:Alert msg not as per specification");
	 Reporter.log("--Alert Msg is as per Spec.--", true);
	 driver.switchTo().alert().accept();
	 Thread.sleep(500);
	
  }
  
  
  @Test(priority=2)
  public void validateAboutUsMenu() throws Exception{
	  WebElement aboutUs=driver.findElement(By.xpath("//a[text()='About us']"));
	  Assert.assertFalse(aboutUs.isSelected(),"Failed: Menu Already selected");
	  Reporter.log("--About us Menu state as per Spec--", true);
	  Assert.assertEquals(aboutUs.getText(), "About us","Failed: Menu name as per Spec.");
	  Reporter.log("--About us menu name is as per spec--", true);
	  Assert.assertTrue(aboutUs.isDisplayed(),"Failed: About us menu is not visible");
	  Thread.sleep(500);
	  aboutUs.click();
	  WebElement playBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Play Video']")));
	  Assert.assertTrue(playBtn.isDisplayed(),"Failed:Video play button is invisible");
	  Reporter.log("--Play button is visible--", true);
	  Assert.assertTrue(playBtn.isEnabled(),"Failed: Play btn is not clickable");
	  Reporter.log("--Play button is clickable--", true);
	  playBtn.click();
	  Thread.sleep(1000);
	  WebElement pause=driver.findElement(By.xpath("//button[@title='Pause']"));
	  Assert.assertFalse(pause.isDisplayed()!=true,"Failed: Pause button is visible");
	  Reporter.log("--Before Mouse Hovering button is invisible--", true);
	  action.moveToElement(pause).click().perform();
	  Assert.assertTrue(pause.isDisplayed(),"Failed: Pause button is invisible");
	  Reporter.log("--On Mouse Hovering button is visible--", true);
	  pause.click();
	  Thread.sleep(500);
	  WebElement closeBtn=driver.findElement(By.xpath("(//button[text()='Close'])[4]"));
	  Assert.assertTrue(closeBtn.isDisplayed(),"Failed: Close button not displayed");
	  Reporter.log("--Close button is present--", true);
	  Assert.assertFalse(closeBtn.isEnabled()!=true, "Failed:Close button is not enabled");
	  Reporter.log("--Close button is enabled--",true);
	  closeBtn.click();
	  Thread.sleep(500);
	
  }
  
  @Test(priority=3)
  public void validateCartMenu() throws Exception{
	  WebElement cart=wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur")));
	  Assert.assertTrue(cart.isDisplayed(),"Failed: cart menu not visible");
	  Reporter.log("--Cart Menu is visible--", true);
	  Assert.assertFalse(cart.isSelected(),"Failed:cart menu preselected");
	  Reporter.log("--Cart Menu State is as per spec",true);
	  Assert.assertEquals(cart.getText(), "Cart","Failed:Menu name not as per Spec");
	  Reporter.log("--Menu name as per spec--",true);
	  Thread.sleep(500);
	  cart.click();
	  Thread.sleep(1000);
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(url,"https://www.demoblaze.com/cart.html","Failed:Page navigated to wrong domain");
	  Reporter.log("--Page Navigated to URL as per Spec--",true);
	  driver.navigate().back();
	  Thread.sleep(1000);
  }
  
  @Test(priority=4)
  public void validateLogOutMenu() throws Exception{
	  WebElement logout=wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
	  Assert.assertTrue(logout.isDisplayed(),"Failed:logout menu invisible");
	  Reporter.log("--Logout menu is visible--",true);
	  Assert.assertFalse(logout.isEnabled()!=true, "Failed:logout menu is disabled");
	  Reporter.log("--Logout menu is Enabled--",true);
	  Assert.assertEquals(logout.getText(), "Log out","Failed: Menu title not as per Spec");
	  Reporter.log("--Menu title is as per Spec--", true);
	  Thread.sleep(1000);
  }
  
  @Test(priority=5)
  public void validateUserName() throws Exception{
	  WebElement userName=wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
	  Assert.assertTrue(userName.isDisplayed(),"Failed:UserName is invisible");
	  Reporter.log("--UserName is displayed--",true);
	  Assert.assertTrue(userName.getText().contains("Day4"), "Failed:Wrong userName");
	  Reporter.log("--UserName is correct--", true);
	  Assert.assertFalse(userName.isEnabled()!=true,"Failed:Username is disabled");
	  Reporter.log("--UserName is clickable--", true);
	  Thread.sleep(1000);
  
  }
  
  @Test(priority=6)
  public void validateCategorySubMenu() throws Exception {
	  
	  List<WebElement>category=wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='list-group']/a"), 4));
	  for(int i=0; i<category.size();i++) {
		   if(i==0) {
			   Assert.assertTrue(category.get(i).isDisplayed(),"Failed: Category name not displayed");
			   Reporter.log("--Category title is present--",true);
			   Assert.assertFalse(category.get(i).isEnabled()!=true,"Failed:Option Disabled");
			   Reporter.log("--Category option is clickable--",true);
			   Assert.assertNotEquals(category.get(i).getText(),"Categories","Failed:Option title wrong");
			   Reporter.log("--Option title is as per Spec--",true);
			   
		      }
		   if(i==1) {
			   js.executeScript("window.scrollBy(0,300)");
			   Thread.sleep(500);
			   Assert.assertTrue(category.get(i).isDisplayed(),"Failed: Phone name not displayed");
			   Reporter.log("--Category title is present--",true);
			   Assert.assertFalse(category.get(i).isEnabled()!=true,"Failed:Option Disabled");
			   Reporter.log("--Category option is clickable--",true);
			   Assert.assertNotEquals(category.get(i).getText(),"Phone","Failed:Option title wrong");
			   Reporter.log("--Option title is as per Spec--",true);
			   category.get(i).click();
			   Thread.sleep(1000);
			   Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/#","Failed:Navigated to wrong page");
			   driver.navigate().back();
			   Reporter.log("--Page Navigated to URL as per Spec.",true);
		   
		   }
		  if (i==2) {
			   Assert.assertTrue(category.get(i).isDisplayed(),"Failed: Laptops name not displayed");
			   Reporter.log("--Laptops title is present--",true);
			   Assert.assertFalse(category.get(i).isEnabled()!=true,"Failed:Option Disabled");
			   Reporter.log("--Laptops option is clickable--",true);
			   Assert.assertNotEquals(category.get(i).getText(),"Laptop","Failed:Option title wrong");
			   Reporter.log("--Option title is as per Spec--",true);
			   category.get(i).click();
			   Thread.sleep(1000);
			   Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/#","Failed:Navigated to wrong page");
			   driver.navigate().back();
			   Reporter.log("--Page Navigated to URL as per Spec.",true);
			   
		   }
		  if (i==3) {
			   Assert.assertTrue(category.get(i).isDisplayed(),"Failed: Monitors name not displayed");
			   Reporter.log("--Monitors title is present--",true);
			   Assert.assertFalse(category.get(i).isEnabled()!=true,"Failed:Option Disabled");
			   Reporter.log("--Monitors option is clickable--",true);
			   Assert.assertNotEquals(category.get(i).getText(),"Monitorr","Failed:Option title wrong");
			   Reporter.log("--Option title is as per Spec--",true);
			   category.get(i).click();
			   Thread.sleep(1000);
			   Assert.assertEquals(driver.getCurrentUrl(), "https://www.demoblaze.com/#","Failed:Navigated to wrong page");
			   driver.navigate().back();
			   Reporter.log("--Page Navigated to URL as per Spec.",true);
			   
		   }	   
		  Thread.sleep(1000);
		 
	  }
  }
  
  @BeforeMethod
  public void logIn() throws Throwable{
	  driver.get("https://www.demoblaze.com/");
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
	  driver.findElement(By.id("login2")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("loginusername")).sendKeys("Day4");
	  Thread.sleep(1000);
	  driver.findElement(By.id("loginpassword")).sendKeys("123456");
	  driver.findElement(By.xpath("//button[text()='Log in']")).click();
	  Thread.sleep(2000);
  }

  @AfterMethod
  public void logOut() throws Exception {
	  Thread.sleep(1000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout2']")));
	  driver.findElement(By.xpath("//a[@id='logout2']")).click();
  }

  @BeforeClass
  public void openBrowser() throws Throwable {
	  System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  wait=new WebDriverWait(driver,30);
	  action=new Actions(driver);
	  js=(JavascriptExecutor)driver;
	  driver.manage().window().maximize();
	  Thread.sleep(100);
  }

  @AfterClass
  public void closeBrowser() {
	  driver.close();
	  driver.quit();
  }

}
