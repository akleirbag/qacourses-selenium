package leftMenu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.Action;
import common.BasePage;
import registrationPanel.RegistrationForm;


public class StartPageMenu extends BasePage{

	private static String leftMenuPanel = "aside#navigation";
	private static final String newCustomerLinkCss = "form table tbody tr td a";
	private static final String logoutLinkCss = "div#box-account div.content ul.list-vertical li:nth-child(4) a";

	public static String getCssSelector(){
		return leftMenuPanel;
	}

	@FindBy(css = newCustomerLinkCss)
	static WebElement newCustomerLink;
	
	@FindBy(css = logoutLinkCss)
	static WebElement logoutLink;


	public WebElement getNewCustomerLink(){
		return newCustomerLink;
	}
	
	public WebElement getLogoutLink(){
		return logoutLink;
	}

	public void openRegistrationForm(){
		Action.click(newCustomerLink);
		getWaitWrapper().untilVisibility(RegistrationForm.getCssSelector());
	}

	public StartPageMenu(){
		super();
		PageFactory.initElements(getDriver(), this);
	}
}
