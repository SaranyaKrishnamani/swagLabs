package swaglabs.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import swaglabs.swaglabs.pageactions.CommonActions;

public class PersonalInfoPage extends CommonActions {
	public void iValidatePersonalInfo() {

		/* Entering the Personal Info */
		WebElement firstName = driver.findElement(By.xpath("//input[@id = 'first-name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id = 'last-name']"));
		WebElement postalCode = driver.findElement(By.xpath("//input[@id = 'postal-code']"));
		WebElement continueBtn = driver.findElement(By.xpath("//input[@class = 'btn_primary cart_button']"));
		iSendInputs(firstName, "QA", "First Name");
		iSendInputs(lastName, "Automation", "Last Name");
		iSendInputs(postalCode, "600094", "Postal Code");
		iClickOnWebElement(continueBtn, "Continue");

	}

}
