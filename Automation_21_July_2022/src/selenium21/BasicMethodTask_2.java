package selenium21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BasicMethodTask_2 {
	static WebDriver driver;
	
	static void multipleBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\geckodriver.exe");
		String browser="Firefox";
		if(browser.equalsIgnoreCase("Firefox")) { 
		driver=new FirefoxDriver();
		}
		else {
		driver=new ChromeDriver();
		}
		 driver.get("http:\\www.google.com");
		
	}
    public static void main(String[] args) throws InterruptedException{

        System.out.println("Execution after setting EdgeDriver path in System Variables on Windows!!");
        System.setProperty("webdriver.edge.driver", "E:\\Selenium\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://udemy.com");
        Thread.sleep(3000);
        driver.quit();
        System.out.println("Execution complete on Windows");
        
        multipleBrowser();
    }

}
