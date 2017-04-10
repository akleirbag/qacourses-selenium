package test.catalogTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Action;
import common.BasePage;
import leftMenu.MenuEntry;
import leftMenu.MenuItemEnum;
import test.common.BaseTest;

public class OpenCatalogTest extends BaseTest{

	@Test(priority = 2) 
	@Parameters({"header"})
	public void openCatalog(String header){
		BasePage page = new BasePage();
		MenuEntry menuCatalog = page.getMenu().get(MenuItemEnum.Countries);
		menuCatalog.getMenuElement().click();
		WebElement headerWE = page.getHeader().getHeaderElement();
		String headerText = Action.getText(headerWE);
		Assert.assertEquals(headerText , header);
	}	
}

