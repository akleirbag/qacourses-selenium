package registrationPanel;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Action;
import common.BasePage;

public class RegistrationForm extends BasePage{

	private static String createAccountCss = "div #create-account h1.title";
	private static final String firstNameInputCss ="input[name='firstname']";
	private static final String lastNameInputCss ="input[name='lastname']";
	private static final String address1InputCss ="input[name='address1']";
	private static final String postcodeInputCss = "input[name='postcode']";
	private static final String cityDropDownCss ="input[name='city']";
	private static final String countryInputCss ="span.selection";
	private static final String emailInputCss ="input[name='email']";
	private static final String phoneNameInputCss ="input[name='phone']";
	private static final String newsletterCheckboxCss = "input[name='newsletter']";
	private static final String desiredPasswordInputCss ="input[name='password']";
	private static final String confirmPasswordInputCss ="input[name='confirmed_password']";
	private static final String createAccountInputCss ="button[name='create_account']";
	
	private List<String> countryNames;
	
	
	public static String getCssSelector(){
		return createAccountCss;
	}
	
	@FindBy(css = firstNameInputCss)
	WebElement firstNameInput;
	
	@FindBy(css = lastNameInputCss)
	WebElement lastNameInput;
	
	@FindBy(css = address1InputCss)
	WebElement address1Input;
	
	@FindBy(css = postcodeInputCss)
	WebElement postcodeInput;
	
	@FindBy(css = cityDropDownCss)
	WebElement cityDropDown;
	
	@FindBy(css = countryInputCss)
	WebElement countryInput;
	
	@FindBy(css = emailInputCss)
	WebElement emailInput;
	
	@FindBy(css = phoneNameInputCss)
	WebElement phoneNameInput;
	
	@FindBy(css = newsletterCheckboxCss)
	WebElement newsletterCheckbox;
	
	@FindBy(css = desiredPasswordInputCss)
	WebElement desiredPasswordInput;
	
	@FindBy(css = confirmPasswordInputCss)
	WebElement confirmPasswordInput;
	
	@FindBy(css = createAccountInputCss)
	WebElement createAccountInput;
	
	public WebElement getFirstNameInput(){
		return firstNameInput;
	}

	public WebElement getLastNameInput(){
		return lastNameInput;
	}
	
	public WebElement getAddress1Input(){
		return address1Input;
	}
	
	public WebElement getPostcodeInput(){
		return postcodeInput;
	}
	
	public WebElement getCityDropInput(){
		return cityDropDown;
	}
	
	public WebElement getCountryList(){
		return countryInput;
	}
	
	public List<String> getCountries(){
		return countryNames;
	}
	
	public void loadCountries(){
		countryNames = new ArrayList<>();
		List<WebElement> countryElements = getDriver().findElements(By.cssSelector("select option"));
		for(WebElement country: countryElements){
			countryNames.add(Action.getAttributeTextContent(country).trim());
		}
	}
	
	public int getCountryIndex(String country){
		return countryNames.indexOf(country);
	}
	
	public WebElement getEmailInput(){
		return emailInput;
	}
	
	public WebElement getPhoneInput(){
		return phoneNameInput;
	}
	
	public WebElement getNewsletterCheckbox(){
		return newsletterCheckbox;
	}
	
	public WebElement getDesiredPasswordInput(){
		return desiredPasswordInput;
	}
	
	public WebElement getConfirmPasswordInput(){
		return confirmPasswordInput;
	}
	
	public WebElement getCreateAccountInput(){
		return createAccountInput;
	}
	
	
	
	
	public RegistrationForm ( ){
		super();
		PageFactory.initElements(getDriver(), this);
		loadCountries();
	}
}