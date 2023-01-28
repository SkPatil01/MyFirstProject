package testNG_15082022;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Prt7_RediffMail_Test_22082022 {
	 static WebDriver driver;
	 static WebDriverWait wait;
	 static JavascriptExecutor js;
	
		@Test(enabled=false)
		public void webpageValidation() throws InterruptedException {
			Reporter.log("verify the visibility of all the web elemwnts on demoblaze webpage after login", true);
			String actualPageTitle = driver.findElement(By.xpath("//a[@id='nava']")).getText();
			String pageTitle="PRODUCT STORE";
			Assert.assertEquals(actualPageTitle, pageTitle,"Test fail: page title is not expected page title");
		System.out.println("---title verified---");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
			//JavascriptExecutor js= (JavascriptExecutor)driver;
			//String actLoginMsg = (String)js.executeScript("return document.getElementById('nameofuser').value");
			String actualLoginMsg = driver.findElement(By.xpath("//a[@id='nameofuser'and @href='#']")).getText();
			boolean loginMsg = actualLoginMsg.contains("RenuDhokte");
			Assert.assertTrue(loginMsg, "Test fail: actual welcome msg doesnt show proper username");
		System.out.println("---success welcome msg---");
			WebElement home = driver.findElement(By.xpath("//a[@href='index.html'and @class='nav-link']"));
			Assert.assertTrue(home.isDisplayed(), "Test fail: Home tab is not displayed");
		System.out.println("---home displayed---");
			WebElement contact= driver.findElement(By.xpath("//a[text()='Contact']"));
			Assert.assertTrue(contact.isDisplayed(), "Test fail: contact tab is not displyed");
		System.out.println("---contact displayed---");
			WebElement aboutUs= driver.findElement(By.xpath("//a[text()='About us']"));
			Assert.assertTrue(aboutUs.isDisplayed(), "Test fail: about us tab is not displyed");
		System.out.println("---about us displayed---");
			WebElement cart= driver.findElement(By.xpath("//a[text()='Cart']"));
			Assert.assertTrue(cart.isDisplayed(), "Test fail: cart tab is not displyed");
		System.out.println("---cart displayed---");
	//-----verify categories-----
			WebElement category= driver.findElement(By.xpath("//a[text()='CATEGORIES']"));
			Assert.assertTrue(category.isDisplayed(), "Test fail: category tab is not displyed");
		System.out.println("---categories displayed---");
	//-----verify if phones are clickable and how many phones are displayed
			WebElement phones= driver.findElement(By.xpath("//a[text()='Phones']"));
			Assert.assertTrue(phones.isDisplayed(), "Test fail: phones tab is not displyed");
		System.out.println("---phones displayed---");
			Assert.assertTrue(phones.isEnabled(), "Test fail: phones tab is not clickable");
			driver.findElement(By.xpath("//a[text()='Phones']")).click();
			Thread.sleep(3000);
			List<WebElement> allPhones = driver.findElements(By.xpath("//div[contains(@class,'col-lg-4 col-md-6')]"));
			wait.until(ExpectedConditions.visibilityOfAllElements(allPhones));
			Assert.assertEquals(allPhones.size(), 7,"Test fail: all phones are not displayed");
		System.out.println("---all phones displayed---");
			for(WebElement phone: allPhones) {
				String phoneInfo=phone.getText();
				System.out.println(phoneInfo);
			}
	//-----verify if lapies are clickable and how many lapies are displayed
			WebElement lapies= driver.findElement(By.xpath("//a[text()='Laptops']"));
			Assert.assertTrue(lapies.isDisplayed(), "Test fail: Laptops tab is not displyed");
		System.out.println("---lapies displayed---");
			Assert.assertTrue(lapies.isEnabled(), "Test fail: Laptops tab is not clickable");
			driver.findElement(By.xpath("//a[text()='Laptops']")).click();
			Thread.sleep(3000);
			List<WebElement> allLaptops = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
			Assert.assertEquals(allLaptops.size(), 6,"Test fail: all laptops are not displayed");
		System.out.println("---all laptops displayed---");
			for(WebElement laptop:allLaptops) {
				String lapyInfo= laptop.getText();
				System.out.println(lapyInfo);
			}
	//-----verify if monitors are clickable and how many monitors are displayed
		}
		@Test
		public void validateMonitors() throws Exception{
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(1000);
			WebElement monitors= driver.findElement(By.xpath("//a[text()='Monitors']"));
			Assert.assertTrue(monitors.isDisplayed(), "Test fail: Monitors tab is not displyed");
		System.out.println("---monitors displayed---");
			Assert.assertTrue(monitors.isEnabled(), "Test fail: Monitors tab is not clickable");
			driver.findElement(By.xpath("//a[text()='Monitors']")).click();
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(3000);
			//List<WebElement> allMonitors = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']"));
			//List<WebElement> allMonitors_Name = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']//h4"));
			//List<WebElement>allMonitors_Price=driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 mb-4']//h5"));
			List<WebElement>MonitorsTitlePrice=driver.findElements(By.xpath("//*[@class='hrefch' or contains (text(),'$')]"));
			Assert.assertEquals(MonitorsTitlePrice.size(), 4,"Test fail: all monitors are not displayed");
			System.out.println("---all monitors displayed---");
			System.out.println("====================================================");
			for(WebElement a1:MonitorsTitlePrice) {
				System.out.println(a1.getText());
			}
			System.out.println("===================================================");
			int items=MonitorsTitlePrice.size();
			for(int i=0;i<items;i++) {
				if(i==0)
					System.out.print(MonitorsTitlePrice.get(i).getText()+" :");
				if (i==1)
					System.out.println(MonitorsTitlePrice.get(i).getText());
				if(i==2)
					System.out.print(MonitorsTitlePrice.get(i).getText()+" :");
				if (i==3)
					System.out.println(MonitorsTitlePrice.get(i).getText());
			}
			System.out.println("=======================================================");
			Thread.sleep(2000);
		
		}
		@BeforeSuite
		public void startBrowser() {
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			js=(JavascriptExecutor)driver;
		}
		@AfterSuite
		public void closeBrowser() {
			driver.close();
			driver.quit();
		}
		@BeforeTest
		public void launchURL() throws Throwable {
			driver.get("https://www.demoblaze.com/");
			wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login2']")));
			driver.findElement(By.xpath("//a[@id='login2']")).click();//click on login
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginusername']")));
			driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("RenuDhokte");//input username
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='loginpassword']")));
			driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("rd1994");//input password
			driver.findElement(By.xpath("//button[text()='Log in']")).click();//click login
		}
		//@AfterTest
		//public void signOut() {
			//driver.findElement(By.xpath("//a[@id='logout2']")).click();// click on logout
		//}

	}

//  @BeforeMethod
//  public void beforeMethod() {
//  }
//
//  @AfterMethod
//  public void afterMethod() {
//  }
//
//  @BeforeClass
//  public void beforeClass() throws Exception {
//	  System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
//	  driver=new ChromeDriver();
//	  wait=new WebDriverWait(driver,30);
//	  js=(JavascriptExecutor)driver;
//	  driver.get("https://www.flipkart.com/");
//	  Thread.sleep(2000);
//	  js.executeScript("document.getElementById("").click");
//	  
//  }
//
//  @AfterClass
//  public void afterClass() {
//  }
//
//}
