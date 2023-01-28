package selenium21;

import java.io.IOException; //to handle error due to late response from server
import java.net.HttpURLConnection; //This class is used to get status code and to use http method
import java.net.MalformedURLException; //to handle exception due to invalid urls
import java.net.URL; //to validate the url
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_3_BrokenLinks {
	 	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//Storing url in string variable
		String homepage="https://www.amazon.in/";
		String url="";
		//creating a object of HttpURLConnection class
		HttpURLConnection Huc=null;
		int respCode=200; //creating int varibale to store the responseCodes
		
		//launching the url in browser
		driver.get(homepage);
		driver.manage().window().maximize();
		//waiting for 8sec as amazon takes time to load all the elements
		Thread.sleep(8000);
		
		//findind all text present on webpage using tagname body..as body is parent tagname
	    WebElement text=driver.findElement(By.tagName("body"));
	    System.out.println("Printing all text present on webpage: "+text.getText());
	    
	    Thread.sleep(2000);
	    //finding links using 'a' tagname and storing them in list of webelements
		List<WebElement>link=driver.findElements(By.tagName("a"));
		
		//creating a Iterator object to iterate through list
		Iterator<WebElement>it=link.iterator();
		
		//creating 2 int variable to count the valid and invalid links 
		int valid=0,invalid=0;
		
		//starting the while loop
		while(it.hasNext()) {
			url=it.next().getAttribute("href");//storing links in url string using "href" attribute
			System.out.println(url);//printing the links on console
			
			//checking whether value is assinged to 'href' attribute or not using if condition
			if(url==null || url.isEmpty()) {
				System.out.println("URL is not assigned for anchor a and it is empty");
				continue;
			}
			//checking whether the links is redirecting to another website or not
			if(!url.startsWith(homepage)) { 
				System.out.println("URL belongs to another domain id");
				continue;
			}
			//inside try catch block checking the status code and valid invalid links
			try {
				Huc=(HttpURLConnection)(new URL(url).openConnection()); //assigned url value to Huc object
				Huc.setRequestMethod("GET"); //applying GET method on url link
				Huc.connect(); //establishing connection to the web 
				
				respCode=Huc.getResponseCode(); //retriving the status code in respCode variable
				System.out.println(respCode);//printing the status code for GET method
				
				//checking whether status code is OK or it is error of above 400 series
				if(respCode>=400) { 
					System.out.println(url+" : is broken link"); //if it is above 400 means broken link
					invalid++; //counting the broken link as initial value is zero
				}
				else {
					System.out.println(url+" : is valid link"); //if it is below 400 means ok links
					valid++; //counting the valid links as initial value is zero
				}
				
				}
			//catching the exception may occur during GET method retriving
			catch(MalformedURLException e) {
				e.printStackTrace();
				}
			//catching the exception may occur due to Input Output error
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Total Links on Amazon are: "+link.size());//printing all links count
		System.out.println("Total Valid links are: "+valid);//printing valid links count
		System.out.println("Total invalid links are: "+invalid);//printing invalid links count
		System.out.println("All Broken Links successfully identified");
		
		driver.quit();

	}

}
