package test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.Action;
import leftMenu.StartPageMenu;
import messages.MainMessages;
import test.common.BaseTest;

public class Logout  extends BaseTest{

	@Test
	@Parameters({"logoutMessage"})
	public void logoutUser(String text){
		StartPageMenu menu = new StartPageMenu();
		Action.click(menu.getLogoutLink());
		getWait().untilTextIs(MainMessages.getCssSelector(), text);
		MainMessages mainMessage = new MainMessages();
		WebElement confirmMessage = mainMessage.getMainMessage();
		//getWait().waitUntilVisibilityOfElement(getDriver(), confirmMessage);
		String fieldText= confirmMessage.getAttribute("textContent").trim();
		Assert.assertEquals(fieldText, text);

	}
}