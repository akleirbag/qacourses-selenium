package common;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.lang.invoke.MethodHandles;
import org.apache.log4j.Logger;

public class Action {

	protected  static  Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass());

	public static void click(WebElement element){
		if(isDisplayed(element)){
			element.click();
			log.info("Element: " + displayElementsIdentifier(element) + " was clicked");
		}
	}

	public static String getText(WebElement e) {
		return e.getText();
	}

	public static String getAttributeTextContent(WebElement element){
		return element.getAttribute("textContent");
	}
	

	public static String getValue(WebElement element){
		return element.getAttribute("value");
	}

	/**
	 * Compares two Strings to check if they have the same text. Uses regular
	 * expression if first check (.equals) fails. Only s2 may contain regular
	 * expressions!
	 * 
	 * @param s1
	 *            - fetched String that will be compared with s2
	 * @param s2
	 *            - may compare regular expressions
	 * @return true if Strings contain the same text, false otherwise
	 */

	public static boolean compareStrings(String s1, String s2) {
		//	log.info("Comparing strings- string1: " + s1 + " string2: " + s2);

		if (s1.equals(s2)) {
			//		log.info("Strings match");
			return true;
		} else {
			// If first comparison fails try with regular expression
			if (s1.matches(s2)) {
				//			log.info("Strings match");
				return true;
			} else {
				//				log.error("Strings do not match");
				//				log.info("String 1: " + s1);
				//				log.info("String 2: " + s2);
				return false;
			}
		}
	}

	/**
	 * Check if element is displayed on page.
	 * 
	 * @param e
	 *            - web element to be checked
	 * @return true if element is displayed, false otherwise
	 */
	public static boolean isDisplayed(WebElement e) {
		try {
			if (e.isDisplayed()) {
				log.info("Element: " + displayElementsIdentifier(e)
				+ " is displayed");
				return true;
			} else {
				log.info("Element: " + displayElementsIdentifier(e)
				+ " is not displayed");
				return false;
			}
		} catch (NoSuchElementException ex) {
			// element was not found on page, thus it is not displayed
			return false;
		}
	}

	public static void selectCheckBox(WebElement element){
		if(!element.isSelected()){
			click(element);
		}
		else{
			log.info("selectCheckBox(): checkbox was selected");
		}
	}
	
	public static void deselectCheckBox(WebElement element){
		if(element.isSelected()){
			click(element);
		}
		else{
			log.info("selectCheckBox(): checkbox was deselected");
		}
	}


	/**
	 * Method will fetch element's identifier e.g. xpath, id. Used to add proper
	 * text into console during execution.
	 * 
	 * @param e
	 *            - web element
	 * @return String with identifier
	 */

	public static String displayElementsIdentifier(WebElement e) {
		try {
			// Fetch original text from toString method
			String original = e.toString();
			// get index of the string after which the identifier occurs
			int start = original.indexOf("->");
			// remove the part of the string that doesn't interest us
			String s = original.substring(start, original.length() - 1);
			return s;
		} catch (StringIndexOutOfBoundsException exception) {
			log.info("String index out of bounds. Returning default toString result.");
		}
		return e.toString();
	}


	public static void sendKeys(WebElement e, String text) {
		e.clear();
		e.sendKeys(text);
		log.info("Element: " + Action.displayElementsIdentifier(e)
		+ " was filled with text: " + text);

	}
	
	public static void selectList(WebElement e, String text){
		Select select = new Select(e);
		select.selectByVisibleText(text);
		log.info("Element select list: "
		+ " was filled with text: " + text);
	}
	
	public static String getFirstSelectedOption(WebElement e){
		Select select = new Select(e);
		return select.getFirstSelectedOption().getText();
	}
	

}