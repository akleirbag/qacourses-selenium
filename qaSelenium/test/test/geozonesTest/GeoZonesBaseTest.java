package test.geozonesTest;

import org.testng.annotations.BeforeClass;
import geoZonesPage.GeoZones;
import test.common.BaseTest;

public class GeoZonesBaseTest extends BaseTest{
	
	GeoZones geoZones;
	
	@BeforeClass
	public void setupStartPage(){
		geoZones = new GeoZones();
	
	}	
}
