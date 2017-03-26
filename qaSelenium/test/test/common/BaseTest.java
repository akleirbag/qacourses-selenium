package test.common;

import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import browser.Browser;
import browser.BrowserFactory;
import common.WaitWrapper;

public class BaseTest {
	protected WebDriver driver;
	private WaitWrapper wait;
	protected Browser browser;
	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());

	private String browserName;
	private String uri;
	private static int invocationsCount = 0;
	
	@BeforeSuite
	public void configureLog(){
		String log4jConfigFile = ".\\log4j.xml";
		DOMConfigurator.configure(log4jConfigFile);
		log.info("start suite");
	}

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
