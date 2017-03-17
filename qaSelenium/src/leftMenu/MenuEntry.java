package leftMenu;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuEntry {
	private static final String prefix = "ul#box-apps-menu  li#app-:nth-child(";
	private static final String suffix= ") >a > span.name";
	private int id;
	WebDriver driver;
	private Map<MenuItemEnum, SubMenuEntry> submenus;

	public String getCssSelector(){
		return prefix + Integer.toString(id) + suffix;
	}

	public MenuEntry(WebDriver driver, int i){
		id = i;
		this.driver = driver;
		submenus = new HashMap<MenuItemEnum, SubMenuEntry>();
	}
	
	private MenuEntry(){
		
	}
	
	public void register(MenuItemEnum item, String id){
		SubMenuEntry s = new SubMenuEntry(id);
		submenus.put(item, s);
	}
	
	public SubMenuEntry get(MenuItemEnum item){
		return submenus.get(item);
	}
	
	public WebElement getMenuElement(){
		return driver.findElement(By.cssSelector(getCssSelector()));
	}

	public WebElement getSubMenuElement(MenuItemEnum item){
		SubMenuEntry sm = get(item);
		//WebElement we = getMenuElement();
		return driver.findElement(By.cssSelector(sm.getCssSelector()));
	}
}
