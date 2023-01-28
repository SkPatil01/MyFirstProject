package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_12_WebTable_1 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//driver.manage().window().maximize();
		
		List<WebElement>table1=driver.findElements(By.xpath("//table[@id='customers']//tr"));
							
		System.out.println("-----------Correct for each loop---------");
		for(int i=2; i<=table1.size();i++) { //i=2 as for tr=1 td=0 this will throw exception
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr["+i+"]//td"));
		for(int j=0; j<rows.size();j++) {
			System.out.print(rows.get(j).getText()+"     ");
			}
		System.out.println();
			
		}
		System.out.println("---Printing using advanced for each loop------");
		for(WebElement tb:table1) {
			System.out.println(tb.getText());
		}
		System.out.println("-----Printing using for each loop------");
		
		
		for(int i=1; i<=table1.size();i++) {
			String row=driver.findElement(By.xpath("//table[@id='customers']//tr["+i+"]")).getText();
			System.out.println(row);
		}

Thread.sleep(4000);
		System.out.println("-----New Table Printing----------");
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		List<WebElement>table2=driver.findElements(By.xpath("//table[@id='table1']//tr"));
		
		String a="//table[@id='table1']//tr[";
		String b="]//td";
		String column;
		List<WebElement>tableColumns;
		for(int i=1; i<table2.size();i++) {
			column=a+i+b;
			tableColumns=driver.findElements(By.xpath(column));
			//System.out.println(column);
			//System.out.println("for row :"+i+" columns are: "+tableColumns.size());
			for(int j=1; j<tableColumns.size();j++) {
				System.out.print(tableColumns.get(j).getText()+"   ");
			}
			System.out.println();
		}
//if tr[1]//td==null{ print this} 
		//else if { tr[i]//td!=null print this}

		
	}

}

