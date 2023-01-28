package selenium21;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_4 {
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("SambhajiNagar");
		
		Thread.sleep(2000);
		List<WebElement>googleSearch=driver.findElements(By.xpath("//ul[@class='erkvQe'][1]//li"));
		
		for(WebElement auto:googleSearch) {
			if(auto.getText().equals("Sambhajinagar")) {
				auto.click();
			}
			break;
		}
		
				

		Thread.sleep(1000);
		driver.navigate().to("https://pune.gov.in/document/pimpri-chinchwad/");
		Thread.sleep(2000);
		WebElement logoTitle=driver.findElement(By.xpath("//span[@class='site_name_english']"));
		String logo=logoTitle.getText();
		String actLogo="DISTRICT PUNE";	
		int height=logoTitle.getSize().height;
		int width=logoTitle.getSize().width;
		
		if(logo==actLogo || height==500 ||width==200) {
			System.out.println("Test Pass:Homepage title is correct as: "+logo);
		}
		else {
			System.out.println("Test Fail: Homepage title is wrong ");
		}
		WebElement allText=driver.findElement(By.tagName("body"));
		String texts=allText.getText();
		int textCount=texts.length();
		System.out.println(texts +"/nTotal text are: "+textCount);
		
		Thread.sleep(2000);
		List<WebElement>links=driver.findElements(By.tagName("a"));
		int k=links.size();
		Thread.sleep(2000);
		for(int i=0; i<k-1;i++) {
			String link=links.get(i).getAttribute("href");
			System.out.println(link);
		}
		
		driver.navigate().to("https://web.whatsapp.com/");
		System.out.println("No error till time");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
