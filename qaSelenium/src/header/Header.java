package header;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;


public class Header {

	private static final String headerCss = "#content > h1";
	WebDriver driver;
			
	public static String getCssSelector(){
		return headerCss;
	}
	
	@FindBy(css = headerCss)
	WebElement header;
	
	
	public WebElement getHeaderElement(){
		return driver.findElement(By.cssSelector(headerCss));
	}
	
	
	public Header(WebDriver driver){
		super();
		this.driver = driver;
	}
}
