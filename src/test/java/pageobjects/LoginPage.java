package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class LoginPage {

	WebDriver driver;
	private WaitUtils waitUtils;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 30);

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@id='account-login']/div[1]")
	private WebElement warningMessage;

	public void enterEmailAddress(String emailText) {

		waitUtils.waitForElementToBeVisible(emailField).sendKeys(emailText);

	}

	public void enterPassword(String passwordText) {

		waitUtils.waitForElementToBeVisible(passwordField).sendKeys(passwordText);

	}

	public AccountPage clickOnLoginButton() {

		waitUtils.waitForElementToBeClickable(loginButton).click();
		return new AccountPage(driver);

	}

	public String getWarningMessageText() {

		return waitUtils.getTextFromElement(warningMessage);

	}

}
