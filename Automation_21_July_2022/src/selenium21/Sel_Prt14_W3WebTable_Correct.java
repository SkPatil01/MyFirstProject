package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt14_W3WebTable_Correct {
	 	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//driver.manage().window().maximize();
		
		List<WebElement>table1=driver.findElements(By.xpath("//table[@id='customers']//tr"));
 	 	//headers of table are stored in webelement header2 
 	 	WebElement header2=driver.findElement(By.xpath("//table[@id='customers']//tr[1]"));
 	 	String th=header2.getText();//Header text are stored in String variable th.
 					
		System.out.println("-----------Corrected for each loop---------");
		for(int i=1; i<=table1.size();i++) 
		{ 
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td"));
// //when element not found by findElements then it returns empty list and size of empty list is zero (0)
		if (rows.size()<1) 
		{
			System.out.println(th);
		}
		else 
		{
			 	for(int j=0; j<rows.size();j++) 
			 	{
			 		
			 		System.out.print(rows.get(j).getText()+" ");
			 	}
			 	System.out.println();
		    }

		}
		System.out.println("---- Successfully Printed the Table ----");
		
		
		
		
	}
}
