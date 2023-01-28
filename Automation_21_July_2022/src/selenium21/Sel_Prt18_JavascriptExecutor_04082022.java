package selenium21;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.StartClass;
import utility.JS_Class;
//extending the StartClass _which will start the driver and launch the chrome_browser
public class Sel_Prt18_JavascriptExecutor_04082022 extends StartClass{

	public static void main(String[] args) throws Exception {
		driver.get("http://exam.unipune.ac.in/"); //launching the pune university website
		String parentID=driver.getWindowHandle();//storing parent window id for switching 
		Thread.sleep(2000);
		JS_Class.scrollPage(0,1000);//scrolling the page down by 1000pixel using my custom method from JS_Class
		System.out.println("--Kishor_Page Scrolled Successfully---");
		Thread.sleep(2000); //storing webelement location in webelement variable
		WebElement timeTable=driver.findElement(By.xpath("(//a[contains(text(),'Timetables')])[2]"));
		JS_Class.clickElement(timeTable);//clicking on webelement using JS_Class clickElement method.
		Thread.sleep(1000);
		driver.switchTo().window(parentID);//switching to parent window again
		Thread.sleep(2000);
		JS_Class.createAlert("Hi, I am Mechanical Engineer");//creating alert using JS_Class creatAlert method
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();//Switching to alert
		alert.accept();//click on ok button of alert 
		System.out.println("------------------Printing all Texts-----------------");
		JS_Class.getAllText();
		Thread.sleep(5000);
		System.out.println("------------------Printing all Links-----------------");
		JS_Class.getAllLinks();
		Thread.sleep(5000);
		driver.close();//closing the driver
		System.out.println("Thank you Selenium for no Exceptions");
		
		
	}

}
