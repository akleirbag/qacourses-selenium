package catalogPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.Action;
import common.BasePage;
import components.SaveCancelDeleteButtons;

public class CatalogNewProduct extends BasePage{

	SaveCancelDeleteButtons saveCancelDeleteButtons;

	private static final String generalTabCss = "ul.index li:nth-child(1) a";
	private static final String informtionTabCss = "ul.index li:nth-child(2) a";
	private static final String dataTabCss = "ul.index li:nth-child(3) a";
	private static final String pricesTabCss = "ul.index li:nth-child(4) a";
	private static final String optionsTabCss = "ul.index li:nth-child(5) a";
	private static final String optionsStockTabCss = "ul.index li:nth-child(6) a";

	public static String getCssSelector(){
		return generalTabCss;
	}

	@FindBy(css =generalTabCss)
	WebElement generalTab;

	@FindBy(css =informtionTabCss)
	WebElement informtionTab;

	@FindBy(css =dataTabCss)
	WebElement dataTab;

	@FindBy(css =pricesTabCss)
	WebElement pricesTab;

	@FindBy(css =optionsTabCss)
	WebElement optionsTab;

	@FindBy(css =optionsStockTabCss)
	WebElement optionsStockTab;

	public void clickOnTabItem(CatalogNewProductEnum tabItem){
		switch (tabItem) {
		case General:
			Action.click(generalTab);
			break;
		case Informaion:
			Action.click(informtionTab);
			break;
		case Data:
			Action.click(dataTab);
			break;
		case Prices:
			Action.click(pricesTab);
			break;
		case Options:
			Action.click(optionsTab);
			break;
		case OptionsStock:
			Action.click(optionsStockTab);
			break;
		}
	}
	
	public SaveCancelDeleteButtons getSaveCancelDeleteButtons(){
		return saveCancelDeleteButtons;
	}


	public CatalogNewProduct(){
		super.getDriver();
		saveCancelDeleteButtons  = new SaveCancelDeleteButtons();
		PageFactory.initElements(getDriver(), this);
	}
}
