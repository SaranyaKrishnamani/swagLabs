package swaglabs.swaglabs.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver;
	public static String selectedTShirtName ;
	@BeforeTest
	public void iLaunchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		/* Login to the Website */
		driver.get("https://www.saucedemo.com/v1/");
		System.out.println("Browser is launched and the url is opened");
	}

}
