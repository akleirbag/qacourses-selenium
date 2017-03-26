package test.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import messages.MainMessages;
import test.common.BaseTest;

public class LoginCustomer  extends BaseTest{

	@Test
	@Parameters({"email", "password", "successLoginMessage"})
	public void loginUser(String username, String password, String text){
		getDriver().findElement(By.name("email")).sendKeys(username);
		getDriver().findElement(By.name("password")).sendKeys(password);
		getDriver().findElement(By.name("login")).click();	
		getWait().untilTextIs(MainMessages.getCssSelector(), text);
		MainMessages mainMessage = new MainMessages();
		WebElement confirmMessage = mainMessage.getMainMessage();
		
		String fieldText= confirmMessage.getAttribute("textContent").trim();
		Assert.assertEquals(fieldText, text);
	}
}