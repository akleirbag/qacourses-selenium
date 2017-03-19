package common;

import org.openqa.selenium.WebDriver;

public class BasePage {

	protected WebDriver driver;

	public WebDriver getDriver(){
		return driver;
	}

	public BasePage(WebDriver driver){
		this.driver = driver;
	}
}
