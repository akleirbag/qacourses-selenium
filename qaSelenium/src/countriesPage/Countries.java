package countriesPage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;
import table.Table;
import table.TreeTable;

import java.util.Collections;

public class Countries extends BasePage{

	ArrayList<String> obtainedList;
	List<WebElement> obtainedElementList;
	ArrayList<String> sortedList;
	Table countriesTable;

	private static final String  nameColumnValueCss = "tr.row td:nth-child(5) a";

	public List<String> getNameColumnValueList(){
		obtainedList = new ArrayList<>(); 
		obtainedElementList = countriesTable.getElement().findElements(By.cssSelector(nameColumnValueCss)); 
		for( WebElement we: obtainedElementList ){
			obtainedList.add(we.getText());		 
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
	
	public Table getTable(){
		return countriesTable;
	}

	public Countries(){
		super();
		countriesTable = new Table(getDriver(), "table.dataTable");
	}
}
