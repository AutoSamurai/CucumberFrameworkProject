package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class AccountPage {

	WebDriver driver;
	private WaitUtils waitUtils;

	public AccountPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 30);

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement confirmationMessage;

	@FindBy(linkText = "Logout")
	WebElement signOutButton;

	public boolean displayStatusOfConfirmationMessage() {

		return waitUtils.displayStatusOfElement(confirmationMessage);

	}

	public AccountLogOutPage clickOnSignoutButton() {

		waitUtils.waitForElementToBeClickable(signOutButton).click();
		return new AccountLogOutPage(driver);

	}

}
