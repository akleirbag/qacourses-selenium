package catalogPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import table.Table;

public class Catalog extends BasePage{

	private static final String  addNewCategoryButtonCss = "a:nth-child(1).button";
	private static final String  addNewProductButtonCss = "a:nth-child(2).button";
	
	public static String getCssSelector(){
		return addNewCategoryButtonCss;
	}
	
	@FindBy(css=addNewCategoryButtonCss)
	WebElement addNewCategoryButton;
	
	@FindBy(css=addNewProductButtonCss)
	WebElement addNewProductButton;
	
	public WebElement getAddNewCategoryButton(){
		return addNewCategoryButton;
	}
	
	public WebElement getAddNewProductButton(){
		return addNewProductButton;
	}
	
	public Catalog(){
		super.getDriver();
		PageFactory.initElements(getDriver(), this);
		
	}
	
}
