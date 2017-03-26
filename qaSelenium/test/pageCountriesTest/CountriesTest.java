package pageCountriesTest;

import org.testng.Assert;
import org.testng.annotations.Test;


public class CountriesTest extends CountriesBaseTest{
	
	
	@Test
	public void getSortedList(){
		System.out.println("obtained list: " + countries.getNameColumnValueList());
		System.out.println("sorted list  : " + countries.getSortedList());
		
		Assert.assertEquals(countries.getNameColumnValueList(), countries.getSortedList());
		
}
}