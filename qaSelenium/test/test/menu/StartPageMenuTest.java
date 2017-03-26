package test.menu;

import org.testng.annotations.Test;
import leftMenu.StartPageMenu;
import test.common.BaseTest;

public class StartPageMenuTest extends BaseTest{

	StartPageMenu startPageMenu;
	
	@Test
	public void openRegistrationForm(){
		startPageMenu = new StartPageMenu();
		startPageMenu.openRegistrationForm();
	}
}
