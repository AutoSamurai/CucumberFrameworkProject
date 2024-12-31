package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	WebDriver driver;
	WebDriverWait wait;

	public WaitUtils(WebDriver driver, int timeOut) {

		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	}

	public WebElement waitForElementToBeVisible(WebElement element) {

		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForElementToBeClickable(WebElement element) {

		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String getTextFromElement(WebElement element) {

		WebElement webElement = waitForElementToBeVisible(element);
		return webElement.getText();

	}

	public boolean displayStatusOfElement(WebElement element) {

		try {
			WebElement webElement = waitForElementToBeVisible(element);
			return webElement.isDisplayed();
		} catch (Throwable e) {
			return false;
		}

	}
	
	public Boolean getCurrentUrlOfWebpage(String expectedSubstring) {

	    return	wait.until(ExpectedConditions.urlContains(expectedSubstring)); 
		
	}

}
