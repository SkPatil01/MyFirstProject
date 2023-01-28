package selenium21;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sel_Prt_21_ActionClass_07082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("http:\\www.google.com");
		//driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		
		WebElement search=driver.findElement(By.name("q"));
		
		action.moveToElement(search).click().perform();
		action.sendKeys("City of India").perform();
		action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.SPACE).sendKeys("Capital").sendKeys(Keys.SPACE).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		Thread.sleep(4000);

		action.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
		Thread.sleep(4000);
		
		js.executeScript("window.confirm('Hi , do u want to process...')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		WebElement srcText=driver.findElement(By.xpath("(//input[@name='q'])[1]"));
		srcText.clear();
		Thread.sleep(2000);
		
		js.executeScript("alert('We are moving to Map Section')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
		WebElement maps=driver.findElement(By.xpath("//a[text()='Maps']"));
		action.moveToElement(maps).click().perform();
		
		Thread.sleep(3000);
		WebElement srcBox=driver.findElement(By.xpath("//input[@name='q']"));
		action.moveToElement(srcBox).click().perform();
		Thread.sleep(2000);
		//action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		action.sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
		Thread.sleep(3000);
		
		js.executeScript("alert('Enter the city name u want to search')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		action.moveToElement(srcBox).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		
		
		action.sendKeys(Keys.ESCAPE,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@class='EIbCs']")).click();
		Thread.sleep(3000);
		
		js.executeScript("window.confirm('do you want to proceed for Facebook')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		
		
		js.executeScript("window.confirm('Do u want to open new tabs')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
		String a = "window.open('https://www.browserstack.com/','_blank');";
		js.executeScript(a);
		Thread.sleep(1000);
		String b="window.open('https://twitter.com','_blank');";
		js.executeScript(b);
		Thread.sleep(1000);
		String c="window.open('https://amazon.in','_blank');";
		js.executeScript(c);
		Thread.sleep(1000);
		String d="window.open('https://www.whatsapp.com/');";
		js.executeScript(d);
		
     	Thread.sleep(4000);
     	js.executeScript("alert('U have created 5 new tabs')");
     	Thread.sleep(2000);
     	driver.switchTo().alert().accept();
     	
		driver.switchTo().window(driver.getWindowHandle());
		Thread.sleep(2000);
		driver.navigate().back();
		System.out.println("You're on this page "+driver.getTitle());
		Thread.sleep(1000);
		
		Set<String>tabs=driver.getWindowHandles();
		List<String>tabID=new ArrayList<String>(tabs);
		driver.switchTo().window(tabID.get(4));
		Thread.sleep(4000);
		
		WebElement career=driver.findElement(By.xpath("//span[text()='Careers']"));
		js.executeScript("arguments[0].scrollIntoView()",career);
		Thread.sleep(4000);
		//career.click();---> ElimentClickInterceptedException
		js.executeScript("arguments[0].click()",career);
		System.out.println("You're on this page "+driver.getTitle());
		Thread.sleep(3000);
		
		WebElement developers=driver.findElement(By.xpath("//span[text()='Developers ']"));
		action.moveToElement(developers).perform();
		Thread.sleep(3000);
		for(int i=0;i<8;i++) {
			action.sendKeys(Keys.TAB).perform();
			if(i==7) {
				action.sendKeys(Keys.ENTER).perform();
			}
			
		}
		
		action.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
		Thread.sleep(3000);
		js.executeScript("alert('Congratulation, you are on testing page')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("You're on this page: "+driver.getTitle());
		Thread.sleep(1000);
		
		driver.switchTo().window(tabID.get(1));
		Thread.sleep(3000);
		System.out.println("You're on this page: "+driver.getTitle());
		
		WebElement langauge=driver.findElement(By.xpath("//button[@data-testid='language-picker']"));
		langauge.click();
		Thread.sleep(2000);
		System.out.println("Page Title is: "+driver.getTitle());
		
		List<WebElement>allLangauges=driver.findElements(By.xpath("//ul[@class='_9te7']//li"));
		System.out.println("Total Languges are: "+allLangauges.size()+"---are as below");
		for(WebElement al:allLangauges) {
			String lang=al.getText();
			System.out.println(lang);
		
		}
		Thread.sleep(3000);
		
		for(WebElement alx:allLangauges) {
			if(alx.getText().contains("मराठी")) {
				alx.click();
				break;
			}
		}
		
		Thread.sleep(4000);
		WebElement allText=driver.findElement(By.tagName("body"));
		System.out.println("The text on page are: "+"\n"+allText);
		Thread.sleep(3000);
		
		driver.switchTo().window(tabID.get(2));
		Thread.sleep(3000);
		System.out.println("Page Title is: "+driver.getTitle());
		
		WebElement items=driver.findElement(By.xpath("//select[@name='url']"));
		Select selItem=new Select(items);
		action.moveToElement(items).click().perform();
		Thread.sleep(3000);
		action.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
		Thread.sleep(2000);
		selItem.selectByVisibleText("Industrial & Scientific");
		
		List<WebElement>itemList=selItem.getOptions();
		System.out.println("All Options are as below: ");
		for(WebElement it:itemList) {
			System.out.println(it.getText());
		}
		
		Thread.sleep(3000);
		WebElement itemName=driver.findElement(By.id("twotabsearchtextbox"));
		itemName.sendKeys("ecg");
		Thread.sleep(2000);
		action.moveToElement(itemName).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform();
		
		List<WebElement>table=driver.findElements(By.xpath("//tbody//tr//td[@class='navFooterDescItem']"));
		for(WebElement tbl:table) {
			if(tbl.isDisplayed()) {
			System.out.print(tbl.getText()+" ");
		}
			System.out.println();
		}
		Thread.sleep(4000);
		
		List<WebElement>searchResult=driver.findElements(By.xpath("//div[contains(@class,'sg-col-4-')]"));
		System.out.println("total result displayed are: "+searchResult.size());
		for(WebElement src:searchResult) {
			System.out.println(src.getText());
		}
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		System.out.println("Driver closed from the System");
	
	}

}
//Opening new blank window using javascript
//String a = "window.open('about:blank','_blank');";
		//((JavascriptExecutor)driver).executeScript(a);


//Select sel=(Select)driver;//ClassCastException _WebElement need pass as argument in constructor
		//Select sel=new Select(WebElement)---->This is correct statement

//List<WebElement>autoSugg=driver.findElements(By.xpath("//ul//li"));
//for(int i=0; i<5;i++) {
//	Thread.sleep(200);
//	action.sendKeys(Keys.ARROW_DOWN).perform();
//	if(i==4) {
//		action.sendKeys(Keys.ENTER).perform();
//	}
//}

//action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();