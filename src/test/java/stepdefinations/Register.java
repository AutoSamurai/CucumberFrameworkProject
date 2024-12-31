package stepdefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountSuccessPage;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utilities.BrowserUtils;

public class Register {

	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;

	@Given("User navigates to Register Account page")
	public void User_navigates_to_Register_Account_page() {
		driver = BrowserUtils.getDriver();

		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();

		registerPage = homePage.selectRegisterOption();

	}

	@When("User enters below details")
	public void User_enters_below_details(DataTable data) {

		Map<String, String> map = data.asMap(String.class, String.class);
		
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		registerPage.enterEmailAddress(map.get("email"));
		registerPage.enterTelephoneNumber(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));

	}

	@And("Selects Privacy Policy field")
	public void Selects_Privacy_Policy_field() {

		registerPage.selectPrivacyPolicy();
	}

	@And("Clicks on Continue button")
	public void Clicks_on_Continue_button() {

		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("Account should get successfully created")
	public void Account_should_get_successfully_created() {

		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getPageHeading());

	}

	@And("Selects Yes for Newsletter")
	public void Selects_Yes_for_Newsletter() {

		registerPage.selectYesNewsletterOption();
	}

	@Then("Warning message informing the user about duplicate email address should be displayed")
	public void Warning_message_informing_the_user_about_duplicate_email_address_should_be_displayed() {

		Assert.assertTrue(
				registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter details into any field")
	public void User_dont_enter_details_into_any_field() {

		registerPage.enterFirstName("");
		registerPage.enterLastName("");
		registerPage.enterEmailAddress("");
		registerPage.enterTelephoneNumber("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
	}

	@Then("Warning message should be displayed for the mandatory fields")
	public void Warning_message_should_be_displayed_for_the_mandatory_fields() {

		Assert.assertTrue(
				registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
	}
}
