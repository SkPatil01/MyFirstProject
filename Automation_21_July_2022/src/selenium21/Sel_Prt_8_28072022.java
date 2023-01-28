package selenium21;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_8_28072022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		String title=driver.getTitle();
		System.out.println("WebSite title is: "+title);
		
		WebElement text=driver.findElement(By.id("email"));
		String placetext=text.getAttribute("placeHolder");
		System.out.println("Text inside the mail box are: "+placetext);
		
		text.sendKeys("kishor.kere2@gmail.com");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='abcd']//a[starts-with(@href,'Register.html')]")).click();
		
		Thread.sleep(3000);
		
		String acURL=driver.getCurrentUrl();
		String exURL="https://demo.automationtesting.in/Register.html";
		
		if(acURL.equals(exURL)) {
			System.out.println("Test Pass: Navigated to correct url");
		}
		else {
			System.out.println("Test Fail: Wrong URL");
		}
		
		WebElement firstName=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastName=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement address=driver.findElement(By.xpath("//textarea[@rows='3']"));
		WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
		WebElement phoneNum=driver.findElement(By.xpath("//input[@type='tel']"));
		WebElement gender=driver.findElement(By.xpath("//input[@type='radio' and @value='Male']"));
		WebElement hobbies=driver.findElement(By.xpath("//input[@type='checkbox' and @value='Cricket']"));
		WebElement lang=driver.findElement(By.xpath("//div[@id='msdd']"));
		
		firstName.sendKeys("Kishor");
		lastName.sendKeys("Kere");
		address.sendKeys("N6 Cidco Aurangabad");
		email.sendKeys("k2kishor@gmail.com");
		phoneNum.sendKeys("7498842511");
		gender.click();
		hobbies.click();
		lang.click();
		
		Thread.sleep(3000);
		List<WebElement>langs=driver.findElements(By.xpath("//li[@class='ng-scope']"));
		
		for(WebElement lan:langs) {
			if(lan.getText().contains("English")) {
				lan.click();
				continue;
			}
			if(lan.getText().contains("German")) {
				lan.click();
				continue;
			}
			if(lan.getText().contains("Hindi")) {
				lan.click();
				break;
			}
			
		}
		
		Thread.sleep(3000);
		
		for(WebElement l:langs) {
			String lan=l.getText();
			System.out.println(lan);
		}
		
		
		driver.findElement(By.xpath("//label[text()='Skills']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Skills")).click();
		Thread.sleep(2000);
		List<WebElement>skills=driver.findElements(By.xpath("//select[@id='Skills']//option"));
		
		for(WebElement sk:skills) {
			
			if(sk.getText().contains("Java")) {
				sk.click();
				break;
			}
			
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@role='combobox'] ")).click();
		Thread.sleep(5000);
		List<WebElement>country=driver.findElements(By.xpath("//span[@role='combobox'] "));
		
		for(WebElement c:country) {
			Thread.sleep(1000);
			if(c.getText().contains("India")) {
				c.click();
			}
		}
		
		Thread.sleep(4000);
		driver.findElement(By.id("yearbox")).click();
		Thread.sleep(5000);
		List<WebElement>year=driver.findElements(By.xpath("//select[@id='yearbox']//option"));
		for(WebElement y:year) {
			if(y.getText().contains("1995")) {
				y.click();
				break;
			}
		}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//select[@placeholder='Month']")).click();
		Thread.sleep(5000);
		List<WebElement>month=driver.findElements(By.xpath("//select[@placeholder='Month']//option"));
		for(WebElement m:month) {
			if(m.getText().contains("December")) {
				m.click();
				break;
			}
		}
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//select[@id='daybox']")).click();
		Thread.sleep(5000);
		
		List<WebElement>date=driver.findElements(By.xpath("//select[@id='daybox']//option"));
		for(WebElement d:date) {
			if(d.getText().contains("22")){
				d.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys("12345678");
		Thread.sleep(800);
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys("12345678");
		Thread.sleep(600);
		//WebElement image=driver.findElement(By.id("imagesrc"));
		//image.sendKeys("\"C:\\Users\\DELL\\Pictures\\Largest_Smallest_Array.jpg\"");//invalidArgumentException
		//Thread.sleep(5000);
		
		driver.findElement(By.id("submitbtn")).click();
		System.out.println("No Exception till time");
		System.out.println("Successfully Registered");
		
		//using JavascriptExecutor for Scrolling and alerts
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("alert('Welcome Mr.Kishor')");
		
		Thread.sleep(2000);
		Alert alert_1=driver.switchTo().alert();
		
		alert_1.accept();
		
		
		
		
		
		
		

	}

}
