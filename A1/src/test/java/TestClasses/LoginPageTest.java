package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageClasses.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	//public WebDriver driver;

	public void verifyPageTitle() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		LoginPage lp=new LoginPage(driver);
		if(lp.getTitle().equals("Login")) {
			System.out.println("Test case Pass");
		}
		else {
			System.out.println("Test case failed");
		}
		
		lp.enterUserName();
		lp.enterPassword();
		lp.clickOnLoginButton();
		Assert.assertTrue(lp.isLoginButtonEnabled());
		
		
		
		
		
	}

}
