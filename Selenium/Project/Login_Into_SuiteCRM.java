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

public class Login_Into_SuiteCRM {
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

		// String HomeUrl= driver.getCurrentUrl();

		homeurl.isDisplayed();

		WebElement navigationclr = driver.findElement(By.id("ygddfdiv"));

		String menucolor = navigationclr.getCssValue("color");
		// convert rgba to hex
		String Bgcolor = Color.fromString(menucolor).asHex();
		System.out.println("Color is :" + menucolor);
		System.out.println("Hex code for color:" + Bgcolor);
	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}