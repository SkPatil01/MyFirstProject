package selenium21;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sel_Lec_25072022_Xpath {
	
	public static WebDriver driver=null;
	
	
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.demoblaze.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		WebElement logo= driver.findElement(By.id("nava"));
		
		String logoName=logo.getText();
		int logoheight=logo.getSize().getHeight();
		int logowidth=logo.getSize().getWidth();	
		System.out.println("Logo name: "+logoName+"  Height of logo is: "+logoheight+" Width is: "+logowidth);
		String ExTitle="Product Store";
	
		if(ExTitle.equalsIgnoreCase(logoName)) {
			System.out.println("Test Pass: Title is as Expected");
		}
		else {
			System.out.println("Test Fail: Title not as per Specification");
		}
		
		WebElement category=driver.findElement(By.linkText("Laptops"));
		Thread.sleep(2000);
		category.click();
		
		WebElement Sony_i5=driver.findElement(By.xpath("//a[@href='prod.html?idp_=8' and @class='hrefch']"));
		String model=Sony_i5.getText();
		if(model.contains("Sony")) {
			System.out.println("Correct model selected");
		}
		else {
			System.out.println("Wrong model");
		}
		
		int height=Sony_i5.getSize().height;
		int width=Sony_i5.getSize().width;
		
		System.out.println("Dimension of Model name are: Height= "+height+" and Widht=  "+width);
		
		int x_point=Sony_i5.getLocation().x;
		int y_point=Sony_i5.getLocation().y;
		
		System.out.println("Location on page is at X: "+x_point+" and Y: "+y_point);
		
		Sony_i5.click();
		
		Thread.sleep(3000);
		
		WebElement price=driver.findElement(By.xpath("//h3[@class='price-container' ]"));
		String actPrice=price.getText();
		String expPrice="$790";
		if(actPrice==expPrice) {
			System.out.println("Test Pass:Price is correct : "+actPrice);
		}
		else {
			System.out.println("Test fail:Wrong Price");
		}
		
		WebElement modelName=driver.findElement(By.xpath("//h2[@class='name']"));
		String actMname=modelName.getText();
		String expMname="Sony viao i5";
		if(actMname==expMname) {
			System.out.println("Test Pass:Model Name is as per Spec.");
		}
		else {
			System.out.println("Test fail:Model name is not as per Spec.");
		}
		
		WebElement lapiImage=driver.findElement(By.xpath("//*[@src=\"imgs/sony_vaio_5.jpg\"]"));
		int imgWidth=lapiImage.getSize().width;
		int imgHeight=lapiImage.getSize().height;
		
		if(imgWidth==400 && imgHeight==300) {
			System.out.println("Test Pass: Image Size is as per Spec. ");
			System.out.println("Image width is: "+imgWidth +" and Height is: "+imgHeight  );
			}
		else {
			System.out.println("Test fail: Image size wrong");
			System.out.println("Image width is: "+imgWidth +" and Height is: "+imgHeight  );
		}
		Thread.sleep(2000);
		WebElement cartButton=driver.findElement(By.xpath("//a[@onclick='addToCart(8)']"));
		String btnName=cartButton.getText();
		String reqName="Add To Cart";
		
		if(btnName.equalsIgnoreCase(reqName)) {
			System.out.println("Test Pass: Button name is correct : "+btnName);
		}
		else {
			System.out.println("Test Fail: need correction : "+btnName);
		}
		
		int btnHt=cartButton.getSize().height;
		int btnWdt=cartButton.getSize().width;
		
		if(btnHt==100 && btnWdt==200) {
			System.out.println("Test Pass: Button height: "+btnHt+ " width is: "+btnWdt);
		}
		else {
			System.out.println("Test fail: Button size is not as per spec.");
		}
		
		cartButton.click();
		
		System.out.println("Thank You Selenium for no error");
		
		Thread.sleep(3000);
		Alert alert=driver.switchTo().alert();
		
		String alertMsg=alert.getText();
		System.out.println("Printing popup msg: "+alertMsg);
		
		alert.accept();
		System.out.println("Pop up accepted Successfully");
		
		Thread.sleep(2000);
		WebElement signUp=driver.findElement(By.id("signin2"));
		signUp.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text' and @id='sign-username']")).sendKeys("K2Kishor8");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='password' and @id='sign-password']")).sendKeys("K@1234!8");
		Thread.sleep(1500);
		WebElement submit=driver.findElement(By.xpath("//button[@onclick='register()']"));
		submit.click();
		
		Thread.sleep(3000);
		Alert sbmt=driver.switchTo().alert();
		String sbmtalert=sbmt.getText();
		System.out.println("Alert after submit is: "+sbmtalert);
		
		sbmt.accept();
		System.out.println("Submit Alert Handled Successfully");
		
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("loginusername")).sendKeys("K2Kishor6");
		driver.findElement(By.id("loginpassword")).sendKeys("K@1234!6");
		Thread.sleep(800);
		driver.findElement(By.xpath("//button[@onclick='logIn()']")).click();
		
		Thread.sleep(2000);
		WebElement uProfile=driver.findElement(By.id("nameofuser"));
		String userName=uProfile.getText();
		String exUserN="K2Kishor";
		if(userName.contains(exUserN)) {
			System.out.println("Test Passs: Correct user logged in");
		}
		
		Thread.sleep(2000);
		driver.findElement(By.id("cartur")).click();
		
		System.out.println("success-- no error");
		
		Thread.sleep(1000);
		WebElement placeOdr=driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-success']"));
		placeOdr.click();
		
		driver.findElement(By.xpath("//input[@type='text' and @id='name']")).sendKeys("Kishor Kere");
		driver.findElement(By.xpath("//input[@type='text' and @id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@type='text' and @id='city']")).sendKeys("Aurangabad");
		driver.findElement(By.xpath("//input[@type='text' and @id='card']")).sendKeys("01245623154821");
		driver.findElement(By.xpath("//input[@type='text' and @id='month']")).sendKeys("July");
		driver.findElement(By.xpath("//input[@type='text' and @id='year']")).sendKeys("2024");
		
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
				
		System.out.println("Order Placed Successfully");
		
		
		
	}

}
