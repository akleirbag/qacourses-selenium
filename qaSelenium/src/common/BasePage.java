package common;

import org.openqa.selenium.WebDriver;
import browser.Browser;
import browser.BrowserFactory;
import components.Header;
import leftMenu.Menu;
import messages.MainMessages;

public class BasePage {

	protected WebDriver driver;
	protected WaitWrapper wait;
	protected Header header;
	protected Menu menu;
	protected MainMessages mainMessages;
	
	public Browser getBrowser(){
		return BrowserFactory.getBrowser();
	}

	public WebDriver getDriver(){
		return getBrowser().getDriver();
	}
	
	public WaitWrapper getWaitWrapper(){
		return getBrowser().getWait();
	}
	
	public Header getHeader(){
		return header;
	}
	
	public Menu getMenu(){
		return menu;
	}
	
	public MainMessages getMainMessages(){
		return mainMessages;
	}

	public BasePage(){
		driver = getDriver();
		header = new Header(driver);
		menu = new Menu(getDriver());
	}
}
