package Demo_test1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExe {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://uitestpractice.com/Students/Index");
		
		//enter text in Search box
		JavascriptExecutor js =(JavascriptExecutor)driver;
		//js.executeScript("document.getElementById('Search_Data').value='Aliya';");
		
		//click on find button 
		WebElement element=driver.findElement(By.xpath("//input[@value='Find']"));
	
		
		
		
		//js.executeScript("arguments[0].click();", element);
		
		//to refresh
	//	js.executeScript("history.go(0)");
		
		//to get domain name
		//String domain= js.executeScript("return document.domain;").toString();
	//	System.out.println("Domain:"+ domain);
		
		//Tittle of webpage
		//String title= js.executeScript("return document.title;").toString();
		//System.out.println("Title:"+ title);
		
		//get url
		//String url= js.executeScript("return document.URL;").toString();
		//System.out.println("URL:"+ url);  
		
		//js.executeScript("arguments[0].style.border= '3px solid red';", element);
		
		//zoom 50%
		//js.executeScript("document.body.style.zoom='100%'");
		
		//System.out.println(js.executeScript("return window.innerHight;").toString());
		//System.out.println(js.executeScript("return window.innerWidth;").toString());
		
		//scroll vertical till the end
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	
		//scroll vertically page up
		//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		//js.executeScript("alert('This is my Alert message.');");
		
		//To navigate to a different page
		//js.executeScript("window.location='http://www.google.com'");
		
		//To flash  
	/*	String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0; i < 20;i++) 
		{
			js.executeScript("arguments[0].style.backgroundColor ='#000000'", element);
			
			try {
				Thread.sleep(80);//20 ms
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
             js.executeScript("arguments[0].style.backgroundColor ='"+ bgcolor +"'", element);
			
			try {
				Thread.sleep(80);//20 ms
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		
		
		
		

		
		
		
		
		
		


	}

	private static void drawBorder(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	private static void DrawBorder(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
