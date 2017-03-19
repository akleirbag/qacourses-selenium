package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitWrapper {
	
	WebDriverWait wait;
	WebDriver driver;
	
	public WaitWrapper(WebDriver d){
		driver = d;
		wait = new WebDriverWait(driver, 10);
	}

	public void untilVisibility(String element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
	}

	public void untilTextIs(String element, String text){
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(element), text));
	}
	
	public void waitUntilInvisibilityOfElementLocatedBy(WebDriver driver, By by){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
}
