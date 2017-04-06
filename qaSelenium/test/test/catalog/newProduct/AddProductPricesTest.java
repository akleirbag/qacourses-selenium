package test.catalog.newProduct;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import catalogPage.CatalogNewProductEnum;
import catalogPage.CatalogNewProductPrices;
import common.Action;
import test.common.BaseTest;

public class AddProductPricesTest extends BaseTest{

	CatalogNewProductPrices catalogNewProductPrices;

	@BeforeClass 
	public void setupCatalogNewProductPrices(){
		catalogNewProductPrices = new CatalogNewProductPrices();
	}

	@Test(priority = 2)
	public void openPricesTab(){
		catalogNewProductPrices.clickOnTabItem(CatalogNewProductEnum.Prices);
		getWait().untilVisibility(catalogNewProductPrices.getCssSelector());
	}

	@Test(priority = 3)
	@Parameters ({"purchasePriceValue"})
	public void setPurchasePriceValue(String text){
		WebElement we = catalogNewProductPrices.getPurchasePriceInput();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 4)
	@Parameters ({"purchasePriceCurrency"})
	public void setPurchasePriceCurrency(String text){
		WebElement we = catalogNewProductPrices.getPurchasePriceList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 6)
	@Parameters ({"taxClass"})
	public void setTaxClassList(String text){
		WebElement we = catalogNewProductPrices.getPriceUSDField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 7)
	@Parameters ({"priceUSD"})
	public void setPriceUSDField(String text){
		WebElement we = catalogNewProductPrices.getPriceUSDField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 8)
	@Parameters ({"priceInclTaxUSD"})
	public void setPriceInclTaxFieldUSD(String text){
		WebElement we = catalogNewProductPrices.getPriceUSDIncludeTaxField();
		//Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 9)
	@Parameters ({"priceEUR"})
	public void setPriceEURField(String text){
		WebElement we = catalogNewProductPrices.getPriceEUR();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 10)
	@Parameters ({"priceInclTaxEUR"})
	public void setPriceInclTaxEURField(String text){
		WebElement we = catalogNewProductPrices.getPriceEURIncludeTaxField();
		//Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

}