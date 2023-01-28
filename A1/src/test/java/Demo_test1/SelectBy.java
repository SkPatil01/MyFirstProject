package Demo_test1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectBy {

	public static void main(String[] args) throws Exception {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();

driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
WebElement countryDropDown=driver.findElement(By.name("country"));

Select dropDnSelect=new Select(countryDropDown);
dropDnSelect.deselectByVisibleText("France");

Thread.sleep(3000);
dropDnSelect.deselectByIndex(10);

Thread.sleep(3000);
dropDnSelect.selectByValue("CO");

Thread.sleep(3000);
List<WebElement> countryList=dropDnSelect.getOptions();

for(WebElement w:countryList)  {
	String countryName=w.getText();
	System.out.println();
	
}
Thread.sleep(5000);
driver.close();
driver.quit();

		
		
	}

}
