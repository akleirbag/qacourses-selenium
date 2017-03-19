package browser;

import org.openqa.selenium.WebDriver;

import common.WaitWrapper;

public abstract class Browser {
	protected WebDriver driver;
	public WaitWrapper wait;
	
	public void openWebsite(String url){
		driver.navigate().to(url);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public WaitWrapper getWait(){
		return wait;
	}
	
	public void close(){
		driver.quit();
	}
	
	public abstract void open();
}
