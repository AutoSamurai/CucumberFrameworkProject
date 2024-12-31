package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtils;

public class RegisterPage {

	WebDriver driver;
	private WaitUtils waitUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		this.waitUtils = new WaitUtils(driver, 60);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyOption;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement YesNewsletterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWaring;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
    public void enterFirstName(String firstName) {
		
    	waitUtils.waitForElementToBeVisible(firstNameField).sendKeys(firstName);
		
	}
	
	public void enterLastName(String lastName) {
		
		waitUtils.waitForElementToBeVisible(lastNameField).sendKeys(lastName);
		
	}
	
	public void enterEmailAddress(String email) {
		
		waitUtils.waitForElementToBeVisible(emailField).sendKeys(email);
		
	}
	
	public void enterTelephoneNumber(String telephone) {
			
		waitUtils.waitForElementToBeVisible(telephoneField).sendKeys(telephone);
		
	}
	
	public void enterPassword(String password) {
		
		waitUtils.waitForElementToBeVisible(passwordField).sendKeys(password);
		
	}
	
	public void enterConfirmPassword(String password) {
		
		waitUtils.waitForElementToBeVisible(passwordConfirmField).sendKeys(password);
	
	}
	
	public void selectPrivacyPolicy() {
		
		waitUtils.waitForElementToBeClickable(privacyPolicyOption).click();
		
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		
		waitUtils.waitForElementToBeClickable(continueButton).click();
		return new AccountSuccessPage(driver);
		
	}
	
	public void selectYesNewsletterOption() {
		
		waitUtils.waitForElementToBeClickable(YesNewsletterOption).click();
		
	}
	
	public String getWarningMessageText() {
		
		return waitUtils.getTextFromElement(warningMessage);
		
	}
	
	public String getFirstNameWarning() {
		
		return waitUtils.getTextFromElement(firstNameWarning);
		
	}
	
	public String getLastNameWarning() {
		
		return waitUtils.getTextFromElement(lastNameWaring);
	
	}
	
	public String getEmailWarning() {
		
		return waitUtils.getTextFromElement(emailWarning);
		
	}
	
	public String getTelephoneWarning() {
		
		return waitUtils.getTextFromElement(telephoneWarning);
		
	}
	
	public String getPasswordWarning() {
		
		return waitUtils.getTextFromElement(passwordWarning);
		
	}
	
	
	
}
