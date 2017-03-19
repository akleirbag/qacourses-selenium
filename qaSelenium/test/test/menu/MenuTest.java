package test.menu;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import leftMenu.Menu;
import leftMenu.MenuEntry;
import leftMenu.MenuItemEnum;
import test.common.BaseTest;

public class MenuTest  extends BaseTest{

	Menu menu;
	List<MenuTestHelper> expected;

	private static final String headerCSS ="#content > h1";
	private static final String selectedMenuColor = "rgb(255, 0, 0)";
	
	public void waitUntilSubmenuTextColorIs(MenuEntry menu, MenuItemEnum submenu, String expColor){
		
		new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) { 
	        	String col = "none";
	        	try {
	        		col = menu.getSubMenuElement(submenu).getCssValue("color");
	        	} catch (Exception e){
	        		System.out.println(e.getMessage());
	        	}
	    		System.out.println("Wait: current color " + col + ", expected: " + expColor);
	            return expColor.equals(col);
	        }
	    });
	}

	@BeforeClass 
	public void create(){
		menu = new Menu(getDriver());
		expected = new ArrayList<MenuTestHelper>();
		System.out.println("MenuTest:setup");
	}



	@Test
	public void checkMenu(){
		System.out.println("MenuTest:checkMenu");
		//wait just in case
		
		MenuEntry app = menu.get(MenuItemEnum.Appearance);
		getWait().untilVisibility(app.getCssSelector());

		//add expected values
		expected.add(new MenuTestHelper(MenuItemEnum.Appearance, MenuItemEnum.Appearance, "Template"));
		expected.add(new MenuTestHelper(MenuItemEnum.Appearance, MenuItemEnum.AppearanceTemplate, "Template"));
		expected.add(new MenuTestHelper(MenuItemEnum.Appearance, MenuItemEnum.AppearanceLogotype, "Logotype"));

		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.Catalog, "Catalog"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogCatalog, "Catalog"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogProductGroups, "Product Groups"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogOptionGroups, "Option Groups"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogManufacturers, "Manufacturers"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogSuppliers, "Suppliers"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogDeliveryStatuses, "Delivery Statuses"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogSoldOutStatuses, "Sold Out Statuses"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogQuantityUnits, "Quantity Units"));
		expected.add(new MenuTestHelper(MenuItemEnum.Catalog, MenuItemEnum.CatalogCSVImportExport, "CSV Import/Export"));
			
		expected.add(new MenuTestHelper(MenuItemEnum.Countries, MenuItemEnum.Countries, "Countries"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Currencies, MenuItemEnum.Currencies, "Currencies"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Customers, MenuItemEnum.Customers, "Customers"));
		expected.add(new MenuTestHelper(MenuItemEnum.Customers, MenuItemEnum.CustomersCustomers, "Customers"));
		expected.add(new MenuTestHelper(MenuItemEnum.Customers, MenuItemEnum.CustomersCsvImportExport, "CSV Import/Export"));
		expected.add(new MenuTestHelper(MenuItemEnum.Customers, MenuItemEnum.CustomersNewsletter, "Newsletter"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.GeoZones, MenuItemEnum.GeoZones, "Geo Zones"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Languages, MenuItemEnum.Languages, "Languages"));
		expected.add(new MenuTestHelper(MenuItemEnum.Languages, MenuItemEnum.LanguagesLanguages, "Languages"));
		expected.add(new MenuTestHelper(MenuItemEnum.Languages, MenuItemEnum.LanguagesStorageEncoding, "Storage Encoding"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.Modules, "Job Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesBackgroundJobs, "Job Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesCustomer, "Customer Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesShipping, "Shipping Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesPayment, "Payment Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesOrderTotal, "Order Total Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesOrderSuccess, "Order Success Modules"));
		expected.add(new MenuTestHelper(MenuItemEnum.Modules, MenuItemEnum.ModulesOrderAction, "Order Action Modules"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Orders, MenuItemEnum.Orders, "Orders"));
		expected.add(new MenuTestHelper(MenuItemEnum.Orders, MenuItemEnum.OrdersOrders, "Orders"));
		expected.add(new MenuTestHelper(MenuItemEnum.Orders, MenuItemEnum.OrdersStatuses, "Order Statuses"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Pages, MenuItemEnum.Pages, "Pages"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Reports, MenuItemEnum.Reports, "Monthly Sales"));
		expected.add(new MenuTestHelper(MenuItemEnum.Reports, MenuItemEnum.ReportsMonthlySales, "Monthly Sales"));
		expected.add(new MenuTestHelper(MenuItemEnum.Reports, MenuItemEnum.ReportsMostSoldProducts, "Most Sold Products"));
		expected.add(new MenuTestHelper(MenuItemEnum.Reports, MenuItemEnum.ReportsMostShippingCustomers, "Most Shopping Customers"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.Settings, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsStoreInfo, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsDefaults, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsGeneral, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsListings, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsImages, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsCheckout, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsAdvanced, "Settings"));
		expected.add(new MenuTestHelper(MenuItemEnum.Settings, MenuItemEnum.SettingsSecurity, "Settings"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Slides, MenuItemEnum.Slides, "Slides"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Tax, MenuItemEnum.Tax, "Tax Classes"));
		expected.add(new MenuTestHelper(MenuItemEnum.Tax, MenuItemEnum.TaxTaxClasses, "Tax Classes"));
		expected.add(new MenuTestHelper(MenuItemEnum.Tax, MenuItemEnum.TaxTaxRates, "Tax Rates"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Translations, MenuItemEnum.Translations, "Search Translations"));
		expected.add(new MenuTestHelper(MenuItemEnum.Translations, MenuItemEnum.TranslationsSearchTransformations, "Search Translations"));
		expected.add(new MenuTestHelper(MenuItemEnum.Translations, MenuItemEnum.TranslationsScanFiles, "Scan Files For Translations"));
		expected.add(new MenuTestHelper(MenuItemEnum.Translations, MenuItemEnum.TranslationsCSVImportExport, "CSV Import/Export"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.Users, MenuItemEnum.Users, "Users"));
		
		expected.add(new MenuTestHelper(MenuItemEnum.VQmods, MenuItemEnum.VQmods, "vQmods"));
		expected.add(new MenuTestHelper(MenuItemEnum.VQmods, MenuItemEnum.VQmodsVQmods, "vQmods"));
		
		MenuItemEnum currentMenu = MenuItemEnum.VQmods;
		for (MenuTestHelper exp:expected){
			MenuEntry menuEn = menu.get(exp.menu);
			
			//click if we're no in this menu
			if (exp.menu != currentMenu){
				menuEn.getMenuElement().click();
				//check header
				getWait().untilTextIs(headerCSS, exp.title);
				currentMenu = exp.menu;
				System.out.println("Click on menu " + exp.menu );
			}
			
			//click if submenu is required
			if (exp.submenu != exp.menu){
				WebElement subm = menuEn.getSubMenuElement(exp.submenu);
				System.out.println("Click on submenu " + exp.submenu );
				subm.click();
				//wait until submenu changes color
				waitUntilSubmenuTextColorIs(menuEn, exp.submenu, selectedMenuColor);
			}

			WebElement getHeader = driver.findElement(By.cssSelector(headerCSS));
			String textHeader = getHeader.getText();
			Assert.assertEquals(exp.title, textHeader);
			System.out.println(textHeader);
		}	
	}

	public class MenuTestHelper{
		public MenuItemEnum menu;
		public MenuItemEnum submenu;
		public String title;

		public MenuTestHelper(MenuItemEnum m, MenuItemEnum sm, String t){
			menu = m;
			submenu = sm;
			title = t;
		}
	}


}