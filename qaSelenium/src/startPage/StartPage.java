package startPage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.BasePage;
import item.Product;


public class StartPage extends BasePage{

	List<Product> productList;

	public void loadProducts(){
		List<WebElement> prods = getDriver().findElements(By.cssSelector(Product.getCssSelector()));
		for (WebElement p:prods){
			Product product = new Product(getDriver(), p);
			productList.add(product);
		}
	}

	public List<Product> getProducts(){
		if(productList.size()== 0){
			loadProducts();
		}
		return productList;
	}

	public StartPage(WebDriver driver) {
		super(driver);
		productList= new ArrayList<Product>();
	}



}
