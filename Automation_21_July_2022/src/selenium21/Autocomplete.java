package selenium21;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autocomplete{
	// Error in Autocomplete linktest
	static WebDriver driver;
	
	public static void Chrome() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://formy-project.herokuapp.com/");
		Thread.sleep(2000);
		WebElement autocomplete=driver.findElement(By.linkText("autocomplete"));
		
		autocomplete.click();
		
		WebElement address=driver.findElement(By.id("autocomplete"));
		address.click();
		Thread.sleep(1000);
		address.sendKeys("5551");
		
		
	}
	
	public static void main(String[] args) {
		System.out.println("Checking the autocomplete box functionality");
		try{
			Chrome();
		}
		catch(Exception e){
			System.out.println("its ok");
		}
	}

	
	

}
