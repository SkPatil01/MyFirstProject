package selenium21;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sel_Prt16_SelectClass_OrgHRM_Task {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	    driver=new ChromeDriver();
	    
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");   //----->Enter username 
	    driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");  //----->Enter password
	    driver.findElement(By.xpath("//input[@name='Submit'] ")).click();  //---->Click on Login Button
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//span[text()='Assign Leave']")).click();//----->Click on Assign Leave Option from dashboard page
	    
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[contains(@class,'ac_input')]")).sendKeys("Ja");//----->enter name in employee name box
	    
	    Thread.sleep(1000);
	    
	    List<WebElement>names=driver.findElements(By.xpath("//div[@class='ac_results']/ul/li"));//----->autosuggestions stored in list
	    System.out.println("---Printing all options shown in Employee name autosuggestion--- ");
	    for(WebElement n:names) {
	    	System.out.println(n.getText());
	    }
	    Thread.sleep(3000);
	    
	    JavascriptExecutor js=(JavascriptExecutor)driver; //----->I'm using JavascriptExecutor to click on required employee name as driver.click throwing error
	   
	    
	    for(WebElement n:names) {
	    	if(n.getText().equalsIgnoreCase("Jasmine Morgan")) {
	 	    	js.executeScript("arguments[0].click()",n); //-----> Select on Jasmine Morgan
	 	    	Thread.sleep(1000);
	    		break;
	    	}
	    }
	    Thread.sleep(3000);
	    
	    WebElement leaveType=driver.findElement(By.xpath("//select[contains(@id,'Type')]"));//----->Storing leavetype dropdown element in webelement
	    
	    Select leave=new Select(leaveType);//----->creating a object of select class and giving reference to leaveType dropdown
	    
	    boolean check=leave.isMultiple();
	    System.out.println("LeaveType DropDown is multiple select type: "+check); //----->verifying whether it is multiselect or not
	    
	    leave.selectByVisibleText("CAN - Personal"); //----->selecting leave type using select class method
	    
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//input[contains(@id,'FromDate')]")).click();//----->click on from date text box
	    
	    WebElement month=driver.findElement(By.xpath("//select[contains(@class,'-month')]"));//----->storing month dropdown in webelement
	    Select selMonth=new Select(month); //-----> creating object of select class and refered to month dropdown
	    System.out.println("---Printing all months present in calender---");
	    List<WebElement>m1=selMonth.getOptions();//----->printing all month options from dropdown
	    for(WebElement m:m1) {
	    	System.out.println(m.getText());
	    }
	    Thread.sleep(3000);
	    
 
	    selMonth.selectByVisibleText("Oct"); //----->selecting desired month
	    
	    Thread.sleep(3000);
	    WebElement year=driver.findElement(By.xpath("//select[contains(@class,'-year')]"));//----->storing year dropdown in web element
	    Select selYear=new Select(year);//----->creating a object of select class and refered to year dropdown
	    System.out.println("---Printing all years present in calender---");
	    List<WebElement>y1=selYear.getOptions();//----->printing all year options from year dropdown
	    for(WebElement y:y1) {
	    	System.out.println(y.getText());
	    }
	    Thread.sleep(2000);
	    selYear.selectByValue("2023");//----->selecting the desired year
	    
	    Thread.sleep(3000);
	    List<WebElement>date=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));//----->storing dates table in list
	    
	    System.out.println("---Printing the calender date table----");
	    List<WebElement>dates=driver.findElements(By.xpath("//table[contains(@class,'date')]//tr"));//----->storing all rows in list
	    for(WebElement d:dates) {
	    	System.out.println(d.getText());//----->printing the dates
	    }
	    
	    System.out.println("--Printing date table using traditional for each loop---");
	    
	    for(int i=0;i<dates.size();i++) {
	    	System.out.println("The element at index "+i+" is: "+dates.get(i).getText()); //----->using foreach loop
	    }
	    
	    Thread.sleep(5000);
	    
	    for(WebElement d:date) { 
	    	if(d.getText().equals("20")) { 
	    		d.click();                       //----->selecting the required date from date list
	    		break;
	    	}
	    }
	    Thread.sleep(3000);
	  //----->same is followed for toDate option.
	    driver.findElement(By.xpath("//input[contains(@id,'ToDate')]")).click();
	    
	    WebElement monthT=driver.findElement(By.xpath("//select[contains(@class,'-month')]"));
	    Select selMonthT=new Select(monthT);
	    selMonthT.selectByVisibleText("Nov");
	    
	    Thread.sleep(3000);
	    WebElement yearT=driver.findElement(By.xpath("//select[contains(@class,'-year')]"));
	    Select selYearT=new Select(yearT);
	    selYearT.selectByValue("2023");
	    
	    Thread.sleep(3000);
	    List<WebElement>dateT=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
	    
	    for(WebElement d:dateT) {
	    	if(d.getText().equals("25")) {
	    		d.click();
	    		break;
	    	}
	    }
	    
	    Thread.sleep(2000);
	  //----->storing partail days dropdown in webelement
	    WebElement duration=driver.findElement(By.xpath("//select[contains(@id,'partialDays')]"));
	    Select selD=new Select(duration);//----->creating a object of select class and refered to partialday dropdown
	    
	    selD.selectByIndex(2); //----->selected req.option by index
	    
	    Thread.sleep(2000);
	  //----->commenting in commment area box
	    WebElement comment=driver.findElement(By.xpath("//textarea[contains(@id,'txt')]"));
	    
	    comment.sendKeys("Hi, I'm a Mechanical Engineer");
	    
	    Thread.sleep(2000);
	    
	    
	  //----->printing all option present in leaveType dropdown
	    System.out.println("---Printing all options present in leave Type dropdown----");
	    List<WebElement>l1=leave.getOptions();
	    for(WebElement l:l1) {
	    	System.out.println(l.getText());
	    }
	    
	    	    
	    System.out.println("Submitting the form");
	    driver.findElement(By.xpath("//input[@id='assignBtn']")).click();//----->submitting the leave form
	    
	    
	    System.out.println("Form submitted");
	    Thread.sleep(5000);
	  //----->click on ok button of confirmation alert
	    driver.findElement(By.xpath("//input[@id='confirmOkButton']")).click();
	    
	  //----->locating logout menu
	    WebElement logOut=driver.findElement(By.xpath("//a[contains(@id,'welcome')]"));
	    logOut.click();
	    Thread.sleep(2000);
	    try{
	    	driver.findElement(By.linkText("Logout")).click();	//----->click on logout.. as i thought it may throw exception    
	    }
	    catch(Exception e) {
	    	System.out.println("Error: Need to use Javascript "+e);
	    }
	    
	    String startURL="https://opensource-demo.orangehrmlive.com/";
	    String endURL=driver.getCurrentUrl();
	  //----->verifying the webpage correct or not
	    if(endURL.startsWith(startURL)) {
	    	System.out.println("Test Pass: Successfully logout");
	    }
	    
	    Thread.sleep(1000);
	    driver.close();//----->closing the browser current window
	   driver.quit();//----->closing the driver instances for current session
	}

}
