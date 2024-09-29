package swaglabs.swaglabs.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swaglabs.swaglabs.pageactions.CommonActions;

public class LoginPage extends CommonActions {

	@FindBy(xpath="//input[@id='user-name']")
	public WebElement userName;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "login-button")
	WebElement login;

	public void LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void iPerformLogin() throws InterruptedException {
		System.out.println(userName);
		System.out.println(driver);
		iSendInputs(userName, "standard_user", "User Name");
		iSendInputs(pwd, "secret_sauce", "Password");
		iClickOnWebElement(login, "Login");
	}
}
