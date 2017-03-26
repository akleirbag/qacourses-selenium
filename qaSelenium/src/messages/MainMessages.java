package messages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;

public class MainMessages extends BasePage{

	private static final String  mainMessagesCss = "div.notice.success";
	
	@FindBy(css= mainMessagesCss)
	WebElement mainMessages;
	
	public static String getCssSelector(){
		return mainMessagesCss;
	}
	
	public WebElement getMainMessage(){
		return mainMessages;
	}
	
	

	public MainMessages(){
		super();
		PageFactory.initElements(getDriver(), this);
	}
}
