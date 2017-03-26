package test.startPage;

import java.lang.invoke.MethodHandles;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;

import startPage.StartPage;
import test.common.BaseTest;

public class StartPageBaseTest extends BaseTest{
	
	StartPage startPage;
	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@BeforeClass
	public void setupStartPage(){
		startPage = new StartPage();
		log.error("Ku uciesze Kamciuszka");
	}
	
	

}
