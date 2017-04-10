package catalogPage;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Action;
import common.BasePage;
import common.Datapicker;
import table.RowWithCheckBox;
import table.TreeTable;

public class CatalogNewProductGeneral extends CatalogNewProduct{

	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());
	TreeTable categoriesTable;
	TreeTable productGroupsTable;
	/*Datapicker datapicker;*/

	private static final String generalContentCss = "div#tab-general";
	private static final String statusRadioButtonsListCss = "label input[type=radio]";

	private static final String nameInputCss = generalContentCss + " span.input-wrapper input";
	private static final String codeInputCss = generalContentCss + " input[name=code]";
	private static final String categoriesListCss = "div#tab-general table div.input-wrapper";
	private static final String defaultCategoryCss = generalContentCss + " select[name=default_category_id]";
	private final static String quantityInputCss = "input[name=quantity]";
	private final static String quantityUnitListCss = "select[name=quantity_unit_id]";
	private final static String deliveryStatusListCss = "select[name=delivery_status_id]";
	private final static String soldOutStatusListCss = "select[name=sold_out_status_id]";
	private final static String uploadImagesInputCss = "input[name^=new_images]";
	private final static String dateValidFromInputCss = "input[name=date_valid_from]";
	private final static String dateValidToInputCss = "input[name=date_valid_to]";


	public static String getCssSelector(){
		return generalContentCss;
	}

	public void loadCategoriesTable(){
		WebElement we = getDriver().findElements(By.cssSelector(categoriesListCss)).get(0);
		categoriesTable = new TreeTable(we);
	}

	public TreeTable getCategoriesTable() {
		return categoriesTable;
	}

	public void loadProductGroupsTable(){
		WebElement w = getDriver().findElements(By.cssSelector(categoriesListCss)).get(1);
		productGroupsTable = new TreeTable(w);
	}

	public TreeTable getProductGroupsTable() {
		return productGroupsTable;
	}

	@FindBy(css =statusRadioButtonsListCss)
	List<WebElement> statusRadioButtons;

	@FindBy(css =nameInputCss)
	WebElement nameInput;;

	@FindBy(css =codeInputCss)
	WebElement codeInput;

	@FindBy(css =defaultCategoryCss)
	WebElement defaultCategory;

	@FindBy(css =quantityInputCss)
	WebElement quantityInput;

	@FindBy(css =quantityUnitListCss)
	WebElement quantityUnitList;

	@FindBy(css =deliveryStatusListCss)
	WebElement deliveryStatusList;

	@FindBy(css =soldOutStatusListCss)
	WebElement soldOutStatusList;

	@FindBy(css =uploadImagesInputCss)
	WebElement uploadImagesInput;

	@FindBy(css = dateValidFromInputCss)
	WebElement dateValidFromInput;

	@FindBy(css = dateValidToInputCss)
	WebElement dateValidToInput;




	public void setStatusEnabled(Boolean value){
		if(value){
			Action.click(statusRadioButtons.get(0));
		}else {
			Action.click(statusRadioButtons.get(1));
		}
	}



	public WebElement getNameField(){
		return nameInput;
	}

	public WebElement getCodeField(){
		return codeInput;
	}

	public WebElement getDefalulCategory(){
		return defaultCategory;
	}

	public WebElement getQuantityField(){
		return quantityInput;
	}

	public WebElement getQuantityUnitList(){
		return quantityUnitList;
	}

	public WebElement getDeliveryStatusList(){
		return deliveryStatusList;
	}

	public WebElement getSoldOutStatusList(){
		return soldOutStatusList;
	}

	public WebElement getUploadImages(){
		return uploadImagesInput;
	}

	public WebElement getDateValidFrom(){
		return dateValidFromInput;
	}

	public WebElement getDateValidTo(){
		return dateValidToInput;
	}
	
	/*public Datapicker getDataPicker(){
		return datapicker;
	}*/
	

	public CatalogNewProductGeneral(){
		super.getDriver();
		loadCategoriesTable();
		loadProductGroupsTable();
		/*datapicker = new Datapicker(getDriver());*/
		PageFactory.initElements(getDriver(), this);
	}


}
