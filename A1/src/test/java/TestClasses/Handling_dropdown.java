package TestClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Handling_dropdown {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe" );
		
		WebDriver driver=new ChromeDriver();
		
		//https://www.opencart.com/index.php?route=account/register
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		WebElement element = driver.findElement(By.id("input-country"));
		
		Select dropdown = new Select(element);
		
		//dropdown.selectByVisibleText("Iceland");
		dropdown.selectByIndex(9);
		//dropdown.selectByValue("1");
		
		if(dropdown.isMultiple())
		{
			System.out.println("drop down is multiple");
		}
		else 
		{
			System.out.println("drop down is not multiple");
        }
		
		List<WebElement> alldropdownoptions = dropdown.getOptions();
		
		for(WebElement el : alldropdownoptions) 
		{
			System.out.println(el.getText());
		}
		
		
		driver.close();
		
	}

}
