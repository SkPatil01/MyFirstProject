package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_2 {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		List<WebElement>links=driver.findElements(By.xpath("//a[@href]"));
		
       for(WebElement link:links) {
    	  String linkNames= link.getAttribute("href");
    	   System.out.println(linkNames);
       }
       System.out.println("Total Links Present are: "+links.size());
		System.out.println("Printing all text of webPage");
		WebElement text=driver.findElement(By.tagName("body"));
		System.out.println(text.getText());
		
		driver.navigate().to("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("Printing all Links present on demoblaze webpage");
		List<WebElement>demoLinks=driver.findElements(By.xpath("//a[@href]"));
		
		for(WebElement dlink:demoLinks) {
			
			String allLinks=dlink.getAttribute("href");
			System.out.println(allLinks);
				
		}
		System.out.println("Total Links Present are: "+demoLinks.size());
		System.out.println("Printing all text present on Demoblaze Webpage");
		WebElement allText=driver.findElement(By.tagName("body"));
		String demoText=allText.getText();
		
		System.out.println(demoText);
		
		System.out.println("Successfully printed all text and links");
		driver.close();
		
	}

}
