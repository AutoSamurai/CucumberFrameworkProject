package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class HomePage {

	WebDriver driver;
	private WaitUtils waitUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 30);

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	public void clickOnMyAccount() {

		waitUtils.waitForElementToBeClickable(myAccountDropMenu).click();

	}

	public LoginPage selectLoginOption() {

		waitUtils.waitForElementToBeVisible(loginOption).click();
		return new LoginPage(driver);

	}

	public RegisterPage selectRegisterOption() {

		waitUtils.waitForElementToBeClickable(registerOption).click();
		return new RegisterPage(driver);

	}

}
