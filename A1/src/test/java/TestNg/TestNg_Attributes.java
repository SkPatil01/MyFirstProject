package TestNg;

import org.testng.annotations.Test;

public class TestNg_Attributes {

	@Test(dependsOnMethods="Registration")
	public void Homepage() {
		System.out.println("Homepage");
	}
	
	@Test (enabled=false)
	public void Login() {
		System.out.println("Login page");
	}
	@Test
	public void Registration() {
		
		System.out.println("Registration page");
	}
}
