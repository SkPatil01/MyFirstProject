package selenium21;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Locator23072022 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		/*
		 * driver.get("http:\\www.google.com"); Thread.sleep(2000);
		 * driver.manage().window().maximize();
		 * 
		 * WebElement search = driver.findElement(By.name("q")); search.click();
		 * search.sendKeys("Kishor Kere");
		 * 
		 * WebElement button = driver.findElement(By.name("btnK")); button.click();
		 * 
		 * driver.close();
		 */
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
//		String source=driver.getPageSource();
//		System.out.println(source);
		String title=driver.getTitle();
		int len=title.length();
		System.out.println(len);
		
		 	
		
		
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement pc=driver.findElement(By.id("txtUsername"));
		Dimension dimensions=pc.getSize();
		System.out.println("Height is: "+dimensions.height+" width is: "+dimensions.width);
		Point point=pc.getLocation();
		System.out.println("X coordinates are: "+point.x+" Y cordinates are : "+point.y);
		String attValue=pc.getAttribute("id");
		System.out.println("The HTML attribute values of webelement is : "+attValue);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		driver.findElement(By.className("button")).click();
		
		
		String ExTitle="OrangeHRM";
		String AcTitle=driver.getTitle();
		
		if(ExTitle.contains(AcTitle)) {
			System.out.println("Correct webpage launched: Pass");
		}
		else {
			System.out.println("Wrong webpage : Fail");
		}
		
	Thread.sleep(2000);
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("searchSystemUser[userName]")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.className("searchbutton")).click();
		Thread.sleep(2000);
		driver.close();
	//	driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
	}

}
