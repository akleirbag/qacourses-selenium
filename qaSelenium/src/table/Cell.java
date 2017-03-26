package table;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import common.Action;


public class Cell {
	WebElement element;
	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());

	public void click(){	
		try{
			element.findElement(By.cssSelector("a")).click();
		} catch(NoSuchElementException e){
			log.error("click(): Element a was not found");
		}
	}
	
	public void getAttributeTextContent(){
		Action.getAttributeTextContent(element);
	}

	public Cell(WebElement element){
		this.element = element;

	}
}
