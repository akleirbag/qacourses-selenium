package test.geozonesTest;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Action;
import common.BasePage;
import components.Header;
import geoZonesPage.GeoZones;
import leftMenu.MenuEntry;
import leftMenu.MenuItemEnum;
import startPage.StartPage;
import test.common.BaseTest;

public class OpenGeoZonesTest extends BaseTest{

	@Test(priority = 2) 
	@Parameters({"header"})
	public void openGeoZones(String header){
		BasePage page = new BasePage();
		MenuEntry menuGeoZones = page.getMenu().get(MenuItemEnum.GeoZones);
		menuGeoZones.getMenuElement().click();
		getWait().untilTextIs(Header.getCssSelector(), "Geo Zones");
		String headerText = Action.getText(page.getHeader().getHeaderElement()).trim();
		Assert.assertEquals(headerText, header);
	}	
}

