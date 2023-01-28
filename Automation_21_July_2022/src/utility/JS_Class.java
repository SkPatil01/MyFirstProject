package utility;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
//created a JavascriptExecutor interface static methods public_class which i can use as and when needed
public class JS_Class {
	//this method is used to scrolled the page .. here just need to pass argument that how u want to scroll
	public static void scrollPage(int x,int y) {  
		
		JavascriptExecutor js = (JavascriptExecutor)StartClass.driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		
	}
	//this method will click on particular web_element ...here just need to pass argument as req.webelement
	public static void clickElement(WebElement element ) {
		JavascriptExecutor js=(JavascriptExecutor)StartClass.driver;
		js.executeScript("arguments[0].click()",element);
		
	}
	//this method will scroll upto the particular element which u have located and stored in web_element
	public static void scrollElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)StartClass.driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	//this method will create custom alert .. just u need to pass the msg u want to show as argument
	public static void createAlert(String msg) {
		JavascriptExecutor js=(JavascriptExecutor)StartClass.driver;
		js.executeScript("alert('"+msg+"')");
	}
	public static void getAllText() {
		WebElement text=StartClass.driver.findElement(By.tagName("body"));
		String allText=text.getText();
		System.out.println(allText);
	}
	
	public static void getAllLinks() {
		List<WebElement>links=StartClass.driver.findElements(By.tagName("a"));
		for(WebElement l:links) {
			String link=l.getAttribute("href");
			System.out.println(link);
		}
	}
	
	
}
























//public static void refreshPage() {
//JavascriptExecutor js=(JavascriptExecutor)StartClass.driver;
//js.executeScript("window.reload();");
//
//}
