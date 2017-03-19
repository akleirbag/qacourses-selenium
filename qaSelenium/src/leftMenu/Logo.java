package leftMenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;


public class Logo extends BasePage{

	private static String logoCss = ".logotype";
	private final String leftArrowCss = ".fa.fa-chevron-circle-leftt";
	private final String homeIconCss = ".fa.fa-home.fa-lg";
	private final String envelopIconCss = ".fa.fa-envelope";
	private final String databaseIconCss = ".fa.fa-database";
	private final String loginIconCss = ".fa.fa-sign-out.fa-lg";
			
	public static String getCssSelector(){
		return logoCss;
	}
	
	@FindBy(css = leftArrowCss)
	WebElement leftArrow;
	
	@FindBy(css = homeIconCss)
	WebElement homeIcon;
	
	@FindBy(css = envelopIconCss)
	WebElement envelopIcon;
	
	@FindBy(css = databaseIconCss)	
	WebElement databaseIcon;
	
	
	@FindBy(css = loginIconCss)
	WebElement loginIcon;
	
	
	public WebElement getLeftArrow(){
		return leftArrow;
	}
	
	public WebElement getHomeIcon(){
		return homeIcon;
	}
	
	public WebElement getEnvelopIcon(){
		return envelopIcon;
	}
	
	public WebElement getDatabaseIcon(){
		return databaseIcon;
	}
	
	public WebElement getLoginIcon(){
		return loginIcon;
	}
	
	
	public Logo(WebDriver driver){
		super(driver);
		PageFactory.initElements(getDriver(), this);
	}
}
