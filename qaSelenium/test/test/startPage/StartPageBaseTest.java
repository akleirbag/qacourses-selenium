package test.startPage;

import org.testng.annotations.BeforeClass;

import startPage.StartPage;
import test.common.BaseTest;

public class StartPageBaseTest extends BaseTest{
	
	StartPage startPage;
	
	@BeforeClass
	public void setupStartPage(){
		startPage = new StartPage(getDriver());
	}
	
	

}
