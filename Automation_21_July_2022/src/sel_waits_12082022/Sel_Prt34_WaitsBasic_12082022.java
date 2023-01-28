package sel_waits_12082022;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Sel_Prt34_WaitsBasic_12082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		TakesScreenshot sc=(TakesScreenshot)driver;
		
		//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);----> to check the pageloads within given time or not...
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Long startTime=System.currentTimeMillis();
		driver.get("https://twitter.com");
		System.out.println("Title is: "+driver.getTitle());
		
		
		WebElement signIn=driver.findElement(By.xpath("//span[text()='Sign in']"));
		signIn.click();
		
		WebElement userName=driver.findElement(By.xpath("//input[@name='text']"));
		userName.sendKeys("@Techboy_kishor");
		
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		WebElement psw=driver.findElement(By.xpath("//input[@name='password']"));
		psw.sendKeys("4EverhappY");
		
		driver.findElement(By.xpath("(//span[text()='Log in' ])[1]")).click();
		Long endTime=System.currentTimeMillis();
		Long totalTime=endTime-startTime;
	
		System.out.println("Total time using implicit wait is :"+(totalTime)/1000+" Second");
		System.out.println("Simple script for understanding the implicit wait work");
		
		System.out.println(driver.getTitle());
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.xpath("//a[@aria-label='Profile']")).click();
		System.out.println(driver.getTitle());
		
		String text=driver.findElement(By.tagName("body")).getText();
		String texts[]=text.split(" ");
		
		XSSFWorkbook tw=new XSSFWorkbook();
		XSSFSheet tSheet=tw.createSheet("my_Profile");
		
		int row=texts.length;
		for(int i=0; i<row;i++) {
			XSSFRow tRow=tSheet.createRow(i);
			for(int j=0; j<1;j++) {
				XSSFCell tCell=tRow.createCell(j);
				String value=texts[i];
				tCell.setCellValue(value);
			}
		}
		String twEx="E:\\Testing\\twExel.xlsx";
		FileOutputStream tfile=new FileOutputStream(twEx);
		tw.write(tfile);
		System.out.println("Sheet saved");
		tw.close();
		
		System.out.println("Text Present on page are as below "+"\n"+text);
		
		js.executeScript("window.scrollBy(0,-1000)");
		String scrPath="E:\\Testing\\twitter_1.png";
		File src=sc.getScreenshotAs(OutputType.FILE);
		File trgt=new File(scrPath);
		FileHandler.copy(src, trgt);
		System.out.println("Screenshot captured");
	
	}

}
