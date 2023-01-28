package selenium21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicMethods_1 {
	static WebDriver driver;
	public static void googleSearch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\\\Selenium\\\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http:\\www.google.com");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		String Extitle="Google";
		String title = driver.getTitle();
		System.out.println("The title of Webpage is : "+title);
		String url=driver.getCurrentUrl();
		System.out.println("The webpage url is : "+url);
		if(title.contains(Extitle)) {
			System.out.println("Test passed -- webpage is correct");
			
		}
		else {
			System.out.println("Test failed-- url is wrong");
		}
		
		Thread.sleep(2000);
		driver.close();
		
	}
	
	public static void javaOnline() throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.scaler.com/");
		Thread.sleep(2000);
		driver.navigate().to("https://www.scaler.com/topics/java/oops-concepts-in-java/");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Calling methods in main method");
	    googleSearch();
		javaOnline();
		
	}

}
