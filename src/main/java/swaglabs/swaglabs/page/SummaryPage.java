package swaglabs.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import swaglabs.swaglabs.pageactions.CommonActions;

public class SummaryPage extends CommonActions {

	public void iCompletePurchase() throws InterruptedException {

		/* Checking pricing */
		WebElement itemPrice = driver.findElement(By.xpath("//div[@class = 'summary_subtotal_label']"));
		WebElement taxPrice = driver.findElement(By.xpath("//div[@class = 'summary_tax_label']"));
		WebElement totalPrice = driver.findElement(By.xpath("//div[@class = 'summary_total_label']"));

		/* Getting the dollar position of ItemPrice and tax price and ui total */
		int dollarPosnOfItemPrice = itemPrice.getText().indexOf("$");
		String orgPrice = itemPrice.getText().substring(dollarPosnOfItemPrice + 1);
		Double oPrice = Double.valueOf(orgPrice);

		int dollarPosnOfTaxPrice = taxPrice.getText().indexOf("$");
		String taxPrice2 = taxPrice.getText().substring(dollarPosnOfTaxPrice + 1);
		Double tPrice = Double.valueOf(taxPrice2);

		int dollarPosnOfTotalPrice = totalPrice.getText().indexOf("$");
		String totPrice = totalPrice.getText().substring(dollarPosnOfTotalPrice + 1);
		Double uiTotalPrice = Double.valueOf(totPrice);

		Double total = Double.sum(tPrice, oPrice);
		int compare = Double.compare(uiTotalPrice, total);
		if (compare == 0) {
			System.out.println("Total is correct");
		}
		/* Clicking the Finish btn */
		WebElement finishBtn = driver.findElement(By.xpath("//a[@class = 'btn_action cart_button']"));
		iClickOnWebElement(finishBtn, "Finish");

		/* Confirming the order has been placed */
		WebElement confirmTxt = driver.findElement(By.xpath("//h2[@class = 'complete-header']"));
		if (confirmTxt.getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER")) {
			System.out.println("Order has been placed successfully");
		}
		Thread.sleep(3000);
	}
}
