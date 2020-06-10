package sauce.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sauce.PageObject.LoginPage;
import sauce.PageObject.ProductPage;
import sauce.Utilities.XLUtils;

public class LoginTC_DD_002 extends BaseClass {


	@Test(dataProvider = "LoginData")
	public void LoginDD(String user, String pwd) throws InterruptedException, IOException {
	
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.getUsernamefield().clear();
		loginpage.setUsername(user);
		Thread.sleep(1000);
		
		loginpage.getPasswordfield().clear();
		loginpage.setPassword(pwd);
		loginpage.clickLogin();
		
	
		ProductPage PP = new ProductPage(driver);	
		  
		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
			
			logger.info("Product Page is Loaded");
		
			PP.clicksideMenu();
			
			Actions action = new Actions(driver);
			WebElement we = driver.findElement(By.xpath("//div[@class='bm-menu']"));
			action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]"))).click().build().perform();
			Thread.sleep(3000);
			Assert.assertTrue(true);
			
			
			

		} else if(driver.getCurrentUrl().equals("https://www.saucedemo.com/index.html")){
			
			captureScreenShort(driver,"LoginDD");
			Thread.sleep(2000);
			logger.info("Product Page is not Loaded");	
			loginpage.loginErrorButton().click();					
			Assert.assertTrue(false);
			
		}
		
		
				
	}

	/*public boolean isMessageAppear() {
		
		boolean crossbtn = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/form/h3/button/svg/path")).isDisplayed();

		if (crossbtn==true) {
			return true;
		} else {
			return false;
		}

	}*/

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\sauce\\TestData\\Login_Data.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int columncount = XLUtils.getcellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][columncount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < columncount; j++) {

				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);

			}

		}

		return logindata;
	}

}
