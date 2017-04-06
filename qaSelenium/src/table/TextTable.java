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
	List<Row> rows;
	Row row;
	List<WebElement> rowElements;

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

	public List<WebElement> getRowEements(){
		rowElements = getTable().findElements(By.cssSelector("tr.row"));
		return rowElements;
	}

	public List<Row> getRows(){
		rows = new ArrayList<Row>();
		for(WebElement r : rowElements){
			Row row = new Row(r);
			rows.add(row);
		}
		return rows;
	}




	public int getColIndex(String colName){
		return colNames.indexOf(colName);
	}



	public Row getRow(){
		return row;
	}


	public Row getRow(String colName, String cellValue){
		int ci = getColIndex(colName);
		if( ci == -1){
			return null;
		}
		for (Row r: getRows()){
			String cv = r.getCell(ci).getAttributeTextContent();
			boolean compare = Action.compareStrings(cv.trim(), cellValue.trim());
			if(compare == true){
				return r;
			}
		}
		return null;
	}


	public TextTable(WebDriver driver, String tablePath){
		this.driver = driver;
		tableRoot = tablePath;
		prepareColumnsNamesList();
		row = new Row(getTable());
		getRowEements();


	}
}

