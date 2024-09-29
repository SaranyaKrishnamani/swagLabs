package swaglabs.swaglabs.pageactions;

import org.openqa.selenium.WebElement;

import swaglabs.swaglabs.base.TestBase;

public class CommonActions extends TestBase {

	public void iClickOnWebElement(WebElement ele, String eleName) {
		try {
			ele.click();
			System.out.println("Click is performed on the element " + eleName);
		} catch (Exception e) {
			System.err.println("Issue with the element " + eleName);
			e.printStackTrace();
		}
	}

	public void iSendInputs(WebElement e, String eValue, String eName) {
		try {
			e.sendKeys(eValue);
			System.out.println(eValue + " is the input given on the " + eName);
		} catch (Exception exc) {
			System.err.println("Issue with the element " + eName);// no such ele vs ele nt found
			exc.printStackTrace();
		}
	}
}