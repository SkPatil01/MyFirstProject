package utility;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

public class Waits {

	@SuppressWarnings("unchecked")
	public static void explicit(WebDriver driver, long time, @SuppressWarnings("rawtypes") ExpectedCondition m) {
		
		WebDriverWait wWait = new WebDriverWait(driver, time);
		wWait.until(m);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void fluent(WebDriver driver, @SuppressWarnings("rawtypes") ExpectedCondition m, int pollingTime) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(m);

	}
}
