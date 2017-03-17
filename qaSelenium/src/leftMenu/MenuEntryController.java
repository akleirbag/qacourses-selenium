package leftMenu;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

public class MenuEntryController{
	Map<MenuItemEnum, MenuEntry> items;
	private int id = 1;
	WebDriver driver;
	
	public MenuEntryController(WebDriver driver){
		this.driver = driver;
		items = new HashMap<MenuItemEnum, MenuEntry>();
	}
	
	private MenuEntryController(){
		//make default constructor private because driver is required
	}
	
	public void register(MenuItemEnum name){
		MenuEntry m = new MenuEntry(driver, id);
		items.put(name, m);
		id++;
	}
	
	public MenuEntry get(MenuItemEnum menu){
		return items.get(menu);
	}
}