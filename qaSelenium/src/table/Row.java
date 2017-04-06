package table;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import common.Action;

public class Row {

	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	WebElement rowElement;
	List<Cell> cellList;
	List<WebElement> cellWebElements;



	public void findCells(){
		cellList = new ArrayList<Cell>();
		cellWebElements = rowElement.findElements(By.cssSelector("td"));
		for(WebElement c : cellWebElements){
			Cell cell = new Cell(c);
			cellList.add(cell);
		}
	}

	public List<Cell> getCellList(){
		return cellList;
	}

	public Cell getCell(int cellIndex){
		return cellList.get(cellIndex);
	}

	public Row(WebElement row){
		rowElement = row;
		findCells();

	}
}
