package test.startPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import catalogPage.Catalog;
import table.Cell;
import table.Table;
import test.common.BaseTest;

public class TestClass extends BaseTest{


	@BeforeClass
	public void setupCatalog(){
	//	Catalog catalog = new Catalog();
		
		
		
	}


	@Test
	public void getValue(){
		Table table = new Table(getDriver(), "dataTable");
		Cell c = table.getRows().get(5).getCell(table.getColIndex("Name"));

		System.out.println(c.getAttributeTextContent());

	}

}
