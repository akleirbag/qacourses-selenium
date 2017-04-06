package common;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class RowWithCheckBox {
	
	int pxPerLevel = 16;
	int margin;
	String name;
	
	List<RowWithCheckBox> children;
	String checkboxCss = "input[type=checkbox]";
	WebElement checkBox;
	String marginleftCss = "[style*=\"margin-left\"]";
	
	public void setPxPerLevel(int px){
		pxPerLevel = px;
	}
	
	public String getName() {
		return name;
	}
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	
	public int getLevel(){
		return margin/pxPerLevel;
	}
	
	public void addChild(RowWithCheckBox c){
		if (c.getLevel() ==  getLevel() + 1){
			children.add(c);
		} else if (c.getLevel() > getLevel() + 1) {
			children.get(children.size() - 1).addChild(c);
		} else {
			//exception wrong level!
		}
	}
	
	public RowWithCheckBox getRow(String name){
		RowWithCheckBox ret = null;
		for (RowWithCheckBox row: children){
			if (name.equals(row.getName())){
				ret = row;
				break;
			}
		}
		return ret;
	}
	
	public List<RowWithCheckBox> getChildren(){
		return children;
	}
	
	public void setCheckBoxSelector(String cssSelector){
		checkboxCss = cssSelector;
	}

	public RowWithCheckBox(WebElement row){
		try {
			WebElement marg = row.findElement(By.cssSelector(marginleftCss));
			String attr = marg.getCssValue("margin-left");
			attr = attr.replace("px", "");
			margin = Integer.valueOf(attr);
		} catch (NoSuchElementException e){
			margin = 0;
		}
		try {
			checkBox = row.findElement(By.cssSelector(checkboxCss));
		} catch (NoSuchElementException e){
			
		}
		
		name = Action.getAttributeTextContent(row).trim();
		children = new ArrayList<RowWithCheckBox>();
	}
}
