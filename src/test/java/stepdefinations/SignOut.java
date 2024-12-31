package stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageobjects.AccountLogOutPage;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import utilities.BrowserUtils;

public class SignOut {

	WebDriver driver = BrowserUtils.getDriver();
	private LoginPage loginPage;
	private AccountPage accountPage;
	private AccountLogOutPage accountLogOutPage;

	@Given("User is on login page")
	public void User_is_on_login_page() {

		driver = BrowserUtils.getDriver();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.selectLoginOption();

	}

	@When("^User enters valid (.+) and (.+)$")
	public void User_enters_valid_and(String email, String password) {

		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		accountPage = loginPage.clickOnLoginButton();

	}

	@When("User clicks on the sign out button")
	public void user_clicks_on_the_sign_out_button() {

		accountLogOutPage = accountPage.clickOnSignoutButton();

	}

	@Then("User should be redirected to the logout page")
	public void user_should_be_redirected_to_the_logout_page() {

		accountLogOutPage.redirectedToLogoutPage("https://tutorialsninja.com/demo/index.php?route=account/logout");

	}

	@And("User should see a confirmation message {string}")
	public void user_should_see_a_confirmation_message(String expectedMessage) throws InterruptedException {

		Assert.assertEquals("You have been logged off your account. It is now safe to leave the computer.",
				accountLogOutPage.getLogOutConfirmationMessage());

	}

}
