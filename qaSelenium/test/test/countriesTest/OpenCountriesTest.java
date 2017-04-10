package test.countriesTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Action;
import common.BasePage;
import components.Header;
import leftMenu.MenuEntry;
import leftMenu.MenuItemEnum;
import test.common.BaseTest;

public class OpenCountriesTest extends BaseTest{

	@Test(priority = 2) 
	@Parameters({"header"})
	public void openCountries(String header){
		BasePage page = new BasePage();
		MenuEntry menuCountries = page.getMenu().get(MenuItemEnum.Countries);
		menuCountries.getMenuElement().click();
		getWait().untilTextIs(Header.getCssSelector(), "Countries");
		String headerText = Action.getText(page.getHeader().getHeaderElement()).trim();
		Assert.assertEquals(headerText, header);
	}	
}

