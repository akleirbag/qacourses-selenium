package startPage;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import common.BasePage;
import item.Product;


public class StartPage extends BasePage{

	List<Product> productList;
	private static final String campaingBoxCss = "div#box-campaigns";
	
	public void loadProducts(){
		List<WebElement> prods = getDriver().findElements(By.cssSelector(Product.getCssSelector()));
		for (WebElement p:prods){
			Product product = new Product(p);
			productList.add(product);
		}
	}

	public List<Product> getProducts(){
		if(productList.size()== 0){
			loadProducts();
		}
		return productList;
	}
	
	public List<Product> getCampaignProducts(){
		List<Product> ps = new ArrayList<Product>();
		WebElement cBox = getDriver().findElement(By.cssSelector(campaingBoxCss));
		for(WebElement w: cBox.findElements(By.cssSelector(Product.getCssSelector()))){
			ps.add(new Product(w));
		}
		return ps;
	}

	public StartPage( ) {
		super();
		productList= new ArrayList<Product>();
	}



}
