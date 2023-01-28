package selenium21;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Sel_Prt_7_29072022 {
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//driver.get("https://demoqa.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[@id='app']//div[@class='card mt-4 top-card'][2]")).click();//error
		//WebElement forms=driver.findElement(By.xpath("//div[@class='card-body']//h5[text()='Forms']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		/*js.executeScript("arguments[0].click()",forms);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();
		WebElement firstName=driver.findElement(By.id("firstName"));
		WebElement lastName=driver.findElement(By.id("lastName"));
		WebElement email=driver.findElement(By.id("userEmail"));
		WebElement gender=driver.findElement(By.id("gender-radio-1"));
		WebElement mNumber=driver.findElement(By.id("userNumber"));
		
		firstName.sendKeys("Kishor");
		lastName.sendKeys("Kere");
		email.sendKeys("k2kishor234@gmail.com");
		js.executeScript("arguments[0].click()", gender);
		mNumber.sendKeys("7498842272");
		
		WebElement birthDate=driver.findElement(By.xpath("//input[@value='28 Jul 2022' and @id='dateOfBirthInput']"));
		js.executeScript("arguments[0].click()", birthDate);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//select[contains(@class,'month')]")).click();
		Thread.sleep(3000);
		
		List<WebElement>month=driver.findElements(By.xpath("//select[contains(@class,'month')]//option"));
		System.out.println(month);
		for(WebElement m:month) {
			if(m.getText().contains("December")) {
				m.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[contains(@class,'year')]")).click();
		Thread.sleep(3000);
		List<WebElement>year=driver.findElements(By.xpath("//select[contains(@class,'year')]//option"));
		System.out.println(year);
		for(WebElement y:year) {
			if(y.getText().contains("1995")) {
				y.click();
				break;
			}
		}
		Thread.sleep(5000);
		List<WebElement>date=driver.findElements(By.xpath("//div[@class='react-datepicker__week']//div[@role='option']"));
		System.out.println(date);
		for(WebElement d:date) {
			if(d.getText().contains("22")) {
				d.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		
		*/
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		WebElement subj=driver.findElement(By.xpath("//div[@id='subjectsContainer']"));
		
		System.out.println("Shriram");
		js.executeScript("arguments[0].click()", subj);
		Thread.sleep(5000);
		js.executeScript("arguments[0].value='Maths'", subj);
		System.out.println("ShriRam");
		//js.executeScript("Alert('Welcome Mr.Kishor')");
		//js.executeScript("document.subj.value='Maths';");
		//program is due for entering subject entering in subject textbox
		//js.executeScript("document.getElementById('subjectsContainer').value='Maths'");

	}

}
