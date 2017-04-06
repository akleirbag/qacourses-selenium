package test.catalogTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import catalogPage.Catalog;
import test.common.BaseTest;

public class CatalogBaseTest extends BaseTest{
	
	Catalog catalog;
	
	@BeforeClass
	public void setupCatalogPage(){
		catalog = new Catalog();
		
	}
	

}
