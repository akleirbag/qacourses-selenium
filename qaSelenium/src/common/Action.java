package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Action {
	
	public static void click(WebElement element){
		if(isDisplayed(element)){
			element.click();
		}
	}
	public static String getText(WebElement e) {
		return e.getText();
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
	//			log.info("Element: " + Utils.displayElementsIdentifier(e)
	//					+ " is displayed");
				return true;
			} else {
		//		log.info("Element: " + Utils.displayElementsIdentifier(e)
		//				+ " is not displayed");
				return false;
			}
		} catch (NoSuchElementException ex) {
			// element was not found on page, thus it is not displayed
			return false;
		}
	}
}
