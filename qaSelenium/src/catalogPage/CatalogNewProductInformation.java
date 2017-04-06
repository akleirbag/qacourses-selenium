package catalogPage;

import java.lang.invoke.MethodHandles;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogNewProductInformation extends CatalogNewProduct {

	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());

	private static final String informationContentCss = "div#tab-information";

	private static final String manufacturerCss = "select[name=manufacturer_id]";
	private static final String supplierCss = "select[name=supplier_id]";
	private static final String keywordsCss = "input[name=keywords]";
	private static final String shortDescriptionCss = "input[name=short_description\\[en\\]]";
	private final static String descriptionCss = "div.trumbowyg-editor";
	private final static String headTitleCss = "input[name=head_title\\[en\\]]";
	private final static String metaDescriptionCss = "input[name=meta_description\\[en\\]]";


	public static String getCssSelector(){
		return informationContentCss;
	}


	@FindBy(css =manufacturerCss)
	WebElement manufacturer;;

	@FindBy(css =supplierCss)
	WebElement supplier;

	@FindBy(css =keywordsCss)
	WebElement keywords;

	@FindBy(css =shortDescriptionCss)
	WebElement shortDescription;

	@FindBy(css =descriptionCss)
	WebElement description;

	@FindBy(css =headTitleCss)
	WebElement headTitle;

	@FindBy(css =metaDescriptionCss)
	WebElement metaDescription;



	public WebElement getManufacturesList(){
		return manufacturer;
	}

	public WebElement getSupplierList(){
		return supplier;
	}

	public WebElement getKeywordsField(){
		return keywords;
	}

	public WebElement getShortDescriptionField(){
		return shortDescription;
	}

	public WebElement getDescriptionField(){
		return description;
	}

	public WebElement getHeadTitleField(){
		return headTitle;
	}

	public WebElement getMetaDescriptionField(){
		return metaDescription;
	}



	public CatalogNewProductInformation(){
		super.getDriver();
		PageFactory.initElements(getDriver(), this);
	}
}
