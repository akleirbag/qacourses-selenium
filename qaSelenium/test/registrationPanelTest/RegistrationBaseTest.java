package registrationPanelTest;

import org.testng.annotations.BeforeClass;

import registrationPanel.RegistrationForm;
import test.common.BaseTest;

public class RegistrationBaseTest extends BaseTest{
	
	RegistrationForm registration;
	
	@BeforeClass
	public void setupStartPage(){
		registration = new RegistrationForm();
		
	}

}
