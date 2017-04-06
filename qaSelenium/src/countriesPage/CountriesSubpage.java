package countriesPage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;
import java.util.Collections;

public class CountriesSubpage extends BasePage{

	ArrayList<String> obtainedList;
	List<WebElement> obtainedElementList;
	ArrayList<String> sortedList;

	private static final String  nameColumnValueCss = "tr.row td:nth-child(5) a";



	public List<String> getNameColumnValueList(){
		obtainedList = new ArrayList<>(); 
		obtainedElementList = driver.findElements(By.cssSelector(nameColumnValueCss)); 
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
	
	

	public CountriesSubpage(){
		super();
		PageFactory.initElements(getDriver(), this);
	}
}
