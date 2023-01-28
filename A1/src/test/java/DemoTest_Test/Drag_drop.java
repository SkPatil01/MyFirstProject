package DemoTest_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_drop {

	public static void main(String[] args) {

		
       WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		//find source and target webElement
		WebElement source =driver.findElement(By.id("box6"));//rome
		WebElement target =driver.findElement(By.id("box106"));//Itlay
		
		Actions act = new Actions(driver);
		
		//drag and drop(sourceElement,targetElement)
		act.dragAndDrop(source, target).perform();
		
	}

}
