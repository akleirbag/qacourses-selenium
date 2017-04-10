package item;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gargoylesoftware.htmlunit.Page;

import common.BasePage;


public class Product extends BasePage{

	WebElement productElement;

	List<WebElement> stickersList;

	private static final String productCss = ".product.column.shadow.hover-light";
	private final String stickerCss = ".sticker";
	private final String redPriceCss = "strong";
	private final String regularPriceCss= "s.regular-price";
	private final String priceCss= "span.price";
	private final String titleCss= "div.name";
	private final String subTitleCss= "div.manufacturer";

	public static String getCssSelector(){
		return productCss;
	}

	public WebElement getProductElement(){
		return productElement;
	}

	public List<WebElement> getStickers(){
		stickersList = productElement.findElements(By.cssSelector(stickerCss));
		return stickersList;
	}	

	WebElement redPrice;
	WebElement regularPrice;
	WebElement price;
	WebElement title;
	WebElement subTitle;

	public WebElement getRedPrice(){
		return redPrice;
	}
	
	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getRegularPrice(){
		return regularPrice;
	}

	public WebElement getTitle(){
		return title;
	}

	public WebElement getSubTitle(){
		return subTitle;
	}

	public Product(WebElement product) {
		super();
		productElement = product;
		title = product.findElement(By.cssSelector(titleCss));
		subTitle = product.findElement(By.cssSelector(subTitleCss));
		try{
			regularPrice = product.findElement(By.cssSelector(regularPriceCss));
		} catch (Exception e){	
		}
		try{
			price = product.findElement(By.cssSelector(priceCss));
		} catch (Exception e){	
		}
		try{
			redPrice = product.findElement(By.cssSelector(redPriceCss));
		} catch (Exception e){	
		}

	}
}
