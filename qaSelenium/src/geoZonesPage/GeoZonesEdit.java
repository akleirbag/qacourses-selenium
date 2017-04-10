package geoZonesPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Action;
import common.BasePage;
import components.SaveCancelDeleteButtons;
import table.Table;

public class GeoZonesEdit extends BasePage{
	
	SaveCancelDeleteButtons saveCancelDeleteButtons;
	
	Table geoZonesEditTable;
	ArrayList<String> obtainedList;
	List<WebElement> obtainedElementList;
	ArrayList<String> sortedList;
	
	private static final String geoZonesEditTableCss = "table#table-zones";
	private static final String  zonesColumnValueCss = "#table-zones tbody tr td:nth-child(3) select";
	
	public static String getCssSelector(){
		return geoZonesEditTableCss;
	}
	
	public List<String> getZonesColumnValueList(){
		obtainedList = new ArrayList<>(); 
		obtainedElementList = driver.findElements(By.cssSelector(zonesColumnValueCss)); 
		for( WebElement we: obtainedElementList ){
			String t = Action.getFirstSelectedOption(we);
			if (t != null && !t.equals("")){
				obtainedList.add(t);	
			}
				 
		}
		return obtainedList;
	}
	
	
	public List<String> getSortedList(){
		sortedList = new ArrayList<>(); 
		for (String se: obtainedList){
			sortedList.add(se);		
		}
		Collections.sort(sortedList);
		return sortedList;
	}
	

	
	public Table getTble(){
		return geoZonesEditTable;
	}
	
	public SaveCancelDeleteButtons getSaveCancelDeleteButtons(){
		return saveCancelDeleteButtons;
	}
	
	public GeoZonesEdit(){
		super();
		geoZonesEditTable = new Table(getDriver(), geoZonesEditTableCss);
		saveCancelDeleteButtons = new SaveCancelDeleteButtons();
	}

}
