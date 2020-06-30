package parser.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DateParserPage {

	WebDriver ldriver;

	public DateParserPage(WebDriver rdriver) {

		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@placeholder='date']")
	WebElement txtDate;

	@FindBy(xpath = "//input[@class='btn btn-default']")
	WebElement subbtn;

	@FindBy(xpath = "//div[contains(text(),'Tue Mar 17 2020 00:00:00 GMT+0000')]")
	WebElement resultDateMessage;

	public void setDate(String date) throws InterruptedException

	{
		txtDate.sendKeys(date);

	}
	public WebElement getDate() throws InterruptedException

	{
		return txtDate;

	}

	public void clickSubmitButton() {
		subbtn.click();

	}

	public WebElement getresultDate() {

		return resultDateMessage;

	}

}
