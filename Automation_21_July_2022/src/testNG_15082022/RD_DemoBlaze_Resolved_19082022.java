package testNG_15082022;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RD_DemoBlaze_Resolved_19082022 {

	public static WebDriver driver;
	
	@Test
	public void phones() throws IOException, Exception {
		Reporter.log("---add phones to cart and take screenshot of phone and cart---", true);
		WebDriverWait wait= new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver;//@used here
		driver.findElement(By.xpath("//a[contains(@onclick,'phone')]")).click();
		WebElement samS6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Samsung galaxy s6']")));//wait untill samsung s6 is clickable
		js.executeScript("arguments[0].scrollIntoView", samS6);//--------@Added
		driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();//------@Added
		System.out.println("---Selected SAMSUNG S-6");
//----take screenshot of a phone(s6) details---
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@width='400']")));//-----@Added wait until img is visible then take screenshot
		TakesScreenshot tksr=(TakesScreenshot)driver;
		File source=tksr.getScreenshotAs(OutputType.FILE);
		File target= new File("E:\\Testing\\SamsungGalexyS6.png");//------@Modified
		FileHandler.copy(source, target);
		System.out.println("-----SamsungGalexyS6.png stored in screenshots folder-----");
//----Screenshot complete---
		WebElement s6AddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));// wait till add to cart is clickable
		s6AddToCart.click();//click on add to cart
		wait.until(ExpectedConditions.alertIsPresent());// wait untill alert is present
		String alertMsg = driver.switchTo().alert().getText();
		Reporter.log(alertMsg, true);// print alert msg
		driver.switchTo().alert().accept();//accept the alert
//--- nevigate back to phones category page and add iphone6 to cart---
		driver.navigate().back();
		driver.navigate().back();//--@Added... because single back returns to cart position
		Thread.sleep(3000);
		WebElement iPhone = driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']"));
		js.executeScript("arguments[0].scrollIntoView()", iPhone);// scroll upto iphone
		driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']")).click();// click on iphone------------@Modified
//---take screenshot of iphone 6 details
		//WebElement imgI6 = driver.findElement(By.xpath("//img[@src='imgs/iphone_6.jpg']"));
		//wait.until(ExpectedConditions.visibilityOf(imgI6));// wait until img is visible then take screenshot
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='imgs/iphone_6.jpg']")));//@Added
		File sourcei=tksr.getScreenshotAs(OutputType.FILE);
		File targeti= new File("E:\\Testing\\Iphone6.png");
		FileHandler.copy(sourcei, targeti);
		System.out.println("-----Iphone6.png stored in screenshots folder-----");
//----Screenshot complete---	
		
		WebElement i6AddToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']")));// wait till add to cart is clickable
		i6AddToCart.click();//click on add to cart
		wait.until(ExpectedConditions.alertIsPresent());// wait untill alert is present
		String alrtMsg = driver.switchTo().alert().getText();
		Reporter.log(alrtMsg,true);
		driver.switchTo().alert().accept();//accept the alert
//---- view cart and take screenshot of a cart
		driver.findElement(By.xpath("//a[@id='cartur']")).click();// click on cart
		Thread.sleep(2000);
		File sourceC=tksr.getScreenshotAs(OutputType.FILE);
		File targetC= new File("E:\\Testing\\PhoneCart.png");
		FileHandler.copy(sourceC, targetC);
		System.out.println("-----PhoneCart.png stored in screenshots folder-----");
//----print cart amount in console and report----
		String cartValue = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();//get cart value
		Reporter.log("cart value is: "+cartValue, true);
		Reporter.log("----Two phones added to cart and screenshots are stored----", true);
			
	}
	
	@BeforeClass
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
	public void login() throws InterruptedException {
		driver.get("https://www.demoblaze.com/");
		WebDriverWait wait= new WebDriverWait(driver,30);
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='login2']")));
		login.click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("K2Kishor_");//input username
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("123456");//input password
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();//click login
		System.out.println("----login successful---");
		Thread.sleep(3000);//---@Added
	}
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//a[@id='logout2']")).click();//click on logout
		System.out.println("----logout successful---");
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
		

}


