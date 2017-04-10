package countriesPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;
import components.SaveCancelDeleteButtons;
import table.Table;

public class CountriesEdit extends BasePage{
	
	SaveCancelDeleteButtons saveCancelDeleteButtons;
	
	Table countryEditTable;
	ArrayList<String> obtainedList;
	List<WebElement> obtainedElementList;
	ArrayList<String> sortedList;
	
	private static final String editCountryTableCss = "table#table-zones";
	private static final String  nameColumnValueCss = "#table-zones td:nth-child(3)";
	
	public static String getCssSelector(){
		return editCountryTableCss;
	}
	
	public List<String> getNameColumnValueList(){
		obtainedList = new ArrayList<>(); 
		obtainedElementList = driver.findElements(By.cssSelector(nameColumnValueCss)); 
		for( WebElement we: obtainedElementList ){
			String t = we.getText();
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
		return countryEditTable;
	}
	
	public SaveCancelDeleteButtons getSaveCancelDeleteButtons(){
		return saveCancelDeleteButtons;
	}
	
	public CountriesEdit(){
		super();
		countryEditTable = new Table(getDriver(), editCountryTableCss);
		saveCancelDeleteButtons = new SaveCancelDeleteButtons();
	}

}
