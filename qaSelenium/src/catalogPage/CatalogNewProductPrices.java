package catalogPage;

import java.lang.invoke.MethodHandles;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogNewProductPrices extends CatalogNewProduct {

	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());

	private static final String generalContentCss = "div#tab-prices";

	private static final String purchasePriceInputCss = "input[name=purchase_price]";
	private static final String purchasePriceListCss = "select[name=purchase_price_currency_code]";
	private static final String taxPriceCss = "select[name=tax_class_id]";
	private static final String priceUSDCss = "input[name=prices\\[USD\\]]";
	private static final String priceUSDIncludeTaxCss = "input[name=gross_prices\\[USD\\]]";
	private final static String priceEURCss = "input[name=prices\\[EUR\\]]";
	private final static String priceEURIncludeTaxCss = "input[name=gross_prices\\[EUR\\]]";

	public static String getCssSelector(){
		return generalContentCss;
	}

	@FindBy(css =purchasePriceInputCss)
	WebElement prchasePrice;
	
	@FindBy(css =purchasePriceListCss)
	WebElement prchaseListPrice;

	@FindBy(css =taxPriceCss)
	WebElement taxPrice;

	@FindBy(css =priceUSDCss)
	WebElement priceUSD;

	@FindBy(css =priceUSDIncludeTaxCss)
	WebElement priceUSDIncludeTax;

	@FindBy(css =priceEURCss)
	WebElement priceEUR;

	@FindBy(css =priceEURIncludeTaxCss)
	WebElement priceEURIncludeTax;


	public WebElement getPurchasePriceInput(){
		return prchasePrice;
	}
	
	public WebElement getPurchasePriceList(){
		return prchaseListPrice;
	}

	public WebElement getTaxPriceList(){
		return taxPrice;
	}

	public WebElement getPriceUSDField(){
		return priceUSD;
	}

	public WebElement getPriceUSDIncludeTaxField(){
		return priceUSDIncludeTax;
	}

	public WebElement getPriceEUR(){
		return priceEUR;
	}

	public WebElement getPriceEURIncludeTaxField(){
		return priceEURIncludeTax;
	}


	public CatalogNewProductPrices(){
		super.getDriver();
		PageFactory.initElements(getDriver(), this);
	}
}
