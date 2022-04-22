package Application_SuiteCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import org.testng.Assert;

public class Verify_the_website_title {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		// Open browser
		driver.get("http://alchemy.hguy.co/crm");
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test
	public void verifyTitle() {
		// Check the title of the page
		String title = driver.getTitle();
		// Assertion for page title
		Assert.assertEquals("SuiteCRM", title);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}