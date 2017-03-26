package table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import common.Action;

public class TextTable {

	WebDriver driver;
	private String tableRoot;
	List<String> colNames;
	List<WebElement> colNameWebElements;


	public WebElement getTable(){
		WebElement table  = driver.findElement(By.cssSelector("table .dataTable"));
		return table;
	}

	public List<String> getColNames(){
		return colNames;
	}

	public void prepareColumnsNamesList(){
		colNames = new ArrayList<>();
		colNameWebElements = getTable().findElements(By.cssSelector("tr .header th"));
		for(int col=0; col< colNameWebElements.size(); col++){
			WebElement cell = colNameWebElements.get(col);
			String colName = Action.getAttributeTextContent(cell);
			colNames.add(colName.trim()); //call trim() to remove white spaces before and after
		}
	}

	public List<WebElement> getRows(){
		List<WebElement> rowsList = getTable().findElements(By.cssSelector("tr.row"));
		return rowsList;
	}

	public TextTable(WebDriver driver, String tablePath){
		this.driver = driver;
		tableRoot = tablePath;
		prepareColumnsNamesList();
		
	}
}

