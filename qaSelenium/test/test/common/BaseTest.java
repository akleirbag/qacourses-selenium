package test.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import browser.Browser;
import browser.BrowserFactory;
import common.WaitWrapper;

public class BaseTest {
	protected WebDriver driver;
	private WaitWrapper wait;
	protected Browser browser;

	private String browserName;
	private String uri;
	private static int invocationsCount = 0;

	@Parameters({"url", "browser"})
	@BeforeClass(alwaysRun=true)
	public void setup(String url, String browser){
		uri = url;
		browserName = browser;
		if (invocationsCount == 0){
			prepare();
		}
		invocationsCount++;
	}

	@AfterTest
	public void afterTest(){
		invocationsCount = 0;
	}

	@AfterSuite
	public void quit(){
		tearDown();
	}

	public void prepare(){
		browser = BrowserFactory.getBrowser(browserName);
		driver = browser.getDriver();
		wait = browser.getWait();
		 //wait = new WaitWrapper(driver);
		 if (uri.isEmpty()){
			//log warning
		} else {
			browser.openWebsite(uri);
		}
	}
	
	private Browser getBrowser(){
		browser = BrowserFactory.getBrowser(browserName);
		return browser;
	}

	public WebDriver getDriver(){
		driver = getBrowser().getDriver();
		return driver;
	}

	
	public WaitWrapper getWait(){
		wait = getBrowser().getWait();
		return wait;
		
	}

	public void tearDown(){
		BrowserFactory.clearBrowser();

	}
}
