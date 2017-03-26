package common;

import org.apache.xalan.processor.WhitespaceInfoPaths;
import org.openqa.selenium.WebDriver;

import browser.Browser;
import browser.BrowserFactory;

public class BasePage {

	protected WebDriver driver;
	protected WaitWrapper wait;
	
	public Browser getBrowser(){
		return BrowserFactory.getBrowser();
	}

	public WebDriver getDriver(){
		return getBrowser().getDriver();
	}
	
	public WaitWrapper getWaitWrapper(){
		return getBrowser().getWait();
	}

	public BasePage(){
		this.driver = getDriver();
	}
}
