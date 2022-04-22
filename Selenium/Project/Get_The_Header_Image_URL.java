package Application_SuiteCRM;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;
import org.testng.Assert;

public class Get_The_Header_Image_URL {
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();
		// Open browser
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test
	public void getHeaderURl() {

		// finding x path of the image
		String imageUrl = driver.findElement(By.xpath("//*[@id=\"form\"]/div[1]/img")).getAttribute("src");

		System.out.println(imageUrl);

	}

	@AfterMethod
	public void afterMethod() {
		// Close the browser
		driver.quit();
	}

}