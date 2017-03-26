package browser;


public class BrowserFactory {
	//private static WebDriver driver = null;
	private static Browser browser = null;
	
	public static Browser getBrowser(String browserName){
		if (browser == null){
			switch (browserName.toLowerCase()){
			case "firefox":
				browser = new Firefox();
				break;
			case "ie":
				browser = new IE();
				break;
			case "chrome":
				browser = new Chrome();
				break;
			default:
				System.err.println("Unknown browser" + browser);
			}
			browser.open();
		//	driver = browser.getDriver();
		}
		
		return browser;
	}
	
	public static Browser getBrowser(){
		return browser;
	}
	
	public static void clearBrowser(){
		browser = null;
		//driver = null;
	}
}
