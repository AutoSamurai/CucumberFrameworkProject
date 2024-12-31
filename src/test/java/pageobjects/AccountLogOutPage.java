package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class AccountLogOutPage {

	WebDriver driver;
	private WaitUtils waitUtils;

	public AccountLogOutPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 30);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/p[1]")
	private WebElement confirmationMessage;

	public String getLogOutConfirmationMessage() {

		return waitUtils.getTextFromElement(confirmationMessage);

	}

	public Boolean redirectedToLogoutPage(String url) {

		return waitUtils.getCurrentUrlOfWebpage(url);

	}
}
