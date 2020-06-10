package sauce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {

		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "user-name")
	@CacheLookup
	WebElement txtUser;

	@FindBy(id = "password")
	@CacheLookup
	WebElement txtPWD;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/div/form/input[3]")
	@CacheLookup
	WebElement logbtn;

	@FindBy(tagName = "h3")
	@CacheLookup
	WebElement loginFailedMessage;
	@FindBy(xpath = "//button[@class='error-button']//*[local-name()='svg']")
	@CacheLookup
	WebElement loginErrorButton;
	
	
	
	public void setUsername(String username) throws InterruptedException
	
	{
		
		txtUser.sendKeys(username);

	}
public WebElement getUsernamefield() throws InterruptedException
	
	{
		
		return txtUser;

	}

	public void setPassword(String pwd)
	{
		txtPWD.sendKeys(pwd);

	}
	
	public WebElement getPasswordfield()
	{
		return txtPWD;

	}

	public void clickLogin()
	{
		logbtn.click();

	}

	public WebElement LoginFailedMessage()
	{
		
		return loginFailedMessage;

	}
	public WebElement loginErrorButton()
	{
		
		return loginErrorButton;

	}
}
