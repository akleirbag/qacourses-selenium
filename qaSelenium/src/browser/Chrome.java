package browser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chrome {

	public WebDriver driver;
	public WebDriverWait wait;

	@Before
	public void start() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("unexpectedAlertBehaviour", "dismiss");
			driver = new ChromeDriver(caps);
			System.out.println(((HasCapabilities) driver).getCapabilities());	
		}
		
	
	@After
	public void stop() {
		driver.quit();
//		driver = null;
	}
}
