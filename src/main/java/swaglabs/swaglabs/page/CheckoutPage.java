package swaglabs.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import swaglabs.swaglabs.pageactions.CommonActions;

public class CheckoutPage extends CommonActions {

	public void iCheckItemName() {
		/* Validating if the selected product is available in the cart */
		WebElement addedItem = driver.findElement(By.xpath("(//div[@class = 'inventory_item_name'])[1]"));
		String addedItemName = addedItem.getText();
		if (selectedTShirtName.equals(addedItemName)) {
			System.out.println("Item Added successfully");
		}
	}

	public void iClickOnCheckout() {
		/* Checking out the Item */
		WebElement checkOutBtn = driver.findElement(By.xpath("//a[@class = 'btn_action checkout_button']"));
		iClickOnWebElement(checkOutBtn, "Check Out");
	}
}
