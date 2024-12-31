package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class AccountSuccessPage {

	WebDriver driver;
	private WaitUtils waitUtils;

	public AccountSuccessPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 30);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement pageHeading;

	public String getPageHeading() {

		return waitUtils.getTextFromElement(pageHeading);

	}
}
