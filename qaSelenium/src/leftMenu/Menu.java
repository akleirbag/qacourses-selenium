package leftMenu;

import org.openqa.selenium.WebDriver;

public class Menu {
	private MenuEntryController mec;
	
	public MenuEntry get(MenuItemEnum m){
		return mec.get(m);
	}
	
	private Menu(){
		//make default constructor private because driver is required
	}
	
	public Menu(WebDriver driver){
		mec = new MenuEntryController(driver);
		
		mec.register(MenuItemEnum.Appearance);
		MenuEntry ap = mec.get(MenuItemEnum.Appearance);
		ap.register(MenuItemEnum.AppearanceLogotype, "doc-logotype");
		ap.register(MenuItemEnum.AppearanceTemplate, "doc-template");
		
		mec.register(MenuItemEnum.Catalog);
		MenuEntry cat = mec.get(MenuItemEnum.Catalog);
		cat.register(MenuItemEnum.CatalogCatalog, "doc-catalog");
		cat.register(MenuItemEnum.CatalogProductGroups, "doc-product_groups");
		cat.register(MenuItemEnum.CatalogOptionGroups, "doc-option_groups");
		cat.register(MenuItemEnum.CatalogManufacturers, "doc-manufacturers");
		cat.register(MenuItemEnum.CatalogSuppliers, "doc-suppliers");
		cat.register(MenuItemEnum.CatalogDeliveryStatuses, "doc-delivery_statuses");
		cat.register(MenuItemEnum.CatalogSoldOutStatuses, "doc-sold_out_statuses");
		cat.register(MenuItemEnum.CatalogQuantityUnits, "doc-quantity_units");
		cat.register(MenuItemEnum.CatalogCSVImportExport, "doc-csv");
				
		mec.register(MenuItemEnum.Countries);
		MenuEntry cou= mec.get(MenuItemEnum.Countries);
		
		mec.register(MenuItemEnum.Currencies);
		MenuEntry cur= mec.get(MenuItemEnum.Currencies);
		
		mec.register(MenuItemEnum.Customers);
		MenuEntry cus= mec.get(MenuItemEnum.Customers);
		cus.register(MenuItemEnum.CustomersCustomers, "doc-customers");
		cus.register(MenuItemEnum.CustomersCsvImportExport, "doc-csv");
		cus.register(MenuItemEnum.CustomersNewsletter, "doc-newsletter");
		
		mec.register(MenuItemEnum.GeoZones);
		MenuEntry geo= mec.get(MenuItemEnum.GeoZones);
		
		mec.register(MenuItemEnum.Languages);
		MenuEntry lan= mec.get(MenuItemEnum.Languages);
		lan.register(MenuItemEnum.LanguagesLanguages, "doc-languages");
		lan.register(MenuItemEnum.LanguagesStorageEncoding, "doc-storage_encoding");
		
		mec.register(MenuItemEnum.Modules);
		MenuEntry mod= mec.get(MenuItemEnum.Modules);
		mod.register(MenuItemEnum.ModulesBackgroundJobs, "doc-jobs");
		mod.register(MenuItemEnum.ModulesCustomer, "doc-customer");
		mod.register(MenuItemEnum.ModulesShipping, "doc-shipping");
		mod.register(MenuItemEnum.ModulesPayment, "doc-payment");
		mod.register(MenuItemEnum.ModulesOrderTotal, "doc-order_total");
		mod.register(MenuItemEnum.ModulesOrderSuccess, "doc-order_success");
		mod.register(MenuItemEnum.ModulesOrderAction, "doc-order_action");
		
		mec.register(MenuItemEnum.Orders);
		MenuEntry ord= mec.get(MenuItemEnum.Orders);
		ord.register(MenuItemEnum.OrdersOrders, "doc-orders");
		ord.register(MenuItemEnum.OrdersStatuses, "doc-order_statuses");
		
		mec.register(MenuItemEnum.Pages);
		MenuEntry pag= mec.get(MenuItemEnum.Pages);
			
		mec.register(MenuItemEnum.Reports);
		MenuEntry rep= mec.get(MenuItemEnum.Reports);
		rep.register(MenuItemEnum.ReportsMonthlySales, "doc-monthly_sales");
		rep.register(MenuItemEnum.ReportsMostSoldProducts, "doc-most_sold_products");
		rep.register(MenuItemEnum.ReportsMostShippingCustomers, "doc-most_shopping_customers");		
		
		mec.register(MenuItemEnum.Settings);
		MenuEntry set= mec.get(MenuItemEnum.Settings);
		set.register(MenuItemEnum.SettingsStoreInfo, "doc-store_info");
		set.register(MenuItemEnum.SettingsDefaults, "doc-defaults");
		set.register(MenuItemEnum.SettingsGeneral, "doc-general");
		set.register(MenuItemEnum.SettingsListings, "doc-listings");
		set.register(MenuItemEnum.SettingsImages, "doc-images");
		set.register(MenuItemEnum.SettingsCheckout, "doc-checkout");
		set.register(MenuItemEnum.SettingsAdvanced, "doc-advanced");
		set.register(MenuItemEnum.SettingsSecurity, "doc-security");
		
		mec.register(MenuItemEnum.Slides);
		MenuEntry sli= mec.get(MenuItemEnum.Slides);
		
		mec.register(MenuItemEnum.Tax);
		MenuEntry tax= mec.get(MenuItemEnum.Tax);
		tax.register(MenuItemEnum.TaxTaxClasses, "doc-tax_classes");
		tax.register(MenuItemEnum.TaxTaxRates, "doc-tax_rates");
		
		mec.register(MenuItemEnum.Translations);
		MenuEntry tra= mec.get(MenuItemEnum.Translations);
		tra.register(MenuItemEnum.TranslationsSearchTransformations, "doc-search");
		tra.register(MenuItemEnum.TranslationsScanFiles, "doc-scan");
		tra.register(MenuItemEnum.TranslationsCSVImportExport, "doc-csv");
		
		mec.register(MenuItemEnum.Users);
		MenuEntry use= mec.get(MenuItemEnum.Users);
		
		mec.register(MenuItemEnum.VQmods);
		MenuEntry vqm= mec.get(MenuItemEnum.VQmods);
		vqm.register(MenuItemEnum.VQmodsVQmods, "doc-vqmods");
		
		
	}
}
