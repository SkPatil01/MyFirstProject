package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsMethod_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/text-box");
		System.out.println("keeping all webElements in List");
		
		List<WebElement>allWebElements=driver.findElements(By.tagName("input"));
		
		if (allWebElements.size()!=0) {
			
			System.out.println("The size of WebElements is: "+allWebElements.size() +"The attribute of input tag name");
			
			for(WebElement k:allWebElements) {
				
				System.out.println("The attribute of elements having tagname as input are: "+k.getAttribute("placeholder"));
			}
		}
						
		
		WebElement element=driver.findElement(By.id("submit"));
		if(element!=null) {
			System.out.println("Element is found by ID");
		}
		
		driver.navigate().to( "https://demoqa.com/automation-practice-form");
		WebElement element1=driver.findElement(By.name("gender"));
		
		if(element1!=null) {
			System.out.println("Element found by name locator");
		}
		
		WebElement parentElement=driver.findElement(By.className("form-control-file"));
		if(parentElement!=null) {
			System.out.println("Element found by Class Locator");
		}
		
		WebElement tagName=driver.findElement(By.tagName("input"));
		if(tagName!=null) {
			System.out.println("Element found by TagName");
		}
		
		WebElement cssSelector=driver.findElement(By.cssSelector("input[id='firstName']"));
		if(cssSelector!=null) {
			System.out.println("Element found by cssSelector locator");
		}
		
		driver.navigate().to("https://demoqa.com/text-box");
		//Using contains() to locate full name and enter data
		WebElement xpath=driver.findElement(By.xpath("//input[contains(@id, '++')]"));
		if(xpath!=null) {
			System.out.println("Element found by xpath");
		}
		
		driver.navigate().to("https://demoqa.com/links");
		
		WebElement linktext=driver.findElement(By.linkText("Home"));
		
		if(linktext!=null) {
			System.out.println("Element found by LinkText Locator");
		}
		
		
		
		WebElement partialLinktext=driver.findElement(By.partialLinkText("No Content"));
		if(partialLinktext!=null) {
			System.out.println("Element found by PartialLinkText Locator");
		}
		
		driver.quit();
	}

}
