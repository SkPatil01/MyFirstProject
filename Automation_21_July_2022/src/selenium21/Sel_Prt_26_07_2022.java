package selenium21;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_26_07_2022 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("loginusername")).sendKeys("K2Kishor2");
		driver.findElement(By.id("loginpassword")).sendKeys("K@1234!2");
		driver.findElement(By.xpath("//button[@type='button' and @onclick='logIn()']")).click();

		Thread.sleep(8000);
		// JavascriptExecutor js=(JavascriptExecutor)driver;
		// js.executeScript("window.scrollBy(0,1000)");

		System.out.println("Successfully Scrolled the Webpage");

		driver.findElement(By.xpath("//a[@class='hrefch' and text()='HTC One M9']")).click();
		System.out.println("Element found");
		Thread.sleep(6000);
		WebElement Htc = driver.findElement(By.xpath("//h2[@class='name']"));

		String AcModelName = Htc.getText();
		String ExModelName = "HTC One M9";
		if (AcModelName == ExModelName) {
			System.out.println("Test Pass: Model Name is correct");
		} else {
			System.out.println("Test fail: Model Name is wrong");
		}
		int ht = Htc.getSize().height;
		int wdt = Htc.getSize().width;

		if (ht == 200 && wdt == 500) {
			System.out.println("Test Pass: Text Dimensions are as per spec.");
		} else {
			System.out.println("Test Fail: Text Dimensions are not as per spec.");
		}
		
		Thread.sleep(5000);
		WebElement price = driver.findElement(By.xpath("//h3[@class='price-container']"));
		String Aprice = price.getText();
		String Eprice = "790";

		if (Aprice == Eprice) {
			System.out.println("Test Pass: Model Price is correct");
		} else {
			System.out.println("Test Fail: Model price is wrong");
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@onclick='addToCart(7)']")).click();

		Thread.sleep(2000);
		Alert cartAd = driver.switchTo().alert();

		String alertMsg = cartAd.getText();
		System.out.println("The Alert Msg is: " + alertMsg);

		cartAd.accept();
		Thread.sleep(2000);

		driver.findElement(By.id("cartur")).click();

		Thread.sleep(5000);

		driver.findElement(By.id("logout2")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("About us")).click();
		
		driver.close();
		System.out.println("Successfully logined and logout with product added in a cart");

	}

}
