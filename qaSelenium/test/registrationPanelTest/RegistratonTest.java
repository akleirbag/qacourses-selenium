package registrationPanelTest;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.Action;
import messages.MainMessages;

import org.testng.annotations.Parameters;

public class RegistratonTest extends RegistrationBaseTest{


	@Test (priority = 1)
	@Parameters ({"customerFirstName"})
	public void setFirstName(String name){
		WebElement nameInput = registration.getFirstNameInput();
		common.Action.sendKeys(nameInput, name);
		String nameText= nameInput.getAttribute("value");
		Assert.assertEquals(nameText, name);
	}

	@Test (priority = 2)
	@Parameters ({"customerLastName"})
	public void setLastName(String name){
		WebElement nameInput = registration.getLastNameInput();
		common.Action.sendKeys(nameInput, name);
		String nameText= nameInput.getAttribute("value");
		Assert.assertEquals(nameText, name);
	}

	@Test (priority = 3)
	@Parameters ({"customerAddress1"})
	public void setAddress1(String text){
		WebElement fieldInput = registration.getAddress1Input();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}

	@Test (priority = 4)
	@Parameters ({"customerPostcode"})
	public void setPostcode(String text){
		WebElement fieldInput = registration.getPostcodeInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}
	
	@Test (priority = 4)
	@Parameters ({"customerCity"})
	public void setCity(String text){
		WebElement fieldInput = registration.getCityDropInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}

	@Test (priority = 5)
	@Parameters ({"customerCountry"})
	public void setCountry(String countryName){
		WebElement fieldList = getDriver().findElement(By.cssSelector("select[name='country_code']"));
		String script = "arguments[0].selectedIndex=" + registration.getCountryIndex(countryName);
		((JavascriptExecutor)getDriver()).executeScript(script, fieldList);
		script = "arguments[0].dispatchEvent(new Event('change'))";
		((JavascriptExecutor)getDriver()).executeScript(script, fieldList);
		fieldList = registration.getCountryList();
		String text = Action.getAttributeTextContent(fieldList);
		Assert.assertEquals(text, countryName );

	}
	
	@Test (priority = 6)
	@Parameters ({"email"})
	public void setEmail(String text){
		WebElement fieldInput = registration.getEmailInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}
	
	@Test (priority = 7)
	@Parameters ({"phone"})
	public void setPhone(String text){
		WebElement fieldInput = registration.getPhoneInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Action.compareStrings(fieldText, text);
	}
	
	@Test (priority = 8)
	public void deselectNewsletter(){
		WebElement checkbox = registration.getNewsletterCheckbox();
		Action.deselectCheckBox(checkbox);
	}
	
	@Test (priority = 9)
	@Parameters ({"password"})
	public void setDesiredPassword(String text){
		WebElement fieldInput = registration.getDesiredPasswordInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}
	
	@Test (priority = 10)
	@Parameters ({"password"})
	public void setConfirmPassword(String text){
		WebElement fieldInput = registration.getConfirmPasswordInput();
		common.Action.sendKeys(fieldInput, text);
		String fieldText= fieldInput.getAttribute("value");
		Assert.assertEquals(fieldText, text);
	}
	
	@Test(priority = 11)
	@Parameters ({"message"})
	public void clickOnCreateAccount(String text){
		WebElement button = registration.getCreateAccountInput();
		Action.click(button);
		MainMessages mainMessage = new MainMessages();
		WebElement confirmMessage = mainMessage.getMainMessage();
		getWait().waitUntilVisibilityOfElement(getDriver(), confirmMessage);
		String fieldText= confirmMessage.getAttribute("textContent").trim();
		Assert.assertEquals(fieldText, text);
		
		
		
	}
}