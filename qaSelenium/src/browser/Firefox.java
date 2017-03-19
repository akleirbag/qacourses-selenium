package browser;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WaitWrapper;

public class Firefox extends Browser{

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public void open() {
		if (tlDriver.get() != null) {
			driver = tlDriver.get();
			return;
		}
		//System.setProperty("webdriver.gecko.driver", "C:\\dev\\drivers\\geckodriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(FirefoxDriver.MARIONETTE, true);
		driver = new FirefoxDriver(caps);
		wait = new WaitWrapper( driver);
		tlDriver.set(driver);
		System.out.println(((HasCapabilities) driver).getCapabilities());

		  Runtime.getRuntime().addShutdownHook(
		        new Thread(() -> { driver.quit(); driver = null; }));
	}
	
}
