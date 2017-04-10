package table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.Action;

public class Table {

	WebDriver driver;
	private String tableRoot;
	List<String> colNames;
	List<Row> rows;
	List<WebElement> rowElements;


	public WebElement getElement(){
		WebElement table  = driver.findElement(By.cssSelector(tableRoot));
		return table;
	}

	public List<String> getColNames(){
		return colNames;
	}

	public void prepareColumnsNamesList(){
		colNames = new ArrayList<>();
		List<WebElement> colNameWebElements = getElement().findElements(By.cssSelector("tr .header th"));
		for(int col=0; col< colNameWebElements.size(); col++){
			WebElement cell = colNameWebElements.get(col);
			String colName = Action.getAttributeTextContent(cell);
			colNames.add(colName.trim()); //call trim() to remove white spaces before and after
		}
	}

	public List<WebElement> getRowElements(){
		rowElements = getElement().findElements(By.cssSelector("tr.row"));
		return rowElements;
	}

	public List<Row> getRows(){
		rows = new ArrayList<Row>();
		for(WebElement r : getRowElements()){
			Row row = new Row(r);
			rows.add(row);
		}
		return rows;
	}

	public int getColIndex(String colName){
		return colNames.indexOf(colName);
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

	public List<Row> findRowsNotHaving(int colIndex, String value){
		List<Row> foundRows = new ArrayList<Row>();

		for (Row r : getRows()){
			Cell cell = r.getCell(colIndex);
			String cellText = cell.getAttributeTextContent();

			if(!cellText.equals(value)){
				foundRows.add(r);
			}
		}
		return foundRows;
	}

	public Table(WebDriver driver, String tablePath){
		this.driver = driver;
		tableRoot = tablePath;
		prepareColumnsNamesList();
	//	getRowElements();
		
	}
}

