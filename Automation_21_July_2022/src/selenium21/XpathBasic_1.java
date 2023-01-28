package selenium21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class XpathBasic_1 {
	 	static WebDriver driver;
	 	
	public static void main(String[] args) throws Exception {
		Long startTime=System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("http:\\www.google.com");
		
		driver.manage().window().maximize();
		
		WebElement gSearch=driver.findElement(By.name("q"));
		gSearch.click();
		gSearch.sendKeys("Java Programming");
		
		Thread.sleep(2000);
		
		WebElement button=driver.findElement(By.name("btnK"));
		button.click();
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		WebElement signIn=driver.findElement(By.linkText("Sign in"));
		signIn.click();
		
		WebElement userName=driver.findElement(By.id("identifierId"));
		userName.sendKeys("k2kishor234");
		
		Thread.sleep(1000);
		
		WebElement nxbutn=driver.findElement(By.id("identifierNext"));
		nxbutn.click();
		
		Thread.sleep(2000);
		WebElement tryAgain=driver.findElement(By.id("next"));
		tryAgain.click();
		System.out.println("Time taken for this script is : "+(System.currentTimeMillis()-startTime+"milliSeconds"));
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle().length());
		driver.close();
		driver.quit();
//		
//		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='identifierId']"))).sendKeys("k2kishor234");
//        driver.findElement(By.id("identifierNext")).click();
//        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys("Isro&nasa@2022");
//        driver.findElement(By.id("passwordNext")).click();
//        System.out.println(driver.getTitle());
		
	
		
	}

}
