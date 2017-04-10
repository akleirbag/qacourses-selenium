package test.geozonesTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.Action;
import components.Header;
import geoZonesPage.GeoZonesEdit;
import table.Cell;
import table.Row;
import table.Table;


public class GeoZonesTest extends GeoZonesBaseTest{

	GeoZonesEdit geoZonesEdit;

	@Parameters({"indexColumnToClick"})
	@Test (priority = 2)
	public void checkAllZones(int columnToClick){
		Table table = geoZones.getTable();
		List<Row> rows  = table.getRows();
		for(int i = 0; i < rows.size(); i++){
			Row r = geoZones.getTable().getRows().get(i);
			Cell cell = r.getCell(columnToClick);
			cell.click();
			getWait().untilVisibility(GeoZonesEdit.getCssSelector());
			geoZonesEdit = new GeoZonesEdit();
			Assert.assertEquals(geoZonesEdit.getZonesColumnValueList(), geoZonesEdit.getSortedList());
			WebElement cancelButton = geoZonesEdit.getSaveCancelDeleteButtons().getCancelButton();
			Action.click(cancelButton);
			getWait().untilTextIs(Header.getCssSelector(), "Geo Zones");

		}
	}
}