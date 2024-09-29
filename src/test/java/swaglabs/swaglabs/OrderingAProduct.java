package swaglabs.swaglabs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderingAProduct {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/* Login to the Website */
		driver.get("https://www.saucedemo.com/v1/");
		WebElement userName = driver.findElement(By.xpath("//input[@id = 'user-name']"));
		userName.sendKeys("standard_user");
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("secret_sauce");
		WebElement login = driver.findElement(By.id("login-button"));
		login.click();
		Thread.sleep(3000);

		/* Validating the landing page by checking the logout in menu items */
		WebElement menuBtn = driver.findElement(By.xpath("//button[text() = 'Open Menu']"));
		menuBtn.click();

//		List<WebElement> menuItems = driver.findElements(By.xpath("//a[@class = 'bm-item menu-item']"));
//		System.out.println(menuItems.get(0).getText());
//
//		for (WebElement i : menuItems) {
//			System.out.println(i.getText());
//			if (i.getText() == "Logout") {
//				System.out.println("Login Successful");
//			}
//		}
		// isDisplayed()
		WebElement thirdElmt = driver.findElement(By.xpath("//a[text() = 'Logout']"));
		WebElement closeMenuItems = driver.findElement(By.xpath("//button[text() = 'Close Menu']"));
		// System.out.println(thirdElmt.getAccessibleName());
		String thirdElmtName = thirdElmt.getAccessibleName();
		if (thirdElmtName.equalsIgnoreCase("Logout")) {
			System.out.println("Login Successful");
		}
		// else{ syso("Issue");}
		Thread.sleep(3000);
		closeMenuItems.click();
		Thread.sleep(3000);

		/* Adding a product to the cart */
		WebElement addTShirt = driver.findElement(By.xpath("(//button[text() = 'ADD TO CART'])[3]"));
		WebElement selectedTShirt = driver.findElement(By.xpath("(//div[@class = 'inventory_item_name'])[3]"));
		String selectedTShirtName = selectedTShirt.getText();
		addTShirt.click();

		WebElement cart = driver.findElement(By.xpath("//a[@class = 'shopping_cart_link fa-layers fa-fw']"));
		// WebElement addedItemName = driver.findElement(By.xpath("(//div[@class =
		// 'inventory_item_name'])[1]"));
		cart.click();
		/* Validating if the selected product is available in the cart */
		WebElement addedItem = driver.findElement(By.xpath("(//div[@class = 'inventory_item_name'])[1]"));
		String addedItemName = addedItem.getText();
		if (selectedTShirtName.equals(addedItemName)) {
			System.out.println("Item Added successfully");
		}
		/* Checking out the Item */
		WebElement checkOutBtn = driver.findElement(By.xpath("//a[@class = 'btn_action checkout_button']"));
		checkOutBtn.click();
		/* Entering the Personal Info */
		WebElement firstName = driver.findElement(By.xpath("//input[@id = 'first-name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id = 'last-name']"));
		WebElement postalCode = driver.findElement(By.xpath("//input[@id = 'postal-code']"));
		WebElement continueBtn = driver.findElement(By.xpath("//input[@class = 'btn_primary cart_button']"));
		firstName.sendKeys("QA");
		lastName.sendKeys("Automation");
		postalCode.sendKeys("600094");// driver.quit();
		continueBtn.click();
		/* Checking pricing */
		WebElement itemPrice = driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']"));
		WebElement taxPrice = driver.findElement(By.xpath("//div[@class = 'summary_tax_label']"));
		WebElement totalPrice = driver.findElement(By.xpath("//div[@class = 'summary_total_label']"));

		// System.out.println(itemPrice.getText().substring(13, 18));

		/* Getting the dollar position of ItemPrice and tax price and ui total */
		int dollarPosnOfItemPrice = itemPrice.getText().indexOf("$");
		System.out.println(dollarPosnOfItemPrice + 1);
		String orgPrice = itemPrice.getText().substring(dollarPosnOfItemPrice + 1);
		Double oPrice = Double.valueOf(orgPrice);
		// System.out.println(oPrice);

		int dollarPosnOfTaxPrice = taxPrice.getText().indexOf("$");
		String taxPrice2 = taxPrice.getText().substring(dollarPosnOfTaxPrice + 1);
		Double tPrice = Double.valueOf(taxPrice2);
		// System.out.println(tPrice);

		int dollarPosnOfTotalPrice = totalPrice.getText().indexOf("$");
		String totPrice = totalPrice.getText().substring(dollarPosnOfTotalPrice + 1);
		Double uiTotalPrice = Double.valueOf(totPrice);
		// System.out.println(uiTotalPrice);

		Double total = Double.sum(tPrice, oPrice);
		// System.out.println(total);
//		if (uiTotalPrice == total) {
//			System.out.println("Total is correct");
//		}
//		if(Double.compare(uiTotalPrice, total)) {
//			System.out.println("Total is correct");
//		}
		int compare = Double.compare(uiTotalPrice, total);
		if (compare == 0) {
			System.out.println("Total is correct");
		}

		/* Clicking the Finish btn */
		WebElement finishBtn = driver.findElement(By.xpath("//a[@class = 'btn_action cart_button']"));
		finishBtn.click();

		/* Confirming the order has been placed */
		WebElement confirmTxt = driver.findElement(By.xpath("//h2[@class = 'complete-header']"));
		if (confirmTxt.getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER")) {
			System.out.println("Order has been placed successfully");
		}
		Thread.sleep(3000);
		driver.close();
	}

}
