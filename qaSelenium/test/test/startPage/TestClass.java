package test.startPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import catalogPage.Catalog;
import table.Cell;
import table.TextTable;
import test.common.BaseTest;

public class TestClass extends BaseTest{


	@BeforeClass
	public void setupCatalog(){
	//	Catalog catalog = new Catalog();
		
		
		
	}


	@Test
	public void getValue(){
		TextTable table = new TextTable(getDriver(), "dataTable");
		Cell c = table.getRows().get(5).getCell(table.getColIndex("Name"));

		System.out.println(c.getAttributeTextContent());

	}

}
