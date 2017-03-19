package test.login;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import leftMenu.Logo;
import test.common.BaseTest;

public class Login  extends BaseTest{

	@Test
	public void loginUser(){
		//driver.navigate().to("");
		System.out.println("login");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name(("login"))).click();	
		getWait().untilVisibility(Logo.getCssSelector());
		
	}
}