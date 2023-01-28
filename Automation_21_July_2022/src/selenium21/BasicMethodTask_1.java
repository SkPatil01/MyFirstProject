package selenium21;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicMethodTask_1 {
static WebDriver driver;
 
void checkUdemy() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
	driver=new ChromeDriver();
	
	driver.get("https://www.udemy.com/");
	Thread.sleep(1500);
	driver.manage().window().maximize();
	String Exptitle="Udemy";
	String ActualTitle=driver.getTitle();
	String url=driver.getCurrentUrl();
	
	if (ActualTitle.contains(Exptitle)) {
		System.out.println("Test is passed and URL is Correct ");
	}
	else{
		System.out.println("Something wrong with URL");
	}
	
	driver.navigate().to("https://www.udemy.com/courses/it-and-software/");
	Thread.sleep(3000);
	 String inTitle=driver.getTitle();
	 String exTitle="IT & Software";
	 boolean check=exTitle.equals(inTitle);
	 boolean check1=exTitle.contains(inTitle);
	 System.out.println("The webpage contain the title : "+ check+" "+url+" "+check1);
	}
	public static void main(String[] args) {
		System.out.println("Checking the title of Udemy");
		BasicMethodTask_1 u=new BasicMethodTask_1();
		try{u.checkUdemy();
		}
		catch(Exception e) {
			System.out.println("Runtime Exception");
		}

	}

}
