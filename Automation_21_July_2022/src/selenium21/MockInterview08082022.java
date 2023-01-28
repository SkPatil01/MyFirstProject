package selenium21;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MockInterview08082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions action=new Actions(driver);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		System.out.println("Select the checkboxes");
		WebElement checkBx1=driver.findElement(By.xpath("//input[@value='red']"));
		if(checkBx1.isSelected()==false) {
			checkBx1.click();
		}
		
		WebElement checkBx2=driver.findElement(By.xpath("//input[@value='yellow']"));
		if(checkBx2.isDisplayed()==true) {
			checkBx2.click();
		}
		
		WebElement checkBx3=driver.findElement(By.xpath("//input[@value='blue']"));
		if(checkBx3.isEnabled()==true) {
			checkBx3.click();
		}
		
		System.out.println("3 items selected");
		Thread.sleep(3000);
		System.out.println("Unselect them again");
		checkBx1.click();
		checkBx2.click();
		checkBx3.click();
		
		System.out.println("Clicking on all checkboxex onebyone");
	    List<WebElement>allCheckBx=driver.findElements(By.xpath("//input[@name='color']"));
	    for(WebElement ck:allCheckBx) {
	  	    	ck.click();
	  	    	Thread.sleep(300);
	    }
	    
	    Thread.sleep(1000);
		
	    System.out.println("Clicking on Radio Button");
	    List<WebElement>allRadioBtn=driver.findElements(By.xpath("//input[@type='radio']"));
	    for(WebElement rb:allRadioBtn) {
	    	rb.click();
	    	Thread.sleep(200);
	    }
	    
	    System.out.println("All Radio Btn selected");
	    js.executeScript("window.confirm('do u want to check iFrames')");
	    Thread.sleep(2000);
	    System.out.println("Accepting the custom alert");
	    driver.switchTo().alert().accept();
	    
	    Thread.sleep(2000);
	    WebElement iframe=driver.findElement(By.xpath("//iframe[@id='comment-editor']"));
	    js.executeScript("arguments[0].scrollIntoView();", iframe);
	    driver.switchTo().frame(iframe);
	   // System.out.println("Title of iframe is: "+iframe.getText());---StaleElementReferenceException
	    Thread.sleep(1000);
	    
	    System.out.println("Performing action on iframe element");
	    driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
	    Thread.sleep(10000);
	    
	    System.out.println("----Printing all text present on page---");
	    WebElement texts=driver.findElement(By.tagName("body"));
	    String allTexts=texts.getText();
	    System.out.println(allTexts);
	    
	    WebElement lang=driver.findElement(By.xpath("//div[@jsname='LgbsSe']"));
	    lang.click();
	    Thread.sleep(1000);
	    
	    List<WebElement>langs=driver.findElements(By.xpath("//div[@jsname='wQNmvb']"));
	    for(WebElement ln:langs) {
	    	if(!(ln.getText().isEmpty())&&(ln.getText().contains("????")) ) {
	    	System.out.println(ln.getText());
	    }
	    }
	    
	    action.moveToElement(lang).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
	    Thread.sleep(3000);
	    System.out.println("--Navigating back to main page--");
	    driver.navigate().back();
	    Thread.sleep(3000);
	    driver.navigate().back();
	    Thread.sleep(5000);
	    
	    System.out.println("---Performing right click using Action class--");
	    WebElement dpDwn=driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]"));
	    
	    action.contextClick(dpDwn).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
	    Thread.sleep(3000);
	    
	    js.executeScript("window.open('https://www.amazon.in', '_blank');");
	    Thread.sleep(3000);
	    System.out.println("Switching to new tab");
	    
	    Set<String>ID=driver.getWindowHandles();
	    List<String>tabIDs=new ArrayList<String>(ID);
	    driver.switchTo().window(tabIDs.get(1));
	    Thread.sleep(3000);
	    System.out.println("Switched");
	    
	    System.out.println("Changing the langauge using action class and for loop");
	    WebElement country=driver.findElement(By.id("icp-nav-flyout"));
	    action.moveToElement(country).perform();
	    System.out.println("Move to country tab");
	    Thread.sleep(10000);
	    List<WebElement>allCntry=driver.findElements(By.xpath("(//div[contains(@class,'nav-temp')])[15]//a[contains(@href,'#switch-lang=')]"));
	    System.out.println("Printed all options");
	    for(WebElement ac:allCntry) {
	    	System.out.println(ac.getText());
	    }
	    Thread.sleep(4000);
	    for(int i=0; i<allCntry.size();i++) {
	    	if(allCntry.get(i).getText().contains("- MR")) {
	    		allCntry.get(i).click();
	    		break;
	    	}
	    }
	    Thread.sleep(2000);
	    System.out.println("Selected Marathi langauge");
	 	
	    Thread.sleep(3000);
	    js.executeScript("window.confirm('do u want to refresh the page')");
	    Thread.sleep(3000);
	    driver.switchTo().alert().accept();
	    js.executeScript("location.reload()");
	    Thread.sleep(2000);
	    System.out.println("Page Refreshed");
	    System.out.println("Locating item dropDown menu");
	    WebElement items=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));	
	    Select selItem=new Select(items);
	    selItem.selectByVisibleText("Alexa Skills");
	    System.out.println("Selected item");
	    Thread.sleep(2000);
	    WebElement txBx=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	    action.sendKeys(txBx, "Song").sendKeys(txBx, Keys.TAB,Keys.ENTER).perform();
	    Thread.sleep(3000);
	    System.out.println("Searched Song in searchbox");	
	    System.out.println("Page title is: "+driver.getTitle());
	    System.out.println("Moving to iframe");
	    js.executeScript("window.confirm('proceed to iframe')");
	    Thread.sleep(1000);
	    driver.switchTo().alert().accept();
	    Thread.sleep(3000);
	    
	   try {
		   WebElement el=driver.findElement(By.xpath("//span[text()='मदत हवी आहे?']"));
		   try{
			   js.executeScript("arguments[0].scrollIntoView()", el);
		   }catch(Exception e) {
			   System.out.println("Big Error");
		   }
		   
	   }catch(Exception e) {
		   System.err.println("Exception: No Such Element");
	   }
	 
	    js.executeScript("window.scrollBy(0,2000)");
	    Thread.sleep(4000);
	    
	    WebElement iframe1=driver.findElement(By.xpath("//iframe[1]"));
	    driver.switchTo().frame(iframe1);
	    driver.findElement(By.xpath("//iframe[1]")).click();
	   try {
		   action.moveToElement(iframe1).click().perform();
	   }catch (Exception e) {
		   System.out.println("No use of action class too");
	   }
	    Thread.sleep(2000);
	    System.out.println("text on iframe: "+driver.getTitle());
	   try {
		   driver.findElement(By.xpath("//iframe[1]")).click();
	   }catch(Exception e) {
		   System.err.println("Exception : StaleElementReferenceException");
	   }
	    Thread.sleep(2000);
	    
	    driver.switchTo().window(tabIDs.get(0));
	    System.out.println("Back on main page URL is: "+driver.getTitle());
	    
	    driver.close();
	    driver.quit();
	    
	    
	}

}
