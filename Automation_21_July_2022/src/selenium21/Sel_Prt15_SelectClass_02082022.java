package selenium21;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sel_Prt15_SelectClass_02082022 {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		driver.get("https://selenium08.blogspot.com/2019/11/dropdown.html");
		
		WebElement dropDown=driver.findElement(By.xpath("//select[@name='country']"));
		
		Select sel=new Select(dropDown);
		
		sel.selectByIndex(104);
		Thread.sleep(1000);
		
		boolean selCheck=dropDown.isSelected();
		if(selCheck==true) {
			System.out.println("Test Pass");
		}
		sel.selectByValue("IS");
		Thread.sleep(1000);
		sel.selectByVisibleText("Yemen");
		Thread.sleep(1000);
		
		
		List<WebElement>allOptions=sel.getOptions();
		
		for(int i=0; i<allOptions.size();i++) {
			String option=allOptions.get(i).getText();
			System.out.println("Option at : "+i+" is: "+option);
		}
		
		Thread.sleep(2000);
		WebElement allDropDown=driver.findElement(By.xpath("//select[@name='Month']"));
		
	    Select selAll=new Select(allDropDown);
	    
	    boolean checkMul=selAll.isMultiple();
	    System.out.println("This dropdown is multiselect : "+checkMul);
		if(checkMul==true) {
	    selAll.selectByIndex(12);
	    Thread.sleep(500);
	    selAll.selectByIndex(2);
	    Thread.sleep(500);
	    selAll.selectByIndex(3);
	    Thread.sleep(500);
	    selAll.selectByIndex(4);
	    Thread.sleep(500);
	    selAll.selectByIndex(10);
	    Thread.sleep(500);
	    selAll.selectByIndex(11);
	    Thread.sleep(500);
	    
	    try {
	    	selAll.selectByIndex(20);
	    }
	    catch(NoSuchElementException wde  ) {
	    	System.err.println("The error is: "+wde);
	    }
	    catch( Exception e) {
	    	System.out.println("IndexNotFound: "+e);
	    }
	    
		}
		
		Thread.sleep(2000);
		System.out.println("Exception handled successfully");
		
		String first=selAll.getFirstSelectedOption().getText();
		System.out.println("First selected option is: "+first);
		
		List<WebElement>allSelOption=selAll.getAllSelectedOptions();
		System.out.println("All selected options are as below");
		for(WebElement wb:allSelOption) {
			System.out.println(wb.getText());
		}
		Thread.sleep(2000);
		
		selAll.deselectAll();
		Thread.sleep(2000);
		
		List<WebElement>multiDrop=selAll.getOptions();
		System.out.println("Options Present in MultiDropDown are as below: ");
		for(WebElement wb:multiDrop) {
			System.out.println(wb.getText());
		}
		
		System.out.println("----Printing all Links Present on Page--------");
		List<WebElement>allLinks=driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> it=allLinks.iterator();
		int linkCount=0;
		while(it.hasNext()) {
			String link=it.next().getAttribute("href");
			System.out.println(link);
			linkCount++;
		}
		System.out.println("Total Links on Page are: "+linkCount);
		
		WebElement textOnPage=driver.findElement(By.tagName("body"));
		String pageTexts=textOnPage.getText();
		System.out.println("--Text on Page are as below:---"+"\n"+pageTexts);
		
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("alert('Welcome Mr.Kishor')");
		
		System.out.println("--Successfully Generated Custom Alert---");
		Thread.sleep(5000);
		
		Alert al=driver.switchTo().alert();
		
		al.accept();
		
		System.out.println("--Successfully handled the alert----");
		
		driver.close();
		
		
		
		
		
		
		
		
	}

}
