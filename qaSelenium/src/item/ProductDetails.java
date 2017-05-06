package item;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BasePage;


public class ProductDetails extends BasePage{

	private final String stickerCss = ".sticker";
	private final String redPriceCss = "div.price-wrapper strong";
	private final String regularPriceCss= "div.price-wrapper s.regular-price";
	private final static String campaignsTitleCss= "div.content h1.title";
	private final String campaignsSubTitleCss= "div.content span.sku";
	private final String quantityCss = "input[name=quantity]";
	private final String addToCartButtonCss = "button[name=add_cart_product]";

	public static String getCssSelector(){
		return campaignsTitleCss;
	}

	@FindBy(css = redPriceCss)
	WebElement redPrice;

	@FindBy(css = regularPriceCss)
	WebElement greyPrice;

	@FindBy(css = campaignsTitleCss)
	WebElement title;

	@FindBy(css = campaignsSubTitleCss)
	WebElement subTitle;

	@FindBy(css = quantityCss)
	WebElement quantity;

	@FindBy(css=addToCartButtonCss)
	WebElement addToCartButton;

	public WebElement getRedPrice(){
		return redPrice;
	}

	public WebElement getRegularPrice(){
		return greyPrice;
	}

	public WebElement getTitle(){
		return title;
	}

	public WebElement getSubTitle(){
		return subTitle;
	}

	public WebElement getQuantity(){
		return quantity;
	}

	public WebElement getAddToCartButton(){
		return addToCartButton;
	}

	public ProductDetails(WebDriver driver) {
		super();
		PageFactory.initElements(getDriver(), this);
	}
}
