package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class LoginUserTest extends Firefox{

	
	@Test
	public void loginUser(){
		driver.navigate().to("http://localhost:8080/litecart/admin/");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name(("login"))).click();	
	}
}
