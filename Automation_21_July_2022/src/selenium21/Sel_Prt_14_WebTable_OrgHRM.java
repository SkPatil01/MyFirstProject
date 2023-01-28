package selenium21;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Prt_14_WebTable_OrgHRM {
	public static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		
		Long Starttime=System.currentTimeMillis();
		driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//driver.manage().window().maximize();
		
		WebElement userName=driver.findElement(By.xpath("//input[@id='txtUsername']"));
		WebElement userPsw=driver.findElement(By.xpath("//input[@id='txtPassword'] "));		
		userName.sendKeys("Admin");
		userPsw.sendKeys("admin123");
		
		boolean a=userName.isDisplayed();
		boolean b=userPsw.isEnabled();
		System.out.println("UserName is displayed "+a +" and password field is clickable "+b);
		
		WebElement login=driver.findElement(By.xpath("//input[@id='btnLogin']"));
		
		String lgbtn=login.getAttribute("value");
		if(lgbtn.equals("LOGIN")) {
			System.out.println("Button Spell is correct");
		}
		
		login.click();
		Thread.sleep(2000);
		
		
		
		WebElement admin=driver.findElement(By.xpath("//a[contains(@id,'AdminModule')]"));
		String Amenu=admin.getText();
		boolean adminDisp=admin.isDisplayed();
		boolean adminClik=admin.isEnabled();
		System.out.println("Menu name is : "+Amenu +" is displayed: "+adminDisp+" isClickable :"+adminClik);
		
		admin.click();
		Thread.sleep(1000);
		
		List<WebElement>OrgTable=driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
		System.out.println("----Printing using advanced for each loop-----");
		for(WebElement table:OrgTable) {
			System.out.println(table.getText());
			}
		System.out.println("---Printing using for each loop--------");
		int Ot=OrgTable.size();
		for(int i=2; i<=Ot; i++) {
			List<WebElement>rows=driver.findElements(By.xpath("//table[@id='resultTable']//tr["+i+"]//td"));
			for(int j=0;j<rows.size()-1;j++) {
				System.out.print(rows.get(j+1).getText()+"  ");
			}
			System.out.println();
		}
		List<WebElement>checkBox=driver.findElements(By.xpath("//tr//td//input[@type='checkbox']"));
		
		for(WebElement c: checkBox) {
			c.click();
		}
		
		Thread.sleep(5000);
		//driver.close();
		System.out.println("---Printing Ename which are Enabled----");
		for( int i=2; i<Ot; i++){
			WebElement status=driver.findElement(By.xpath("//table[@id='resultTable']//tr["+i+"]//td[5]"));

			if(status.getText().contains("Enabled")){
			WebElement eName=driver.findElement(By.xpath("//table[@id='resultTable']//tr["+i+"]//td[4]"));
			System.out.println(eName.getText());
			}
			}
		Thread.sleep(2000);
		
		System.out.println("---------Unclicking the Checkboxes---------");
		for(WebElement c: checkBox) {
			c.click();
		}
		Thread.sleep(2000);
		
		for(int i=0; i<checkBox.size();i++) {  //checkbox=46 . index will be 45
			if(i%2==0) {
				checkBox.get(i).click();
			}
		}

		
		Thread.sleep(3000);
		
		System.out.println("-----Searching employee from table-----");
		WebElement user=driver.findElement(By.xpath("//li//input[contains(@id,'userName')]"));
		List<WebElement> role=driver.findElements(By.xpath("//li//select[contains(@id,'userType')]"));
		WebElement ename=driver.findElement(By.xpath("//li//input[contains(@id,'empName')]"));
		List<WebElement> status=driver.findElements(By.xpath("//li//select[contains(@id,'status')]"));
		WebElement srBtn=driver.findElement(By.xpath("//p//input[contains(@id,'search')]"));
		
		user.sendKeys("Aravind");
		Thread.sleep(1000);
		for(WebElement r:role) {
		if(r.getText().contains("ESS")) {
			r.click();
			break;
		}
	}
		ename.sendKeys("Dominic Chase");
		Thread.sleep(1000);
		for(WebElement s:status) {
			if(s.getText().contains("Enabled")) {
				s.click();
				break;
			}
		}
		
		srBtn.click();
		driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
		Thread.sleep(3000);
		System.out.println("----Logout from system-----");
		List<WebElement>logout=driver.findElements(By.xpath("//div[@id=\"welcome-menu\"]//ul//li"));
		for(WebElement lg:logout) {
			if(lg.getText().contains("Logout")) {
				lg.click();
			}
		}
		
		Long endTime=System.currentTimeMillis();
		Long Totaltime=endTime-Starttime;
		Long time=Totaltime/1000;
		System.out.println("Total time taken for test is: "+Totaltime +" MilliSecond");
		System.out.println("Total time taken for test is: "+time +" Seconds");
		
	}

}
