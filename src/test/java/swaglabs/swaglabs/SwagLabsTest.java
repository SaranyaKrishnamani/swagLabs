package swaglabs.swaglabs;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import swaglabs.swaglabs.base.TestBase;
import swaglabs.swaglabs.page.LoginPage;
import swaglabs.swaglabs.page.SwagLabPages;

public class SwagLabsTest extends TestBase {

	@Test
	public void purchaseAProduct() throws InterruptedException {
		new LoginPage().iPerformLogin();
//		SwagLabPages swag = new SwagLabPages();
//		swag.addingAProd();
		// new SwagLabPages().addingAProd(); (Runtime obj creation
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
