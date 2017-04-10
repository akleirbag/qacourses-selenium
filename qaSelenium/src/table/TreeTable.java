package table;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TreeTable {
	WebElement element;
	List<RowWithCheckBox> rows;

	private void loadRows() {
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
	
	public TreeTable(WebElement w){
		element = w;
		loadRows();
	}
}
