package common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Table {
	WebElement element;
	List<RowWithCheckBox> rows;
	
	WebElement header;

	public WebElement getHeader() {
		return header;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}
	
	private void loadRows() {
		try {
			header = element.findElement(By.cssSelector("th"));
		} catch (NoSuchElementException e){
			//log no header
		}
		rows = new ArrayList<RowWithCheckBox>();
		List<WebElement> rowElements = element.findElements(By.cssSelector("tr"));
		for (WebElement row: rowElements){
			RowWithCheckBox rwc = new RowWithCheckBox(row);
			if (rwc.getLevel() == 0){
				rows.add(rwc);
			} else {
				rows.get(rows.size() - 1).addChild(rwc);
			}
		}
	}
	
	public RowWithCheckBox getRow(String name){
		RowWithCheckBox ret = null;
		for (RowWithCheckBox row: rows){
			if (name.equals(row.getName())){
				ret = row;
				break;
			}
		}
		return ret;
	}
	
	public List<RowWithCheckBox> getRows() {
		return rows;
	}
	
	public Table(WebElement w){
		element = w;
		loadRows();
	}
}
