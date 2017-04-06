package test.catalogTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.Action;
import table.Cell;
import table.Row;
import table.TextTable;

public class CatalogTest extends CatalogBaseTest{

	@Test
	@Parameters ({"newProductHeader"})
	public void openNewProductForm(String text){
		WebElement anpButton = catalog.getAddNewProductButton();
		Action.click(anpButton);
		getWait().untilTextIs(catalog.getHeader().getCssSelector(), text);
		WebElement header = catalog.getHeader().getHeaderElement();
		String headerText = Action.getText(header).trim();
		Assert.assertEquals(text, headerText);
	}

	@Test
	@Parameters ({"findCoumnName", "findCoumnValue"})
	public void checkIfProductIsAvailable(String colName, String cellValue){
		TextTable table = new TextTable(getDriver(), "dataTable");
		Row row = table.getRow(colName, cellValue);
		Assert.assertTrue(row != null);


	}


}
