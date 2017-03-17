package browser;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IE {

	public WebDriver driver;
	public WebDriverWait wait;

	@Before
	public void start() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("unexpectedAlertBehaviour", "dismiss");
			driver = new InternetExplorerDriver(caps);
			System.out.println(((HasCapabilities) driver).getCapabilities());	
		}
		

	
	@After
	public void stop() {
		driver.quit();
//		driver = null;
	}
}
