package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//h5[text()='Login']")
	private WebElement pageTitle;
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserName() {
		userName.sendKeys("Admin");
	}
	
	public void enterPassword() {
		passWord.sendKeys("admin123");
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public boolean isLoginButtonEnabled() {
		return loginButton.isEnabled();
	}
	
	public boolean isUserNameBoxClickable() {
		return userName.isEnabled();
	}
	
	public boolean isPasswordBoxClickable() {
		return passWord.isEnabled();
	}
	
	public String getTitle() {
		return pageTitle.getText();
	}

}
