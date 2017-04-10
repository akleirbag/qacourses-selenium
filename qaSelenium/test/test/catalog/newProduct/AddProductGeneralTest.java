package test.catalog.newProduct;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import catalogPage.CatalogNewProductEnum;
import catalogPage.CatalogNewProductGeneral;
import common.Action;
import table.RowWithCheckBox;
import test.common.BaseTest;

public class AddProductGeneralTest extends BaseTest {

	CatalogNewProductGeneral newProductGeneral;
	
	@BeforeClass
	public void setupCatalogNewProduct(){
		newProductGeneral = new CatalogNewProductGeneral();
	}
	
	@Test(priority = 1)
	public void openGeneralTab(){
		newProductGeneral.clickOnTabItem(CatalogNewProductEnum.General);
		
	}
	
	
	@Test(priority = 2)
	@Parameters ({"statusEnabled"})
	public void setStatusEnabled(Boolean value){
		newProductGeneral.setStatusEnabled(value);
	}

	@Test (priority = 3)
	@Parameters ({"productName"})
	public void setProductName(String text){
		WebElement we = newProductGeneral.getNameField();
		Action.sendKeys(we, text);
		Assert.assertEquals(text, Action.getValue(we));
	}

	@Test (priority = 4)
	@Parameters ({"productCode"})
	public void setProductCode(String text){
		WebElement we = newProductGeneral.getCodeField();
		Action.sendKeys(we, text);
		Assert.assertEquals(text, Action.getValue(we));
	}

	@Test (priority = 5)
	@Parameters ({"categoryName" , "subcategoryName"})
	public void checkCategories(String categoryName, String subcategoryName){
		RowWithCheckBox row = newProductGeneral.getCategoriesTable().getRow("").
				getRow(categoryName).getRow(subcategoryName);
		Action.click(row.getCheckBox());
		Assert.assertTrue(row.getCheckBox().isSelected()); 
	}

	@Test (priority = 6)
	@Parameters ({"prodctDefaultCategory"})
	public void getDefaultCategory(String text){
		WebElement we = newProductGeneral.getDefalulCategory();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test (priority = 7)
	@Parameters ({"productGroupsName"})
	public void checkGender(String name){
		RowWithCheckBox row = newProductGeneral.getProductGroupsTable().getRow(name);
		Action.click(row.getCheckBox());
		Assert.assertTrue(row.getCheckBox().isSelected());
	}

	@Test (priority = 8)
	@Parameters ({"productQuantity"})
	public void setQuantity(String text){
		WebElement we = newProductGeneral.getQuantityField();
		Action.sendKeys(we, text);
		Assert.assertEquals(text, Action.getValue(we));
	}

	@Test (priority = 9)
	@Parameters ({"prodctQuantityUnit"})
	public void getQuantityUnit(String text){
		WebElement we = newProductGeneral.getQuantityUnitList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test (priority = 10)
	@Parameters ({"prodctDeliveryStatus"})
	public void getDeliveryStatus(String text){
		WebElement we = newProductGeneral.getDeliveryStatusList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test (priority = 11)
	@Parameters ({"prodctSoldOutStatus"})
	public void getSoldOutStatus(String text){
		WebElement we = newProductGeneral.getSoldOutStatusList();
		Action.selectList(we, text);
		String getText = Action.getFirstSelectedOption(we);
		Assert.assertEquals(text, getText);
	}

	@Test (priority = 12)
	@Parameters ({"uploadImageName"})
	public void uploadFile(String file){
		WebElement we = newProductGeneral.getUploadImages();
		String workDir = System.getProperty("user.dir") + "\\resources\\";
		we.sendKeys(workDir + file);
		String getText = Action.getValue(we);
		Assert.assertEquals(getText, file);
	}
	
	@Test (priority = 13)
	@Parameters ({"productDateValidFrom"})
	public void setDateValidFrom(String text){
		WebElement we = newProductGeneral.getDateValidFrom();
		/*TODO for chrome
		 Action.click(we);
		getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(selector)));
		newProductGeneral.getDataPicker().setDatepicker(getDriver(), cssSelector, "2017-01-02");
		newProductGeneral.getDateValidFrom()*/
		Action.sendKeys(we, text);
		Assert.assertEquals(text, Action.getValue(we));
	}
	
	
	@Test (priority = 14)
	@Parameters ({"productDateValidTo"})
	public void setDateValidTo(String text){
		WebElement we = newProductGeneral.getDateValidTo();
		Action.sendKeys(we, text);
		Assert.assertEquals(text, Action.getValue(we));
	}
}
