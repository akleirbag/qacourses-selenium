package test.startPage;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.Action;
import components.Header;
import item.Product;
import item.ProductDetails;

public class StartPageTest extends StartPageBaseTest{

	/*@Parameters({"productAmount"})
	@Test
	public void getNumberOfProduct(int productAmount){

		int actual = startPage.getProducts().size();
		Assert.assertEquals(productAmount, actual);
	}*/

	@Test
	public void testStickers(){
		List<Product> products = startPage.getProducts();
		for (Product p: products){
			List<WebElement> stickers = p.getStickers();
			Assert.assertTrue(stickers.size()<2);
		}
	}

	@Parameters({"detailsTitle"})
	@Test
	public void getCheckProduct(String detailsTitle){
		Product first = startPage.getCampaignProducts().get(0);
		String title = Action.getAttributeTextContent(first.getTitle()).trim();
		String regularPrice = Action.getAttributeTextContent(first.getRegularPrice()).trim();
		String campaingsPrice = Action.getAttributeTextContent(first.getRedPrice()).trim();

		Assert.assertEquals(first.getRegularPrice().getCssValue("text-decoration"),"line-through") ;
		Assert.assertEquals(first.getRegularPrice().getCssValue("color"),"rgb(119, 119, 119)") ;

		Assert.assertEquals(first.getRedPrice().getCssValue("color"),"rgb(204, 0, 0)") ;
		Assert.assertTrue(Integer.valueOf(first.getRedPrice().getCssValue("font-weight"))>=700) ;

		Action.click(first.getProductElement());
		getWait().untilTextIs(ProductDetails.getCssSelector(), detailsTitle);

		ProductDetails productDetails = new ProductDetails(getDriver());

		String detaisTitle = Action.getAttributeTextContent(productDetails.getTitle()).trim();
		String detailsRegularPrice = Action.getAttributeTextContent(productDetails.getRegularPrice()).trim();
		String detailsCampaingsPrice = Action.getAttributeTextContent(productDetails.getRedPrice()).trim();

		Assert.assertEquals(title, detaisTitle);
		Assert.assertEquals(regularPrice, detailsRegularPrice);
		Assert.assertEquals(campaingsPrice, detailsCampaingsPrice);

		Assert.assertEquals(productDetails.getRegularPrice().getCssValue("text-decoration"),"line-through") ;
		Assert.assertEquals(productDetails.getRegularPrice().getCssValue("color"),"rgb(102, 102, 102)") ;

		Assert.assertEquals(productDetails.getRedPrice().getCssValue("color"),"rgb(204, 0, 0)") ;
		Assert.assertTrue(Integer.valueOf(productDetails.getRedPrice().getCssValue("font-weight"))>=700) ;
	}


	@Parameters({"detailsTitle", "productNumber", "quantity"})
	@Test
	public void chooseAndOpenProductDetails(String detailsTitle, int productNumber, String quantity){
		Product first = startPage.getProducts().get(productNumber);
		String title = Action.getAttributeTextContent(first.getTitle()).trim();
		String price = Action.getAttributeTextContent(first.getPrice()).trim();

		Action.click(first.getProductElement());
		getWait().untilTextIs(ProductDetails.getCssSelector(), detailsTitle);

		ProductDetails productDetails = new ProductDetails(getDriver());
		WebElement quantityField = productDetails.getQuantity();
		Action.sendKeys(quantityField, quantity);
		String quantityText = Action.getAttributeTextContent(quantityField);
		Action.click(productDetails.getAddToCartButton());
		
	
		
		if( nowa != stara ||)

		Assert.assertEquals(title, detailsTitle);

	}
}
