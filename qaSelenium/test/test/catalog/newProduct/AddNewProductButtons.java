package test.catalog.newProduct;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import catalogPage.Catalog;
import catalogPage.CatalogNewProductPrices;
import common.Action;
import messages.MainMessages;
import test.common.BaseTest;

public class AddNewProductButtons extends BaseTest{


	CatalogNewProductPrices newProductPrices;
	MainMessages mainMessage;
	Catalog catalog;

	@BeforeClass
	public void setupCatalogNewProduct(){
		newProductPrices = new CatalogNewProductPrices();
		
	}

	@Test
	@Parameters({"messageAfterSave"})
	public void clickSaveButton(String text){
		WebElement button = newProductPrices.getSaveButton();
		Action.click(button);
	
		//catalog = new Catalog();
		MainMessages mainMessage = new MainMessages();
		WebElement confirmMessage = mainMessage.getMainMessage();
		getWait().waitUntilVisibilityOfElement(getDriver(), confirmMessage);
		String fieldText= confirmMessage.getAttribute("textContent").trim();
		Assert.assertEquals(fieldText, text);
	}

}
