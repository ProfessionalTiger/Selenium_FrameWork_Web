package sauce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver ldriver;

	public ProductPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[1]/div[3]/div")
	@CacheLookup
	WebElement proPageTitle;
	
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div[3]/div/button")
	@CacheLookup
	WebElement sideMenu;
	
	@FindBy(xpath = "//*[@id=\\\"logout_sidebar_link\\")
	@CacheLookup
	WebElement logout;
	

	
	public String getProTitle()
	{
		
		String ProductPageTitle= proPageTitle.getText();
		return ProductPageTitle;
		
	}
	
	public void clicksideMenu()
	{
		
		sideMenu.click();
		
	}
	public WebElement getlogout()
	{
		
		 return logout;
		
	}
	
	
}
