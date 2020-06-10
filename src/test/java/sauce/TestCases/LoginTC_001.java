package sauce.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import sauce.PageObject.LoginPage;
import sauce.PageObject.ProductPage;

public class LoginTC_001 extends BaseClass {

	@Test
	public void loginTest() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		ProductPage PP = new ProductPage(driver);		
		
	   lp.setUsername(username);
		logger.info("Enter Username");

		lp.setPassword(pwd);
		logger.info("Enter Password");

		lp.clickLogin();

		String ProPageTitle = PP.getProTitle();
		

		if (ProPageTitle.equals("Products")) {
			
			logger.info("Product Page is Loaded");
			
			PP.clicksideMenu();
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//div[@class='bm-menu']"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"))).click().build().perform();
			Thread.sleep(3000);
			Assert.assertTrue(true);
			

		} else {

			captureScreenShort(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Product Page is not Loaded");
			
			
			
		}

	}

}
