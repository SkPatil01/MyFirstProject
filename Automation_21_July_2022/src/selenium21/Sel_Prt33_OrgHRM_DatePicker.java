package selenium21;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Sel_Prt33_OrgHRM_DatePicker {
	public static WebDriver driver;
	public static void main(String[] args) throws Throwable{
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();//upcasting
		JavascriptExecutor js=(JavascriptExecutor)driver;//downcasting
		Actions action=new Actions(driver);//constructor initialization
		TakesScreenshot sc=(TakesScreenshot)driver;//downcasting
		Date date=new Date();
		System.out.println("Print: "+date);
		
		Long startTime=System.currentTimeMillis(); //storing current time in a Long variable
		Properties prop=new Properties(); //object creation of Properties class to use instance method present in properties class
		String iprop=".\\TestData_KK_01\\config.properties"; //path of properties file
		FileInputStream iFile=new FileInputStream(iprop); //loaded file in input stream
		prop.load(iFile); //now reading the properties file
		String url=prop.getProperty("URL_1"); //getting value of URL_1 key from properties file
		
		driver.manage().window().maximize(); //maximize window
		driver.get(url); //passed string url variable holding properties of URL_1 key
		Thread.sleep(3000); 
		
		WebElement user=driver.findElement(By.id("txtUsername")); //located username textbox
		WebElement psw=driver.findElement(By.id("txtPassword"));//located password textbox
		
		if(user.isDisplayed())  //validating the textbox 
		user.sendKeys(prop.getProperty("Username_1"));  //entering data from properties file
		Thread.sleep(3000);
		if(psw.isEnabled())
		psw.sendKeys(prop.getProperty("Password_1"));
		Thread.sleep(3000);
		
		js.executeScript("window.confirm('Do u want to proceed')"); //created custom confirmation alert using Javascriptexecutor
		Thread.sleep(2000);
		driver.switchTo().alert().accept();//accepted the alert
		
		driver.findElement(By.id("btnLogin")).click(); //clicked on login buttong
		Thread.sleep(3000);
		
		WebElement leave=driver.findElement(By.xpath("//b[text()='Leave']"));
		action.click(leave).perform(); //click on leave option using action class method
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Assign Leave']")).click(); //clicked on assign leave option
		Thread.sleep(2000);
		
		WebElement emp=driver.findElement(By.xpath("//input[contains(@class,'ac_input')]"));
		action.moveToElement(emp).click().sendKeys("Jasmine").sendKeys(Keys.ARROW_DOWN,  Keys.ENTER).perform(); //entered employee name using action class methods
		
		WebElement leaveType=driver.findElement(By.xpath("//select[@id='assignleave_txtLeaveType']"));
		Select sel=new Select(leaveType); //handling leave type dropdown using select class method
		sel.selectByVisibleText("CAN - Personal"); //selected leave type 
		Thread.sleep(2000);
		
		js.executeScript("alert('Select from and to data')"); //simple alert using JavascriptExecutor
		Thread.sleep(2000);
		driver.switchTo().alert().accept();//accepted alert
		
		driver.findElement(By.xpath("//input[contains(@id,'FromDate')]")).click(); //clicked on date box
		WebElement month=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selM=new Select(month);//selected month using select class as it's dropdown having select tagname
		selM.selectByVisibleText("Feb"); //selected feb month
		Thread.sleep(2000);
		
		WebElement year=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selYr=new Select(year);//similarly selected year using select class
		selYr.selectByVisibleText("2024");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='18']")).click();
		Thread.sleep(2000);//clicked on requierd date
		System.out.println("--------------------From date selected successfully--------------");
		driver.findElement(By.xpath("//input[contains(@id,'txtToDate')]")).click();
		Thread.sleep(2000); //clicked on todate box
		String months; //declared string variable 
		//selecting month using datepicker logic
		do {
			driver.findElement(By.xpath("//span[text()='Next']")).click(); //clicked on next button 
			months=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[@selected='selected']")).getText();
			//months=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option")).getText(); //getting text of month
		Thread.sleep(1000);
		}
		while(!(months.matches("Dec"))); //selected month is dec
		
		
		Thread.sleep(20000);
		
		
		
		WebElement toYr=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select toYrs=new Select(toYr); //selected year using action action
		toYrs.selectByVisibleText("2024");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='20']")).click();
		System.out.println("--------------------to date selected successfully--------------");
		System.exit(0);
		WebElement pdays=driver.findElement(By.xpath("//select[contains(@id,'partialDays')]"));
		Select sday=new Select(pdays); //selecting daystype  using select class as it's a dropdown
		sday.selectByVisibleText("All Days"); 
		Thread.sleep(2000);
		
		
		WebElement duration=driver.findElement(By.xpath("//select[contains(@id,'firstDuration_dura')]"));
		action.click(duration).sendKeys(Keys.ARROW_DOWN,Keys.ENTER).perform(); //selected time from dropdown using action class
		Thread.sleep(2000);
		
		WebElement time=driver.findElement(By.xpath("//select[contains(@id,'firstDuration_time_from')]"));
		Select selT=new Select(time);
		selT.selectByVisibleText("02:45");
		Thread.sleep(2000);
		
		WebElement timeTo=driver.findElement(By.xpath("//select[contains(@id,'firstDuration_time_to')]"));
		Select selTo=new Select(timeTo); 
		selTo.selectByValue("04:30");
		Thread.sleep(2000);
		
		WebElement comment=driver.findElement(By.xpath("//textarea[contains(@id,'txtComment')]"));
		comment.sendKeys("Hi_I'm A Robot _----_----_!"); //commented in comment box
		Thread.sleep(2000);
		 
		js.executeScript("window.confirm('Change will not be accepted')"); //custom alert using js
		Thread.sleep(2000);
		driver.switchTo().alert().accept(); //accepted alert
		Thread.sleep(2000);
		
		driver.findElement(By.id("assignBtn")).click(); //clicked on submit buttong
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='confirmOkButton']")).click(); //clicked on OK button of confirmation lightbox
		Thread.sleep(2000);
		
		driver.navigate().to("https://twitter.com"); //navigating to twitter webpage
		Thread.sleep(8000);
		System.out.println("-----Taking ScreenShot of the page--------"); 
		String spath="E:\\Testing\\orgHr.png"; //screenshot file save path with file name stored in string variable
		File src=sc.getScreenshotAs(OutputType.FILE); //captured screenshot using TakesScreenshot interface method
		File tr=new File(spath); //created the blank file at destination folder
		FileHandler.copy(src, tr); //copied screenshot in given folder using FileHandler class copy method
		System.out.println("-----Screenshot captured successfully");
		Thread.sleep(2000);
		
		System.out.println("---------Storing all links of twitter in excel file---------------");
		List<WebElement>links=driver.findElements(By.tagName("link")); //links stored in list
		int linkCount=links.size(); // size of list 
		
		System.out.println("-------Storing all links in Excel file-----");
		
		XSSFWorkbook link=new XSSFWorkbook(); //created a blank workbook using XSSFWorkbook class 
		XSSFSheet linkSheet=link.createSheet("all_Links"); //created new sheet in link workbook
		System.out.println("-------Copying data in excel sheet using for loop---------");
		for(int i=0; i<linkCount; i++) {
		    XSSFRow liRow=linkSheet.createRow(i); //created row in sheet 
		     for(int j=0; j<1; j++) {
		    	 XSSFCell liCell=liRow.createCell(j); //created cell in sheet
		    	 String data=links.get(i).getAttribute("href"); //getting text of links from list and storing it in String
		    	 liCell.setCellValue(data); //setting all links in excel sheet cells.
		     }
		}
		
		System.out.println("Successfully stored all links in Excel sheet");
		
		String linkExcel="E:\\Testing\\twitterLinks.xlsx";   //excel sheet path with name stored in string varible
		FileOutputStream fO=new FileOutputStream(linkExcel); //opened blank excel sheet using FileOutputStream class
		link.write(fO); //writing all data in blank excel sheet 
		System.out.println("data copied on link workbook"); 
		link.close(); //closing the excel sheet
		
		js.executeScript("window.open('https://w3c.github.io/webdriver/','_blank')"); //opened the new tab using JavascriptExecutor
		Thread.sleep(2000);
		
		
		Set<String>tabIDs=driver.getWindowHandles(); //Storing tab ID  for window Handling
		List<String>idL=new ArrayList<String>(tabIDs); //converted set to list
		
		js.executeScript("alert('Switching on new tab')"); //simple alert using js
		Thread.sleep(2000);
		driver.switchTo().alert().accept();//accepted the alert
		Thread.sleep(2000);
		
		driver.switchTo().window(idL.get(1)); //switched on tab 1
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600)"); //scrolling the window by 600 pixels
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle()); //getting the title of switched page...
		
		driver.close(); //closing the current window
		driver.quit(); //closing the all windows opened by WebDriver.
		
		Long endTime=System.currentTimeMillis();
		Long totalTime=endTime-startTime;
		System.out.println("Total time required :"+(totalTime/1000)+" seconds");
		System.out.println(".............Thanks for No Exceptions..............");
	

	}

}
