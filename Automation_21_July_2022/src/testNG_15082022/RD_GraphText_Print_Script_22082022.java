package testNG_15082022;

import org.testng.annotations.Test;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class RD_GraphText_Print_Script_22082022 {
	public static WebDriver driver;
	public static WebDriverWait wait;

	@BeforeMethod
	public void launchUrl() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.rgraph.net/svg/bar.html");
	}
	
	@Test
	public void graphReading() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		wait= new WebDriverWait(driver, 30);
		WebElement graph= driver.findElement(By.xpath("//div[@id='chart-container']"));
		js.executeScript("arguments[0].scrollIntoView()",graph);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='chart-container']")));
		List<WebElement> bars = driver.findElements(By.cssSelector("rect[fill='#5cf']"));
		for(WebElement bar: bars) {
			bar.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='RGraph_tooltipsFormattedKeyLabel_0']")));
			String a = driver.findElement(By.xpath("//table[@id='RGraph_tooltipsFormattedKey_table']//tr//td[2]")).getText();
			System.out.println(a);
		}
	}
} 