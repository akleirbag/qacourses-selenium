package pageCountriesTest;

import org.testng.annotations.BeforeClass;

import countriesPage.CountriesSubpage;
import test.common.BaseTest;

public class CountriesBaseTest extends BaseTest{
	
	CountriesSubpage countries;
	
	@BeforeClass
	public void setupStartPage(){
		countries = new CountriesSubpage();
	
	}	
}
