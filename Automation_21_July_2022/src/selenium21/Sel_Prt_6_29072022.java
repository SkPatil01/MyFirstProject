package selenium21;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_6_29072022 {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		int valid=0, invalid=0;
		
		String homepage="https://www.google.co.in/";
		driver.get(homepage);
		Thread.sleep(2000);
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		for(WebElement link:links) {
			
			String url=link.getAttribute("href");
			System.out.println(url);
			
			if(url==null | url.isEmpty()) {
				System.out.println(" Link is not assigned to Anchor a");
				continue;
			}
		
			
		 if(!url.contains(homepage)) {
			 System.out.println("url belongs to another website or domain");
				continue;
			}
		 
		 try {
			 HttpURLConnection hRC=(HttpURLConnection)(new URL(url).openConnection());
			 hRC.setRequestMethod("GET");
			 hRC.connect();
			 hRC.getURL();
			 int responseCode=hRC.getResponseCode();
			
			  if(responseCode>=400) {
				  System.out.println("Link is invalid");
				  invalid++;
			  }
			  else {
				  System.out.println("Link is valid");
				  valid++;
			  }
			 
		 }
		 catch(Exception e) {
			 System.out.println("Catch the Exception");
			 
		 }
			
			
		}
		
		System.out.println("Valid links are : "+valid);
		System.out.println("Invalid links are: "+invalid);
		System.out.println("Total links are: "+links.size());
		System.out.println("Task Completed Successfully");
		
		Thread.sleep(15000);
		
		WebElement imlucky=driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='RNmpXc']"));
		String btnText=imlucky.getAttribute("value");
		String btnWord=imlucky.getText();
		System.out.println("Button attributes are: "+btnText+ " "+btnWord);
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("Software Testing");
		
		String srcText=search.getAttribute("value");
		System.out.println("Entered word is: "+srcText);
		Thread.sleep(5000);
		List<WebElement>autoSrc=driver.findElements(By.xpath("//ul//li[@class='sbct']"));
		
		int totalAutoSug=autoSrc.size();
		System.out.println("Total suggested search are: "+totalAutoSug);
		
		for(WebElement wb:autoSrc) {
			System.out.println(wb.getText());
			if(wb.getText().contains("life cycle")) {
				wb.click();
				break;
			}
		}
//		Iterator<WebElement>itW=autoSrc.iterator();
//		
//		while(itW.hasNext()) {
//			String srcWord=itW.next().getText();
//			System.out.println(srcWord);
//			if(itW.next().getText().contains("life cycle")){
//				itW.next().click();
//				break;
//			}
//		}
		
		Thread.sleep(3000);
		WebElement stlc=driver.findElement(By.xpath("//*[@id=\"rso\"]/div[5]/div/div[1]/div/a/h3"));
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)");
//		Thread.sleep(5000);
//		js.executeScript("arguments[0].scrollIntoView",stlc);
//		Thread.sleep(2000);
		stlc.click();
		Thread.sleep(10000);
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//Thread.sleep(5000);
		//driver.findElement(By.xpath("//button[text()='OK']")).click(); No such element exception
		//driver.findElement(By.xpath("//div[@class='sp-cookie-banner-3']//button[text()='OK']")).click();exception NosuchElement
		
		String titl=driver.getTitle();
		System.out.println("The webpage title is: "+titl);
		
		
		
		
		
	}

}
