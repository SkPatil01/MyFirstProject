package selenium21;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_13_WebTable_Self_31072022 {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("C:\\Users\\DELL\\Desktop\\Skilled_Testers.html");
		
		List<WebElement>header=driver.findElements(By.xpath("//table[@name=\"Skilled Testers\"]//tr[1]"));
		System.out.println("Total Headers Present in table is: "+header.size());
		for(WebElement headers:header) {
			System.out.print(headers.getText()+"   ");
		}
		System.out.println();
		List<WebElement>columns=driver.findElements(By.xpath("//table[@name='Skilled Testers']//tr"));
		for(int i=2; i<columns.size();i++) {
			
			List<WebElement>rows=driver.findElements(By.xpath("//table[@name='Skilled Testers']//tr["+i+"]//td"));
			for(int j=0; j<rows.size();j++) {
				System.out.print(rows.get(j).getText()+"   ");
			}
			System.out.println();
		}
		List<WebElement>rows=driver.findElements(By.xpath("//table[@name='Skilled Testers']//tr"));
		System.out.println("Total rows present in table are: "+(rows.size()-1));
		
		//Printing number of rows in each column
		
		for(int i=2; i<=rows.size();i++) {
			List<WebElement>row=driver.findElements(By.xpath("//table[@name='Skilled Testers']//tr["+i+"]//td"));
			System.out.println("Number of columns in : "+(i-1)+"data row is: "+row.size());
			
			
		}
		
		
		
		
		

	}

}
