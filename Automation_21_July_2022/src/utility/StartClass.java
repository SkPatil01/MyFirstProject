package utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//created a StartClass which will set the systemProperty and initialize the webDriver
public class StartClass {
	public static WebDriver driver; //declared it is public static 
	//here i am using Static block in start class as static block executes first when class loaded in JVM
  	static 	{ 
  		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
  		driver =new ChromeDriver();//initializing the chrome_driver and launching the chrome_browser
	 	driver.manage().window().maximize();//maximizing the browser window
  	}
  	

}
