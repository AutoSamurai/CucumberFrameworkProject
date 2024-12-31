package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.BrowserUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;

	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws InterruptedException {

		driver = BrowserUtils.getDriver();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("^User enters valid email address (.+)$")
	public void user_enters_valid_email_address(String email) {

		loginPage.enterEmailAddress(email);

	}

	@And("^Enter valid password (.+)$")
	public void enter_valid_password(String password) {

		loginPage.enterPassword(password);

	}

	@And("Clicks on login button")
	public void clicks_on_login_button() {

		accountPage = loginPage.clickOnLoginButton();

	}

	@Then("User should login successfully")
	public void user_should_login_successfully() {

		Assert.assertTrue(accountPage.displayStatusOfConfirmationMessage());

	}

	@And("User enters invalid email address {string}")
	public void user_enters_invalid_email_address(String email) {

		loginPage.enterEmailAddress(email);
	}

	@And("Enter invalid password {string}")
	public void enter_invalid_password(String password) {

		loginPage.enterPassword(password);
	}

	@Then("User should get a proper warning message")
	public void user_should_get_a_proper_warning_message() {

		Assert.assertTrue(
				loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@When("User dont enter any credentials")
	public void user_dont_enter_any_credentials() {

		loginPage.enterEmailAddress("");
		loginPage.enterPassword("");
	}

}
