package components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Action;
import common.BasePage;

public class SaveCancelDeleteButtons extends BasePage{

	private final static String saveButtonCss = "button[name=save]";
	private final static String cancelButtonCss = "button[name=cancel]";
	private final static String deleteButtonCss = "button[name=delete]";

	@FindBy(css = saveButtonCss)
	WebElement saveButton;

	@FindBy(css = cancelButtonCss)
	WebElement cancelButton;

	@FindBy(css = deleteButtonCss)
	WebElement deleteButton;

	public WebElement getSaveButton(){
		return saveButton;
	}

	public WebElement getCancelButton(){
		return cancelButton;
	}

	public WebElement getDeleteButton(){
		return deleteButton;
	}

	public SaveCancelDeleteButtons(){
		super.getDriver();
		PageFactory.initElements(getDriver(), this);
	}
}
