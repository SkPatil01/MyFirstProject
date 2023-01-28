package Demo_test1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Action2 {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:selenium08.blogspot.com/2019/11/dropdown.html");

		WebElement monthdropDn = driver.findElement(By.name("Month"));
		
		Select monthSelect=new Select(monthdropDn);
		
		//first verify whether is the given dropdown is of multiselect or not
		
	 boolean  checkMultiple=monthSelect.isMultiple();
	 
	 if(checkMultiple) {
		 monthSelect.selectByIndex(1);
		 
		 Thread.sleep(3000);
		 
		 Actions action=new Actions(driver);
		 
		 action.keyDown(Keys.CONTROL).perform();
		 
		 for(int i=2;i<=10;i++) {
			 monthSelect.selectByIndex(i);
			 Thread.sleep(5000);
		 }
		 action.keyUp(Keys.CONTROL).perform();
		 Thread.sleep(3000);
		 for(int i=2; i<=10;i++) {
			 monthSelect.deselectByIndex(i);
			 Thread.sleep(500);
		 }
	 }
		

	}

}
