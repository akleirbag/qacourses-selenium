package geoZonesPage;

import common.BasePage;
import table.Table;

public class GeoZones extends BasePage{


	Table geoZonesTable;

	private static final String geoZonesTableCss = "table[class=dataTable]";

	public static String getCssSelector(){
		return geoZonesTableCss;
	}


	public Table getTable(){
		return geoZonesTable;
	}

	public GeoZones(){
		super();
		geoZonesTable = new Table(getDriver(), geoZonesTableCss);
	}
}
