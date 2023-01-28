package selenium21;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sel_25 {
	public static WebDriver driver = null;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		// implicit wait for 15 seconds to load the all elements.
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Open the Web page
		driver.navigate().to("https:\\flipkart.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();

		if (title.equalsIgnoreCase("flipkart.com")) {
			System.out.println("Title matches");
		} else {
			System.out.println(title);
		}

		// locate the web-element
		String tagname = " ";
		tagname = driver.findElement(By.cssSelector("#container > div > div._331-kn._2tvxW > div > div > div:nth-child(1) > a > div.xtXmba")).getText();
	System.out.println(tagname);

		
		WebElement mobile = driver.findElement(By.cssSelector("#container > div > div._331-kn._2tvxW > div > div > div:nth-child(1) > a > div.xtXmba"));
		mobile.click();
	
	WebElement men=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/span[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(men).perform();
		Thread.sleep(2500);
		System.out.println("this is for today");

	}

}
