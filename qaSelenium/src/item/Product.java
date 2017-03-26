package item;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.BasePage;


public class Product extends BasePage{

	WebElement productElement;

	List<WebElement> stickersList;

	private static final String productCss = ".product.column.shadow.hover-light";
	private final String stickerCss = ".sticker";

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

	public Product(WebDriver driver, WebElement product) {
		super();
		productElement = product;
	}
}
