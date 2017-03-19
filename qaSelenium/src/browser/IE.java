package browser;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.WaitWrapper;

public class IE extends Browser{


	public void open() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("unexpectedAlertBehaviour", "dismiss");
			driver = new InternetExplorerDriver(caps);
			wait = new WaitWrapper( driver);
			System.out.println(((HasCapabilities) driver).getCapabilities());	
		}

}
