package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BrowserUtils;

public class MyHooks {
	WebDriver driver;	
	
	@Before
	public void stepUp(Scenario scenario) {
		    driver = BrowserUtils.getDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    driver.get("https://tutorialsninja.com/demo/");
			System.out.println("Execution started for scenerio - " +scenario.getName());				
	}
	
	@After
	public void tearDown(Scenario scenario) {
		BrowserUtils.tearDown();
		System.out.println("Execution ended for scenerio- " +scenario.getName());
	}


}
