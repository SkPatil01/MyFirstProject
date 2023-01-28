package selenium21;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Disable_Notifications_Sel_Prt37_16082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		//option.addArguments("incongito");
		option.addArguments("start-maximized");
		option.addArguments("disable-notifications");
		//option.addArguments("headless");
	
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		WebElement srcBox=driver.findElement(By.name("q"));
		srcBox.sendKeys("IRCTC"+Keys.ENTER);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)");
		
		System.out.println("Scrolled by 400Pixels");
		
		driver.findElement(By.xpath("//h3[text()='|| IRCTC Corporate Portal ||']")).click();
		
		System.out.println("We are page: "+driver.getTitle());
		WebElement ticket=driver.findElement(By.xpath("//a[text()=' Train Ticket']"));
		js.executeScript("arguments[0].scrollIntoView()", ticket);
		Thread.sleep(2000);
		
		Actions action=new Actions(driver);
		action.contextClick(ticket).perform();
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		ticket.click();
		Thread.sleep(2000);
		System.out.println("We navigated to: "+driver.getTitle());
		String Otab=driver.getWindowHandle();
		Set<String>tabs=driver.getWindowHandles();
		List<String>tabslist=new ArrayList<String>(tabs);
		driver.switchTo().window(tabslist.get(1));
		
		WebElement banner=driver.findElement(By.id("disha-banner-close"));
		banner.click();
		Thread.sleep(1000);
		
		WebElement alert=driver.findElement(By.xpath("//button[text()='OK']"));
		alert.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//img[contains(@src,'cross.png')]")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//img[contains(@src,'Minimum.png')]")).click();
		Thread.sleep(500);
		
		
		WebElement from=driver.findElement(By.id("origin"));
		from.click();
		action.sendKeys(from,"Aurangabad").perform();
		driver.findElement(By.xpath("//span[text()='AURANGABAD - AWB']")).click();
		Thread.sleep(2000);
		
		
		WebElement to=driver.findElement(By.id("destination"));
		to.click();
//		WebElement cr=driver.findElement(By.xpath("//ul[@id='pr_id_2_list']"));
//		System.out.println(cr.getText());
//		Thread.sleep(5000);
		
		List<WebElement>citys=driver.findElements(By.xpath("//ul[@id='pr_id_2_list']//li"));
		System.out.println("Total cities are: "+citys.size());
		for(WebElement c:citys) {
			System.out.println(c.getText());
		}
		Thread.sleep(3000);
		action.sendKeys(to,"Delhi").perform();
		driver.findElement(By.xpath("//span[text()='DELHI - DLI']")).click();
		Thread.sleep(2000);
		System.out.println("----------All city names printd---------------------");
		
		WebElement date=driver.findElement(By.id("jDate"));
		date.click();
		Thread.sleep(1000);
		
		String monthYr;
		
		 do {
			 driver.findElement(By.xpath("//a[contains(@class,'-next')]")).click();
			 monthYr=driver.findElement(By.xpath("//div[contains(@class,'-title')]")).getText();
		 } while(!(monthYr.contains("December2022")));
		 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='13']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//span[text()='All Classes']")).click();
		 Thread.sleep(500);
		 System.out.println("--------Date selected-----------------");
		 
		 List<WebElement>classType=driver.findElements(By.xpath("//p-dropdownitem//li"));
		 for(WebElement c:classType) {
			 System.out.println(c.getText());
		 }
		 Thread.sleep(3000);
		 
		 ListIterator<WebElement>it=classType.listIterator();
		 while(it.hasNext()) {
			 String cType=it.next().getText();
			 if(cType.contains("First Class")) {
				 it.previous().click();
				break;
			 }
		 }
		 
		System.out.println("----------Printed all available class types-----------");
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("//span[text()='GENERAL']")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//span[text()='LADIES']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//label[@for='dateSpecific']")).click();
		 Thread.sleep(200);
		 driver.findElement(By.xpath("//button[text()='Search']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//strong[text()='Sleeper (SL)']")).click();
		 js.executeScript("alert('Select Journey Date')");
		 Thread.sleep(2000);
		 driver.switchTo().alert().accept();
		 driver.findElement(By.xpath("//strong[text()='Wed, 14 Dec']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//button[text()=' Book Now ']")).click();
		 try {
				 driver.switchTo().alert().accept();
			 }catch(Exception e) {
				 System.out.println("---------It's Title is a Alert but it is not a alert--------");
			 }
		WebElement alrtMsg=driver.findElement(By.xpath("//span[contains(@class,'confirmdialog')]"));
		System.out.println(alrtMsg.getText());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='I Agree']")).click();
		Thread.sleep(1000);
		WebElement cfrmMsg=driver.findElement(By.xpath("//span[contains(@class,'-confirmdialog-m')]"));
		System.out.println("-------The Confirmation  Message is: "+"\n"+cfrmMsg.getText());
		System.out.println("---------Alert message printed------------------");
		driver.findElement(By.xpath("//button[contains(@class,'rmdialog-acceptbutton')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[text()='REGISTER']")).click();
		Thread.sleep(1000);
		System.out.println("The current page is: "+driver.getTitle());
		driver.switchTo().window(Otab);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-1940)");
		Thread.sleep(1000);
		driver.navigate().back();
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(500);
		System.out.println("We are back on : "+driver.getTitle());
		driver.close();
		driver.quit();
		
		
		
		
		


}}
