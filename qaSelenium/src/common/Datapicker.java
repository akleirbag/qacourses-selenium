package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Datapicker {
	
	WebDriver driver;

	
	public void setDatepicker(WebDriver driver, String cssSelector, String date) {
		
		  new WebDriverWait(driver, 30000).until(

		    (WebDriver d) -> d.findElement(By.cssSelector(cssSelector)).isDisplayed());

		  JavascriptExecutor.class.cast(driver).executeScript(

		    String.format("$('%s').datepicker('setDate', '%s')", cssSelector, date));
		  
}
	
	public Datapicker(WebDriver driver){
		this.driver = driver;
	
	}
}