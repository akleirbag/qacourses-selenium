package test.startPage;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import item.Product;

public class StartPageTest extends StartPageBaseTest{


	@Test
	public void getNumberOfProduct(){
		
		int actual = startPage.getProducts().size();
		int expected = 11;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testStickers(){
		List<Product> products = startPage.getProducts();
		for (Product p: products){
			List<WebElement> stickers = p.getStickers();
			Assert.assertTrue(stickers.size()<2);
		}
	}
}
