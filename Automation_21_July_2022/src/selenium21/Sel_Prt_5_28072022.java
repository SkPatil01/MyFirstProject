package selenium21;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_5_28072022 {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launching the url
		driver.get("https://www.google.com/");
		Thread.sleep(1000);
		//finding searchbox using name and entering text in it
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(2000);
		WebElement searchBox=driver.findElement(By.name("q"));
		//storing entered text in string using getAttribute method and"value" parameter
		String searchText=searchBox.getAttribute("value");
		System.out.println("The text present in search box is : "+searchText);
		System.out.println("Successful");
		Thread.sleep(3000);
		
		//selecting complete Autosuggestion box
		WebElement autoSize=driver.findElement(By.xpath("//div[@class='aajZCb']"));
		int height=autoSize.getSize().height;
		int width=autoSize.getSize().width;
		//Printing dimensions of Autosuggestion box
		System.out.println("The dimension of Autosuggestion box are: Height= "+height+ " and width= "+width);
		
		//Storing all suggested elements in list 
		List<WebElement>autoSrc=driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		int size=autoSrc.size();
		//printing the count of suggested elements
		System.out.println("Total Elements present in autosuggestion list are : "+size);
		//printing all suggested element using iterator
		Iterator<WebElement>it=autoSrc.iterator();
		while(it.hasNext()) {
			String element=it.next().getText();
			System.out.println(element);
		}
		
		//clicking on 1st link which matches to selenium word
		Thread.sleep(18000);
		for(WebElement wb:autoSrc) {
			
			if(wb.getText().equals("selenium")) {
				wb.click();
			}
			break;
		}
		
		//creating a object of JavascriptExecutor class for window scrolling purpose
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//scrolling window to bottom
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(10000);
		//scrolling window upside by 1000 pixels
		js.executeScript("window.scrollBy(0,-1000)");
		//searching element using xpath
		WebElement ghub=driver.findElement(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md' and contains(text(),'ecosystem.')]"));
		Thread.sleep(5000);
		//viewing that particular element on window 
		js.executeScript("arguments[0].scrollIntoView", ghub);
		Thread.sleep(2000);
		//click on selected object
		ghub.click();
		Thread.sleep(3000);
		//searching search box using xpath
		WebElement srcBox=driver.findElement(By.xpath("//input[@type='text' and @name='q']"));	
		//entering selenium in search box
		srcBox.sendKeys("Selenium");
		//storing entered text in string
		String typedText=srcBox.getAttribute("value");
		//printing entered text
		System.out.println("Entered Text is: "+typedText);
		Thread.sleep(3000);
		//selecting element from suggested elements
		driver.findElement(By.xpath("//ul[@id=\"jump-to-results\"]//li//a[@data-item-type='scoped_search']")).click();
		Thread.sleep(3000);
		//scrolling down the page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(5000);
		//finding trainig option using xpath
		WebElement training=driver.findElement(By.xpath("//a[text()='Training']"));
		//click on selected elmenet
		training.click();
		Thread.sleep(3000);
		//closing the browser window
		driver.close();
		System.out.println("Successful: No exceptions");
		
		
		
		
		
		
	}

}
