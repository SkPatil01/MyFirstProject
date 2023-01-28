package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt15_W3TableLogic4 {
	public static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr"));
		List<WebElement> colmn = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//th"));
		for(int i=1; i<=rows.size(); i++) {
			for(int j=1; j<=colmn.size(); j++) {
				if(i==1) {
					String header=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//th["+j+"]")).getText();
					System.out.print(header+"   ");
				}else {
				String data=driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(data+"   ");
				}
			}
			System.out.println();
		}
	}

}
