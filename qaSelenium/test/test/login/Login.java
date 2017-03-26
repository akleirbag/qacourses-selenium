package test.login;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import leftMenu.Logo;
import test.common.BaseTest;

public class Login  extends BaseTest{

	@Test
	@Parameters({"username", "password"})
	public void loginUser(String username, String password){
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name(("login"))).click();	
		getWait().untilVisibility(Logo.getCssSelector());
		
	}
}