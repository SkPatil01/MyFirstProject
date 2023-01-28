package DemoTest_Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     //System.setProperty("webdriver.chrome.driver","C:\\Users\\om\\Desktop\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		//int resCode=0;
		
		driver.manage().window().maximize();
		
		//wait 5seconds
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		driver.get("http://www.deadlinkcity.com/");
		
		//find hyperlinks
		List<WebElement>linkList = driver.findElements(By.tagName("a"));
		
		int resCode = 200;//2xx response code is valid link
		int brokenLinkCut = 0;
		
		System.out.println("Total links on page:" + linkList.size());
		
		for(WebElement element:linkList)
		{
			String url= element.getAttribute("href");
			
				URL urlLink = new URL(url);
				
				HttpURLConnection huc= (HttpURLConnection)urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode = huc.getResponseCode();
				if (resCode >=400)
				{
					System.out.println(url + "broken link.");
					brokenLinkCut ++;
				}
			
			
		}
		System.out.println("Total broken link");
	}

}
