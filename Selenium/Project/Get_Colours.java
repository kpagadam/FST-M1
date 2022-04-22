package Application_SuiteCRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Get_Colours {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		// Open browser
		driver.get("https://alchemy.hguy.co/crm");
	}

	@Test
	public void login() {

		// Finding the User name

		WebElement username = driver.findElement(By.id("user_name"));
		username.isDisplayed();
		username.clear();
		username.sendKeys("admin");

		// Finding the Password

		WebElement Password = driver.findElement(By.xpath("//*[@id=\"username_password\"]"));
		Password.isDisplayed();
		Password.clear();
		String pasword = "pa$$w0rd";
		Password.sendKeys(pasword);

		// Finding the login_button
		driver.findElement(By.id("bigbutton")).click();

		WebElement homeurl = driver.findElement(By.xpath("//*[@id=\"toolbar\"]/ul/li[1]/a"));

		homeurl.isDisplayed();

		// Finding the navigation menu locator

		WebElement navigationmenu = driver.findElement(By.id("toolbar"));

		String Bgcolor = navigationmenu.getCssValue("color");

		String Nvigationcolor = Color.fromString(Bgcolor).asHex();

		System.out.println("Color is :" + Bgcolor);
		System.out.println("Hex code for color:" + Nvigationcolor);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}