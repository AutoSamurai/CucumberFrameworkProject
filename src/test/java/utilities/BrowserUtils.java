package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtils {

	static WebDriver driver;
	
//	method is responsible for initializing the WebDriver instance (if it hasn't been already) and returning it.
	public static WebDriver getDriver() {		
		if (driver == null) {
		 driver = new ChromeDriver();
		}
		return driver;		
	}
	
	public static void tearDown() {
		if (driver != null){ 			
		driver.quit();
		driver = null; 
		}
	}
}
