package swaglabs.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglabs.swaglabs.pageactions.CommonActions;

public class ProductSelectionPage extends CommonActions {
	@FindBy(xpath = "//button[text() = 'Open Menu']")
	WebElement menuBtn;

	@FindBy(xpath = "//a[text() = 'Logout']")
	WebElement thirdElmt;

	@FindBy(xpath = "//button[text() = 'Close Menu']")
	WebElement closeMenuItems;

	@FindBy(xpath = "(//button[text() = 'ADD TO CART'])[3]")
	WebElement addTShirt;

	@FindBy(xpath = "(//div[@class = 'inventory_item_name'])[3]")
	WebElement selectedTShirt;

	@FindBy(xpath = "//a[@class = 'shopping_cart_link fa-layers fa-fw']")
	WebElement cart;

	public void ProductSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	public void iValidateLandingPg() throws InterruptedException {
		iClickOnWebElement(menuBtn, "Open Menu");
		String thirdElmtName = thirdElmt.getAccessibleName();
		if (thirdElmtName.equalsIgnoreCase("Logout")) {
			System.out.println("Login Successful");
		}
		iClickOnWebElement(closeMenuItems, "Close Menu Items");
	}

	public void iSelectAProd() {
		/* Adding a product to the cart */
		selectedTShirtName = selectedTShirt.getText();
		iClickOnWebElement(addTShirt, "ADD TO CART");
		iClickOnWebElement(cart, "Cart");

	}
}
