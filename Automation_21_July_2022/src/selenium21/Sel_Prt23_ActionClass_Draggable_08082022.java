package selenium21;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sel_Prt23_ActionClass_Draggable_08082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		Actions action=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Robot robot=new Robot();
		
		driver.get("https:\\www.google.com");
		driver.manage().window().maximize();
		System.out.println("Webpage launched is: "+driver.getTitle());
		System.out.println("Search jqueryui website for practice in google");
		WebElement srcBx=driver.findElement(By.name("q"));
		srcBx.sendKeys("jqueryui website for automation practice");
		action.moveToElement(srcBx).click().sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		
		js.executeScript("alert('Welcome to the Search Result')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		System.out.println("Scrolling down the window by 90 pixel");
		js.executeScript("window.scrollBy(0,90)");
		Thread.sleep(1000);
		
		System.out.println("Right click on element");
		WebElement jquery=driver.findElement(By.xpath("//h3[text()='jQuery UI Demos']"));
		action.contextClick(jquery).perform();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		System.out.println("Element open in new tab using robot class");
		Thread.sleep(4000);
		
		System.out.println("Switching on new tab");
		Set<String>tab=driver.getWindowHandles();
		List<String>tabs=new ArrayList<String>(tab);
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(3000);
		System.out.println("Successfully switched to new window");
		
		js.executeScript("alert('Successfully entered to Jquery')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		System.out.println("Switching to the frame");
		WebElement frame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		Thread.sleep(1000);
		System.out.println("Switched to the frame");
		
		
		
		System.out.println("Dragging the small box");
		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		action.clickAndHold(drag).moveByOffset(50,50).perform();
		Thread.sleep(5000);
		System.out.println("Successfully dragged");
		
		
		action.dragAndDropBy(drag,-20, -30).perform();
		System.out.println("Successfully restored to previous position");
		Thread.sleep(3000);
	
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		
		System.out.println("Click on resizable");
		driver.findElement(By.xpath("//a[text()='Resizable']")).click();
		Thread.sleep(3000);
		System.out.println("Switch to resize element frame again");
		WebElement reFrame=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(reFrame);
			
		System.out.println("Select the resizable element");
		WebElement resize=driver.findElement(By.xpath("//div[contains(@class,'-gripsmall-')]"));
		action.moveToElement(resize).clickAndHold().moveByOffset(20, 80).perform();
		js.executeScript("window.confirm('Click OK to resize it')");
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
		System.out.println("Successfully resized");
		Thread.sleep(3000);
		
		action.clickAndHold(resize).moveByOffset(0, -10).perform();
		System.out.println("Successfully restored by -100");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		System.out.println("returned on main window");
		
		js.executeScript("alert('Please refresh the page')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		js.executeScript("location.reload()");
		System.out.println("Page refreshed");
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();
		System.out.println("Clicked on dragndrop option");
		Thread.sleep(3000);
		
		System.out.println("Switching to the frame again");
		WebElement dpframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		
		driver.switchTo().frame(dpframe);
		Thread.sleep(3000);
		
		
		System.out.println("Performing drag and drop operation");
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
		action.clickAndHold(source).moveToElement(target).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		
		System.out.println("Click on Selectable option");
		driver.findElement(By.xpath("//a[text()='Selectable']")).click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,200)");
	    Thread.sleep(1000);
	    
		WebElement frame3=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame3);
		Thread.sleep(2000);
		
		List<WebElement>allItm=driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		for(WebElement al:allItm) {
			System.out.println(al.getText());
			al.click();
		}
		Thread.sleep(2000);
		
		System.out.println("Selecting multiple items");
		WebElement i1=driver.findElement(By.xpath("//li[text()='Item 1']"));
		action.moveToElement(i1).clickAndHold().moveByOffset(0, 210).perform();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[text()='Sortable']")).click();
		Thread.sleep(2000);
	    System.out.println("Switching on iframe");
	    
	    
	    js.executeScript("window.scrollBy(0,200)");
	    Thread.sleep(1000);
	    WebElement iframe4=driver.findElement(By.xpath(" //iframe[@class='demo-frame']"));
	    driver.switchTo().frame(iframe4);
	    Thread.sleep(1000);
	    System.out.println("1st Position changed");
	    WebElement it22=driver.findElement(By.xpath(" //li[text()='Item 2']"));
	    WebElement it1=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it1, it22).perform();
	    
	    Thread.sleep(1000);
	    System.out.println("6th Position changed");
	    WebElement it6=driver.findElement(By.xpath(" //li[text()='Item 6']"));
	    WebElement it11=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it6, it11).perform();
	    Thread.sleep(1000);
	    
	    System.out.println("5th Position changed");
	    WebElement it5=driver.findElement(By.xpath(" //li[text()='Item 5']"));
	    WebElement it12=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it5, it12).perform();
	    Thread.sleep(1000);
	    
	    System.out.println("4th Position changed");
	    WebElement it4=driver.findElement(By.xpath(" //li[text()='Item 4']"));
	    WebElement it14=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it4, it14).perform();
	    Thread.sleep(1000);
	    
	    System.out.println("3rd Position changed");
	    WebElement it3=driver.findElement(By.xpath(" //li[text()='Item 3']"));
	    WebElement it13=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it3, it13).perform();
	    Thread.sleep(1000);
	    
	    System.out.println("2nd Position changed");
	    WebElement it2=driver.findElement(By.xpath(" //li[text()='Item 2']"));
	    WebElement it15=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.dragAndDrop(it2, it15).perform();
	    Thread.sleep(1000);
	    
	    System.out.println("7th Position changed");
	    WebElement it7=driver.findElement(By.xpath(" //li[text()='Item 7']"));
	   // WebElement it17=driver.findElement(By.xpath(" //li[text()='Item 1']"));
	    action.clickAndHold(it7).moveToElement(it6).perform();
	    Thread.sleep(1000);
		
		System.out.println("---Action class wiht Jquery is over here----");
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
		
		
		System.out.println("Click on serach box and type India");
		js.executeScript("window.scrollBy(0,-100)");
		Thread.sleep(2000);
		WebElement srcBx1=driver.findElement(By.name("q"));
		action.moveToElement(srcBx1).click().sendKeys(Keys.TAB,Keys.ENTER).perform();
		Thread.sleep(2000);
		action.sendKeys(srcBx1,"India").perform();
		Thread.sleep(2000);
		action.moveToElement(srcBx1).click().keyDown(Keys.CONTROL).sendKeys("a","c").keyUp(Keys.CONTROL).perform();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Searched for India");
		Thread.sleep(3000);
		
		System.out.println("Click on Map option");
		driver.findElement(By.xpath("//a[@data-hveid='CAIQBQ']")).click();
	 	Thread.sleep(10000);
		
	 	driver.findElement(By.xpath("//img[@class='EIbCs']")).click();
	 	Thread.sleep(5000);
	 	js.executeScript("alert('Opened the Map Page')");
	 	Thread.sleep(2000);
	 	driver.switchTo().alert().accept();
	 	Thread.sleep(2000);
	 	System.out.println("Get the current location");
	 	driver.findElement(By.id("sVuEFc")).click();
	 	Thread.sleep(5000);
	 	System.out.println("Zoom in the page");
	 	WebElement zoomIn=driver.findElement(By.id("widget-zoom-in"));
	 	action.click(zoomIn).click(zoomIn).click(zoomIn).perform();
	 	Thread.sleep(10000);
	 	
	 	System.out.println("-----This is for today------");
	 	
	 	
	 
	 	
		
		
		
		
	
	
		
		
	}

}

