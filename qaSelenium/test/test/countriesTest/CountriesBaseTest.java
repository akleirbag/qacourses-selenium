package test.countriesTest;

import org.testng.annotations.BeforeClass;

import countriesPage.Countries;
import test.common.BaseTest;

public class CountriesBaseTest extends BaseTest{
	
	Countries countries;
	
	@BeforeClass
	public void setupStartPage(){
		countries = new Countries();
	
	}	
}
