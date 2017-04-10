package test.countriesTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Action;
import countriesPage.CountriesEdit;
import table.Cell;
import table.Row;
import table.Table;


public class CountriesTest extends CountriesBaseTest{

	CountriesEdit countriesEdit;


	@Test(priority = 1)
	public void getSortedList(){

		System.out.println("obtained list: " + countries.getNameColumnValueList());
		System.out.println("sorted list  : " + countries.getSortedList());

		Assert.assertEquals(countries.getNameColumnValueList(), countries.getSortedList());
	}

	@Parameters({"columnIndex", "columnValue", "indexColumnToClick"})
	@Test (priority = 2)
	public void findAndOpenRowsNotHaving(int columnIndex, String colunmValue, int columnToClick){
		Table table = countries.getTable();
		int zoneIndex = table.getColIndex("Zones");
		List<Row> rows  = table.findRowsNotHaving(zoneIndex, colunmValue);
		for(int i = 0; i < rows.size(); i++){
			Row r = countries.getTable().findRowsNotHaving(zoneIndex, colunmValue).get(i);
			Cell cell = r.getCell(columnToClick);
			cell.click();
			getWait().untilVisibility(CountriesEdit.getCssSelector());
			countriesEdit = new CountriesEdit();
			Assert.assertEquals(countriesEdit.getNameColumnValueList(), countriesEdit.getSortedList());
			WebElement cancelButton = countriesEdit.getSaveCancelDeleteButtons().getCancelButton();
			Action.click(cancelButton);
			getWait().untilTextIs(countries.getHeader().getCssSelector(), "Countries");
			
		}
	}
}