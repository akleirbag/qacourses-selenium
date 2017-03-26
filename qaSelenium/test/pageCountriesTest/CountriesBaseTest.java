package pageCountriesTest;

import org.testng.annotations.BeforeClass;

import pageCountries.Countries;
import test.common.BaseTest;

public class CountriesBaseTest extends BaseTest{
	
	Countries countries;
	
	@BeforeClass
	public void setupStartPage(){
		countries = new Countries();
	
	}	
}
