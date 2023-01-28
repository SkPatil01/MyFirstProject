package sel_waits_12082022;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel_Prt35_ExplicitWait_Methods_12082022 {

	public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		//notification and pop-up blocking
		ChromeOptions options=new ChromeOptions(); //object of chromeoptions
		options.addArguments("--disable-notifications");//method to disable notification
		DesiredCapabilities cp=new DesiredCapabilities();//object of DesiredCapabilities class
		cp.setCapability(ChromeOptions.CAPABILITY, options);//setCapability of chrome 
		options.merge(cp); //merging capability and requirement together
		
		
		driver =new ChromeDriver(options); //pass by obj.reference in chromedriver constructor
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.manage().window().maximize();
		
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		driver.switchTo().window(driver.getWindowHandle());
				
		
		
		
		WebElement ele1=driver.findElement(By.xpath("//button[@id='alert']"));
		String ele1Atext="Click me";
		if(ele1.isDisplayed() && ele1.getText().contains(ele1Atext))
			ele1.click();
		wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert is: "+driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		WebElement ele2=driver.findElement(By.xpath("//button[@id='populate-text']"));
		String ele2B4text=driver.findElement(By.xpath("//h2[@id='h2']")).getText();
		System.out.println("Text before click are: "+ele2B4text);
		
		if(ele2.isEnabled())
			ele2.click();
		wait.until(ExpectedConditions.textToBe(By.xpath("//h2[@id='h2']"), "Selenium Webdriver"));
		String ele2A4text=driver.findElement(By.xpath("//h2[@id='h2']")).getText();
		System.out.println("Text before click are: "+ele2A4text);
		
		WebElement ele3=driver.findElement(By.xpath("//button[contains(@id,'other')]"));
		if(ele3.isSelected()) {
			System.out.println("Button already selected_don't click");
		}else {
			ele3.click();
		}
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@id='hidden']"))));
		driver.findElement(By.xpath("//button[@id='hidden']")).click();
		
		WebElement ele4=driver.findElement(By.xpath("//button[@id='enable-button']"));
		ele4.click();
		WebElement hidbn=driver.findElement(By.xpath("//button[@id='disable']"));
		System.out.println("Text before wait is: "+hidbn.getText());
		wait.until(ExpectedConditions.elementToBeClickable(hidbn));
		hidbn.click();
		System.out.println("Text after wait is: "+hidbn.getText());
		
		WebElement ele5=driver.findElement(By.xpath("//button[@id='checkbox']"));
		ele5.click();
		
		WebElement chkbx=driver.findElement(By.xpath("//input[@id='ch']"));
		wait.until(ExpectedConditions.elementSelectionStateToBe(chkbx, true));
		boolean status=chkbx.isSelected();
		System.out.println("Checkbox is selected: "+status);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		driver.navigate().to("https://demo.automationtesting.in/Accordion.html");
		List<WebElement>links=driver.findElements(By.xpath("//b[contains(text(),'Group')]"));
		int size=links.size();
		for(int i=0; i<size;i++) {
			links.get(i).click();
		}
		
		WebElement ele6=driver.findElement(By.xpath("//a[text()='Interactions ']"));
		action.moveToElement(ele6).perform();
		WebElement ele7=driver.findElement(By.xpath("//a[text()='Drag and Drop ']"));
		ele7.click();
		
		WebElement ele8=driver.findElement(By.xpath("//a[text()='Static ']"));
		ele8.click();
		
		WebElement img1=driver.findElement(By.xpath("//img[@id='angular']"));
		WebElement img2=driver.findElement(By.xpath("//img[@id='mongo']"));
		WebElement img3=driver.findElement(By.xpath("//img[@id='node']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droparea']"));
		
		action.dragAndDrop(img1, target).perform();
		wait.until(ExpectedConditions.elementToBeClickable(img2));
		action.dragAndDrop(img2, target).perform();
		wait.until(ExpectedConditions.elementToBeClickable(img3));
		action.dragAndDrop(img3, target);
		
		js.executeScript("window.confirm('Do u want to sleep now')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		System.out.println("--------Basic of Explicit Wait is over here-----------");
		System.out.println("---Moving to the previous learned topics----------");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		try{
			String tex=driver.switchTo().alert().getText();
			{
				System.out.println(tex);
			}
		}catch(Exception e) {
			System.out.println("It is not a alert");
		}
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		
		System.out.println("----will continue tomorrow-------");
		
//---------------------------------------------------------------------------------------------------------
		
		
	}

}
