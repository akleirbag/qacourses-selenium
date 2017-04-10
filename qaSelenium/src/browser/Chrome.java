package browser;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import common.WaitWrapper;

public class Chrome extends Browser {

	public void open() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("unexpectedAlertBehaviour", "dismiss");
			driver = new ChromeDriver(caps);
			wait = new WaitWrapper( this);
			System.out.println(((HasCapabilities) driver).getCapabilities());	
		}
		
}
