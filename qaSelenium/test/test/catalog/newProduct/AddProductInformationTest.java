package test.catalog.newProduct;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import catalogPage.CatalogNewProductEnum;
import catalogPage.CatalogNewProductInformation;
import common.Action;
import test.common.BaseTest;

public class AddProductInformationTest extends BaseTest{

	CatalogNewProductInformation catalogNewProductInformation;

	@BeforeClass 
	public void setupCatalogNewProductInformation(){
		catalogNewProductInformation = new CatalogNewProductInformation();
	}

	@Test(priority = 2)
	public void openInformationTab(){
		catalogNewProductInformation.clickOnTabItem(CatalogNewProductEnum.Informaion);
		getWait().untilVisibility(catalogNewProductInformation.getCssSelector());
	}

	@Test(priority = 3)
	@Parameters ({"manufacturer"})
	public void setManufacturerList(String text){
		WebElement we = catalogNewProductInformation.getManufacturesList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 4)
	@Parameters ({"supplier"})
	public void setSupplierList(String text){
		WebElement we = catalogNewProductInformation.getSupplierList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 6)
	@Parameters ({"keywords"})
	public void setKeywordsField(String text){
		WebElement we = catalogNewProductInformation.getKeywordsField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 7)
	@Parameters ({"shortDescription"})
	public void setShortDescriptionField(String text){
		WebElement we = catalogNewProductInformation.getShortDescriptionField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 8)
	@Parameters ({"description"})
	public void setDescriptionField(String text){
		WebElement we = catalogNewProductInformation.getDescriptionField();
		Action.sendKeys(we, text);
		String getText = Action.getAttributeTextContent(we);
		Assert.assertEquals(text.trim(), getText.trim());
	}

	@Test(priority = 9)
	@Parameters ({"headTitle"})
	public void setHeadTitleField(String text){
		WebElement we = catalogNewProductInformation.getHeadTitleField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

	@Test(priority = 10)
	@Parameters ({"metaDescription"})
	public void setMetaDescriptionField(String text){
		WebElement we = catalogNewProductInformation.getMetaDescriptionField();
		Action.sendKeys(we, text);
		String getText = Action.getValue(we);
		Assert.assertEquals(text, getText);
	}

}
